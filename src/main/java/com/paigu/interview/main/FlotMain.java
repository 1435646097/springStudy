package com.paigu.interview.main;

import java.nio.charset.StandardCharsets;
import java.util.ArrayList;

public class FlotMain {
    public static void main(String[] args) {
        ArrayList<Integer> arrayList = new ArrayList<>();
        arrayList.add(20);
        String str = "abc为";
        byte[] bytes = str.getBytes(StandardCharsets.UTF_8);

        System.out.println(bytes);
    }
}
