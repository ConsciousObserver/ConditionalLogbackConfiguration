package com.example.demo;

import java.net.URISyntaxException;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@SpringBootApplication
public class ConditionalLogbackConfigurationApplication {

    public static void main(String[] args) throws URISyntaxException {
//      Following log lines print location of default logback configuration files in Spring Boot.
//      By the way it shows that this these files are present in spring-boot-3.0.0.jar
        log.info("#########################################################");
        log.info("defaults.xml location: {}", ConditionalLogbackConfigurationApplication.class.getClassLoader()
                .getResource("org/springframework/boot/logging/logback/defaults.xml")
                .toURI());

        log.info("defaults.xml location: {}", ConditionalLogbackConfigurationApplication.class.getClassLoader()
                .getResource("org/springframework/boot/logging/logback/console-appender.xml")
                .toURI());
        log.info("#########################################################");

        SpringApplication.run(ConditionalLogbackConfigurationApplication.class, args);
    }

    @Bean
    CommandLineRunner commandLineRunner() {
        return (args) -> {
            for (int i = 0; i < 1000; i++) {
                log.info("Hello {}", i);
            }

//            Exit as I don't need it to stick around, it also 
//            becomes inconvenient to stop the app again and 
//            again before each run for testing
            System.exit(0);
        };
    }

}
