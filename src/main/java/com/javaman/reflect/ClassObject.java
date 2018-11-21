package com.javaman.reflect;

/**
 * @author pengzhe
 * @date 2018/4/25 16:20
 * @description
 */

public class ClassObject {

    public static void main(String[] args) {
        Object object = new Object();
        System.out.println("Object的全限定类名:" + object.getClass().getName());
        System.out.println("===" + ClassObject.class.getName());
    }
}
