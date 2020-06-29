package com.springcloud.feign.service;

import com.springcloud.feign.config.MyFeignConfig;
import com.springcloud.feign.fallback.FeignError;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient(name = "user-service",fallback = FeignError.class,configuration = MyFeignConfig.class)
public interface IUserService {

    @RequestMapping("/user")
    String user();

    @RequestMapping("/user/{name}")
    String user2(@PathVariable("name")String name);
}
