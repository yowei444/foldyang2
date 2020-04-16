package com.foldyang.yowei.practice.lambda.test20200126;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.LongStream;
import java.util.stream.Stream;

/**
 * @Author foldYang
 * @Description lambda测试2
 * @Date 2020/1/26
 * @Version 1.0
 */
public class LambdaTest2 {

    @Test
    public void test01() {
        Collector<String, List<String>, List<String>> list = new TestToListCollector3<>();
        String[] str = new String[]{"one", "two", "three", "four", "five", "six", "seven", "eight", "nine", "ten"};
        List<String> list1 = Stream.of(str).filter(a -> a.length() >= 4).collect(list);

        System.out.println(list1);
    }

    @Test
    public void test02() {
        // 获取电脑cup核数
        System.out.println(Runtime.getRuntime().availableProcessors());
        getSum01(100000000);
        getSum02(100000000);
    }

    /**
     * @Author: foldYang
     * @Description: 获取累加值
     * @Date: 23:26 2020/1/26
     */
    public void getSum01(long limit) {
        long start = System.currentTimeMillis();
        Long reduce = Stream.iterate(1L, i -> i + 1).limit(limit).reduce(0L, (a, b) -> a + b);
        long end = System.currentTimeMillis();
        System.out.println(end - start);
    }

    /**
     * @Author: foldYang
     * @Description: 函数式获取值
     * @Date: 23:37 2020/1/26
     */
    public void getSum02(long limit) {
        long start = System.currentTimeMillis();
        long sum = LongStream.rangeClosed(0, limit).parallel().sum();
        long end = System.currentTimeMillis();
        System.out.println(end - start);
    }

}
