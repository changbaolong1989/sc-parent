package com.cbl.spring.cloud.controller;

import com.cbl.spring.cloud.entity.UserInfo;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

@RestController
public class MovieController {

    @Resource
    private RestTemplate restTemplate;

    @GetMapping("/getUser/{userId}")
    public UserInfo getUserById(@PathVariable String userId) {
        return this.restTemplate.getForObject("http://localhost:8000/users/" + userId, UserInfo.class);
    }

}
