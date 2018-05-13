package com.ay.sample.springboot.presentation;

import org.hamcrest.Matchers;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

/**
 * in this case ,only web controller layer is started
 */
@RunWith(SpringRunner.class)
@WebMvcTest
public class OnlyStartControllerTest {

    /**
     * injected by @WebMvcTest annoation
     */
    @Autowired
    private MockMvc mockMvc;

    @Test
    public void startOnlyControllerTest() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.post("/start").accept(MediaType.APPLICATION_JSON))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().string(Matchers.containsString("this is a only start controller context testing")));
    }
}