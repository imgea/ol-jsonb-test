package com.openliberty.jsonb;

import org.bson.Document;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import jakarta.json.Json;
import jakarta.json.JsonObject;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

@Path("")
public class TestController {

	private static final Logger log = LoggerFactory.getLogger(TestController.class);
	
	
	@POST
	@Path("test")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public void test(SomeBean testBean) {
		log.debug("Processing received bean {}", testBean);
		String jsonStr = JsonUtils.toJson(testBean);
		Document.parse(jsonStr); //parse should not fail with a valid json string
		JsonObject someJsonObject = Json.createObjectBuilder().add("type", "object")
				.add("properties", Json.createArrayBuilder().build()).build();
		Document doc = Document.parse(someJsonObject.toString()); //parse should not fail with a valid json string
		JsonObject obj = JsonUtils.populate(doc.toJson(), JsonObject.class);
		String json = JsonUtils.toJson(obj);
		JsonUtils.populate(json, JsonObject.class);
	}

}
