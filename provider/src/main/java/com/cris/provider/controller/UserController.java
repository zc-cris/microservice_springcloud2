package com.cris.provider.controller;

import com.cris.provider.service.UserService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName UserController
 * @Description TODO
 * @Author zc-cris
 * @Version 1.0
 **/
@RestController
public class UserController {

    @Autowired
    private UserService service;

    @Value("${server.port}")
    private String port;

    @GetMapping("/provider/get")
    @HystrixCommand()
    public String get(){
        return service.get() + port;
    }



}
