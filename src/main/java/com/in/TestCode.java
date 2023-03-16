package com.in;


import org.junit.Test;

public class TestCode {

    @Test
    public void test() {
        System.out.println(sum(5));
    }

    public int sum(int days) {
        int total = 1;
        for (int i = 1; i < days; i++) {
            total = (total + 1) * 2;
        }
        return total;
    }

    void moveZero() {

    }
}
