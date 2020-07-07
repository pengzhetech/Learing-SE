package com.java.datastructrue.problem19;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class ListNode {

    int val;

    ListNode next;

    ListNode(int x) {
        val = x;
    }
}
