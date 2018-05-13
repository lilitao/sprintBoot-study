package com.ay.sample.springboot.presentation;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class OnlyStartController {
    @RequestMapping("/start")
    public String start() {
        return "this is a only start controller context testing";
    }
}
