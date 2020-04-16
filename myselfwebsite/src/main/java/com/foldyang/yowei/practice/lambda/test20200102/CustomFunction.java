package com.foldyang.yowei.practice.lambda.test20200102;

/**
 * @Author foldYang
 * @Description 自定义Function
 * @Date 2020/1/8
 * @Version 1.0
 */
@FunctionalInterface
public interface CustomFunction<T, R, U, E> {
    E apply(T t, R r, U u);
}
