package com.openliberty.jsonb;


import jakarta.json.bind.Jsonb;
import jakarta.json.bind.JsonbBuilder;
import jakarta.ws.rs.ext.ContextResolver;
import jakarta.ws.rs.ext.Provider;

@Provider
public class JsonbConfigurator implements ContextResolver<Jsonb> {

	// Tried using another jsonb instance for jax-rs
    private static final Jsonb jsonbInstance = JsonbBuilder.newBuilder().build();

    @Override
    public Jsonb getContext(Class type) {
        return jsonbInstance;
    }
}