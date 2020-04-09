package com.foldyang.config;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RoundRobinRule;
import org.springframework.context.annotation.Bean;

/**
 * @Author foldYang
 * @Description ribbon自定义规则
 * @Date 2020/3/15
 * @Version 1.0
 */
public class MySelfRule {

    @Bean
    public IRule myRule() {
        return new RoundRobinRule();
        // return new RandomRule();
        // 自定义轮询一台服务器5次
        // return new MyRoundRobinRule();
    }

}
