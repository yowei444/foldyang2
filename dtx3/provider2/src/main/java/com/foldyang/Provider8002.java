package com.foldyang;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @Author foldYang
 * @Description 启动类
 * @Date 2020/3/14
 * @Version 1.0
 */
@SpringBootApplication
@EnableEurekaClient
public class Provider8002 {

    public static void main(String[] args) {
        SpringApplication.run(Provider8002.class, args);
    }

}
