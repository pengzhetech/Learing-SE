package com.poizon;

import org.apache.commons.lang3.BooleanUtils;

public class Test {
    public static void main(String[] args) {
        boolean t = BooleanUtils.isTrue(null);
        System.out.println(t);
    }
}
