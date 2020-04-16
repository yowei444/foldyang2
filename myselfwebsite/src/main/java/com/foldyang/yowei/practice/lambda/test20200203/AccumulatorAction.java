package com.foldyang.yowei.practice.lambda.test20200203;

import java.util.concurrent.RecursiveAction;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @Author foldYang
 * @Description
 * @Date 2020/2/3
 * @Version 1.0
 */
public class AccumulatorAction extends RecursiveAction {

    private final int start;
    private final int end;
    private final int data[];
    private final int LIMIT = 3;

    public AccumulatorAction(int start, int end, int[] data) {
        this.start = start;
        this.end = end;
        this.data = data;
    }

    @Override
    protected void compute() {
        if (end - start <= 3) {
            for (int i = start; i < end; i++) {
                System.out.println("加一次");
                AccumulatorHelper.getAndAdd(data[i]);
            }
        } else {
            int mid = (start + end) / 2;
            AccumulatorAction left = new AccumulatorAction(start, mid, data);
            AccumulatorAction right = new AccumulatorAction(mid, end, data);
            left.fork();
            right.fork();
            left.join();
            right.join();
        }

    }

    static class AccumulatorHelper {
        private static final AtomicInteger result = new AtomicInteger(0);

        static void getAndAdd(int value) {
            result.getAndAdd(value);
        }

        public static int getResult() {
            return result.get();
        }

        static void rest() {
            result.set(0);
        }
    }
}
