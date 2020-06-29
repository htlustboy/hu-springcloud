package com.springcloud.feign;

import com.springcloud.feign.service.IUserService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@EnableFeignClients
@EnableDiscoveryClient
@SpringBootApplication
public class SpringcloudFeignApplication {

    @Resource
    IUserService iUserService;

    public static void main(String[] args) {
        SpringApplication.run(SpringcloudFeignApplication.class, args);
    }

    @RequestMapping("/feign-test")
    public Object feignTest(){
        return iUserService.user();
    }

    @RequestMapping("/feign-test2")
    public Object feignTest2(){
        String name = "hutao";
        return iUserService.user2(name);
    }

}
