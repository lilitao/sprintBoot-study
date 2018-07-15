package com.ay.sample.springboot;

import com.ay.sample.springboot.properties.EvnProperties;
import com.ay.sample.springboot.properties.PropertiesConfAuto;
import com.ay.sample.springboot.properties.PropertiesExpress;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class PropertiesStarter {

    private static org.slf4j.Logger logger = LoggerFactory.getLogger(PropertiesStarter.class);

    public static void main(String[] args) {
        SpringApplication.run(PropertiesStarter.class, args);
    }

    @Bean
    public CommandLineRunner commandLineRunner(ApplicationContext context) {
        CommandLineRunner commandLineRunner = new CommandLineRunner() {
            @Autowired
            EvnProperties evnProperties;
            @Autowired
            PropertiesConfAuto propertiesConfAuto;
            @Autowired
            PropertiesExpress propertiesExpress;
            @Override
            public void run(String... args) throws Exception {
                logger.info("type:{}", propertiesConfAuto.type);
                logger.info("title:{}",propertiesConfAuto.title);
            }
        };
        return commandLineRunner;
    }
}
