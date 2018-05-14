package com.ay.sample.springboot.properties;

import org.assertj.core.api.Assertions;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

@SpringBootTest
@RunWith(SpringRunner.class)
@TestPropertySource(locations = "classpath:application-test.properties")
public class PropertiesConfAutoTest {

    @Autowired
    PropertiesConfAuto propertiesConfAuto;

    @Test
    public void protertiesTest() {
        Assertions.assertThat(propertiesConfAuto.login).containsValues("AndyLi","123","127.0.0.1");
        Assertions.assertThat(propertiesConfAuto.title).isEqualTo("sample test");
        Assertions.assertThat(propertiesConfAuto.type).isEqualTo("test");
        Assertions.assertThat(propertiesConfAuto.urls).contains("htpp;//localhost:8080/1","htpp;//localhost:8080/2");
    }
}