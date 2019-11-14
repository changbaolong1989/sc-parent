package com.cbl.spring.cloud.controller;

import com.cbl.spring.cloud.entity.UserInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

@RestController
public class MovieController {

    private static final Logger logger = LoggerFactory.getLogger(MovieController.class);

    @Resource
    @LoadBalanced //标记启动负载均衡自动化配置
    private RestTemplate restTemplate;

    @Resource
    private LoadBalancerClient loadBalancerClient;

    @GetMapping("/getUser/{userId}")
    public UserInfo getUserById(@PathVariable String userId) {
        //http://sc-server-provider/  虚拟主机名（服务提供者名）
        return this.restTemplate.getForObject("http://sc-server-provider/" + userId, UserInfo.class);
    }

    @GetMapping("/log-user-instance")
    public void logUserInstance() {
        ServiceInstance serviceInstance = loadBalancerClient.choose("sc-server-provider");
        //打印负载均衡当前选择的是哪个节点
        MovieController.logger.info("{}:{}:{}", serviceInstance.getServiceId(), serviceInstance.getHost(), serviceInstance.getPort());
    }

}
