package com.springcloud.ribbon.controller;

import com.netflix.ribbon.proxy.annotation.Hystrix;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

@RestController
public class RibbonController {

    @Resource
    RestTemplate restTemplate;

    @RequestMapping("/ribbon-test")
    public Object ribbonTest() {
        return restTemplate.getForEntity("http://user-service/user", String.class).getBody();
    }

    @RequestMapping("/hystrix-test")
    public Object hystrixTest() {
        return restTemplate.getForEntity("http://user-service/user", String.class).getBody();
    }
}

