package com.http;

import java.util.*;

public class Main {

    private static final String CN_UPPER_NUMBER[] = { "零", "壹", "贰", "叁", "肆", "伍", "陆", "柒", "捌", "玖" };
    private static final String CN_UPPER_MONETRAY_UNIT[] = { "分", "角", "圆", "拾", "佰", "仟", "萬", "拾", "佰", "仟",
            "亿", "拾", "佰", "仟", "兆", "拾", "佰", "仟", "京", "拾", "佰", "仟" };
    private static final String CN_FULL = "整";
    private static final String CN_NEGATIVE = "负";
    private static final long MAX_VALUE = 9999999999999999L;
    private static final long MIN_VALUE = -9999999999999999L;

    public static void main(String[] args) {
        System.out.println(numberToChinese(12345_5678_9098_7654L)); // 一万二千三百四十五亿五千六百七十八万九千零九十八亿七千六百五十四
        System.out.println(numberToChinese(1000_0000_0000_0002L)); // 一千万亿零二
    }
    public static String numberToChinese(long number) {
        String[] units = {"零", "一", "二", "三", "四", "五", "六", "七", "八", "九"}; //定义中文数字
        String[] places = {"", "十", "百", "千", "万", "亿"}; //定义中文数字的单位
        String result = "";
        int i = 0;
        while (number > 0) {
            long digit = number % 10; //取最后一位数字
            if (digit == 0) {
                if (!result.startsWith(units[0])) {
                    result = units[0] + result;
                }
            } else {
                result = units[(int) digit] + places[i] + result;
            }
            i++;
            number /= 10;
        }
        return result;

    }
        private static String chineseNumber(long number) {
        if (number == 0) {
            return "零";
        }


        boolean negative = false;
        if (number < 0) {
            negative = true;
            number = -number;
        }

        String numberStr = String.valueOf(number);
        String[] groups = splitNumber(numberStr, 4);

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < groups.length; i++) {
            int groupNum = Integer.parseInt(groups[i]);

            if (groupNum > 0) {
                String groupStr = parseGroup(groupNum);
                sb.insert(0, groupStr + CN_UPPER_MONETRAY_UNIT[i + 2]);
            }
        }

        if (negative) {
            sb.insert(0, CN_NEGATIVE);
        }

        return sb.toString();
    }

    private static String[] splitNumber(String number, int groupSize) {
        int length = number.length();
        int numGroups = (length + groupSize - 1) / groupSize;
        String[] groups = new String[numGroups];

        int start = length - groupSize;
        int end = length;

        for (int i = numGroups - 1; i >= 0; i--) {
            if (start < 0) {
                start = 0;
            }
            groups[i] = number.substring(start, end);
            start -= groupSize;
            end -= groupSize;
        }

        return groups;
    }

    private static String parseGroup(int group) {
        int length = String.valueOf(group).length();
        char[] digits = String.valueOf(group).toCharArray();

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < length; i++) {
            int digit = digits[i] - '0';

            if (digit != 0) {
                sb.append(CN_UPPER_NUMBER[digit]);
                sb.append(CN_UPPER_MONETRAY_UNIT[length - i - 1]);
            } else {
                // 连续的零只保留一个
                if (i > 0 && digits[i - 1] != '0') {
                    sb.append(CN_UPPER_NUMBER[digit]);
                }
            }
        }

        // 处理零拾、零佰、零仟的情况
        if (sb.toString().endsWith("零佰") || sb.toString().endsWith("零仟")) {
            sb.deleteCharAt(sb.length() - 1);
        }
        if (sb.toString().endsWith("零拾")) {
            sb.deleteCharAt(sb.length() - 1);
        }

        // 处理零萬、零亿、零兆等情况
        if (group < 1000 && sb.toString().startsWith("零")) {
            sb.deleteCharAt(0);
        }

        return sb.toString();
    }
}
