package com.code;

/**
 * @author pengzhe
 * @date 2023/4/27 下午7:25
 * @description
 */

public class Main {


    public static DListNode reverseKGroup(DListNode head, int k) {
        DListNode dummy = new DListNode(-1);
        dummy.next = head;

        DListNode prev = dummy;
        DListNode end = dummy;

        while (end.next != null) {
            for (int i = 0; i < k && end != null; i++) {
                end = end.next;
            }
            if (end == null) break;

            DListNode start = prev.next;
            DListNode next = end.next;

            end.next = null;
            prev.next = reverseNode(start);
            start.next = next;

            prev = start;
            end = start;
        }
        return dummy.next;
    }

    private static DListNode reverseNode(DListNode head) {
        DListNode prev = null;
        DListNode cur = head;

        while (cur != null) {
            DListNode next = cur.next;
            cur.next = prev;
            prev = cur;
            cur = next;
        }
        return prev;
    }

    public static void main(String[] args) {
        DListNode head = new DListNode(1);
        head.next = new DListNode(2);
        head.next.next = new DListNode(3);
        head.next.next.next = new DListNode(4);
        head.next.next.next.next = new DListNode(5);
        System.out.println(head);

        DListNode dListNode = reverseKGroup(head, 2);
        System.out.println(dListNode);
    }
}

class DListNode {
    int val;
    DListNode next;

    public DListNode(int val) {
        this.val = val;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        DListNode cur = this;
        while (cur != null) {
            stringBuilder.append(cur.val).append("->");
            cur = cur.next;
        }
        stringBuilder.append("null");
        return stringBuilder.toString();
    }
}

