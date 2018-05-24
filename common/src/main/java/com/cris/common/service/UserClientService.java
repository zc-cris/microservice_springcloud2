package com.cris.common.service;

import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @ClassName UserClientService
 * @Description TODO
 * @Author zc-cris
 * @Version 1.0
 **/
@FeignClient(value = "SERVICE-PROVIDER", fallbackFactory = UserFallbackFactory.class)
public interface UserClientService {

    @GetMapping("/provider/get")
    public String get();

}
