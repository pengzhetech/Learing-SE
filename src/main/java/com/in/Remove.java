package com.in;

import org.apache.commons.lang3.StringUtils;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.List;

public class Remove {
  /*  public static void main(String[] args) throws MalformedURLException, URISyntaxException {
        String url = "https://h5cdn-sig-sign.poizonapp.com/217611081751/34c6df42ebda0b6efcaaaa392501bfbb/global/poizon-deal-h5-two/108.50.201.180/3e15db8872b56197856bfbf008717dad.jpeg";
        if ("https".equals(url.substring(0, 5))) {
                URI uri = new URI(url);
                String newUrl = "https://h5cdn-sig-sign.poizonapp.com/" + uri.getPath();
                if (StringUtils.isNotBlank(uri.getQuery())) {
                    newUrl = newUrl + uri.getQuery();
                    System.out.println(newUrl);
                }

        }
    }*/



    public static String generateCode(String url) throws NoSuchAlgorithmException {
        MessageDigest sha1 = MessageDigest.getInstance("SHA-1"); //使用SHA-1算法生成摘要
        byte[] digest = sha1.digest(url.getBytes(StandardCharsets.UTF_8)); //将url字符串转换为字节数组，并生成摘要
        StringBuilder builder = new StringBuilder();
        for (byte b : digest) {
            builder.append(String.format("%02x", b)); //将字节转换成16进制的字符串，拼接起来
        }
        return builder.toString();
    }

    public static void main(String[] args) throws NoSuchAlgorithmException {
        String url = "https://example.com/imagess.jpg";
        String uniqueCode = generateCode(url);
        System.out.println(uniqueCode); //9c7a7fc26411f8fff3d858c42107e1f25a84d00d
    }

}


class Mode {
    public Mode(String name, int age) {
        this.name = name;
        this.age = age;
    }

    private String name;
    private int age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}