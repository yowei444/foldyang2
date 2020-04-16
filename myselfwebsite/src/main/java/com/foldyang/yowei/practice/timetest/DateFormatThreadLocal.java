package com.foldyang.yowei.practice.timetest;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @Author foldYang
 * @Description
 * @Date 2020/4/17
 * @Version 1.0
 */
public class DateFormatThreadLocal {

    private static final ThreadLocal<DateFormat> df = new ThreadLocal<DateFormat>() {
        @Override
        protected DateFormat initialValue() {
            return new SimpleDateFormat("yyyyMMdd");
        }
    };

    public static Date conver(String source) throws ParseException {
        return df.get().parse(source);
    }
}
