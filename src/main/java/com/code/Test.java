package com.code;

import java.util.Comparator;
import java.util.PriorityQueue;

public class Test {


    @org.junit.Test
    public void test() {
        ListNode head = new ListNode(-1);
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        head.next = node1;
        node1.next = node2;
        node2.next = node3;

        System.out.println("test");
        System.out.println(head);
    }

    private ListNode reverse(ListNode head) {
        ListNode prev = null;
        ListNode cur = head;

        while (cur != null) {
            ListNode next = cur.next;
            cur.next = prev;
            prev = cur;
            cur = next;
        }
        return prev;
    }


    private ListNode middleNode() {

        return null;
    }

    @org.junit.Test
    public void test2() {
        int[] nums = {1, 2, 5, 8, 10};
        System.out.println(topK(nums, 2));
    }


    public int topK(int[] nums, int k) {

        PriorityQueue<Integer> queues = new PriorityQueue<>(Comparator.comparing(a -> a));
        for (int num : nums) {
            queues.add(num);
        }
        for (int i = 0; i < nums.length - k; i++) {
            queues.remove(nums[i]);
        }
        assert queues.peek() != null;
        return queues.peek();
    }


    private ListNode middleNode(ListNode head) {

        ListNode slow = head;
        ListNode fast = head.next;

        while (fast != null && fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow;
    }


    private boolean isPalindromeList(ListNode head) {




        return false;
    }


}



