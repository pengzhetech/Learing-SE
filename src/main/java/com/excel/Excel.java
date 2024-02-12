package com.excel;


public class Excel {

    public static void main(String[] args) {
        String input = "23453d4534"; // 可以替换成任意字符串进行测试
        if (input.matches("\\p{Nd}+")) {
            System.out.println("字符串只包含纯阿拉伯数字");
        } else {
            System.out.println("字符串不只包含纯阿拉伯数字");
        }
    }
}
