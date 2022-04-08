package com.ztax.feign.service;

import com.ztax.common.result.Result;
import com.ztax.feign.entity.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(value = "ztax-iam-develop", contextId = "userService")
public interface UserService {

    @GetMapping(value = "/users/me")
    Result<User> currentUserInfo();
}
