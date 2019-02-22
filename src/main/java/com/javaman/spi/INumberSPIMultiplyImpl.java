package com.javaman.spi;

/**
 * @author pengzhe
 * @date 2019-02-22 14:08
 */
public class INumberSPIMultiplyImpl implements INumberOperate {
    public int operate(int a, int b) {
        int multiplyNumber = a * b;
        System.out.println("SPI机制的积:" + multiplyNumber);
        return multiplyNumber;
    }
}
