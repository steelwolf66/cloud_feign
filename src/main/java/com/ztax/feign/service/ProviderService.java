package com.ztax.feign.service;

import com.ztax.feign.entity.Info;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@FeignClient(value = "ztax-provider-develop", contextId = "providerService")
public interface ProviderService {

    @PostMapping(value = "/info/list")
    List<Info> getInfoList(Info info);
}
