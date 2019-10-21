package com.javaman.reflect;

import java.util.stream.Stream;

/**
 * @author pengzhe
 * @date 2018/4/25 16:20
 * @description
 */

public class ClassObject {

    public static void main(String[] args) throws ClassNotFoundException {
       /* Object object = new Object();
        System.out.println("Object的全限定类名:" + object.getClass().getName());
        System.out.println("===" + ClassObject.class.getName());*/

        TestClass aClass = new TestClass();
        Stream.of(aClass.getClass().getDeclaredMethods())
            .forEach(method -> System.out.println(method.getName()));

        System.out.println("--------->" + aClass.getClass().toGenericString());

        Class<?> forNameClass = Class.forName("com.javaman.reflect.TestClass");
        Class<? extends TestClass> aClass1 = aClass.getClass();
        Class<TestClass> testClassClass = TestClass.class;

        System.out.println(forNameClass == aClass1);
        System.out.println(aClass1 == testClassClass);
    }
}
