package com.springcloud.client.user.clientuser;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@EnableDiscoveryClient
@SpringBootApplication
public class ClientUserApplication {

    @Resource
    DiscoveryClient discoveryClient;

    private final Logger logger = LoggerFactory.getLogger(ClientUserApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(ClientUserApplication.class, args);
    }

    @RequestMapping("/user")
    public Object test() {
        return "user client successful...";
    }

    @RequestMapping("/user/{name}")
    public Object testParam(@PathVariable("name") String name) {
        return "user client param request successful..." + name;
    }

}
