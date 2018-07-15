package com.ay.sample.springboot.presentation;

import com.ay.sample.springboot.AppStarter;
import org.hamcrest.Matchers;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = AppStarter.class)//要求spring boot 启动了整个spring boot context上下文，包括了所有的配置 ,如果仅仅需要启动spring boot 中的web controller动的context,则使用 @WebMvcTest
@AutoConfigureMockMvc
public class WebControllerWithWholeContextTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void controllerTest() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/index").accept(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().string(Matchers.containsString("this is a web request example")));

    }
}