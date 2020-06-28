package com.java.datastructrue.problem2;


/**
 * 对于链表问题，返回结果为头结点时，通常需要先初始化一个预先指针 pre，
 * 该指针的下一个节点指向真正的头结点head。使用预先指针的目的在于链表初始化时无可用节点值，
 * 而且链表构造过程需要指针移动，进而会导致头指针丢失，无法返回结果
 * <p>
 * 链接：https://leetcode-cn.com/problems/add-two-numbers/solution/hua-jie-suan-fa-2-liang-shu-xiang-jia-by-guanpengc/
 */
public class Solution2 {
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode pre = new ListNode(0);
        ListNode currentNode = pre;
        int carry = 0;
        while (l1 != null || l2 != null) {
            int x = l1 == null ? 0 : l1.val;
            int y = l2 == null ? 0 : l2.val;
            int sum = x + y + carry;

            carry = sum / 10;
            sum = sum % 10;
            currentNode.next = new ListNode(sum);
            //移动链表当前指针
            currentNode = currentNode.next;
            if (l1 != null)
                l1 = l1.next;
            if (l2 != null)
                l2 = l2.next;
        }
        if (carry == 1) {
            currentNode.next = new ListNode(carry);
        }
        return pre.next;
    }

    public static void main(String[] args) {

        //2->-4>-3
        ListNode l1 = new ListNode(2);
        ListNode l2 = new ListNode(4);
        ListNode l3 = new ListNode(3);
        l1.next = l2;
        l2.next = l3;
        //5->-6>-4
        ListNode l4 = new ListNode(5);
        ListNode l5 = new ListNode(6);
        ListNode l6 = new ListNode(4);
        l4.next = l5;
        l5.next = l6;

        //  ListNode listNode = addTwoNumbers(l1, l4);

        //9->-8>-7
        ListNode l7 = new ListNode(7);
        ListNode l8 = new ListNode(8);
        ListNode l9 = new ListNode(9);
        l7.next = l8;
        l8.next = l9;
        System.out.println(l7);
        //2->-3
        ListNode l10 = new ListNode(3);
        l10.next = new ListNode(2);
        System.out.println(l10);
        System.out.println(addTwoNumbers(l7, l10));

        System.out.println(12 / 10);
        System.out.println(19 / 10);

    }

}
