package com.foldyang.yowei.practice.lambda.test20200203;

import org.junit.Test;

import java.util.ArrayList;
import java.util.concurrent.ForkJoinPool;

/**
 * @Author foldYang
 * @Description ForkJoin测试类
 * @Date 2020/2/3
 * @Version 1.0
 */
public class ForkJoinTest {

    @Test
    public void test01() {
        ArrayList<Long> arrayList = new ArrayList<>();
        for (int i = 0; i < 1_000_000; i++) {
            arrayList.add(Long.parseLong(i + ""));
        }
        long start = System.currentTimeMillis();
        AccumulatorRecursiverTask accumulatorRecursiverTask = new AccumulatorRecursiverTask(0L, Long.parseLong(arrayList.size() + ""), arrayList);
        ForkJoinPool forkJoinPool = new ForkJoinPool();
        long invoke = forkJoinPool.invoke(accumulatorRecursiverTask);
        long end = System.currentTimeMillis();

        long start2 = System.currentTimeMillis();
        long result = getSum(arrayList);
        long end2 = System.currentTimeMillis();
        System.out.println("forkJoin耗费时间为:" + (end - start));
        System.out.println("一般操作耗费时间为:" + (end2 - start2));
        System.out.println(invoke);
        System.out.println(result);
    }

    public Long getSum(ArrayList<Long> data) {
        long sum = 0;
        for (int i = 0; i < data.size(); i++) {
            sum += data.get(i);
        }
        return sum;
    }

    @Test
    public void test02() {
        int[] ints = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        AccumulatorRecursiverTask2 accumulatorRecursiverTask2 = new AccumulatorRecursiverTask2(0, ints.length, ints);
        ForkJoinPool forkJoinPool = new ForkJoinPool();
        Integer invoke = forkJoinPool.invoke(accumulatorRecursiverTask2);
        System.out.println(invoke);
    }

    @Test
    public void test03() {
        int[] ints = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        AccumulatorAction accumulatorAction = new AccumulatorAction(0, ints.length, ints);
        ForkJoinPool forkJoinPool = new ForkJoinPool();
        forkJoinPool.invoke(accumulatorAction);
        System.out.println(AccumulatorAction.AccumulatorHelper.getResult());
    }

    @Test
    public void test04() {
        int[] data = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        AccumulatorAction2 accumulatorAction2 = new AccumulatorAction2(0, data.length, data);
        ForkJoinPool forkJoinPool = new ForkJoinPool();
        forkJoinPool.invoke(accumulatorAction2);
        System.out.println(AccumulatorAction2.AccumulatorClass.getValue());
    }

}
