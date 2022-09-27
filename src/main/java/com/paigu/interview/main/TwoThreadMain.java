package com.paigu.interview.main;

import cn.hutool.core.thread.ThreadUtil;
import com.paigu.interview.aqs.TwoThread;

public class TwoThreadMain {

    public static void main(String[] args) throws InterruptedException {
        TwoThread twoThread = new TwoThread();
        for (int i = 0; i < 100; i++) {
            Thread t1 = new Thread(() -> {
                twoThread.lock();
                try {
                    System.out.println(Thread.currentThread().getName());
                    ThreadUtil.sleep(1000);
                } finally {
                    twoThread.unLock();
                }
            });
            t1.start();
        }
    }
}
