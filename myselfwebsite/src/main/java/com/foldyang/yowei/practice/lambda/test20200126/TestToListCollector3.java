package com.foldyang.yowei.practice.lambda.test20200126;

import java.util.*;
import java.util.function.BiConsumer;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collector;

/**
 * @Author foldYang
 * @Description
 * @Date 2020/1/26
 * @Version 1.0
 */
public class TestToListCollector3<T> implements Collector<T, List<T>, List<T>> {

    /**
     * @Author: foldYang
     * @Description: 提供者，返回一个容器
     * @Date: 2:27 2020/1/26
     */
    @Override
    public Supplier<List<T>> supplier() {
        return ArrayList::new;
    }

    /**
     * @Author: foldYang
     * @Description: 叠加
     * @Date: 2:27 2020/1/26
     */
    @Override
    public BiConsumer<List<T>, T> accumulator() {
        return List::add;
    }

    /**
     * @Author: foldYang
     * @Description: 数据组装 fork join
     * @Date: 2:27 2020/1/26
     */
    @Override
    public BinaryOperator<List<T>> combiner() {
        return (left, right) -> {
            left.addAll(right);
            return left;
        };
    }

    /**
     * @Author: foldYang
     * @Description: 最终返回数据
     * @Date: 2:28 2020/1/26
     */
    @Override
    public Function<List<T>, List<T>> finisher() {
        return Function.identity();
    }

    /**
     * @Author: foldYang
     * @Description: 特征值
     * @Date: 2:28 2020/1/26
     */
    @Override
    public Set<Characteristics> characteristics() {
        return Collections.unmodifiableSet(EnumSet.of(Collector.Characteristics.IDENTITY_FINISH));
    }
}
