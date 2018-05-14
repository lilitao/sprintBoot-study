package com.ay.sample.springboot.properties;

import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

@TestPropertySource(locations = "classpath:application-test.properties")
@RunWith(SpringRunner.class)
@SpringBootTest
public class EvnPropertiesTest {

    @Autowired
    private EvnProperties evnProperties;

    @Test
    public void evnTest() {
        Assertions.assertThat(evnProperties.getEnvironment().getProperty("sample.conf.title")).isEqualTo("sample test");
    }
}