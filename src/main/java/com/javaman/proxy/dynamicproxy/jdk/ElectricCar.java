package com.javaman.proxy.dynamicproxy.jdk;

/**
 * @author pengzhe
 * @date 2019-07-02 19:40
 */
public class ElectricCar implements Rechargable, Vehicle {

    @Override
    public void drive() {
        System.out.println("Electric Car is Moving silently...");
    }

    @Override
    public void recharge() {
        System.out.println("Electric Car is Recharging...");
    }
}
