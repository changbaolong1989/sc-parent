package com.cbl.spring.cloud.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
//将该应用设置为一个Eureka服务器
@EnableEurekaServer
public class ScEurekaServer1Application {

    public static void main(String[] args) {
        SpringApplication.run(ScEurekaServer1Application.class, args);
    }

}
