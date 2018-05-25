package com.cris.configclient.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName ConfigClientRest
 * @Description TODO
 * @Author zc-cris
 * @Version 1.0
 **/
@RestController
public class ConfigClientRest {

    @Value("${spring.application.name}")
    private String applicationName;

    @Value("${eureka.client.service-url.defaultZone}")
    private String eurekaServers;

    @Value("${server.port}")
    private String port;

    @GetMapping("/config")
    public String getConfig() {
        String string = "applicationName:" + applicationName + ",eurekaServers:" + eurekaServers + ",port:" + port;
        System.out.println(string);
        return string;
    }
}
