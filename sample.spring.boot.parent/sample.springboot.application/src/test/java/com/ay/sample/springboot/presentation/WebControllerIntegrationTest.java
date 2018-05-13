package com.ay.sample.springboot.presentation;

import org.hamcrest.Matchers;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import java.net.URL;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)//配置服务器启动时使用随机端口
public class WebControllerIntegrationTest {
    @LocalServerPort
    private  int port;
    private URL base;
    @Autowired
    private TestRestTemplate testRestTemplate;

    @Before
    public void setUp() throws Exception {
        this.base = new URL("http://localhost:" + this.port + "/load");
    }

    @Test
    public void controllerTest() {
        ResponseEntity<String> responseEntity = this.testRestTemplate.getForEntity(this.base.toString(),String.class);
        assertThat(responseEntity.getBody(),Matchers.containsString("this is a test"));
    }
}