package com.system.design;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/**
 * @author pengzhe
 * @date 2023/4/1 下午9:44
 * @description
 */

public class TinyUrlV1 {
    private Map<String, String> long2Short;
    private Map<String, String> short2Long;

    public TinyUrlV1() {
        long2Short = new HashMap<String, String>();
        short2Long = new HashMap<String, String>();
    }

    /**
     * @param url a long url
     * @return a short url starts with http://tiny.url/
     */
    public String longToShort(String url) {
        if (long2Short.containsKey(url)) {
            return long2Short.get(url);
        }

        while (true) {
            String shortURL = generateShortURL();
            if (!short2Long.containsKey(shortURL)) {
                short2Long.put(shortURL, url);
                long2Short.put(url, shortURL);
                return shortURL;
            }
        }
    }

    /**
     * @param url a short url starts with http://tiny.url/
     * @return a long url
     */
    public String shortToLong(String url) {
        if (!short2Long.containsKey(url)) {
            return null;
        }

        return short2Long.get(url);
    }

    private String generateShortURL() {
        String allowedChars = "0123456789" + "abcdefghijklmnopqrstuvwxyz" + "ABCDEFGHIJKLMNOPQRSTUVWXYZ";

        Random rand = new Random();
        StringBuilder shortURL = new StringBuilder("http://tiny.url/");
        for (int i = 0; i < 6; i++) {
            int index = rand.nextInt(62);
            shortURL.append(allowedChars.charAt(index));
        }

        return shortURL.toString();
    }
}
