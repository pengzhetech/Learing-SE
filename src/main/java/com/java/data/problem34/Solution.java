package com.java.data.problem34;

/***
 * 方法 1：线性扫描
 * 想法
 *
 * 对 target 检查每一个下标，一定能得到正确答案。
 *
 * 算法
 *
 * 首先，我们对 nums 数组从左到右做线性遍历，
 * 当遇到 target 时中止。如果我们没有中止过，那么 target 不存在，
 * 我们可以返回“错误代码” [-1, -1] 。如果我们找到了有效的左端点坐标，我们可以坐第二遍线性扫描，
 * 但这次从右往左进行。这一次，第一个遇到的 target 将是最右边的一个（因为最左边的一个存在，所以一定会有一个最右边的 target）。
 * 我们接下来只需要返回这两个坐标。
 *
 */
class Solution {
    public static int[] searchRange(int[] nums, int target) {
        int[] targetRange = {-1, -1};

        // find the index of the leftmost appearance of `target`.
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == target) {
                targetRange[0] = i;
                break;
            }
        }

        // if the last loop did not find any index, then there is no valid range
        // and we return [-1, -1].
        if (targetRange[0] == -1) {
            return targetRange;
        }

        // find the index of the rightmost appearance of `target` (by reverse
        // iteration). it is guaranteed to appear.
        for (int j = nums.length - 1; j >= 0; j--) {
            if (nums[j] == target) {
                targetRange[1] = j;
                break;
            }
        }

        return targetRange;
    }
}
