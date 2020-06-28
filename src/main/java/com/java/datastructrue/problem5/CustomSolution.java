package com.java.datastructrue.problem5;

public class CustomSolution {


    public static void main(String[] args) {
        String testString = "qmqwerwerwbbbbbbbbbbb";
        String testString2 = "bbbbbbbbbbb";
        System.out.println(isPalindrome(testString2));
        System.out.println(longestString(testString));
    }

    private static String longestString(String s) {
        int length = s.length();
        String ans = "";
        //其中一个回文串的长度
        int max = 0;
        for (int i = 0; i < length; i++) {
            for (int j = i + 1; j < length; j++) {
                String candidateString = s.substring(i, j);
                //这个子串是回文串,并且它的长度比之前其中一个回文串的长度要长
                if (isPalindrome(candidateString) && candidateString.length() > max) {
                    ans = candidateString;
                    max =  ans.length();
                }
            }
        }
        return ans;
    }

    private static boolean isPalindrome(String s) {
        int length = s.length();
        for (int i = 0; i < length / 2; i++) {
            if (s.charAt(i) != s.charAt(length - 1 - i)) {
                return false;
            }
        }
        return true;
    }

}
