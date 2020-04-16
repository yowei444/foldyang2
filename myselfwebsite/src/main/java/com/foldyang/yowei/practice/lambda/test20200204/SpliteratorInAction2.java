package com.foldyang.yowei.practice.lambda.test20200204;

import org.junit.Test;

import java.util.Objects;
import java.util.Spliterator;
import java.util.function.Consumer;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

/**
 * @Author foldYang
 * @Description
 * @Date 2020/2/5
 * @Version 1.0
 */
public class SpliteratorInAction2 {

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
        MySplitorText mySplitorText = new MySplitorText(text);
        mySplitorText.parallelStream().forEach(System.out::println);
    }

    static class MySplitorText {
        String[] data;

        public MySplitorText(String text) {
            Objects.requireNonNull(text, "parameters can not be null");
            data = text.split("\n");
        }

        /**
         * @Author: foldYang
         * @Description: 非并行
         * @Date: 2:05 2020/2/5
         */
        public Stream<String> stream() {
            return StreamSupport.stream(new MySplitor(), false);
        }

        /**
         * @Author: foldYang
         * @Description: 并行
         * @Date: 2:06 2020/2/5
         */
        public Stream<String> parallelStream() {
            return StreamSupport.stream(new MySplitor(), true);
        }

        private class MySplitor implements Spliterator<String> {

            int start, end;

            public MySplitor() {
                start = 0;
                end = data.length - 1;
            }

            public MySplitor(int start, int end) {
                this.start = start;
                this.end = end;
            }

            /**
             * @Author: foldYang
             * @Description: 试图消费
             * @Date: 1:59 2020/2/5
             */
            @Override
            public boolean tryAdvance(Consumer<? super String> action) {
                if (start <= end) {
                    action.accept(data[start++]);
                    return true;
                }
                return false;
            }

            /**
             * @Author: foldYang
             * @Description: 拆分任务
             * @Date: 2:01 2020/2/5
             */
            @Override
            public Spliterator<String> trySplit() {
                int mid = (end - start) / 2;
                if (mid <= 0) {
                    return null;
                }
                int left = start;
                int right = start + mid;
                start = start + mid + 1;
                return new MySplitor(left, right);
            }

            @Override
            public long estimateSize() {
                return end - start;
            }

            @Override
            public int characteristics() {
                return IMMUTABLE | SIZED | SUBSIZED;
            }
        }

    }


}