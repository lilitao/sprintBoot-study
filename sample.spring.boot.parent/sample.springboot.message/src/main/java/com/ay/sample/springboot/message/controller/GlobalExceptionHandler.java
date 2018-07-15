package com.ay.sample.springboot.message.controller;

import com.google.common.collect.ImmutableMap;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.jmx.export.annotation.ManagedAttribute;
import org.springframework.ui.Model;
import org.springframework.validation.BindException;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;

/**
 * supply this advice as a aspect to a point cut of  method annotated with @RequestMapping.
 *
 */
@RestControllerAdvice
public class GlobalExceptionHandler {
    static Logger logger = LoggerFactory.getLogger(GlobalExceptionHandler.class);
    @Autowired
    MessageSource messageSource;

    /**
     * initialize a binder to turn specific form data into specific format.
     * this advice will be applied to all point cut annotated with @RequestMapping
     * @param webDataBinder a binder used to transform specific form data
     */
    @InitBinder
    public void initBinder(WebDataBinder webDataBinder) {

    }

    /**
     * setting in this method will be apply to all rest controller model of @RequestMapping point cut
     * @param model model are created and managed by spring MVC , is used to manage model attributes for view
     */
    @ModelAttribute
    public void addAttributes(Model model) {

    }

    /**
     * exception handler
     * @param exception
     * @return
     */
    @ResponseBody
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(BindException.class)
    public ResponseEntity beanValidation(BindException exception) {
        //https://blog.csdn.net/nickmengo/article/details/77488273

        List<String>  errors = exception.getBindingResult().getFieldErrors().stream()
                .map(errorFile -> handlerFileError(errorFile))
                .collect(Collectors.toList());

        return ResponseEntity.badRequest().body(ImmutableMap.of("error",errors));
    }

    private String handlerFileError(FieldError errorFile) {
        return messageSource.getMessage(errorFile.getDefaultMessage(), errorFile.getArguments(), Locale.CHINA);

    }
}
