package com.ay.sample.springboot.presentation;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/")
public class WebController {


    @GetMapping("/index")
    public Map<String,Object> index(){
        Map<String, Object> result = new HashMap<>();
        result.put("success", true);
        result.put("msg","this is a web request example");
        return result;
    }
}
