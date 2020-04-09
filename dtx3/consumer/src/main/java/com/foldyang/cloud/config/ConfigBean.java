package com.foldyang.cloud.config;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * @Author foldYang
 * @Description
 * @Date 2020/3/14
 * @Version 1.0
 */
@Configuration
public class ConfigBean {

    @Bean
    @LoadBalanced
    public RestTemplate getRestTemplate() {
        return new RestTemplate();
    }
//    默认负载均衡规则配置
//    @Bean
//    public IRule myRule() {
//        return new RandomRule();
//    }

}
