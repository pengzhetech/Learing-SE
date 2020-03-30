package com.java.data.problem62;

/**
 * 反推法
 * https://leetcode-cn.com/problems/yuan-quan-zhong-zui-hou-sheng-xia-de-shu-zi-lcof/solution/javajie-jue-yue-se-fu-huan-wen-ti-gao-su-ni-wei-sh
 */
public class Solution2 {
    private static int cir(int n, int m) {
        int p = 0;
        for (int i = 2; i <= n; i++) {
            p = (p + m) % i;
        }
        return p;
    }

    public static void main(String[] args) {
        System.out.println(cir(5, 3));
        System.out.println(cir(10, 17));
    }

}
