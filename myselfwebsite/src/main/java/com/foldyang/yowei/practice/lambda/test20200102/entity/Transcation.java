package com.foldyang.yowei.practice.lambda.test20200102.entity;

/**
 * @Author foldYang
 * @Description 交易
 * @Date 2020/1/16
 * @Version 1.0
 */
public class Transcation {

    private Trader trader;
    private Integer year;
    private Integer value;

    public Trader getTrader() {
        return trader;
    }

    public void setTrader(Trader trader) {
        this.trader = trader;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public Integer getValue() {
        return value;
    }

    public void setValue(Integer value) {
        this.value = value;
    }

    public Transcation(Trader trader, Integer year, Integer value) {
        this.trader = trader;
        this.year = year;
        this.value = value;
    }

    @Override
    public String toString() {
        return "Transcation{" +
                "trader=" + trader +
                ", year=" + year +
                ", value=" + value +
                '}';
    }
}
