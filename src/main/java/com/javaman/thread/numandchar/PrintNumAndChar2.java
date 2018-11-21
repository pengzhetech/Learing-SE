package com.javaman.thread.numandchar;

import java.util.concurrent.locks.LockSupport;

/**
 * @author pengzhe
 * @date 2018/7/4 11:03
 * @description
 */

public class PrintNumAndChar2 {
    public static void main(String[] args) {

        int[] nums = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        char[] chars = {'a', 'b', 'c', 'd', 'e'};

        PrintNums printNums = new PrintNums(nums);
        PrintChars printChars = new PrintChars(chars);

        printNums.setPrintChars(printChars);
        printChars.setPrintNums(printNums);

        printNums.start();
        printChars.start();

    }

    public static class PrintNums extends Thread {
        private int[] nums;
        private PrintChars printChars;

        public PrintNums(int[] a1) {
            super();
            this.nums = a1;
        }

        public void setPrintChars(PrintChars printChars) {
            this.printChars = printChars;
        }

        @Override
        public void run() {
            int count = 0;
            for (int i = 0; i < nums.length; i++) {
                if (count == 2) {
                    count = 0;
                    LockSupport.unpark(printChars);
                    LockSupport.park();
                }
                System.out.print(nums[i]);
                count++;
            }
            LockSupport.unpark(printChars);
        }
    }

    public static class PrintChars extends Thread {
        private char[] chars;
        private PrintNums printNums;

        public PrintChars(char[] chars) {
            super();
            this.chars = chars;
        }

        public void setPrintNums(PrintNums printNums) {
            this.printNums = printNums;
        }

        @Override
        public void run() {
            LockSupport.park();
            int count = 0;
            for (int i = 0; i < chars.length; i++) {
                if (count == 1) {
                    count = 0;
                    LockSupport.unpark(printNums);
                    LockSupport.park();
                }
                System.out.print(chars[i]);
                count++;
            }
            LockSupport.unpark(printNums);
        }
    }
}
