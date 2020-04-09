package com.foldyang.cloud;

import com.foldyang.config.MySelfRule;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;

/**
 * @Author foldYang
 * @Description
 * @Date 2020/3/14
 * @Version 1.0
 */
@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
// 这里要报错，所以把exclude排除写好（Failed to configure a DataSource: 'url' attribute is not specified and no embedded datasource could be configured）
@EnableEurekaClient
@RibbonClient(value = "BACK1", configuration = MySelfRule.class)
public class Consumer80 {

    public static void main(String[] args) {
        SpringApplication.run(Consumer80.class, args);
    }

}
