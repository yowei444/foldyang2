package com.foldyang;

import com.netflix.hystrix.contrib.metrics.eventstream.HystrixMetricsStreamServlet;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;

/**
 * @Author foldYang
 * @Description 启动类
 * @Date 2020/3/14
 * @Version 1.0
 */
@SpringBootApplication
@EnableEurekaClient
@EnableCircuitBreaker
public class Provider8004Hystrix {

    public static void main(String[] args) {
        SpringApplication.run(Provider8004Hystrix.class, args);
    }
    @Bean
    public ServletRegistrationBean hystrixMetricsStreamServlet() {
        ServletRegistrationBean registration = new ServletRegistrationBean(new HystrixMetricsStreamServlet());
        registration.addUrlMappings("/actuator/hystrix.stream");
        return registration;
    }

}
