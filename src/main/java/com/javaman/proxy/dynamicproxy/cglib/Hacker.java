package com.javaman.proxy.dynamicproxy.cglib;

import java.lang.reflect.Method;

import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

/**
 * @author pengzhe
 * @date 2019-07-02 19:50
 */
public class Hacker implements MethodInterceptor {
    @Override
    public Object intercept(Object obj, Method method, Object[] args,
        MethodProxy proxy) throws Throwable {
        System.out.println("**** I am a hacker,Let's see what the poor programmer is doing Now...");
        proxy.invokeSuper(obj, args);
        System.out.println("****  Oh,what a poor programmer.....");
        return null;
    }
}
