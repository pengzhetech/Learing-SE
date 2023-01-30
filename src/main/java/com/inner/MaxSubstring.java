package com.inner;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class MaxSubstring {
    @Test
    public void test() {
        String s = "ssssssff";
        System.out.println(maxSubStringLength(s));
    }

    public int maxSubStringLength(String s) {
        int ans = 0;
        if (s == null || s.length() == 0) return ans;
        int length = s.length();
        Map<Character, Integer> map = new HashMap<>();
        for (int start = 0, end = 0; end < length; end++) {
            char c = s.charAt(end);
            if (map.containsKey(c)) {
                start = Math.max(start, map.get(c));
            }
            ans = Math.max(ans, end - start + 1);
            map.put(c, end + 1);
        }
        return ans;
    }
}

