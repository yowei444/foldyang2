package com.foldyang.yowei.practice.lambda.test20200203;

import java.util.concurrent.RecursiveTask;

/**
 * @Author foldYang
 * @Description
 * @Date 2020/2/3
 * @Version 1.0
 */
public class AccumulatorRecursiverTask2 extends RecursiveTask<Integer> {

    private final int start;
    private final int end;
    private final int[] data;
    private final int LIMIT = 3;

    public AccumulatorRecursiverTask2(int start, int end, int[] data) {
        this.start = start;
        this.end = end;
        this.data = data;
    }

    @Override
    protected Integer compute() {
        if (end - start <= LIMIT) {
            int result = 0;
            for (int i = start; i < end; i++) {
                result += data[i];
            }
            return result;
        }
        int mid = (start + end) / 2;
        AccumulatorRecursiverTask2 left = new AccumulatorRecursiverTask2(start, mid, data);
        AccumulatorRecursiverTask2 right = new AccumulatorRecursiverTask2(mid, end, data);
        left.fork();
        Integer rightValue = right.compute();
        Integer leftValue = left.join();
        return leftValue + rightValue;
    }
}
