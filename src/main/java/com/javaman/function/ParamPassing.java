package com.javaman.function;

/**
 * @author pengzhe
 * @date 2018/10/13 13:27
 * @description
 */

public class ParamPassing {

    private static int intStatic = 222;
    private static String stringStatic = "oldString";
    private static StringBuilder stringBuilderStatic = new StringBuilder("oldStringBuilderStatic");

    public static void main(String[] args) {
        //实参调用
        method(intStatic);
        method(stringStatic);
        method(stringBuilderStatic, stringBuilderStatic);

        System.out.println(intStatic);

        method();



        System.out.println(intStatic);

        System.out.println(stringStatic);

        System.out.println(stringBuilderStatic);

    }


    public static void method(int intStatic) {
        intStatic = 7777;
    }


    public static void method() {
        intStatic = 888;
    }

    public static void method(String stringStatic) {
        stringStatic = "new String";
    }

    public static void method(StringBuilder stringBuilder1, StringBuilder stringBuilder2) {
        //直接使用参数引用修改对象
        stringBuilder1.append(".method-first-");
        stringBuilder2.append("method-second-");

        //引用重新赋值
        stringBuilder1 = new StringBuilder("new StringBuilder");
        stringBuilder1.append("new method's append");

    }


}
