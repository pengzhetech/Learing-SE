package com.inner;

import org.apache.commons.lang3.StringUtils;
import org.junit.Test;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class MaxSubstring {
    @Test
    public void test() {
        String s = "ssssssff";
        System.out.println(maxSubStringLength(s));

        System.out.println(System.currentTimeMillis() / 1000);
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

    @Test
    public void testL() {
        System.out.println(10000%100);

    }
}

class ReportInfo implements Serializable {
    //真实的reportId
    private Long id;
    //真实的reportId对应的描述信息
    private String desc;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}


