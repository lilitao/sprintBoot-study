package com.ay.sample.springboot.presentation;

import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;


/**
 *go and look for a main class annotation with @SpringBootApplication.
 * a spring boot main method should be create before run
 *
 * in the spring boot test,the application context will be cached between tests;
 * control the cache using @DirtiesContext
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class WebControllerTest {

    @Autowired
    private WebController webController;

    @Test
    public void startTest() {
        //about the assertJ use case :http://joel-costigliola.github.io/assertj/
        Assertions.assertThat(this.webController).isNotNull();
    }
}