package com.foldyang.yowei.practice.lambda.test20200102.entity;

import lombok.Data;

import java.util.Optional;

/**
 * @Author foldYang
 * @Description 汽车实体类
 * @Date 2020/1/18
 * @Version 1.0
 */
@Data
public class Car {

    private String name;
    private String brand;
    private ElseThing elseThing;

    public ElseThing getElseThing() {
        return Optional.ofNullable(elseThing).orElseGet(ElseThing::new);
    }

    public String getName() {
        return Optional.ofNullable(name).orElseGet(String::new);
    }

    public String getBrand() {
        return Optional.ofNullable(brand).orElseGet(String::new);
    }

    public Car() {
    }

    public Car(String name, String brand) {
        this.name = name;
        this.brand = brand;
    }

}
