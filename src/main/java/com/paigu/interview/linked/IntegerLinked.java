package com.paigu.interview.linked;

import lombok.Data;

/**
 * 有序整数链表
 *
 * @author PaiGu
 * @description TODO
 * @date 2022/3/20 19:56
 */
@Data
public class IntegerLinked {
    /**
     * 头节点 傀儡节点
     */
    private Node head;

    public IntegerLinked() {
        this.head = new Node(null);
    }

    public void addNode(Node node) {
        //仅有傀儡节点
        if ((head.getNext() == null)) {
            head.setNext(node);
            return;
        }
        Node current = head;
        Node next = head.getNext();
        while (current.getNext() != null && next.getValue() > node.getValue()) {
            current = next;
            next = next.getNext();
        }
        Node temp = current.getNext();
        node.setNext(temp);
        current.setNext(node);
    }

    public void print() {
        Node next = this.head.getNext();
        while (next != null) {
            System.out.println(next.getValue());
            next = next.getNext();
        }
    }
}
