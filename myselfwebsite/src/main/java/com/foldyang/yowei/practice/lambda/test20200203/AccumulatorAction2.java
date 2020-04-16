package com.foldyang.yowei.practice.lambda.test20200203;

import java.util.concurrent.RecursiveAction;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @Author foldYang
 * @Description
 * @Date 2020/2/3
 * @Version 1.0
 */
public class AccumulatorAction2 extends RecursiveAction {

    private final int start;
    private final int end;
    private final int[] data;
    private final int LIMIT = 3;

    public AccumulatorAction2(int start, int end, int[] data) {
        this.start = start;
        this.end = end;
        this.data = data;
    }

    @Override
    protected void compute() {
        if (end - start <= LIMIT) {
            for (int i = start; i < end; i++) {
                AccumulatorClass.addValue(data[i]);
            }
        } else {
            int mid = (start + end) / 2;
            AccumulatorAction2 left = new AccumulatorAction2(start, mid, data);
            AccumulatorAction2 right = new AccumulatorAction2(mid, end, data);
            left.fork();
            right.fork();
            left.join();
            right.join();
        }
    }

    static class AccumulatorClass {
        static AtomicInteger result = new AtomicInteger(0);

        static void addValue(int value) {
            result.getAndAdd(value);
        }

        public static int getValue() {
            return result.get();
        }
    }
}
