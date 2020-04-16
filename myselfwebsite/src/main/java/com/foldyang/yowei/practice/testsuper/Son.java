package com.foldyang.yowei.practice.testsuper;

/**
 * @Author foldYang
 * @Description
 * @Date 2019/12/28
 * @Version 1.0
 */
public class Son extends Father {
    public static Integer one=1;
    public Son() {
        this.show();
        System.out.println("子类");
    }

    public static void main(String[] args) {
        Son son =new Son();
    }
}
