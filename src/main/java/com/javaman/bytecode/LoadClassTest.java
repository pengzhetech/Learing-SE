package com.javaman.bytecode;

import java.lang.reflect.InvocationTargetException;

/**
 * @author pengzhe
 * @date 2019-07-02 16:23
 */
public class LoadClassTest {
    public static void main(String[] args)
        throws ClassNotFoundException, IllegalAccessException, InstantiationException {

        MyClassLoader loader = new MyClassLoader();
        //使用自定义的类加载器将 加载该类并转换成Class对象
        Class<?> clazz = loader.loadClass("com.javaman.Programmer");

        //测试加载是否成功，打印class 对象的名称
        System.out.println(clazz.getCanonicalName());

        //实例化一个Programmer对象
        Object o = clazz.newInstance();
        try {
            //调用Programmer的code方法
            clazz.getMethod("code", null).invoke(o, null);
        } catch (IllegalArgumentException | InvocationTargetException
            | NoSuchMethodException | SecurityException e) {
            e.printStackTrace();
        }
    }
}
