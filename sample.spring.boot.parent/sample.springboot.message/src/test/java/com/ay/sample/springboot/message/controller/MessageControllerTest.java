package com.ay.sample.springboot.message.controller;

import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = WebConfigTest.class)
public class MessageControllerTest {
   @Autowired
    MessageController messageController;

    @Test
    public void startTest() {
        Assertions.assertThat(messageController).isNotNull();
    }
}