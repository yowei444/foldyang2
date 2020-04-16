package com.foldyang.yowei.practice.lambda.test20200205;

/**
 * @Author foldYang
 * @Description
 * @Date 2020/2/5
 * @Version 1.0
 */
public interface InterfaceDefaultTest {

    int size();

    default boolean isEmpty() {
        return size() == 0;
    }

}
