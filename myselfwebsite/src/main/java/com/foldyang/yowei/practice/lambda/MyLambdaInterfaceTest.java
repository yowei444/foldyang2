package com.foldyang.yowei.practice.lambda;

import org.junit.Test;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @Author foldYang
 * @Description lambda表达式测试类
 * @Date 2019/12/27
 * @Version 1.0
 */
public class MyLambdaInterfaceTest {

    @Test
    public void test() {
        List<String> list = Arrays.asList("aaa", "bbb", "ccc");
        list.forEach(str -> modifyList(str, list));
        MyLambdaInterface aBlockOfCode = (list_) -> show();
        aBlockOfCode.doSomeShit(list);
        MyLambdaInterface aBlockOfCode2 = (list_) -> show2();
        aBlockOfCode2.doSomeShit(list);
        MyLambdaInterface aBlockOfCode3 = (list_) -> show3(list);
        aBlockOfCode3.doSomeShit(list);
    }

    public void modifyList(String str, List<String> list) {
        if (str.equals("aaa")) {
            System.out.println("这是aaa");
        }
        if (str.equals("bbb")) {
            System.out.println("这是bbb");
        }
        if (str.equals("ccc")) {
            System.out.println("这是ccc");
        }
    }

    public void show() {
        System.out.println(111);
        System.out.println(222);
    }

    public void show2() {
        System.out.println(111);
        System.out.println(222);
        System.out.println(333);
    }

    public void show3(List<String> list) {

    }

    @Test
    public void lambdaTest() {
        List<Person> guiltyPersons = Arrays.asList(
                new Person("Yixing", "Zhao", 25, 1),
                new Person("Yanggui", "Li", 30, 1),
                new Person("Chao", "Ma", 29, 1)
        );

        checkAndExecute(guiltyPersons, p -> p.getLastName().startsWith("Z"), p -> p.setLastName("符合参数"));
        System.out.println(guiltyPersons.toString());
    }

    public static void checkAndExecute(List<Person> personList, NameChecker nameChecker, Executor executor) {
        for (Person p : personList) {
            if (nameChecker.check(p)) {
                executor.execute(p);
            }
        }
    }

    @Test
    public void test2() {
        // 需求把添加的数据按照顺序排序
        List<Person> personList = Arrays.asList(
                new Person("张", "麻子", 24, 1),
                new Person("黄", "四郎", 23, 2),
                new Person("杨", "星辉", 25, 0)
        );
        personList = personList.stream().sorted(Comparator.comparing(Person::getOrder).reversed()).collect(Collectors.toList());
        System.out.println(personList);
    }

//    public List<Person> sortByOrder(List<Person> list, Executor2 executor) {
//        List<Person> people = executor.execute(list);
//        return people;
//    }
//
//    public List<Person> modifyList(List<Person> personList) {
//        List<Integer> list = new ArrayList<>();
//        List<Person> list1 = new ArrayList<>();
//        personList.forEach(p -> list.add(p.getOrder()));
//        list.forEach(p -> list1.add(personList.get(p)));
//        return list1;
//    }


}
