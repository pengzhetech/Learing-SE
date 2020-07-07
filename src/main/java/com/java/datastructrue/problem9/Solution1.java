package com.java.datastructrue.problem9;

public class Solution1 {
    public static boolean isPalindrome(int x) {
        String reversedStr = (new StringBuilder(x + "")).reverse().toString();
        return (x + "").equals(reversedStr);
    }

    public static void main(String[] args) {
        int test = 11111;
        int testint = 234;
        System.out.println(isPalindrome(test));
        System.out.println(isPalindrome(testint));
    }

}
