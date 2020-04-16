package com.foldyang.yowei.practice.lambda.test20200204;

import org.junit.Test;

import java.util.Arrays;
import java.util.Objects;
import java.util.Spliterator;
import java.util.function.Consumer;
import java.util.stream.IntStream;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

/**
 * @Author foldYang
 * @Description Spliterator测试
 * @Date 2020/2/4
 * @Version 1.0
 */
public class SpliteratorInAction {

    private static String text = "one one one one" +
            "\n" +
            "two two two two" +
            "\n" +
            "three three three three" +
            "\n" +
            "four four four four" +
            "\n" +
            "five five five five" +
            "\n" +
            "six six six six" +
            "\n" +
            "seven seven seven seven" +
            "\n" +
            "eight eight eight eight" +
            "\n" +
            "nine nine nine nine" +
            "\n" +
            "ten ten ten ten";

    @Test
    public void test01() {
//        IntStream intStream = IntStream.rangeClosed(0, 10);
//        Spliterator.OfInt split = intStream.spliterator();
//        Consumer<Integer> consumer = i -> System.out.println(i);
//        split.forEachRemaining(consumer);
        MySpliteratorText mySpliteratorText = new MySpliteratorText(text);
        mySpliteratorText.parallelStream().forEach(System.out::println);
        //Arrays.stream(text.split("\n")).parallel().forEach(System.out::println);
    }

    static class MySpliteratorText {
        private final String[] data;

        public MySpliteratorText(String text) {
            Objects.requireNonNull(text, "The parameter can not be null");
            this.data = text.split("\n");
        }

        /**
         * @Author: foldYang
         * @Description: 非并行
         * @Date: 23:52 2020/2/4
         */
        public Stream<String> stream() {
            return StreamSupport.stream(new MySpliterator(), false);
        }

        public Stream<String> parallelStream() {
            return StreamSupport.stream(new MySpliterator(), true);
        }

        private class MySpliterator implements Spliterator<String> {

            private int start, end;

            public MySpliterator() {
                this.start = 0;
                this.end = MySpliteratorText.this.data.length - 1;
            }

            public MySpliterator(int start, int end) {
                this.start = start;
                this.end = end;
            }

            /**
             * @Author: foldYang
             * @Description: 试图去stream里面拿数据消费
             * @Date: 23:42 2020/2/4
             */
            @Override
            public boolean tryAdvance(Consumer<? super String> action) {
                if (start <= end) {
                    action.accept(MySpliteratorText.this.data[start++]);
                    return true;
                }
                return false;
            }

            /**
             * @Author: foldYang
             * @Description: 当是并行时执行该方法
             * @Date: 0:13 2020/2/5
             */
            @Override
            public Spliterator<String> trySplit() {
                System.out.println("进来一次");
                int mid = (end - start) / 2;
                // 这里我觉得是小于等于0吧
                if (mid <= 0) {
                    return null;
                }
                int left = start;
                int right = start + mid;
                start = start + mid + 1;
                return new MySpliterator(left, right);
            }

            /**
             * @Author: foldYang
             * @Description: 还剩多少个元素未被消费(估计)
             * @Date: 23:47 2020/2/4
             */
            @Override
            public long estimateSize() {
                System.out.println(end - start);
                return end - start;
            }

            /**
             * @Author: foldYang
             * @Description: 确切剩余多少元素
             * @Date: 0:44 2020/2/5
             */
            @Override
            public long getExactSizeIfKnown() {
                return estimateSize();
            }

            @Override
            public int characteristics() {
                return IMMUTABLE | SIZED | SUBSIZED;
            }
        }
    }


}
