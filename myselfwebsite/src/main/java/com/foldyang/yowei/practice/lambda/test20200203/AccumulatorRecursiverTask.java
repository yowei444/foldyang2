package com.foldyang.yowei.practice.lambda.test20200203;

import java.util.ArrayList;
import java.util.concurrent.RecursiveTask;

/**
 * @Author foldYang
 * @Description RecursiveTask测试
 * @Date 2020/2/3
 * @Version 1.0
 */
public class AccumulatorRecursiverTask extends RecursiveTask<Long> {

    private final Long start;
    private final Long end;
    private final ArrayList<Long> data;
    private final int LIMIT = 3;

    public AccumulatorRecursiverTask(Long start, Long end, ArrayList<Long> data) {
        this.start = start;
        this.end = end;
        this.data = data;
    }

    @Override
    protected Long compute() {
        if ((end - start) <= LIMIT) {
            Long result = 0L;
            for (Long i = start; i < end; i++) {
                result += data.get(Integer.parseInt(i+""));
            }
            // System.out.println("计算一次" + System.currentTimeMillis());
            return result;
        }
        Long mid = (start + end) / 2;
        AccumulatorRecursiverTask left = new AccumulatorRecursiverTask(start, mid, data);
        AccumulatorRecursiverTask right = new AccumulatorRecursiverTask(mid, end, data);
        left.fork();
        Long rightValue = right.compute();
        Long leftValue = left.join();
        return rightValue + leftValue;
    }
}
