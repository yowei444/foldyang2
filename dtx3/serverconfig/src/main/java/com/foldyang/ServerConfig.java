package com.foldyang;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.config.server.EnableConfigServer;

/**
 * @Author foldYang
 * @Description git中心配置启动类
 * @Date 2020/4/2
 * @Version 1.0
 */
@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
@EnableConfigServer
public class ServerConfig {

    public static void main(String[] args) {
        SpringApplication.run(ServerConfig.class, args);
    }

}
