package com.foldyang.yowei.practice.testsuper;

/**
 * @Author foldYang
 * @Description 测试子父级super关键字
 * @Date 2019/12/28
 * @Version 1.0
 */
public class Father {

    private Integer id;
    private String name;

    public Father() {
        System.out.println("父类");
    }

    public Father(Integer id) {
        this.id = id;
        System.out.println("父类2");
    }

    public void show(){
        System.out.println(111);
    }



}
