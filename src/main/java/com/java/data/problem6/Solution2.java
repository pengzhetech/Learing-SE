package com.java.data.problem6;

/**
 * 思路
 *
 * 按照与逐行读取 Z 字形图案相同的顺序访问字符串。
 *
 * 算法
 *
 * 首先访问 行 0 中的所有字符，接着访问 行 1，然后 行 2，依此类推...
 *
 * 对于所有整数 kk，
 *
 * 行 00 中的字符位于索引 k \; (2 \cdot \text{numRows} - 2)k(2⋅numRows−2) 处;
 * 行 \text{numRows}-1numRows−1 中的字符位于索引 k \; (2 \cdot \text{numRows} - 2) + \text{numRows} - 1k(2⋅numRows−2)+numRows−1 处;
 * 内部的 行 ii 中的字符位于索引 k \; (2 \cdot \text{numRows}-2)+ik(2⋅numRows−2)+i 以及 (k+1)(2 \cdot \text{numRows}-2)- i(k+1)(2⋅numRows−2)−i 处;
 *
 * 作者：LeetCode
 * 链接：https://leetcode-cn.com/problems/zigzag-conversion/solution/z-zi-xing-bian-huan-by-leetcode/

 */
public class Solution2 {

    public static String convert(String s, int numRows) {

        if (numRows == 1) return s;

        StringBuilder ret = new StringBuilder();
        int n = s.length();
        int cycleLen = 2 * numRows - 2;

        for (int i = 0; i < numRows; i++) {
            for (int j = 0; j + i < n; j += cycleLen) {
                ret.append(s.charAt(j + i));
                if (i != 0 && i != numRows - 1 && j + cycleLen - i < n)
                    ret.append(s.charAt(j + cycleLen - i));
            }
        }
        return ret.toString();
    }

}
