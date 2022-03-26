package com.paigu.interview.linked;

import lombok.Data;

/**
 * @author PaiGu
 * @description TODO
 * @date 2022/3/20 19:57
 */
@Data
public class Node {
    private Integer value;
    private Node next;

    public Node(Integer value) {
        this.value = value;
        this.next = null;
    }
}
