package com.ay.sample.springboot.presentation;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class SingleControllerStartupController {

    @RequestMapping("/single")
    public String signleController(){
        return "this is a signle controller testing";
    }
}
