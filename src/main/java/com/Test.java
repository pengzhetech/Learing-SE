package com;


import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import java.time.Instant;
import java.time.LocalDate;
import java.time.Month;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.time.temporal.WeekFields;
import java.util.*;

public class Test {

    public static void main(String[] args) {
        String str = "1_10239,11_10239,111_10239,1_10242,11_10242,111_10242,1_36,11_36,111_36,1_10387,11_10387,111_10387,105_1000813,104_1000366,11_10119,11_10032,11_10045,11_10010,11_1000259,11_1001452,11_10054,11_10015,1_10085,56_10074,56_10207,2_10195,2_10219,5_10219,6_10219,11_10026";
        String[] arr = str.split(",");
        StringBuilder sb = new StringBuilder();
        for (String s : arr) {
            String number = s.split("_")[1];
            sb.append(number).append(",");
        }
        String result = sb.toString();
// 去掉最后一个逗号
        if (result.length() > 0) {
            result = result.substring(0, result.length() - 1);
        }
        System.out.println(result);

    }

    @org.junit.Test
    public void test() {
        //现在：1694590498
        System.out.println(1111111111);
    }

    @org.junit.Test
    public void testIoJsonWebToken() {
        String key = "myKey";
        HashMap<String, Object> map = new HashMap<>();
        map.put("name", "get");
        String jwt = Jwts.builder().signWith(SignatureAlgorithm.HS256, key).setClaims(map).compact();
        System.out.println(jwt); // eyJhbGciOiJIUzI1NiJ9.eyJuYW1lIjoiZ2V0In0.RiKlMMNgv3XRDcZtxgukAEpOHv_Q9pQQjDPPuPa-Dw0
    }

    @org.junit.Test
    public void parseJsonWebToken() {
        String key = "myKey";
        Jws<Claims> jws = Jwts.parser().setSigningKey(key).parseClaimsJws("eyJhbGciOiJIUzI1NiJ9.eyJuYW1lIjoiZ2V0In0.RiKlMMNgv3XRDcZtxgukAEpOHv_Q9pQQjDPPuPa-Dw0");
        System.out.println(jws.getBody());
        System.out.println(jws.getBody().get("name"));
    }

    @org.junit.Test
    public void testWeek() {
        long timestamp = System.currentTimeMillis() / 1000; // 转换为秒级时间戳
        LocalDate date = Instant.ofEpochSecond(timestamp).atZone(ZoneId.systemDefault()).toLocalDate();
        WeekFields weekFields = WeekFields.of(Locale.getDefault());
        int week = date.get(weekFields.weekOfWeekBasedYear());
        System.out.println("当前时间戳所在的周：" + week);
    }

    @org.junit.Test
    public void testMonth() {
        long timestamp = System.currentTimeMillis() / 1000; // 将时间戳转换为秒级
        LocalDate date = Instant.ofEpochSecond(timestamp).atZone(ZoneId.systemDefault()).toLocalDate();
        Month month = date.getMonth();

        // 创建DateTimeFormatter对象，并使用M模式来获取月份的阿拉伯数字表示
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("M");
        String arabicMonth = formatter.format(month);

        System.out.println("时间戳所在的阿拉伯数字月份：" + arabicMonth);
    }

    @org.junit.Test
    public void testSplit() {
        Map<String, String> mao = new HashMap<>();
        System.out.println(String.valueOf(mao.get("wtrwe")));
        String communityIdentifyRecords = "";
        List<String> list = Arrays.asList(communityIdentifyRecords.split("\\|"));
        System.out.println(list);
    }

    @org.junit.Test
    public void testSplitF() {
        String s = "fsdf";
        String[] s1 = s.split("_");
        System.out.println(s1);
        System.out.println(s1.length);



        String s2 = "fsdf_234";
        String[] s12 = s2.split("_");
        System.out.println(s12);
        System.out.println(s12.length);
    }

}


