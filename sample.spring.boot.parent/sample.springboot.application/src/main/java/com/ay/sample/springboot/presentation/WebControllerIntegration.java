package com.ay.sample.springboot.presentation;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/")
public class WebControllerIntegration {

    @GetMapping("/load")
    @ResponseBody
    public String load(){
        return "this is a test";
    }
}
