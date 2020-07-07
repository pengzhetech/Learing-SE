package com.javaman.staticclass;

public class StaticClass {

    public static void main(String[] args) {
        Class[] testArr = {Test.class};
        System.out.println("test");
    }
}

class Test {
    static {
        System.out.println("execute");
    }
}
