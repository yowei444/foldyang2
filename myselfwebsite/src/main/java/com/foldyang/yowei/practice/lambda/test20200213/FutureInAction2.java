package com.foldyang.yowei.practice.lambda.test20200213;

import org.junit.Test;

import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;

/**
 * @Author foldYang
 * @Description
 * @Date 2020/2/14
 * @Version 1.0
 */
public class FutureInAction2 {

    public static void main(String[] args) {
        Future<String> future = invoke(() -> {
            try {
                Thread.sleep(10000);
                return "I am finished";
            } catch (InterruptedException e) {
                e.printStackTrace();
                return "Error";
            }
        });
        System.out.println(future.get());
        while (!future.isDone()) {

        }
        System.out.println(future.get());

    }

    @Test
    public void show() {
        String str = block(() -> {
            try {
                Thread.sleep(10000);
                return "I am finished";
            } catch (InterruptedException e) {
                e.printStackTrace();
                return "Error";
            }
        });
        System.out.println(str);
    }

    private static <T> T block(Callable<T> option) {
        return option.option();
    }

    private static <T> Future<T> invoke(Callable<T> callable) {
        AtomicReference<T> atomicReference = new AtomicReference<>();
        AtomicBoolean atomicBoolean = new AtomicBoolean(false);
        Thread thread = new Thread(() -> {
            T result = callable.option();
            atomicReference.set(result);
            atomicBoolean.set(true);
        });
        thread.start();
        Future future = new Future() {
            @Override
            public Object get() {
                return atomicReference.get();
            }

            @Override
            public boolean isDone() {
                return atomicBoolean.get();
            }
        };
        return future;
    }

    private interface Callable<T> {
        T option();
    }

    private interface Future<T> {
        T get();

        boolean isDone();
    }

}
