package com.paigu.interview.main;

import cn.hutool.core.thread.ThreadUtil;
import lombok.var;

import java.util.concurrent.TimeUnit;

public class FlotMain {
    public static void main(String[] args) {
//        ArrayList<Integer> arrayList = new ArrayList<>();
//        arrayList.add(20);
//        String str = "abc为";
//        byte[] bytes = str.getBytes(StandardCharsets.UTF_8);
//
//        System.out.println(Arrays.toString(bytes));
//
//        System.out.println(Runtime.getRuntime()
//                                  .availableProcessors());
        FlotMain flotMain = new FlotMain();
        int a = 10;
        var c = "asda";
        flotMain.add();
        ThreadUtil.sleep(10000, TimeUnit.SECONDS);
    }

    public Integer add() {
        int a = 20;
        int b = 30;
        int c = a + b;
        return sub();
    }

    public Integer sub() {
        int c = 10;
        return c - 5;
    }
}
