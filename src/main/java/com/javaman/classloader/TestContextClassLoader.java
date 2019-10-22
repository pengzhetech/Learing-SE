package com.javaman.classloader;
import java.io.FileNotFoundException;
import java.net.URL;
import java.sql.Driver;
import java.util.Iterator;
import java.util.ServiceLoader;

/**
 * @author pengzhe
 * @date 2019-10-22 11:29
 */
public class TestContextClassLoader {

    public static void main(String[] args) {
        //获取extclassloader
        ClassLoader extClassloader = MyContextClassLoad.class.getClassLoader().getParent();
        System.out.println("extloader:"  +extClassloader);
        //设置当前线程上下文加载器为ext
        Thread.currentThread().setContextClassLoader(extClassloader);
        ServiceLoader<Driver> loader = ServiceLoader.load(Driver.class);
        Iterator<Driver> iterator = loader.iterator();
        while (iterator.hasNext()) {
            Driver driver = (Driver) iterator.next();
            System.out.println("driver:" + driver.getClass() + ",loader:" + driver.getClass().getClassLoader());
        }
        System.out.println("current thread context loader:"  +Thread.currentThread().getContextClassLoader());
        System.out.println("current loader:" + MyContextClassLoad.class.getClassLoader());
        System.out.println("ServiceLoader loader:" + ServiceLoader.class.getClassLoader());
    }

}
