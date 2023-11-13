package com.openliberty.jsonb;

import java.util.Set;

import jakarta.ws.rs.ApplicationPath;
import jakarta.ws.rs.core.Application;

@ApplicationPath("/")
public class SampleApplication extends Application {
	
	@Override
    public Set<Class<?>> getClasses() {
        return Set.of(TestController.class, JsonbConfigurator.class);
    }
}
