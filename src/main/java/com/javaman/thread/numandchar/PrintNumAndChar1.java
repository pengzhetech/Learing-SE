package com.javaman.thread.numandchar;

import java.util.concurrent.atomic.AtomicBoolean;

/**
 * @author pengzhe
 * @date 2018/7/4 10:51
 * @description
 */

public class PrintNumAndChar1 {

    public static void main(String[] args) {
        AtomicBoolean isNum = new AtomicBoolean(true);
        int[] nums = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        char[] chars = {'a', 'b', 'c', 'd', 'e'};
        new PrintNums(nums, isNum).start();
        new PrintChars(chars, isNum).start();
    }

    public static class PrintNums extends Thread {
        private int[] nums;
        private AtomicBoolean isNum;

        public PrintNums(int[] a1, AtomicBoolean isNum) {
            this.nums = a1;
            this.isNum = isNum;
        }

        @Override
        public void run() {
            int count = 0;
            for (int i = 0; i < nums.length; i++) {
                while (!isNum.get()) {
                    Thread.yield();
                }
                System.out.print(nums[i]);
                count++;
                if (count == 2) {
                    isNum.set(false);
                    count = 0;
                }
            }
            isNum.set(false);
        }
    }

    public static class PrintChars extends Thread {
        private char[] chars;
        private AtomicBoolean isNum;

        public PrintChars(char[] a2, AtomicBoolean isNum) {
            this.chars = a2;
            this.isNum = isNum;
        }

        @Override
        public void run() {
            int count = 0;
            for (int i = 0; i < chars.length; i++) {
                while (isNum.get()) {
                    Thread.yield();
                }
                System.out.print(chars[i]);
                count++;
                if (count == 1) {
                    isNum.set(true);
                    count = 0;
                }
            }
            isNum.set(true);
        }
    }
}
