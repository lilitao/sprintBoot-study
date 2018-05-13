package com.ay.sample.springboot.presentation;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class MockMvcController {
    @RequestMapping("/mockMvc")
    public String mockMvcController() {
        return "this is a mock mvc testing";
    }
}
