package com.paigu.interview.main;

import cn.hutool.core.date.TimeInterval;
import cn.hutool.core.thread.ThreadUtil;
import cn.hutool.core.util.RandomUtil;

import java.util.Collections;
import java.util.NavigableMap;
import java.util.concurrent.*;

public class FutureTaskMain {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        TimeInterval timeInterval = new TimeInterval();
        timeInterval.start();
        CompletableFuture<Integer> future = CompletableFuture.supplyAsync(FutureTaskMain::getResult);
        CompletableFuture<Integer> future1 = CompletableFuture.supplyAsync(FutureTaskMain::getResult);
        CompletableFuture<Object> objectCompletableFuture = future.thenCombine(future1, FutureTaskMain::sum);
        System.out.println(objectCompletableFuture.get());
        System.out.println("本次执行耗时：" + timeInterval.interval());
        NavigableMap<String, String> objectObjectNavigableMap = Collections.emptyNavigableMap();
    }

    public static Integer getResult() {
        ThreadUtil.sleep(1000);
        return RandomUtil.randomInt(0, 100);
    }
    public static Integer sum(Integer i1,Integer i2){
        ThreadUtil.sleep(2000);
        return i1 + i2;
    }
}
