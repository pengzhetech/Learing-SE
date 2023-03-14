package com.in;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @author pengzhe
 * @date 2023/3/14 下午7:56
 * @description
 */

public class Test {

    @org.junit.Test
    public void test() {
        int[][] arr1 = new int[2][2];
        arr1[0][0] = 1;
        arr1[0][1] = 2;
        arr1[1][0] = 4;
        arr1[1][1] = 3;
        System.out.println(Arrays.deepToString(arr1));

        List<Integer> reverseArray = printNum(arr1);
        System.out.println(reverseArray);

    }

    public List<Integer> printNum(int[][] arrays) {

        LinkedList<Integer> result = new LinkedList<>();
        if (arrays == null || arrays.length == 0) return result;

        int left = 0;
        int right = arrays[0].length - 1;
        int top = 0;
        int bottom = arrays.length - 1;
        int totalNum = arrays.length * arrays[0].length;

        while (totalNum > 0) {

            for (int i = left; i <= right && totalNum >= 1; i++) {
                result.add(arrays[top][i]);
                totalNum--;
            }
            top++;

            for (int i = top; i <= bottom && totalNum >= 1; i++) {
                result.add(arrays[i][right]);
                totalNum--;
            }
            right--;

            for (int i = right; i >= left && totalNum >= 1; i--) {
                result.add(arrays[bottom][i]);
                totalNum--;
            }
            bottom--;

            for (int i = bottom; i >= top && totalNum >= 1; i--) {
                result.add(arrays[i][left]);
                totalNum--;
            }
            left++;
        }

        return result;
    }
}
