package com.foldyang.yowei.practice;

import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * @Author foldYang
 * @Description 测试CommandLineRunner的作用：CommandLineRunner接口的作用是在springboot中实现了这个接口的类在项目启动后执行run方法里面的功能
 * @Date 2019/12/27
 * @Version 1.0
 */
@Component
@Order(value = 2)
public class CommandLineRunnerTestTwo implements CommandLineRunner {
    @Override
    public void run(String... args) throws Exception {
        System.out.println("》》》》服务第二顺序启动》》》》");
    }
}
