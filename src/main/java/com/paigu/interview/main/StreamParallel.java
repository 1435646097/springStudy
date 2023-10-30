package com.paigu.interview.main;

import cn.hutool.core.date.TimeInterval;

import java.util.stream.IntStream;

public class StreamParallel {
    public static void main(String[] args) {
        TimeInterval timeInterval = new TimeInterval();
        timeInterval.start();
        int reduce = getReduce(2000000000);
        System.out.println(timeInterval.interval() + "--------" + reduce);
    }

    private static int getReduce(int n) {
        return IntStream.rangeClosed(1, n)
                        .parallel()
                        .reduce(0, (left, right) -> {
                            System.out.println(Thread.currentThread().getName());
                            return left + right;
                        });
    }
}
