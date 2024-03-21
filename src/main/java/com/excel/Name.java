package com.excel;


public class Name {
    public static void main(String[] args) {
        String name = "A StistgMfsdf》^asdfsd ？d3 ASD-F： f=sdf";
        String parsedName = name.replaceAll("[^a-zA-Z0-9]+", " ")
                // 去除字符串两端的空格
                .trim()
                .replaceAll("\\s+", "-")
                .toLowerCase();
        System.out.println(parsedName);
    }
}
