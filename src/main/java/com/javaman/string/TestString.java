package com.javaman.string;

import java.util.Arrays;

public class TestString {

    public static void main(String[] args) {
        String testString = "werwer.fsvhefsx";
        String testString2 = "rwefsr";
        System.out.println(testString2.replaceFirst("r", "R"));
        System.out.println(testString2.replaceAll("r", "R"));
        System.out.println(Arrays.toString(testString2.getBytes()));
        System.out.println(testString.lastIndexOf("e", 2));
        System.out.println(testString.lastIndexOf("e", 2));
        System.out.println(testString.charAt(testString.lastIndexOf("e", 2)));
        System.out.println(testString.indexOf(testString2));
        System.out.println(testString.contentEquals(testString2));
        System.out.println(testString.substring(3, 8));
        System.out.println(testString.replace("w", "P"));
        System.out.println(Arrays.toString(testString.split("\\.")));
        System.out.println(testString.startsWith("wer"));


    }
}
