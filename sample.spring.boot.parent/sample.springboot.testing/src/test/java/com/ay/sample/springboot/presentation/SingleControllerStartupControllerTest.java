package com.ay.sample.springboot.presentation;

import org.hamcrest.Matchers;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@WebMvcTest(value = SingleControllerStartupController.class)
public class SingleControllerStartupControllerTest {

    /**
     * injected by @WebMvcTest annoation
     */
    @Autowired
    private MockMvc mockMvc;

    @Test
    public void singleTest() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders.get("/single"))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().string(Matchers.containsString("this is a signle controller testing")));



    }
}