package com.java.datastructrue.problem49;

import java.util.*;

class Solution {
    public static List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        for (String str : strs) {
            char[] s = str.toCharArray();
            //排序以便找到一样的字符串
            Arrays.sort(s);
            String find = new String(s);
            if (map.containsKey(find)) {
                List<String> arr = map.get(find);
                arr.add(str);
                map.put(find, arr);
            } else {
                List<String> arr = new ArrayList<>();
                arr.add(str);
                map.put(find, arr);
            }
        }
        return new ArrayList<>(map.values());
    }

    public static void main(String[] args) {
        String[] test = {"eat", "tea", "tan", "ate", "nat", "bat"};
        System.out.println(groupAnagrams(test));
    }
}

