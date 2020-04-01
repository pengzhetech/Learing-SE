package com.java.data.problem26;

import java.util.Arrays;

/**
 * 方法：双指针法
 * 算法
 * <p>
 * 数组完成排序后，我们可以放置两个指针 ii 和 jj，其中 ii 是慢指针，而 jj 是快指针。只要 nums[i] = nums[j]nums[i]=nums[j]，我们就增加 jj 以跳过重复项。
 * <p>
 * 当我们遇到 nums[j] \neq nums[i]nums[j]
 * 
 * ​
 * =nums[i] 时，跳过重复项的运行已经结束，因此我们必须把它（nums[j]nums[j]）的值复制到 nums[i + 1]nums[i+1]然后递增 ii，接着我们将再次重复相同的过程，直到 jj 到达数组的末尾为止。
 */
public class Solution {
    public static int removeDuplicates(int[] nums) {
        if (nums.length == 0) return 0;
        int i = 0;
        for (int j = 1; j < nums.length; j++) {
            if (nums[j] != nums[i]) {
                i++;
                nums[i] = nums[j];
            }
        }
        System.out.println(Arrays.toString(nums));
        return i + 1;
    }

    public static void main(String[] args) {
        int[] test = {0, 0, 111, 1, 2, 2, 2, 3};
        System.out.println(removeDuplicates(test));
    }
}
