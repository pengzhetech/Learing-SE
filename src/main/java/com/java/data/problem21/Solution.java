package com.java.data.problem21;

/**
 * 方法 1：递归
 * 想法
 * <p>
 * 我们可以如下递归地定义在两个链表里的 merge 操作（忽略边界情况，比如空链表等）：
 * <p>
 * \left\{ \begin{array}{ll} list1[0] + merge(list1[1:], list2) & list1[0]
 * < list2[0] \\ list2[0] + merge(list1, list2[1:]) & otherwise \end{array} \right.
 * {
 * list1[0]+merge(list1[1:],list2)
 * list2[0]+merge(list1,list2[1:])
 * ​
 * <p>
 * list1[0]<list2[0]
 * otherwise
 * ​
 * <p>
 * <p>
 * 也就是说，两个链表头部较小的一个与剩下元素的 merge 操作结果合并。
 * <p>
 * 算法
 * 我们直接将以上递归过程建模，首先考虑边界情况。
 * 特殊的，如果 l1 或者 l2 一开始就是 null ，那么没有任何操作需要合并，
 * 所以我们只需要返回非空链表。否则，我们要判断 l1 和 l2 哪一个的头元素更小，
 * 然后递归地决定下一个添加到结果里的值。如果两个链表都是空的，那么过程终止，所以递归过程最终一定会终止。
 */
class Solution {
    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        } else if (l2 == null) {
            return l1;
        } else if (l1.val < l2.val) {
            l1.next = mergeTwoLists(l1.next, l2);
            return l1;
        } else {
            l2.next = mergeTwoLists(l1, l2.next);
            return l2;
        }
    }
}

