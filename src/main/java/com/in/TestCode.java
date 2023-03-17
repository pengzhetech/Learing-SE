package com.in;


import org.junit.Test;


public class TestCode {

    @Test
    public void test() {
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
}
