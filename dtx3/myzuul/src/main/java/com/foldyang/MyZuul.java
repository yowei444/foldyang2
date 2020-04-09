package com.foldyang;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

/**
 * @Author foldYang
 * @Description 网关
 * @Date 2020/3/16
 * @Version 1.0
 */
@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
@EnableZuulProxy
public class MyZuul {

    public static void main(String[] args) {
        SpringApplication.run(MyZuul.class, args);
    }

}
