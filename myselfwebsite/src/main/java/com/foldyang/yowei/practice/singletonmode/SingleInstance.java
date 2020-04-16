package com.foldyang.yowei.practice.singletonmode;

import java.io.ObjectStreamException;
import java.io.Serializable;

/**
 * @Author foldYang
 * @Description
 * @Date 2020/3/10
 * @Version 1.0
 */
public class SingleInstance implements Serializable {

    private static SingleInstance instance = new SingleInstance();

    private SingleInstance() {
        if (instance != null) {
            throw new RuntimeException();
        }
    }

    public static SingleInstance getInstance() {
        return instance;
    }

    private Object readResolve() throws ObjectStreamException {
        return instance;
    }

}
