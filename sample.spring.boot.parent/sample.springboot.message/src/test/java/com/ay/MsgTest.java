package com.ay;

import org.assertj.core.api.Assertions;
import org.hamcrest.Matchers;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.*;

@RunWith(SpringRunner.class)
@EnableAutoConfiguration
@ComponentScan(basePackages = "com.ay")
@TestPropertySource(locations = "classpath:application.properties")
@WebMvcTest
public class MsgTest {
    @Autowired
    private MessageSource messageSource;

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void helloWorlTest() {
        Assertions.assertThat(messageSource).isNotNull();
    }

    @Test
    public void should_result_message() {
        Assertions.assertThat(messageSource.getMessage("exception.args.not.empty",new String[]{"test"}, Locale.getDefault())).isEqualTo("test 不能为空");
    }

    @Test
    public void should_result_success_controllerTest() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.post(new URI("/message/getMessage"))
                .param("id","1")
                 .param("firstName","abcdd")
                .param("lastName","efdggg")
                    )
                .andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().string(Matchers.containsString("success")));
    }

    @Test
    public void should_return_error_controllerTest() throws Exception {
        MultiValueMap param = new LinkedMultiValueMap();
        param.put("id", Arrays.asList("1"));
        param.put("firstName", Arrays.asList("1"));
        param.put("lastName", Arrays.asList("222222"));
        mockMvc.perform(MockMvcRequestBuilders.post(new URI("/message/getMessage")).params(param))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.status().is(400));
    }
}

