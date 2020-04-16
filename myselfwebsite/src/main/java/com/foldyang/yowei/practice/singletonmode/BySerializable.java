package com.foldyang.yowei.practice.singletonmode;

import java.io.*;

/**
 * @Author foldYang
 * @Description
 * @Date 2020/3/10
 * @Version 1.0
 */
public class BySerializable {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        SingleInstance instance = SingleInstance.getInstance();
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("E:/test.txt"));
        oos.writeObject(instance);
        oos.flush();
        oos.close();
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream("E:/test.txt"));
        SingleInstance instance2=(SingleInstance)ois.readObject();
        System.out.println(instance);
        System.out.println(instance2);

    }
}
