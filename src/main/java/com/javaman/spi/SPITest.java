package com.javaman.spi;


import java.util.Iterator;
import java.util.ServiceLoader;


public class SPITest {
    public static void main(String[] args) {

        int a = 7;
        int b = 3;

        ServiceLoader<INumberOperate> loader = ServiceLoader.load(INumberOperate.class);
        Iterator<INumberOperate> iterator = loader.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next().operate(a, b));
        }


    }
}
