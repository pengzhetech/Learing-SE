package com.java.data.problem27;

/**
 * 这是一个相当简单的问题，但人们可能会对“就地”一词感到困惑，并认为在不复制数组的情况下从数组中删除元素是不可能的。
 *
 * 提示
 * 尝试双指针法。
 * 你是否使用“元素顺序可以更改”这一属性？
 * 当要删除的元素很少时会发生什么？
 * 解决方案
 * 方法一：双指针
 * 思路
 *
 * 既然问题要求我们就地删除给定值的所有元素，我们就必须用 O(1)O(1) 的额外空间来处理它。如何解决？我们可以保留两个指针 ii 和 jj，其中 ii 是慢指针，jj 是快指针。
 *
 * 算法
 *
 * 当 nums[j]nums[j] 与给定的值相等时，递增 jj 以跳过该元素。只要 nums[j] \neq valnums[j]
 * 
 * ​
 *  =val，我们就复制 nums[j]nums[j] 到 nums[i]nums[i] 并同时递增两个索引。重复这一过程，直到 jj 到达数组的末尾，该数组的新长度为 ii。
 *
 * 该解法与 删除排序数组中的重复项 的解法十分相似。

 */
public class Solution {
    public int removeElement(int[] nums, int val) {
        int i = 0;
        for (int j = 0; j < nums.length; j++) {
            if (nums[j] != val) {
                nums[i] = nums[j];
                i++;
            }
        }
        return i;
    }
}
