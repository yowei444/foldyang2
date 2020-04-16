package com.foldyang.yowei.practice.lambda.test20200206;

import org.junit.Test;

/**
 * @Author foldYang
 * @Description
 * @Date 2020/2/6
 * @Version 1.0
 */
public class DefaultExtendsCase {

    public void say(Object one) {
        System.out.println("say int");
    }

    public void say(Long one) {
        System.out.println("say String");
    }

    @Test
    public void say() {
        say(null);
    }

    public interface A {
        default void say() {
            System.out.println("==A==");
        }
    }

    public interface B extends A {
        @Override
        default void say() {
            System.out.println("==B==");
        }
    }

    static class C implements B, A {
        @Override
        public void say() {
            B.super.say();
            System.out.println("==C==");
        }
    }

    @Test
    public void test02() {

    }

}
