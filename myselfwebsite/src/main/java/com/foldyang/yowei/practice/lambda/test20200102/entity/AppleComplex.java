package com.foldyang.yowei.practice.lambda.test20200102.entity;

import lombok.Data;
import lombok.ToString;

/**
 * @Author foldYang
 * @Description 复杂苹果实体类
 * @Date 2020/1/8
 * @Version 1.0
 */
@Data
@ToString
public class AppleComplex {

    public AppleComplex(String color, String brand, Integer weight) {
        this.color = color;
        this.brand = brand;
        this.weight = weight;
    }

    /**
     * 颜色
     */
    private String color;

    /**
     * 重量
     */
    private Integer weight;

    /**
     * 品牌
     */
    private String brand;

}
