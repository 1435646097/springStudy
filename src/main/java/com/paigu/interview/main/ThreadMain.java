package com.paigu.interview.main;

import cn.hutool.core.thread.ThreadUtil;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.CyclicBarrier;

/**
 * 线程主要
 *
 * @author liao
 * @date 2022/08/14
 */
public class ThreadMain {
    static boolean flag = true;
    static final Integer i = 1;


    public static void main(String[] args) throws InterruptedException {
//        TimeInterval timer = DateUtil.timer();
        ThreadMain threadMain = new ThreadMain();
        Thread thread1 = new Thread(() -> {
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
//                throw new RuntimeException(e);
            }
            for (;;){
                System.out.println("Hello World");
            }
        });


//        thread.start();
//        ThreadUtil.sleep(100);
//        flag = false;
//        System.out.println(timer.intervalRestart());
//        countDownLatchTest();
//        cyclicBarrierTest();
////        countDownLatchTest();
//        Thread thread1 = new Thread(() -> {
//            ThreadUtil.sleep(10000);
//        });
//        Thread thread2 = new Thread(() -> {
//            ThreadUtil.sleep(1000);
//            i = 10;
//        });
        thread1.start();
        thread1.interrupt();
//        thread1.join();
//        System.out.println("aaaa");
    }


    public static void countDownLatchTest() throws InterruptedException {
        CountDownLatch countDownLatch = new CountDownLatch(2);
        Thread thread1 = new Thread(() -> {
            System.out.println("你好，世界");
            countDownLatch.countDown();
        });
        Thread thread2 = new Thread(() -> {
            System.out.println("你好，世界");
            countDownLatch.countDown();
        });
        thread1.start();
        thread2.start();
        countDownLatch.await();
        System.out.println("countDownLatch完成");
    }

    public static void cyclicBarrierTest() {
        CyclicBarrier cyclicBarrier = new CyclicBarrier(2, () -> {
            System.out.println("完成了等待");
        });
        Thread thread1 = new Thread(() -> {
            try {
                cyclicBarrier.await();
                ThreadUtil.sleep(1000);
                System.out.println("你好，世界");
                cyclicBarrier.await();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            } catch (BrokenBarrierException e) {
                throw new RuntimeException(e);
            }
        });
        Thread thread2 = new Thread(() -> {
            try {
                cyclicBarrier.await();
                ThreadUtil.sleep(1000);
                System.out.println("你好，世界");
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            } catch (BrokenBarrierException e) {
                throw new RuntimeException(e);
            }

        });
        Thread thread3 = new Thread(() -> {
            ThreadUtil.sleep(1000);
            try {
                cyclicBarrier.await();
                System.out.println("你好，世界");
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            } catch (BrokenBarrierException e) {
                throw new RuntimeException(e);
            }
        });
        thread1.start();
        thread2.start();
        thread3.start();
    }
}
