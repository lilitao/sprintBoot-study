package com.ay.sample.springboot.properties;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
/**
 * load properties
 */
@ConfigurationProperties(prefix = "sample.conf")
public class PropertiesConfAuto {
    public String type;
    public String title;

    public Map<String, String> login = new HashMap<>();

    public List<String> urls = new ArrayList<>();

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Map<String, String> getLogin() {
        return login;
    }

    public void setLogin(Map<String, String> login) {
        this.login = login;
    }

    public List<String> getUrls() {
        return urls;
    }

    public void setUrls(List<String> urls) {
        this.urls = urls;
    }
}
