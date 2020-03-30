package com.java.data.problem5;

public class Solution1 {
    public static boolean isPalindromic(String s) {
        int len = s.length();
        for (int i = 0; i < len / 2; i++) {
            if (s.charAt(i) != s.charAt(len - i - 1)) {
                return false;
            }
        }
        return true;
    }

/*    public static boolean isHuiwen(String s) {
        int len = s.length();
        IntStream.range(0,len/2).forEach(index->{
            if (s.charAt(index)!=s.charAt(len-index-1)){

            }
        });
        return true;
    }*/

    // 暴力
    public static String longestPalindrome(String s) {
        String ans = "";
        int max = 0;
        int len = s.length();
        for (int i = 0; i < len; i++) {
            for (int j = i + 1; j <= len; j++) {
                String candidateString = s.substring(i, j);
                if (isPalindromic(candidateString) && candidateString.length() > max) {
                    ans = s.substring(i, j);
                    max = Math.max(max, ans.length());
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        String testString = "babsdfsdfsdfbadbbbbbbbbbbbbbbbbbbbbb";
        String testString1 = "qmqqdsf3rerafsd";
        String testString01 = "qmq";
        System.out.println(longestPalindrome(testString1));
        System.out.println(isPalindromic(testString1));
        System.out.println(isPalindromic(testString01));
    }

}
