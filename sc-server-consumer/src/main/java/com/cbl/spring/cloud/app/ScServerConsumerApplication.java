package com.cbl.spring.cloud.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("com.cbl")
public class ScServerConsumerApplication {

    public static void main(String[] args) {
        SpringApplication.run(ScServerConsumerApplication.class, args);
    }

}
