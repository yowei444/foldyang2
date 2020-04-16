//package com.foldyang.yowei.practice.lambda.test20200102;
//
//import com.foldyang.yowei.practice.lambda.test20200102.entity.*;
//import org.junit.Test;
//
//import java.nio.file.Files;
//import java.nio.file.Path;
//import java.nio.file.Paths;
//import java.util.*;
//import java.util.concurrent.ConcurrentHashMap;
//import java.util.concurrent.ConcurrentMap;
//import java.util.concurrent.ConcurrentSkipListMap;
//import java.util.function.*;
//import java.util.stream.Collectors;
//import java.util.stream.IntStream;
//import java.util.stream.Stream;
//
//import static java.lang.System.*;
//import static java.util.stream.Collectors.*;
//
///**
// * @Author foldYang
// * @Description
// * @Date 2020/1/2
// * @Version 1.0
// */
//public class LambdaTest {
//
//    /**
//     * 问题
//     * Function 传入的<T,R> 其中的R是返回类型，为啥可以不为静态(看Function源码97行默认为传进来的参数加了static的意思吗)，但是Consumer中的void必须是静态(因为没有为传进来的参数加上static)
//     */
//
//    /**
//     * nio了解一下
//     */
//
//    /**
//     * A collection in Java 8 is like a movie stored on DVD --> Java8中的Collection就像在DVD中存储电影  Eager construction means waiting for computation of ALL values  -->  急切的构造意味着等待所有值的计算
//     * A stream in Java8 is like a movie streamed over the internet --> Java8中的流就像一部在互联网上传输的电影  Lazy construction means values are computed only as needed --> 惰性构造意味着只根据需要计算值
//     * collection 是把所有值算出来，然后给出答案  stream 是根据需要的值来计算得出答案
//     */
//
//    @Test
//    public void getList() throws InterruptedException {
//        assert 1 > 0;
//
//        List<Apple> apples = Arrays.asList(new Apple("red", 120), new Apple("green", 130), new Apple("white", 110));
//        List<Apple> apples1 = getList(apples, apple ->
//                apple.getColor().equals("red")
//        );
//
//
////        Collections.sort(apples, new Comparator<Apple>() {
////            @Override
////            public int compare(Apple o1, Apple o2) {
////                return o1.getWeight().compareTo(o2.getWeight());
////            }
////        });
////        Collections.sort(apples, (o1, o2) -> {
////            return o1.getWeight().compareTo(o2.getWeight());
////        });
//
//        apples.sort((o1, o2) -> {
//            return o1.getWeight().compareTo(o2.getWeight());
//        });
//
//        Function<String, Boolean> function = (String s) -> s.equals("aaa");
//        out.println(function.apply("aaaaa"));
//        Predicate predicate = s -> s.equals("a");
//        out.println(predicate.test("b") + "嘿嘿嘿嘿嘿");
//
//        BiConsumer<String, Integer> biConsumer = (s, a) -> out.println(s + a);
//        biConsumer.accept("one", 111);
//
//        Runnable runnable = () -> out.println(111);
//        Supplier<Apple> supplier = () -> {
//            return new Apple("blue", 110);
//        };
//        out.println(supplier.get());
//        runnable.run();
//
//        out.println(apples);
//
////        Thread thread = new Thread(new Runnable() {
////            @Override
////            public void run() {
////                System.out.println(Thread.currentThread().getName());
////            }
////        });
////        thread.start();
////        Thread.currentThread().join();
//
//    }
//
//
//    @FunctionalInterface
//    public interface AppleFilter {
//        boolean filter(Apple apple);
//    }
//
//    public List<Apple> getList(List<Apple> apples, AppleFilter appleFilter) {
//        ArrayList<Apple> apples1 = new ArrayList<>();
//        for (Apple apple : apples) {
//            if (appleFilter.filter((Apple) apple)) {
//                apples1.add(apple);
//            }
//        }
//        return apples1;
//    }
//
//    @Test
//    public void test02() {
//        List<Apple> list = Arrays.asList(new Apple("green", 120), new Apple("red", 130));
////        List<Apple> list1 = predicate(list, (a, b) -> a.getColor().equals("red") && b.equals("red"));
////        System.out.println(list1);
////        List<Apple> list2 = consumer(list, apple -> apple.setColor("blue"), apple -> apple.getColor().equals("red"));
////        System.out.println(list2);
//        Function<String, Integer> fun = Integer::parseInt;
//        out.println(fun.apply("123"));
//        List<Apple> list3 = function(list, "ss", s -> s.toString());
//        out.println(list3);
//        BiFunction<String, Integer, Character> biFun = String::charAt;
//
//        List<Apple> list1 = supplier(list, () -> new Apple("blue", 120));
//        out.println(list1);
//
//        // 推导 静态
//        Function<String, Integer> fun2 = Integer::parseInt;
//        out.println(fun2.apply("111"));
//
//
//    }
//
//    public void setList(List<Apple> apples, Apple apple) {
//        for (Apple apple1 : apples) {
//            apple1 = apple;
//        }
//    }
//
//    public <T> void reConsumer(Consumer<T> consumer, T t) {
//        consumer.accept(t);
//    }
//
//    public List<Apple> predicate(List<Apple> apples, BiPredicate<Apple, String> predicate) {
//        List<Apple> list = new ArrayList<>();
//        for (Apple apple : apples) {
//            if (predicate.test(apple, apple.getColor())) {
//                list.add(apple);
//            }
//        }
//        return list;
//    }
//
//    public List<Apple> consumer(List<Apple> list, Consumer<Apple> appleConsumer, Predicate<Apple> applePredicate) {
//        for (Apple apple : list) {
//            if (applePredicate.test(apple)) {
//                appleConsumer.accept(apple);
//            }
//        }
//        return list;
//    }
//
//    public List<Apple> function(List<Apple> apples, String temp, Function<Apple, String> function) {
//        List<Apple> apples1 = new ArrayList<>();
//        for (Apple apple : apples) {
//            String string = function.apply(apple);
//            apple.setColor(string);
//            apples1.add(apple);
//        }
//        return apples1;
//    }
//
//    public List<Apple> supplier(List<Apple> apples, Supplier<Apple> appleSupplier) {
//        List<Apple> apples1 = new ArrayList<>();
//        for (Apple apple : apples) {
//            apples1.add(appleSupplier.get());
//        }
//        return apples1;
//
//    }
//
//    @Test
//    public void test03() {
////        String one = "onetwothree";
////        char c = one.charAt(0);
////        System.out.println(c);
////        Function<Integer, Character> function = one1 -> charAtt(one1);
//
//        Supplier<String> supplier = String::new;
//        String s = supplier.get();
//        out.println(s);
//
//        BiFunction<String, Integer, Apple> supplier1 = Apple::new;
//        out.println(supplier1.apply("blue", 122));
//
//        CustomFunction<String, String, Integer, AppleComplex> complexCustomFunction = AppleComplex::new;
//        out.println(complexCustomFunction.apply("红色", "红富士", 120));
//
//        List<Apple> list = Arrays.asList(new Apple("green", 120), new Apple("blue", 134), new Apple("red", 130));
//
//        // 排序方法一
//        list.sort(new Comparator<Apple>() {
//            @Override
//            public int compare(Apple o1, Apple o2) {
//                return o1.getWeight().compareTo(o2.getWeight());
//            }
//        });
//
//        // 排序方法二
//        list.sort((o1, o2) -> {
//            return o1.getWeight().compareTo(o2.getWeight());
//        });
//
//        // 排序方法三
//        list.sort(Comparator.comparing(Apple::getWeight));
//        out.println(list);
//
//        // 静态方法
//        Function<String, Integer> function = Integer::parseInt;
//        out.println(function.apply("111"));
//
//        // 类方法
//        BiFunction<String, Integer, Character> biFunction = String::charAt;
//        out.println(biFunction.apply("one", 1));
//
//        // 对象的实例方法(推导过程它会自动判断传参个数，类型)
//        String str = new String("one");
//        Function<Integer, Character> biFunction1 = str::charAt;
//        out.println(biFunction1.apply(1));
//    }
//
//    @Test
//    public void test04() {
//        List<Apple> list = Arrays.asList(new Apple("green", 120), new Apple("blue", 134), new Apple("red", 130), new Apple("yellow", 131), new Apple("gray", 137));
//        out.println(list.stream().filter(apple -> apple.getWeight() >= 130).sorted(Comparator.comparing(apple -> apple.getWeight())).map(apple -> apple.getColor()).collect(toList()));
//    }
//
//    @Test
//    public void test05() {
//        List<Apple> apples = Arrays.asList(new Apple("red", 110), new Apple("blue", 100), new Apple("green", 130), new Apple("yellow", 120));
//        // System.out.println(sortStream(apples));
//        out.println("==========================");
//        out.println(sortParallel(apples));
//    }
//
//    public static void main(String[] args) {
//        List<Apple> apples = Arrays.asList(new Apple("red", 110), new Apple("blue", 100), new Apple("green", 130), new Apple("yellow", 120));
//        out.println(sortStream(apples));
//        out.println("==========================");
//        // System.out.println(sortParallel(apples));
//    }
//
//    /**
//     * @Author: foldYang
//     * @Description: 非并行排序
//     * @Date: 19:58 2020/1/12
//     */
//    public static List<Object> sortStream(List<Apple> apples) {
//        return apples.stream().filter(apple -> apple.getWeight() >= 120).sorted(Comparator.comparing(Apple::getWeight)).map(apple -> {
//            try {
//                Thread.sleep(100000);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//            return apple.getColor();
//        }).collect(Collectors.toList());
//    }
//
//    /**
//     * @Author: foldYang
//     * @Description: 并行排序
//     * @Date: 19:58 2020/1/12
//     */
//    public static List<Object> sortParallel(List<Apple> apples) {
//        return apples.parallelStream().filter(apple -> apple.getWeight() >= 120).sorted(Comparator.comparing(Apple::getWeight)).map(apple -> {
////            try {
////                Thread.sleep(100000);
////            } catch (InterruptedException e) {
////                e.printStackTrace();
////            }
//            return apple.getColor();
//        }).collect(Collectors.toList());
//    }
//
//    @Test
//    public void test06() {
//        List<Apple> apples = Arrays.asList(new Apple("red", 110), new Apple("blue", 100), new Apple("green", 130), new Apple("yellow", 120));
//        Stream<Apple> stream = apples.stream();
//        stream.forEach(out::println);
//        Stream stream1 = apples.stream();
//        stream1.forEach(out::println);
//    }
//
//    /**
//     * @Author: foldYang
//     * @Description: stream intermediate operations 和 terminal operation 一个表示过程一个表示结果返回
//     * @Date: 22:00 2020/1/12
//     */
//    @Test
//    public void test07() {
//        List<Apple> apples = Arrays.asList(new Apple("red", 110), new Apple("blue", 100), new Apple("green", 130), new Apple("yellow", 120));
//        out.println(apples.stream().filter(apple -> apple.getWeight() <= 110));
//    }
//
//    /**
//     * @Author: foldYang
//     * @Description:
//     * @Date: 22:45 2020/1/12
//     */
//    @Test
//    public void test08() {
//        Path path = Paths.get("E:\\myselfwebsite\\src\\main\\java\\com\\foldyang\\yowei\\practice\\lambda\\test20200102\\LambdaTest.java");
//        try {
//            Files.lines(path).forEach(LambdaTest::printLineByPredicate);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }
//
//    /**
//     * @Author: foldYang
//     * @Description: 按照条件打印数据
//     * @Date: 22:55 2020/1/12
//     */
//    public static void printLineByPredicate(String str) {
//        Predicate<String> predicate = str::contains;
//        if (predicate.test("print")) {
//            out.println(str);
//        }
//    }
//
//    @Test
//    public void test09() {
//        Stream.iterate("one", one -> one = one + "1").limit(10).forEach(out::println);
//    }
//
//    @Test
//    public void test10() {
//        Apple apple = new Apple();
//        Stream.generate(Math::random).limit(10).sorted().forEach(out::println);
//    }
//
//    @Test
//    public void test11() {
//        Stream.generate(new ObjSupplier()).limit(10).forEach(out::println);
//    }
//
//    static class ObjSupplier implements Supplier {
//
//        Random random = new Random();
//
//        @Override
//        public Obj get() {
//            return new Obj(random.nextInt(100), "name" + random.nextInt(100));
//        }
//    }
//
//    static class Obj {
//        private Integer age;
//        private String name;
//
//        public Integer getAge() {
//            return age;
//        }
//
//        public void setAge(Integer age) {
//            this.age = age;
//        }
//
//        public String getName() {
//            return name;
//        }
//
//        public void setName(String name) {
//            this.name = name;
//        }
//
//        public Obj(Integer age, String name) {
//            this.age = age;
//            this.name = name;
//        }
//
//        @Override
//        public String toString() {
//            return "Obj{" +
//                    "age=" + age +
//                    ", name='" + name + '\'' +
//                    '}';
//        }
//    }
//
//    /**
//     * @Author: foldYang
//     * @Description: 这里深刻理解
//     * @Date: 0:24 2020/1/14
//     */
//    @Test
//    public void test12() {
//        String[] str = {"on,e", "three"};
//        // Arrays.stream(str).map(d -> d.split(",")).flatMap(Arrays::stream).forEach(System.out::println);
//
//        Stream<String> stream = Arrays.stream(str);
//        // on,e , three
//        stream.forEach(out::println);
//        // {o,n,,,e},{t,h,r,e,e}
//        Stream<String[]> stream1 = stream.map(a -> a.split(""));
//        // o,n,,,e,t,h,r,e,e
//        Stream<String> stringStream = stream1.flatMap(a -> {
//            return Arrays.stream(a);
//        });
//    }
//
//    @Test
//    public void test13() {
//        Stream<Integer> integerStream = Stream.of(new Integer[]{1, 2, 3, 4, 5, 6, 7});
//        boolean b = integerStream.allMatch(integer -> integer > 0);
//        out.println(b);
//
//        integerStream = Arrays.stream(new Integer[]{1, 2, 3, 4, 5, 6, 7});
//        boolean c = integerStream.noneMatch(integer -> integer == 10);
//        out.println(c);
//    }
//
//    @Test
//    public void test14() {
//        Stream<Integer> integerStream = Stream.of(new Integer[]{1, 2, 3, 4, 5, 6, 7});
//        Optional<Integer> any = integerStream.findAny();
//        out.println(any.get());
//
//        integerStream = Stream.of(new Integer[]{1, 2, 3, 4, 5, 6, 7});
//        Optional<Integer> first = integerStream.findFirst();
//        out.println(first.get());
//
//        // findAny()和findFirst()的区别
//        // 在非并行的情况下，串行的情况下，一般findAny会返回第一个数据，但是在并行的情况下，会随机返回 示例
//
//        List<String> lst1 = Arrays.asList("Jhonny", "David", "Jack", "Duke", "Jill", "Dany", "Julia", "Jenish", "Divya");
//        List<String> lst2 = Arrays.asList("Jhonny", "David", "Jack", "Duke", "Jill", "Dany", "Julia", "Jenish", "Divya");
//
//        // 返回的一定是Jhonny
//        Optional<String> j1 = lst1.parallelStream().filter(a -> a.startsWith("J")).findFirst();
//        // 返回的可能是 David/Duke/Dany/Divya
//        Optional<String> d = lst2.parallelStream().filter(a -> a.startsWith("D")).findAny();
//        out.println(j1.get());
//        out.println(d.get());
//
//    }
//
//    @Test
//    public void test15() {
//        Integer[] integers = new Integer[]{1, 2, 3, 4, 5, 6, 7};
//        // 这里没有值就会报错
//        // System.out.println(Stream.of(integers).filter(a -> a > 10).findAny().get());
//        // 用orElse
//        out.println(Stream.of(integers).filter(a -> a > 10).findAny().orElse(-1));
//        // 个人写法
//        out.println(getIntegerValue(integers, -1, integer -> integer < 10));
//        // 返回true和false
//        out.println(Stream.of(integers).filter(a -> a == 1).findFirst().isPresent());
//
//        out.println(Stream.of(integers).filter(integer -> integer == 2).findFirst().get());
//
//    }
//
//    /**
//     * @Author: foldYang
//     * @Description: 如果不满足条件就获取默认值
//     * @Date: 0:37 2020/1/15
//     */
//    public int getIntegerValue(Integer[] integers, Integer defaultValue, Predicate<Integer> predicate) {
//        for (Integer integer1 : integers) {
//            if (predicate.test(integer1)) {
//                return integer1;
//            }
//        }
//        return defaultValue;
//    }
//
//    @Test
//    public void test16() {
//        Integer[] integers = new Integer[]{1, 2, 3, 4, 5, 6, 7};
//        // 这里的意思是1-1-2-3-4-5-6-7
//        out.println(Stream.of(integers).reduce(1, (a, b) -> a - b));
//        // 这里的意思是0-1-2-3-4-5-6-7
//        out.println(Stream.of(integers).reduce(0, (a, b) -> a - b));
//        // (a, b) -> Integer.sum(a, b))返回的是int值，所以符合条件
//        out.println(Stream.of(integers).reduce(0, (a, b) -> Integer.sum(a, b)));
//        // 如果存在就打印
//        Stream.of(integers).filter(a -> a < 7).reduce(Integer::max).ifPresent(out::println);
//        // 偶数相乘
//        Stream.of(integers).filter(a -> a % 2 == 0).reduce((a, b) -> a * b).ifPresent(out::println);
//        // Optional的相乘
//        Integer integer = Stream.of(integers).filter(a -> a % 2 == 0).reduce((a, b) -> a * b).get();
//        out.println("===============");
//        Optional.of(integer).ifPresent(out::println);
//        out.println(integer);
//    }
//
//    /**
//     * @Author: foldYang
//     * @Description: 拆箱操作
//     * @Date: 23:43 2020/1/15
//     */
//    @Test
//    public void test17() {
//        Integer[] integers = new Integer[]{1, 2, 3, 4, 5, 6, 7, 8, 9};
//        int reduce1 = Stream.of(integers).mapToInt(i -> i.intValue()).filter(integer -> integer > 3).reduce(0, Integer::sum);
//
//        out.println(reduce1);
//
//        int[] ints = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9};
//        Stream.of(ints);
//
//    }
//
//    /**
//     * @Author: foldYang
//     * @Description: 装箱操作
//     * @Date: 23:44 2020/1/15
//     */
//    @Test
//    public void test18() {
//        int a = 9;
//        IntStream.rangeClosed(1, 100)
//                .filter(b -> Math.sqrt(a * a + b * b) % 1 == 0).boxed()
//                .map(r -> new Integer[]{r, a, (int) Math.sqrt(r * r + a * a)}).forEach(r -> out.println(r[0] + ":" + r[1] + ":" + r[2]));
//    }
//
//    @Test
//    public void test19() {
//        int a = 3;
//        IntStream.rangeClosed(1, 100).filter(b -> Math.sqrt(b * b + a * a) % 1 == 0).boxed().map(b -> new int[]{a, b, (int) Math.sqrt(a * a + b * b)}).forEach(b -> out.println(b[0] + ":" + b[1] + ":" + b[2]));
//    }
//
//    @Test
//    public void test20() {
//        int a = 12, start = 1, end = 100;
//        IntStream.rangeClosed(start, end).filter(temp -> Math.sqrt(a * a + temp * temp) % 1 == 0).boxed().map(temp -> new int[]{a, temp, (int) Math.sqrt(a * a + temp * temp)}).forEach(temp -> out.println(temp[0] + ":" + temp[1] + ":" + temp[2]));
//    }
//
//    /**
//     * @Author: foldYang
//     * @Description: 装箱操作
//     * @Date: 23:44 2020/1/15
//     */
//    @Test
//    public void test21() {
//        int a = 13, start = 1, end = 100;
//        IntStream.rangeClosed(start, end)
//                .filter(temp -> Math.sqrt(a * a + temp * temp) % 1 == 0)
//                .mapToObj(temp -> new int[]{a, temp, (int) Math.sqrt(a * a + temp * temp)})
//                .forEach(temp -> out.println(temp[0] + ":" + temp[1] + ":" + temp[2]));
//
//        out.println(13 * 13 + 84 * 84 == 85 * 85);
//    }
//
//    @Test
//    public void test22() {
//        Trader trader = new Trader("尼特罗", 77, "日本");
//        Trader trader1 = new Trader("迦楼罗", 78, "西藏");
//        Trader trader2 = new Trader("路飞", 79, "日本");
//        Trader trader3 = new Trader("哟喂", 80, "中国");
//
//
//        List<Transcation> transcations = Arrays.asList(new Transcation(trader, 2011, 2000),
//                new Transcation(trader, 2012, 3000),
//                new Transcation(trader1, 2011, 4000),
//                new Transcation(trader1, 2012, 5000),
//                new Transcation(trader2, 2011, 6000),
//                new Transcation(trader2, 2012, 7000),
//                new Transcation(trader3, 2011, 8000),
//                new Transcation(trader3, 2012, 9000));
//
//        // 1.获取2011年所有交易，然后根据它的value进行排序
//        List<Transcation> collect = transcations.stream().filter(a -> a.getYear() == 2011).sorted(Comparator.comparing(Transcation::getValue)).collect(toList());
//        out.println(collect);
//        out.println("====================");
//
//        // 2.哪些城市是唯一的
//        List<String> collect1 = transcations.stream().map(Transcation::getTrader).map(Trader::getCity).distinct().collect(toList());
//        out.println(collect1);
//        out.println("====================");
//
//        // 3.找到所有的日本的Trader然后通过他们的名字进行排序
//        List<Trader> traderList = transcations.stream().map(Transcation::getTrader).filter(a -> a.getCity().equals("日本")).distinct().sorted(Comparator.comparing(Trader::getAge)).collect(toList());
//        out.println(traderList);
//        out.println("====================");
//
//        // 4.把名字Trader的名字连接起来 String就是拼接吗，数字就是加吗
//        String reduce = transcations.stream().map(Transcation::getTrader).map(Trader::getName).sorted().reduce("", (a, b) -> a + b);
//        out.println(reduce);
//        out.println("====================");
//
//        // 5.有Trader在中国吗？
//        boolean anyMatch = transcations.stream().anyMatch(a -> a.getTrader().getCity().equals("中国"));
//        out.println(anyMatch);
//        out.println("====================");
//
//        // 6.打印出所有在日本的业务员做的业务
//        List<Integer> transcations1 = transcations.stream().filter(a -> a.getTrader().getCity().equals("日本")).map(Transcation::getValue).collect(toList());
//        out.println(transcations1);
//        out.println("====================");
//
//        // 7.打印出最高的Transcation
//        Optional<Integer> reduce1 = transcations.stream().map(Transcation::getValue).reduce(Integer::max);
//        out.println(reduce1.get());
//
//        // 8.打印出最低的Transcation
//        Integer integer = transcations.stream().map(Transcation::getValue).reduce((a, b) -> a > b ? b : a).get();
//        out.println(integer);
//
//    }
//
//    @Test
//    public void test23() {
////        Optional<Person> person = Optional.<Person>empty();
////        // 这里为空所以报错
////        // System.out.println(person.get());
////
////        // 这里的of后面不能为null，可看源码看到为null它要报一个空指针一次
////        Optional<Person> person1 = Optional.of(new Person());
////        System.out.println(person1);
//
//        //
//        Optional<Person> optionalPerson = Optional.ofNullable(null);
//        // System.out.println(optionalPerson.get());
//
//        // 这里的Person::new指的是Person的无参构造
//        out.println(optionalPerson.orElseGet(Person::new));
//
//        // 这里的() -> 的()指的是Supplier的get()的括号
//        out.println(optionalPerson.orElseGet(() -> new Person("", 1, new Car())));
//
//        // 这里的Person::new指的是Person的无参构造
//        out.println(optionalPerson.orElse(new Person()));
//
//        String one = null;
//        out.println(Optional.ofNullable(one).orElseGet(() -> new String("on")));
//
//        // 在这里of(person)中person为null的话，底层会判断是否为null，为null报空指针
//        // Person person = null;
//        // System.out.println(Optional.of(person).orElse(new Person()));
//        // System.out.println(optionalPerson.orElseThrow(RuntimeException::new));
//
//        // orElseGet 和 orElse的区别在于一个用的Supplier，一个用的纯对象
//
//        // Person person = null;
//        // System.out.println(Optional.ofNullable(person).orElseThrow(() -> new RuntimeException("空指针")));
//        // System.out.println(Optional.ofNullable(person).orElseThrow(RuntimeException::new));
//
//        // 这里一个对象只能一个对象去判断，不能越过这个对象去直接访问它的下一层包含的对象
//        Person person1 = new Person("one", 12, new Car());
//        // System.out.println(Optional.ofNullable(person1.getCar()).orElseGet(Car::new));
//        Person person2 = Optional.ofNullable(person1).filter(person -> person.getName() != null).get();
//        out.println(person2);
//
//        // Person person_ = null;
//        // System.out.println("------------------->");
//        // of 要判断是否传入的值为空，为空的话要抛出一个空指针异常 ofNullable不会，如果为null它会返回一个默认的值
//        // Person person = Optional.of(person_).orElse(new Person("one",12,new Car()));
//        // System.out.println(person);
//
//        out.println(Optional.of(new Person()).orElse(new Person()));
//
//        out.println(Optional.of(new Person()).map(Person::getName).orElse("haha"));
//
//        Car x = Optional.of(new Person()).map(Person::getCar).orElse(new Car("哈哈哈", "奔驰"));
//        out.println(x);
//
//        Person person = new Person();
//        out.println(person.getAge());
//        Optional.ofNullable(person).map(Person::getCar).map(Car::getBrand).ifPresent(out::println);
//        // System.out.println(s.length());
//        Long l = null;
//        long l1 = Optional.ofNullable(l).orElse(2L);
//        out.println(l1);
//        // 熟练使用java8 stream流式编程，函数式编程
//
//    }
//
//    @Test
//    public void test24() {
//        Person person = null;
//        // map和flatMap的区别
//        // String unknow = Optional.ofNullable(person).map(Person::getCar).map(Car::getElseThing).map(ElseThing::getParameters).orElse("unknow");
//        Integer age = Optional.ofNullable(person).map(Person::getPets).orElse(new Pets()).getAge();
//        // System.out.println(unknow);
//        out.println(age);
//        Optional.ofNullable(person).map(Person::getPets).map(Pets::getAge).ifPresent(out::println);
//    }
//
//    @Test
//    public void test25() {
//        List<Apple> apples = Arrays.asList(new Apple("red", 110),
//                new Apple("orange", 120),
//                new Apple("blue", 130),
//                new Apple("orange", 140),
//                new Apple("blue", 150),
//                new Apple("orange", 160),
//                new Apple("blue", 130),
//                new Apple("orange", 120),
//                new Apple("blue", 130));
//        out.println(getAppleList(apples));
//        out.println(getApples(apples));
//        out.println(getAppleListByStream(apples));
//        out.println(getAppleListByStream2(apples));
//        out.println(getAppleListByCollectors(apples));
//    }
//
//    /**
//     * @Author: foldYang
//     * @Description: 测试引用
//     * @Date: 22:54 2020/1/20
//     */
//    public Map<String, List<Apple>> getApples(List<Apple> list) {
//        Map<String, List<Apple>> map = new HashMap<>();
//        for (Apple apple : list) {
//            List<Apple> list1 = map.get(apple.getColor());
//            if (list1 == null) {
//                list1 = new ArrayList<>();
//                map.put(apple.getColor(), list1);
//            }
//            list1.add(apple);
//        }
//        return map;
//    }
//
//    /**
//     * @Author: foldYang
//     * @Description: 非函数式编程
//     * @Date: 22:03 2020/1/20
//     */
//    public Map<String, List<Apple>> getAppleList(List<Apple> list) {
//        Map<String, List<Apple>> map = new HashMap<>();
//        for (Apple apple : list) {
//            List<Apple> list1 = new ArrayList<>();
//            for (Apple apple1 : list) {
//                if (apple.getColor().equals(apple1.getColor()) && !map.containsKey(apple.getColor())) {
//                    list1.add(apple1);
//                }
//            }
//            if (list1.size() > 0) {
//                map.put(apple.getColor(), list1);
//            }
//        }
//        return map;
//    }
//
//
//    /**
//     * @Author: foldYang
//     * @Description: 带函数式编程
//     * @Date: 22:04 2020/1/20
//     */
//    public Map<String, List<Apple>> getAppleListByStream(List<Apple> list) {
//        Map<String, List<Apple>> listMap = new HashMap<>();
//        list.stream().forEach(apple -> {
//            List<Apple> apples = Optional.ofNullable(listMap.get(apple.getColor())).orElseGet(ArrayList::new);
//            apples.add(apple);
//            listMap.put(apple.getColor(), apples);
//        });
//        return listMap;
//    }
//
//    /**
//     * @Author: foldYang
//     * @Description: 带函数式编程2
//     * @Date: 23:36 2020/1/20
//     */
//    public Map<String, List<Apple>> getAppleListByStream2(List<Apple> apples) {
//        Map<String, List<Apple>> listMap = new HashMap<>();
//        apples.forEach(apple ->
//                {
//                    List<Apple> list1 = Optional.ofNullable(listMap.get(apple.getColor())).orElseGet(() -> {
//                        List<Apple> list = new ArrayList<>();
//                        listMap.put(apple.getColor(), list);
//                        return list;
//                    });
//                    list1.add(apple);
//                }
//        );
//        return listMap;
//    }
//
//    /**
//     * @Author: foldYang
//     * @Description: 获取列表分类后的数据
//     * @Date: 23:46 2020/1/20
//     */
//    public Map<String, List<Apple>> getAppleListByCollectors(List<Apple> list) {
//        return list.parallelStream().collect(Collectors.groupingBy(Apple::getColor));
//    }
//
//    @Test
//    public void test26() {
//        List<Apple> apples = Arrays.asList(new Apple("red", 110),
//                new Apple("orange", 120),
//                new Apple("blue", 130),
//                new Apple("orange", 140),
//                new Apple("blue", 150),
//                new Apple("orange", 160),
//                new Apple("blue", 130),
//                new Apple("orange", 120),
//                new Apple("blue", 130));
//        testAveragingDouble(apples);
//        testAveragingInt(apples);
//        testAveragingLong(apples);
//        testCollectingAndThen(apples);
//        testCounting(apples);
//        testGroupByFunction(apples);
//        testGroupByFunctionAndCollector(apples);
//        testSummarizing(apples);
//    }
//
//    /**
//     * @Author: foldYang
//     * @Description: 获取平均值Double
//     * @Date: 23:15 2020/1/21
//     */
//    public void testAveragingDouble(List<Apple> list) {
//        Optional.ofNullable(Optional.ofNullable(list).orElseGet(ArrayList::new).parallelStream().collect(averagingDouble(Apple::getWeight))).ifPresent(out::println);
//    }
//
//    /**
//     * @Author: foldYang
//     * @Description: 获取平均值Int
//     * @Date: 23:25 2020/1/21
//     */
//    public void testAveragingInt(List<Apple> list) {
//        Optional.ofNullable(Optional.ofNullable(list).orElseGet(ArrayList::new).parallelStream().collect(Collectors.averagingInt(Apple::getWeight))).ifPresent(out::println);
//    }
//
//    /**
//     * @Author: foldYang
//     * @Description: 获取平均值Long
//     * @Date: 23:31 2020/1/21
//     */
//    public void testAveragingLong(List<Apple> list) {
//        Optional.ofNullable(Optional.ofNullable(list).orElseGet(ArrayList::new).parallelStream().collect(averagingLong(Apple::getWeight))).ifPresent(out::println);
//    }
//
//    /**
//     * @Author: foldYang
//     * @Description: 测试CollectingAndThen
//     * @Date: 23:34 2020/1/21
//     */
//    public void testCollectingAndThen(List<Apple> list) {
//        Optional.ofNullable(Optional.ofNullable(list).orElseGet(ArrayList::new).parallelStream().collect(collectingAndThen(averagingDouble(Apple::getWeight), a -> "平均值是:" + a))).ifPresent(out::println);
//        Optional.ofNullable(Optional.ofNullable(list).orElseGet(ArrayList::new).parallelStream().collect(Collectors.collectingAndThen(Collectors.averagingDouble(Apple::getWeight), aDouble -> aDouble))).ifPresent(out::println);
//        List<Apple> list1 = Optional.ofNullable(Optional.ofNullable(list).orElseGet(ArrayList::new).parallelStream().filter(apple -> apple.getWeight() < 130).collect(toList())).orElseGet(ArrayList::new);
//        list1.add(new Apple("orange", 1111));
//        out.println(list1);
//        List<Apple> list2 = Optional.ofNullable(list).orElseGet(ArrayList::new).parallelStream().filter(apple -> apple.getWeight() < 130).collect(collectingAndThen(toList(), Collections::unmodifiableList));
//        // list2.add(new Apple("orange", 111));
//        out.println(list2);
//    }
//
//    /**
//     * @Author: foldYang
//     * @Description: 测试数量
//     * @Date: 0:15 2020/1/22
//     */
//    public void testCounting(List<Apple> list) {
//        Optional.ofNullable(Optional.ofNullable(list).orElseGet(ArrayList::new).parallelStream().collect(counting())).ifPresent(out::println);
//    }
//
//    /**
//     * @Author: foldYang
//     * @Description: 测试分组
//     * @Date: 0:19 2020/1/22
//     */
//    public void testGroupByFunction(List<Apple> list) {
//        Optional.ofNullable(Optional.ofNullable(list).orElseGet(ArrayList::new).parallelStream().collect(Collectors.groupingBy(Apple::getColor))).ifPresent(out::println);
//    }
//
//    /**
//     * @Author: foldYang
//     * @Description: 多重获取值
//     * @Date: 0:24 2020/1/22
//     */
//    public void testGroupByFunctionAndCollector(List<Apple> list) {
//        Optional.ofNullable(Optional.ofNullable(list).orElseGet(ArrayList::new).parallelStream().collect(Collectors.groupingBy(Apple::getColor))).ifPresent(out::println);
//        Optional.ofNullable(Optional.ofNullable(list).orElseGet(ArrayList::new).parallelStream().collect(Collectors.groupingBy(Apple::getColor, Collectors.groupingBy(Apple::getWeight)))).ifPresent(out::println);
//        Optional.ofNullable(Optional.ofNullable(list).orElseGet(ArrayList::new).parallelStream().collect(groupingBy(Apple::getColor, TreeMap::new, groupingBy(Apple::getColor)))).ifPresent(out::println);
//    }
//
//    /**
//     * @Author: foldYang
//     * @Description: 测试Summarizing
//     * @Date: 0:46 2020/1/22
//     */
//    public void testSummarizing(List<Apple> list) {
//        Optional.ofNullable(Optional.ofNullable(list).orElseGet(ArrayList::new).parallelStream().collect(summarizingInt(Apple::getWeight))).ifPresent(out::println);
//    }
//
//    @Test
//    public void test27() {
//        List<Apple> apples = Arrays.asList(new Apple("red", 110),
//                new Apple("orange", 120),
//                new Apple("blue", 130),
//                new Apple("orange", 140),
//                new Apple("blue", 150),
//                new Apple("orange", 160),
//                new Apple("blue", 130),
//                new Apple("orange", 120),
//                new Apple("blue", 130));
//        tesetConcurrentHashMap(apples);
//        testJoining(apples);
//        testMapping(apples);
//        testMaxBy(apples);
//        testMinBy(apples);
//    }
//
//    /**
//     * @Author: foldYang
//     * @Description: 测试groupingByConcurrent
//     * @Date: 23:11 2020/1/22
//     */
//    public void tesetConcurrentHashMap(List<Apple> list) {
//        Optional.ofNullable(Optional.ofNullable(list).orElseGet(ArrayList::new).parallelStream().collect(Collectors.groupingByConcurrent(Apple::getColor, Collectors.groupingByConcurrent(Apple::getWeight)))).ifPresent(System.out::println);
//        ConcurrentSkipListMap<String, ConcurrentMap<Integer, List<Apple>>> collect = Optional.ofNullable(list).orElseGet(ArrayList::new).parallelStream().collect(groupingByConcurrent(Apple::getColor, ConcurrentSkipListMap::new, groupingByConcurrent(Apple::getWeight)));
//        System.out.println(collect.getClass());
//    }
//
//    /**
//     * @Author: foldYang
//     * @Description: 测试joining
//     * @Date: 23:28 2020/1/22
//     */
//    public void testJoining(List<Apple> list) {
//        Optional.ofNullable(Optional.ofNullable(list).orElseGet(ArrayList::new).parallelStream().map(Apple::getColor).collect(Collectors.joining())).ifPresent(System.out::println);
//        Optional.ofNullable(Optional.ofNullable(list).orElseGet(ArrayList::new).parallelStream().map(Apple::getColor).distinct().collect(Collectors.joining(","))).ifPresent(System.out::println);
//        Optional.ofNullable(Optional.ofNullable(list).orElseGet(ArrayList::new).parallelStream().map(Apple::getColor).distinct().collect(Collectors.joining(",", "color = [", "]"))).ifPresent(System.out::println);
//    }
//
//    /**
//     * @Author: foldYang
//     * @Description: 测试mapping
//     * @Date: 23:55 2020/1/22
//     */
//    public void testMapping(List<Apple> list) {
//        Optional.ofNullable(Optional.ofNullable(list).orElseGet(ArrayList::new).parallelStream().collect(Collectors.mapping(Apple::getColor, Collectors.joining(",", "color = [", "]")))).ifPresent(System.out::println);
//    }
//
//    /**
//     * @Author: foldYang
//     * @Description: testMaxBy
//     * @Date: 23:59 2020/1/22
//     */
//    public void testMaxBy(List<Apple> list) {
//        System.out.println("========");
//        Optional.ofNullable(Optional.ofNullable(list).orElseGet(ArrayList::new).parallelStream().collect(Collectors.maxBy(Comparator.comparing(Apple::getWeight)))).ifPresent(System.out::println);
//    }
//
//    /**
//     * @Author: foldYang
//     * @Description: testMinBy
//     * @Date: 0:08 2020/1/23
//     */
//    public void testMinBy(List<Apple> list) {
//        Optional.ofNullable(Optional.ofNullable(list).orElseGet(ArrayList::new).parallelStream().collect(Collectors.minBy((a, b) -> a.getWeight().compareTo(b.getWeight())))).ifPresent(System.out::println);
//        Optional.ofNullable(Optional.ofNullable(list).orElseGet(ArrayList::new).parallelStream().map(Apple::getWeight).reduce(Integer::max)).ifPresent(System.out::println);
//        Optional.ofNullable(Optional.ofNullable(list).orElseGet(ArrayList::new).parallelStream().collect(Collectors.maxBy(Comparator.comparing(Apple::getWeight)))).ifPresent(System.out::println);
//    }
//
//    @Test
//    public void test28() {
//        List<Apple> apples = Arrays.asList(new Apple("red", 110),
//                new Apple("orange", 120),
//                new Apple("blue", 130),
//                new Apple("orange", 140),
//                new Apple("blue", 150),
//                new Apple("orange", 160),
//                new Apple("blue", 130),
//                new Apple("orange", 120),
//                new Apple("blue", 130));
//        testPartitioningByWithPredicate(apples);
//        testPartitioningByWithPredicateAndCollectors(apples);
//        testReducingBinaryOperator(apples);
//        testReducingBinaryOperatorAndIdentity(apples);
//        testSummarizingLongAndDoubleAndInt(apples);
//    }
//
//    /**
//     * @Author: foldYang
//     * @Description: 测试partitioningBy
//     * @Date: 0:17 2020/1/24
//     */
//    public void testPartitioningByWithPredicate(List<Apple> list) {
//        Optional.ofNullable(Optional.ofNullable(list).orElseGet(ArrayList::new).parallelStream().collect(Collectors.partitioningBy((apple) -> apple.getWeight() > 110))).ifPresent(System.out::println);
//        Optional.ofNullable(Optional.ofNullable(list).orElseGet(ArrayList::new).parallelStream().collect(Collectors.partitioningBy(apple -> apple.getWeight() > 120))).ifPresent(System.out::println);
//    }
//
//    /**
//     * @Author: foldYang
//     * @Description: 测试partitioningByAndCollectors
//     * @Date: 0:25 2020/1/24
//     */
//    public void testPartitioningByWithPredicateAndCollectors(List<Apple> list) {
//        Optional.ofNullable(Optional.ofNullable(list).orElseGet(ArrayList::new).parallelStream().collect(Collectors.partitioningBy(apple -> apple.getWeight() > 110, Collectors.summingInt(Apple::getWeight)))).ifPresent(System.out::println);
//    }
//
//    /**
//     * @Author: foldYang
//     * @Description: 测试BinaryOperator
//     * @Date: 0:31 2020/1/24
//     */
//    public void testReducingBinaryOperator(List<Apple> list) {
//        Optional.ofNullable(Optional.ofNullable(list).orElseGet(ArrayList::new).parallelStream().collect(Collectors.reducing(BinaryOperator.maxBy((a, b) -> a.getWeight().compareTo(b.getWeight()))))).ifPresent(System.out::println);
//        Optional.ofNullable(Optional.ofNullable(list).orElseGet(ArrayList::new).parallelStream().collect(Collectors.reducing(BinaryOperator.minBy(Comparator.comparing(Apple::getWeight))))).ifPresent(System.out::println);
//    }
//
//    /**
//     * @Author: foldYang
//     * @Description: 测试reducing
//     * @Date: 0:41 2020/1/24
//     */
//    public void testReducingBinaryOperatorAndIdentity(List<Apple> list) {
//        Optional.ofNullable(Optional.ofNullable(list).orElseGet(ArrayList::new).parallelStream().map(Apple::getWeight).collect(Collectors.reducing(0, (a, b) -> a + b))).ifPresent(System.out::println);
//        Optional.ofNullable(Optional.ofNullable(list).orElseGet(ArrayList::new).parallelStream().collect(Collectors.reducing(0, Apple::getWeight, (a, b) -> a + b))).ifPresent(System.out::println);
//    }
//
//    /**
//     * @Author: foldYang
//     * @Description: 测试summarizing
//     * @Date: 0:48 2020/1/24
//     */
//    public void testSummarizingLongAndDoubleAndInt(List<Apple> list) {
//        Optional.ofNullable(Optional.ofNullable(list).orElseGet(ArrayList::new).parallelStream().collect(Collectors.summarizingInt(Apple::getWeight))).ifPresent(System.out::println);
//        Optional.ofNullable(Optional.ofNullable(list).orElseGet(ArrayList::new).parallelStream().collect(Collectors.summarizingDouble(Apple::getWeight))).ifPresent(System.out::println);
//    }
//
//
//    /**
//     * @Author: foldYang
//     * @Description: 测试29
//     * @Date: 23:18 2020/1/24
//     */
//    @Test
//    public void test29() {
//        List<Apple> apples = Arrays.asList(new Apple("a", 110),
//                new Apple("b", 120),
//                new Apple("c", 130),
//                new Apple("d", 140),
//                new Apple("e", 150),
//                new Apple("f", 160),
//                new Apple("g", 170),
//                new Apple("h", 180),
//                new Apple("h", 180));
//        testSumming(apples);
//        // testToConcurrentMapWithBinaryOperator(apples);
//        testToSumming(apples);
//        testToCollection(apples);
//        testConCurrentMapWithMerge(apples);
//        listToList(apples);
//        listToSet(apples);
//        listToMap(apples);
//        listToSyMap(apples);
//    }
//
//    /**
//     * @Author: foldYang
//     * @Description: 测试聚合
//     * @Date: 23:20 2020/1/24
//     */
//    public void testSumming(List<Apple> list) {
//        Optional.ofNullable(Optional.ofNullable(list).orElseGet(ArrayList::new).parallelStream().collect(Collectors.summingInt(Apple::getWeight))).ifPresent(System.out::println);
//        int asInt = Optional.ofNullable(Optional.ofNullable(list).orElseGet(ArrayList::new).parallelStream().mapToInt(Apple::getWeight)).get().reduce((a, b) -> a + b).getAsInt();
//        System.out.println(asInt);
//        Optional.ofNullable(Optional.ofNullable(list).orElseGet(ArrayList::new).parallelStream().mapToInt(Apple::getWeight).sum()).ifPresent(System.out::println);
//        Optional.ofNullable(Optional.ofNullable(list).orElseGet(ArrayList::new).parallelStream().collect(Collectors.summingDouble(Apple::getWeight))).ifPresent(System.out::println);
//    }
//
//    /**
//     * @Author: foldYang
//     * @Description: 测试获取分类统计，有多个相同的key值时，这里java不会把相同的key值对应的value值和key值merge成一个，如果存在两个一样的key值会报空指针错误
//     * @Date: 23:46 2020/1/24
//     */
//    public void testToConcurrentMapWithBinaryOperator(List<Apple> list) {
//        Optional<ConcurrentMap<String, Integer>> collect = Optional.ofNullable(Optional.ofNullable(list).orElseGet(ArrayList::new).parallelStream().collect(toConcurrentMap(Apple::getColor, Apple::getWeight)));
//        System.out.println(collect.get());
//        Optional.ofNullable(Optional.ofNullable(list).orElseGet(ArrayList::new).parallelStream().collect(Collectors.toConcurrentMap(Apple::getColor, Apple::getWeight))).ifPresent(t -> {
//            System.out.println(t);
//        });
//    }
//
//    /**
//     * @Author: foldYang
//     * @Description: 测试计算总值
//     * @Date: 0:37 2020/1/25
//     */
//    public void testToSumming(List<Apple> list) {
//        Optional.ofNullable(Optional.ofNullable(list).orElseGet(ArrayList::new).parallelStream().collect(Collectors.summingInt(Apple::getWeight))).ifPresent(System.out::println);
//        Optional.ofNullable(Optional.ofNullable(list).orElseGet(ArrayList::new).parallelStream().collect(Collectors.summingDouble(Apple::getWeight))).ifPresent(System.out::println);
//        Optional.ofNullable(Optional.ofNullable(list).orElseGet(ArrayList::new).parallelStream().collect(Collectors.summingLong(Apple::getWeight))).ifPresent(System.out::println);
//    }
//
//    /**
//     * @Author: foldYang
//     * @Description: 转换存储一种数据结构
//     * @Date: 0:41 2020/1/25
//     */
//    public void testToCollection(List<Apple> list) {
//        Optional.ofNullable(Optional.ofNullable(list).orElseGet(ArrayList::new).parallelStream().collect(Collectors.toCollection(LinkedList::new))).ifPresent(t -> {
//            System.out.println(t);
//            System.out.println(t.getClass());
//        });
//    }
//
//    /**
//     * @Author: foldYang
//     * @Description: merge HashMap
//     * @Date: 0:50 2020/1/25
//     */
//    public void testConCurrentMapWithMerge(List<Apple> list) {
//        System.out.println("开始!!");
//        // 这里的1L是什么意思哦，表示的是返回的是sum数字吗
//        Optional.ofNullable(Optional.ofNullable(list).orElseGet(ArrayList::new).parallelStream().collect(Collectors.toConcurrentMap(Apple::getColor, v -> {
//            return 1L;
//        }, (a, b) -> a + b))).ifPresent(System.out::println);
//        Optional.ofNullable(Optional.ofNullable(list).orElseGet(ArrayList::new).parallelStream().collect(Collectors.toConcurrentMap(Apple::getColor, Apple::getWeight, (a, b) -> a + b))).ifPresent(System.out::println);
//        Optional.ofNullable(Optional.ofNullable(list).orElseGet(ArrayList::new).parallelStream().collect(Collectors.toConcurrentMap(Apple::getWeight, Apple::getColor, (a, b) -> a + b, ConcurrentSkipListMap::new))).ifPresent(t -> {
//            System.out.println(t);
//            System.out.println(t.getClass());
//        });
//    }
//
//    /**
//     * @Author: foldYang
//     * @Description: 转成list
//     * @Date: 1:13 2020/1/25
//     */
//    public void listToList(List<Apple> list) {
//        Optional.ofNullable(Optional.ofNullable(list).orElseGet(ArrayList::new).parallelStream().filter(apple -> apple.getWeight() > 130).collect(Collectors.toList())).ifPresent(System.out::println);
//    }
//
//    /**
//     * @Author: foldYang
//     * @Description: list转成Set
//     * @Date: 1:20 2020/1/25
//     */
//    public void listToSet(List<Apple> list) {
//        Set<Apple> collect = Optional.ofNullable(list).orElseGet(ArrayList::new).parallelStream().filter(apple -> apple.getWeight() > 130).collect(toSet());
//        System.out.println(collect);
//    }
//
//    /**
//     * @Author: foldYang
//     * @Description: list转map
//     * @Date: 1:29 2020/1/25
//     */
//    public void listToMap(List<Apple> list) {
//        Optional.ofNullable(Optional.ofNullable(list).orElseGet(ArrayList::new).parallelStream().collect(Collectors.toMap(Apple::getColor, Apple::getWeight, (a, b) -> a + b))).ifPresent(t -> {
//            System.out.println(t);
//            System.out.println(t.getClass());
//        });
//    }
//
//    /**
//     * @Author: foldYang
//     * @Description: HashMap加线程安全锁
//     * @Date: 1:36 2020/1/25
//     */
//    public void listToSyMap(List<Apple> list) {
//        Optional.ofNullable(Optional.ofNullable(list).orElseGet(ArrayList::new).parallelStream().collect(Collectors.collectingAndThen(Collectors.toMap(Apple::getColor, Apple::getWeight, (a, b) -> a + b), Collections::synchronizedMap))).ifPresent(System.out::println);
//    }
//
//    /**
//     * @Author: foldYang
//     * @Description: map转list
//     * @Date: 16:27 2020/2/3
//     */
//    @Test
//    public void mapToList() {
//        List<HashMap> list = new ArrayList<>();
//        HashMap map = new HashMap();
//        map.put("id", "1");
//        map.put("pid", "0");
//        map.put("name", "哈哈");
//        list.add(map);
//        map = new HashMap();
//        map.put("id", "2");
//        map.put("pid", "1");
//        map.put("name", "呵呵");
//        list.add(map);
//        map = new HashMap();
//        map.put("id", "3");
//        map.put("pid", "1");
//        map.put("name", "嚯嚯");
//        list.add(map);
//        String str = Optional.ofNullable(list).orElseGet(ArrayList::new).parallelStream().map(a -> a.get("id")).reduce((a, b) -> "code:" + a.toString() + ",code:" + b.toString()).get().toString();
//        System.out.println(str);
//    }
//
//    @Test
//    public void one() {
//        String one = "onefasfaj/s";
//        Optional.of(one.substring(0, one.indexOf("/"))).ifPresent(System.out::println);
//        Optional.of(one).ifPresent(a -> {
//
//        });
//    }
//
//}