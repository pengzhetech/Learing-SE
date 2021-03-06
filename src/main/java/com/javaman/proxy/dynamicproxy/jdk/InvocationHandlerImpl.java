package com.javaman.proxy.dynamicproxy.jdk;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @author pengzhe
 * @date 2019-07-02 19:42
 */
public class InvocationHandlerImpl implements InvocationHandler {

    private ElectricCar car;

    public InvocationHandlerImpl(ElectricCar car) {
        this.car = car;
    }

    @Override
    public Object invoke(Object paramObject, Method paramMethod,
        Object[] paramArrayOfObject) throws Throwable {
        System.out.println("You are going to invoke " + paramMethod.getName() + " ...");
        paramMethod.invoke(car, paramArrayOfObject);
        System.out.println(paramMethod.getName() + " invocation Has Been finished...");
        return null;
    }
}
