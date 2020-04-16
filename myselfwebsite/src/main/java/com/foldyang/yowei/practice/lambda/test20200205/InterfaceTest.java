package com.foldyang.yowei.practice.lambda.test20200205;

import org.junit.Test;

/**
 * @Author foldYang
 * @Description
 * @Date 2020/2/5
 * @Version 1.0
 */
public class InterfaceTest implements InterfaceDefaultTest {

    @Test
    public void test01() {
        InterfaceDefaultTest interfaceDefaultTest = () -> 10;
        System.out.println(interfaceDefaultTest.size());
        System.out.println(interfaceDefaultTest.isEmpty());
    }

    @Override
    public int size() {
        return 0;
    }

    @Override
    public boolean isEmpty() {
        return size() == 0;
    }
}
