package com.cris.consumer.controller;

import com.cris.common.service.UserClientService;
import org.springframework.beans.factory.annotation.Autowired;
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
    private UserClientService service;

    @GetMapping("/consumer/user/get")
    public String get(){
        return service.get();
    }

    @GetMapping("/consumer/get")
    public String getUser(){
        return "cris";
    }

}
