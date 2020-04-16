package com.foldyang.yowei.practice.lambda;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.stereotype.Service;

/**
 * @Author foldYang
 * @Description 测试lambda实体类
 * @Date 2019/12/28
 * @Version 1.0
 */
@AllArgsConstructor
@ToString
public class Person {

    // 姓
    @Getter
    @Setter
    private String firstName;
    // 名称
    @Getter
    @Setter
    private String lastName;
    // 年龄
    @Getter
    @Setter
    private int age;
    // 排序
    @Getter
    @Setter
    private Integer order;

}
