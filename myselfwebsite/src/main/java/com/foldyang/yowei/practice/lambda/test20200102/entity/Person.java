package com.foldyang.yowei.practice.lambda.test20200102.entity;

import lombok.Data;

import java.util.Optional;

/**
 * @Author foldYang
 * @Description
 * @Date 2020/1/18
 * @Version 1.0
 */
@Data
public class Person {

    private String name;
    private Integer age;
    private Car car;
    private Pets pets;

    public Pets getPets() {
        return Optional.ofNullable(pets).orElseGet(Pets::new);
    }

    public String getName() {
        return Optional.ofNullable(name).orElseGet(String::new);
    }

    public Integer getAge() {
        return Optional.ofNullable(age).orElse(-1);
    }

    public Car getCar() {
        return Optional.ofNullable(car).orElse(new Car());
    }


    public Person() {
    }

    public Person(String name, Integer age, Car car) {
        this.name = name;
        this.age = age;
        this.car = car;
    }

}
