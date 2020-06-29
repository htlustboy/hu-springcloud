package com.springcloud.feign.fallback;

import com.springcloud.feign.service.IUserService;
import org.springframework.stereotype.Component;

@Component
public class FeignError implements IUserService {

    @Override
    public String user() {
        return "error";
    }

    @Override
    public String user2(String name) {
        return "error" + name;
    }
}
