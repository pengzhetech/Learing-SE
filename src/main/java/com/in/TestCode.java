package com.in;


import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;


public class TestCode {

    @Test
    public void test() {
        int[] arr1 = {1, 5, 0};
        int[] arr2 = {6, 3, 9};
        List<Integer> integers = topK(arr1, arr2, 2);

        System.out.println(trailingZeroes(10));
    }

    public int sum(int days) {
        int total = 1;
        for (int i = 1; i < days; i++) {
            total = (total + 1) * 2;
        }
        return total;
    }

    void moveZero(int[] nums) {
        if (nums == null) return;

        int j = 0;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                int tmm = nums[i];
                nums[i] = nums[j];
                nums[j++] = tmm;
            }
        }

    }

    public int trailingZeroes(int n) {
        int count = 0;
        while (n > 0) {
            count += n / 5;
            n = n / 5;
        }
        return count;
    }

    public List<Integer> topK(int[] arr1, int[] arr2, int k) {
        List<Integer> res = new ArrayList<>();
        Arrays.sort(arr1);
        Arrays.sort(arr2);
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        for (int i = 0; i < arr1.length; i++) {
            for (int j = 0; j < arr2.length; j++) {
                queue.offer(arr1[i] + arr2[j]);
            }

        }
        for (int i = 0; i < k; i++) {
            res.add(queue.remove());
        }
        return res;
    }
}
