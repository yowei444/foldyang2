package com.foldyang.yowei.practice.lambda.test20200126;

import java.util.*;
import java.util.function.BiConsumer;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collector;
import java.util.stream.Collectors;

/**
 * @Author foldYang
 * @Description
 * @Date 2020/1/26
 * @Version 1.0
 */
public class TestToListCollector2<T> implements Collector<T, List<T>, List<T>> {

    /**
     * @Author: foldYang
     * @Description: 返回一个容器, 必须是可变的容器(供应商)
     * @Date: 2:12 2020/1/26
     */
    @Override
    public Supplier<List<T>> supplier() {
        return ArrayList::new;
    }

    /**
     * @Author: foldYang
     * @Description: 叠加
     * @Date: 2:13 2020/1/26
     */
    @Override
    public BiConsumer<List<T>, T> accumulator() {
        return List::add;
    }

    /**
     * @Author: foldYang
     * @Description: 组装数据, fork join
     * @Date: 2:14 2020/1/26
     */
    @Override
    public BinaryOperator<List<T>> combiner() {
        return (list1, list2) -> {
            list1.addAll(list2);
            return list1;
        };
    }

    /**
     * @Author: foldYang
     * @Description: 最终返回数据
     * @Date: 2:14 2020/1/26
     */
    @Override
    public Function<List<T>, List<T>> finisher() {
        return Function.identity();
    }

    /**
     * @Author: foldYang
     * @Description: 特征值
     * @Date: 2:15 2020/1/26
     */
    @Override
    public Set<Characteristics> characteristics() {
        return Collections.unmodifiableSet(EnumSet.of(Characteristics.IDENTITY_FINISH));
    }
}
