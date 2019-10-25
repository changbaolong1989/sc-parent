package com.cbl.spring.cloud.app;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("com.cbl")
@MapperScan("com.cbl.spring.cloud.dao")
public class ScServerProviderApplication {

    public static void main(String[] args) {
        SpringApplication.run(ScServerProviderApplication.class, args);
    }

}
