package com.javaman.spi;

/**
 * @author pengzhe
 * @date 2019-02-22 14:24
 */
public class INumberOperateImpl implements INumberOperate {
    public int operate(int a, int b) {
        int addNumber = a + b;
        System.out.println("非SPI的和:" + addNumber);
        return addNumber;
    }
}
