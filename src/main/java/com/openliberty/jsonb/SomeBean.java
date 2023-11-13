package com.openliberty.jsonb;

import jakarta.json.JsonObject;
import jakarta.json.bind.annotation.JsonbCreator;
import jakarta.json.bind.annotation.JsonbProperty;

public class SomeBean {

	private JsonObject data;
	private String name;

	public SomeBean(String uid, JsonObject data) {
		this.data = data;
	}

	@JsonbCreator
	public SomeBean(@JsonbProperty("uid") String uid, @JsonbProperty("data") JsonObject data, @JsonbProperty("name") String name) {
		this(uid, data);
		this.name = name;
	}

	public JsonObject getData() {
		return data;
	}

	public void setData(JsonObject data) {
		this.data = data;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return 	"SomeBean{" +
					"Name " + name + " data: " + data +
				"}";
	}

}
