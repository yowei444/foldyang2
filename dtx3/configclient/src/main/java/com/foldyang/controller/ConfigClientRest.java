package com.foldyang.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author foldYang
 * @Description
 * @Date 2020/4/2
 * @Version 1.0
 */
@RestController
public class ConfigClientRest {

    @Value("${spring.application.name:#{null}}")
    private String applicationName;

    @Value("${eureka.client.service-url.defaultZone:#{null}}")
    private String eurekaServers;

    @Value("${server.port:#{null}}")
    private String port;

    @RequestMapping(value = "/clientConfig", method = RequestMethod.GET)
    public String getConfig() {
        String str = "applicationName:" + applicationName + ",eurekaServers:" + eurekaServers + ",port:" + port;
        return str;
    }

}
