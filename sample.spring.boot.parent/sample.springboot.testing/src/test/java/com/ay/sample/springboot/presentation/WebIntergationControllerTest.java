package com.ay.sample.springboot.presentation;

import com.ay.sample.springboot.StarterSpringBoot;
import org.assertj.core.api.Assertions;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;

import java.net.URL;

import static org.junit.Assert.*;

/**
 * below the way of testing will start up whole  spring boot server with spring context
 */
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT,classes = StarterSpringBoot.class)
public class WebIntergationControllerTest {
    @LocalServerPort
    private int port;

    /**
     * spring boot prove a rest template for connection test
     * we only to do what is auto wire up
     */
    @Autowired
    private TestRestTemplate testRestTemplate;

    private URL base;

    @Before
    public void setUp() throws Exception {
        this.base = new URL("http://localhost:" + this.port + "/intergation");

    }

    @Test
    public void testController() {
        ResponseEntity<String> responseEntity = this.testRestTemplate.getForEntity(this.base.toString(), String.class);
        Assertions.assertThat(responseEntity.getBody()).contains("this is a sample test");
    }
}