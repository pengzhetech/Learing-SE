package com.in;

import org.junit.Test;

import java.util.Arrays;

/**
 * @author pengzhe
 * @date 2023/4/3 上午10:19
 * @description
 */

public class MoveZero {
    @Test
    public void test() {
        int[] array = {1, 9, 0, 4, 5, 0, 3};
        System.out.println(Arrays.toString(array));
        moveZeroes(array);
        System.out.println(Arrays.toString(array));

    }

    public void moveZeroes(int[] nums) {
        if (nums == null) {
            return;
        }
        //两个指针i和j
        int j = 0;
        for (int i = 0; i < nums.length; i++) {
            //当前元素!=0，就把其交换到左边，等于0的交换到右边
            if (nums[i] != 0) {
                int tmp = nums[i];
                nums[i] = nums[j];
                nums[j++] = tmp;
            }
        }
    }


}
