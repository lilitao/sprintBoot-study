package com.ay;

import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.context.junit4.SpringRunner;

/**
 *
 */
@Configuration
@EnableAutoConfiguration
@ComponentScan(basePackages = "com.ay")
public class AppTest 
{

}
