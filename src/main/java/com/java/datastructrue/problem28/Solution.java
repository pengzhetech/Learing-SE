package com.java.datastructrue.problem28;

/**
 * 这道题是要在 haystack 字符串中找到 needle 字符串。下面会给出的三种解法，这三种解法都基于滑动窗口。
 * <p>
 * 子串逐一比较的解法最简单，将长度为 L 的滑动窗口沿着 haystack 字符串逐步移动，并将窗口内的子串与 needle 字符串相比较，时间复杂度为 O((N - L)L)O((N−L)L)
 * <p>
 * 显示上面这个方法是可以优化的。双指针方法虽然也是线性时间复杂度，不过它可以避免比较所有的子串，因此最优情况下的时间复杂度为 O(N)O(N)，但最坏情况下的时间复杂度依然为 O((N - L)L)O((N−L)L)。
 * <p>
 * 有 O(N)O(N) 复杂度的解法嘛？答案是有的，有两种方法可以实现：
 * <p>
 * Rabin-Karp，通过哈希算法实现常数时间窗口内字符串比较。
 * <p>
 * 比特位操作，通过比特掩码来实现常数时间窗口内字符串比较。
 * <p>
 * 方法一：子串逐一比较 - 线性时间复杂度
 * 最直接的方法 - 沿着字符换逐步移动滑动窗口，将窗口内的子串与 needle 字符串比较。
 * <p>
 */
public class Solution {
    public int strStr(String haystack, String needle) {
        int L = needle.length();
        int n = haystack.length();

        for (int start = 0; start < n - L + 1; ++start) {
            if (haystack.substring(start, start + L).equals(needle)) {
                return start;
            }
        }
        return -1;
    }

}
