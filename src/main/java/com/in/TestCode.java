package com.in;


import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;

public class TestCode {

    @Test
    public void test() {
        System.out.println(sum(5));
        int[] nums = {1, 23, 0, 78, 0, 8, 0};
        System.out.println(Arrays.toString(nums));
        moveZero(nums);
        System.out.println(Arrays.toString(nums));
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
}
