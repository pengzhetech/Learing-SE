package com.javaman.spi;

/**
 * @author pengzhe
 * @date 2019-02-22 14:01
 */
public class INumberSPIPlusOperateImpl implements INumberOperate {
    public int operate(int a, int b) {
        int addNumber = a + b;
        System.out.println("SPI机制的和:" + addNumber);
        return addNumber;
    }
}
