package com.foldyang.yowei.practice.lambda.test20200213;

import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;

/**
 * @Author foldYang
 * @Description
 * @Date 2020/2/13
 * @Version 1.0
 */
public class FutureInAction {
    public static void main(String[] args) {

        Future<String> invoke = invoke(() -> {
            try {
                Thread.sleep(10000);
                return "I am finished";
            } catch (Exception e) {
                e.printStackTrace();
                return "Error";
            }
        });
        System.out.println(invoke.get());
        System.out.println(invoke.get());
        System.out.println(invoke.get());
        while (!invoke.isDone()) {
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println(invoke.get());

    }

    private static <T> Future<T> invoke(Callable<T> callable) {
        AtomicReference<T> result = new AtomicReference<>();
        AtomicBoolean finished = new AtomicBoolean(false);
        Thread thread = new Thread(() -> {
            T value = callable.action();
            result.set(value);
            finished.set(true);
        });
        thread.start();
        Future<T> future = new FutureInAction.Future<T>() {
            @Override
            public T get() {
                return result.get();
            }

            @Override
            public boolean isDone() {
                return finished.get();
            }
        };
        return future;

    }

    private interface Future<T> {
        T get();
        boolean isDone();
    }

    private interface Callable<T> {
        T action();
    }
}