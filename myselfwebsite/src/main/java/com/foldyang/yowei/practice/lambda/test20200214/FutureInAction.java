package com.foldyang.yowei.practice.lambda.test20200214;

import org.junit.Test;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * @Author foldYang
 * @Description jdk自带Future
 * @Date 2020/2/22
 * @Version 1.0
 */
public class FutureInAction {

    @Test
    public void show() {
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        Future<String> stringFuture = executorService.submit(() -> {
            try {
                Thread.sleep(10000);
                return "I am finished";
            } catch (InterruptedException e) {
                e.printStackTrace();
                return "Error";
            }
        });
        try {
            System.out.println("hahah");
            System.out.println(stringFuture.get());
            while (!stringFuture.isDone()) {

            }
            System.out.println(stringFuture.get());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        // executorService.shutdown();
    }

}
