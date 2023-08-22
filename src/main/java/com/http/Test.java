package com.http;

import java.util.HashMap;
import java.util.Map;

public class Test {

    public static void main(String[] args) {

        System.out.println(chineseNumber(1234_5678_9098_7654L));
        System.out.println(chineseNumber(1000_0000_0000_0002L));
    }
    private static final Map<Integer, String> digitMap = new HashMap<>();
    private static final String[] units = {"", "十", "百", "千", "万", "十万", "百万", "千万", "亿", "十亿", "百亿", "千亿", "万亿"};

    static {
        digitMap.put(0, "零");
        digitMap.put(1, "一");
        digitMap.put(2, "二");
        digitMap.put(3, "三");
        digitMap.put(4, "四");
        digitMap.put(5, "五");
        digitMap.put(6, "六");
        digitMap.put(7, "七");
        digitMap.put(8, "八");
        digitMap.put(9, "九");
    }

    public static String chineseNumber(long num) {
        if (num == 0) {
            return digitMap.get(0);
        }

        StringBuilder sb = new StringBuilder();
        String numStr = String.valueOf(num);
        int length = numStr.length();
        boolean lastIsZero = true;

        for (int i = 0; i < length; i++) {
            int digit = numStr.charAt(i) - '0';

            if (digit == 0) {
                if (!lastIsZero && (i % 4 == 0 || i == 8 || i == 12)) {
                    sb.insert(0, digitMap.get(digit));
                }
                lastIsZero = true;
            } else {
                String digitStr = digitMap.get(digit) + units[getUnitIndex(length, i)];
                sb.insert(0, digitStr);
                lastIsZero = false;
            }
        }

        return sb.toString();
    }

    private static int getUnitIndex(int length, int index) {
        int unitIndex = length - index - 1;
        if (unitIndex < 4) {
            return unitIndex;
        }
        return (unitIndex - 4) % 8 + 4;
    }
}
