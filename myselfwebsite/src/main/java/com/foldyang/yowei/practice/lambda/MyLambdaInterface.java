package com.foldyang.yowei.practice.lambda;

import java.util.List;

/**
 * @Author foldYang
 * @Description lambda接口测试学习
 * @Date 2019/12/27
 * @Version 1.0
 */
@FunctionalInterface
public interface MyLambdaInterface {
    void doSomeShit(List<String> list);
}
