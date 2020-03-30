package com.java.data.problem62;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

/**
 * 模拟解法
 * https://leetcode-cn.com/problems/yuan-quan-zhong-zui-hou-sheng-xia-de-shu-zi-lcof/solution/javajie-jue-yue-se-fu-huan-wen-ti-gao-su-ni-wei-sh/
 */
public class Solution1 {

    public static int lastRemaining(int n, int m) {
      /*  List<Integer> list = new ArrayList<>(n);
        for (int i = 0; i < n; i++) {
            list.add(i);
        }*/
        List<Integer> list1 = new ArrayList<>();
        IntStream.range(0, n).forEach(list1::add);
        //此次需要删除的位置
        int idx = 0;
        while (n > 1) {
            //下一个需要删除的位置 idx + m - 1
            idx = (idx + m - 1) % n;
            list1.remove(idx);
            n--;
        }
        return list1.get(0);
    }

    public static void main(String[] args) {
        System.out.println(lastRemaining(5, 10));
        System.out.println(lastRemaining(10, 17));
    }
}
