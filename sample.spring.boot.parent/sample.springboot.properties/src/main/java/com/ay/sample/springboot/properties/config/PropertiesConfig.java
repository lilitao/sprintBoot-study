package com.ay.sample.springboot.properties.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource(value = "classpath:name.properties", ignoreResourceNotFound = true)
@PropertySource(value = "classpath:url.properties")
@PropertySource(value = "file:${JAVA_HOME}/other.properties",ignoreResourceNotFound = true)
public class PropertiesConfig {
}
