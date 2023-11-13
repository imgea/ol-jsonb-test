package com.openliberty.jsonb;

import jakarta.json.Json;
import jakarta.json.JsonObject;
import jakarta.json.bind.Jsonb;
import jakarta.json.bind.JsonbBuilder;
import jakarta.json.bind.JsonbConfig;


public final class JsonUtils {

    public static final JsonObject EMPTY = Json.createObjectBuilder().build();

    private static final Jsonb jsonb = JsonbBuilder.newBuilder().withConfig(new JsonbConfig()).build();

    public static <T> T populate(String json, Class<T> type) {
        return jsonb.fromJson(json, type);
    }

    public static <T> String toJson(T instance) {
        return jsonb.toJson(instance);
    }

}
