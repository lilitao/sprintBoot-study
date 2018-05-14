package com.ay.sample.springboot.properties;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

@Component
public class EvnProperties {

    @Autowired
    private Environment environment;

    public Environment getEnvironment() {
        return environment;
    }
}
