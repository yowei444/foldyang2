package com.foldyang.yowei.practice.lambda.test20200102.entity;

import lombok.Data;

import java.util.Optional;

/**
 * @Author foldYang
 * @Description 宠物
 * @Date 2020/1/19
 * @Version 1.0
 */
@Data
public class Pets {

    private String nickName;
    private Integer age;

    public String getNickName() {
        return Optional.ofNullable(nickName).orElse("");
    }

    public Integer getAge() {
        return Optional.ofNullable(age).orElse(-1);
    }

}
