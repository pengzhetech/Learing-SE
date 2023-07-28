package com.in;

import org.apache.commons.lang3.StringUtils;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
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

    public static void main(String[] args) {
        String url = "https://h5cdn-sig-sign.dewu.com/202307261027/5a2a4d293a6ea4c148ac12aa0bdf1b42/global/poizon-deal-h5/2000000004/f9eaf4bacc7882a51bc8232eee6d71a7.jpeg";
        String patternStr = ".*/(global/.*)";
        String newUrl = url.replaceAll(patternStr, "$1");
        System.out.println(newUrl);
        //System.out.println("https://h5cdn-sig-sign.dewu.com/"+newUrl);
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