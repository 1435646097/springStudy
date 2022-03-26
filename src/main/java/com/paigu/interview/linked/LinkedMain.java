package com.paigu.interview.linked;

import lombok.extern.slf4j.Slf4j;

/**
 * @author PaiGu
 * @description TODO
 * @date 2022/3/20 20:15
 */
@Slf4j
public class LinkedMain {
    public static void main(String[] args) {
//        IntegerLinked  linked = new IntegerLinked();
//        linked.addNode(new Node(20));
//        linked.addNode(new Node(8));
//        linked.addNode(new Node(30));
//        linked.addNode(new Node(11));
//        linked.addNode(new Node(24));
//        linked.addNode(new Node(21));
//        linked.print();
        System.out.println(recursion(15));
    }

    public static int recursion(int n) {
        log.info("当前是{}", n);
        if (n == 1) {
            return 1;
        }
        if (n == 2) {
            return 2;
        }
        return recursion(n - 1) + recursion(n - 2);
    }
}
