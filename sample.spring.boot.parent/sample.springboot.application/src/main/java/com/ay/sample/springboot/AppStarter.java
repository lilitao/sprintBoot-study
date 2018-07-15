package com.ay.sample.springboot;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Profile;
import org.springframework.context.annotation.PropertySource;

import java.util.Arrays;

@SpringBootApplication(scanBasePackages = "com.ay.sample")
//@Profile(value = "dev")
//@PropertySource(value = "classpath:application.properties")
public class AppStarter {
    private static Logger logger = LoggerFactory.getLogger(AppStarter.class);
    public static void main(String[] args) {
        SpringApplication.run(AppStarter.class, args);
    }

    @Bean
    public CommandLineRunner commandLineRunner(final ApplicationContext context) {
        return args -> {

            logger.info("a spring boot example staring");
            String[] beanNames = context.getBeanDefinitionNames();
            Arrays.stream(beanNames).forEach(name -> logger.info(name));
        };
    }
}
