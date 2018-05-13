package com.ay.sample.springboot.presentation;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class WebIntergationController {
    @RequestMapping("intergation")
    public String index(){
        return "this is a sample test";
    }
}
