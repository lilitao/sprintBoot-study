package com.ay.sample.springboot.message.controller;

import org.springframework.validation.BindException;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/message")
public class MessageController {

    @PostMapping("getMessage")
    public Map<String, Object> loadMessage(@Validated MessageFrom messageFrom, BindingResult messageFormBind) throws BindException {

        if(messageFormBind.hasErrors()){
            throw new BindException(messageFormBind);
        }
        Map<String, Object> result = new HashMap<>();
        result.put("success", true);
        result.put("data",messageFrom);
        return result;
    }
}
