package com.foldyang.yowei;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.core.annotation.Order;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.sql.DataSource;
import javax.swing.text.html.HTMLDocument;
import java.sql.Connection;
import java.util.*;
import java.util.function.Consumer;

@SpringBootApplication
@Slf4j
@RestController
@Order(value = 3)
public class YoweiApplication implements CommandLineRunner {
    // CommandLineRunner接口的作用是在springboot中实现了这个接口的类在项目启动后执行run方法里面的功能

    @Autowired
    private DataSource dataSource;

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public static void main(String[] args) {
        SpringApplication.run(YoweiApplication.class, args);
    }

    @RequestMapping("/hello")
    public String hello() {
        return "Hello spring";
    }

    @Override
    public void run(String... args) throws Exception {
        // System.out.println(1/0); 用于测试打包时的不运行项目的操作
        log.info(dataSource.toString());
        Connection connection = dataSource.getConnection();
        log.info(connection.toString());
        connection.close();
    }

    /**
     * @Author: foldYang
     * @Description: 遍历数据
     * @Date: 16:08 2019/12/27
     */
    private void showData() {
        jdbcTemplate.queryForList("SELECT * FROM FOO").forEach(row -> log.info(row.toString()));
    }

    /**
     * @Author: foldYang
     * @Description: 测试List遍历方式
     * @Date: 16:13 2019/12/27
     */
    @Test
    public void testList() {
        List<String> list = Arrays.asList("aaa", "bbb", "ccc");
        // for循环
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }
        System.out.println("=====================");
        // 增强for循环
        for (String str : list) {
            System.out.println(str);
        }
        System.out.println("=====================");
        // 迭代器
        Iterator<String> iterator = list.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
        System.out.println("=====================");
        // forEach
        list.forEach(new Consumer<String>() {
            @Override
            public void accept(String s) {
                System.out.println(s);
            }
        });
        System.out.println("=====================");
        // lambda表达式
        list.forEach(str -> System.out.println(str));

    }


}
