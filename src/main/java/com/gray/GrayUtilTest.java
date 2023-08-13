package com.gray;

public class GrayUtilTest {
    public static void main(String[] args) {
        GrayConfig config = new GrayConfig();
        config.setMainSwitch(false);
        config.setModulo(0);
        config.setRatio(10);
        System.out.println(GrayUtil.hitGray(config, "200000000"));
    }
}
