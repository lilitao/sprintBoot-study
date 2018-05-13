package com.ay.sample.springboot.presentation;

import com.ay.sample.springboot.application.service.SampleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class MockBeanCotroller {
    @Autowired
    private SampleService sampleService;
    @RequestMapping("/service")
    public String mockBean() {
        return sampleService.process();
    }
}
