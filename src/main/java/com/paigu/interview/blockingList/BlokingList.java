package com.paigu.interview.blockingList;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/**
 * @author PaiGu
 * @description TODO
 * @date 2022/3/29 20:14
 */
public class BlokingList {
    public static void main(String[] args) throws InterruptedException {
//        Executors.newFixedThreadPool(20, Executors.defaultThreadFactory());
//        Executors.
        BlockingQueue<String> blockingQueue = new ArrayBlockingQueue<>(3);
        blockingQueue.put("Asd");
        blockingQueue.put("Asd");
        blockingQueue.put("Asd");
        blockingQueue.put("Asd");
    }
}
