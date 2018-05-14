package com.ay.sample.springboot.properties;

import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
@TestPropertySource(locations = "classpath:application-test.properties")
public class PropertiesExpressTest {

    @Autowired
    private PropertiesExpress propertiesExpress;

    @Test
    public void ExpressTest() {
        Assertions.assertThat(propertiesExpress.getTitle()).isEqualTo("sample test");
        Assertions.assertThat(propertiesExpress.getType()).isEqualTo("test");
        Assertions.assertThat(propertiesExpress.getUserName()).isEqualTo("AndyLi");
    }
}