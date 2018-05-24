package com.cris.common.service;

import feign.hystrix.FallbackFactory;
import org.springframework.stereotype.Component;

/**
 * @ClassName UserFallbackFactory
 * @Description TODO
 * @Author zc-cris
 * @Version 1.0
 **/
@Component
public class UserFallbackFactory implements FallbackFactory<UserClientService> {

    @Override
    public UserClientService create(Throwable throwable) {
        return new UserClientService() {
            @Override
            public String get() {
                return "当前服务模块不可用";
            }
        };
    }
}
