package com.cbl.spring.cloud.controller;

import com.cbl.spring.cloud.entity.UserInfo;
import com.cbl.spring.cloud.service.UserService;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
public class UserController {

    @Resource
    private UserService userService;

    @Resource
    private DiscoveryClient discoveryClient;

    @GetMapping("/users/{userId}")
    public UserInfo getUserById(@PathVariable String userId) {
        return userService.getUserById(userId);
    }

    /**
     * 查询服务信息
     */
    @GetMapping("/user-instance")
    public List<ServiceInstance> showServerInfo() {
        return discoveryClient.getInstances("sc-server-provider");
    }

}
