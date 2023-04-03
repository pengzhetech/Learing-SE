package com.in;

import org.junit.Test;

import java.util.*;

/**
 * @author pengzhe
 * @date 2023/4/3 上午11:06
 * @description
 */

public class TopK {

    @Test
    public void test() {
        int[] array = {1, 1, 1, 2, 2, 3};
        System.out.println(Arrays.toString(topKFrequent(array, 2)));

    }

    public int[] topKFrequent(int[] nums, int k) {
        //使用字典，统计每个元素出现的次数，元素为键，元素出现的次数为值
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])) {
                map.put(nums[i], map.get(nums[i]) + 1);
            } else {
                map.put(nums[i], 1);
            }
        }
        // 遍历map，用最小堆保存频率最大的k个元素
        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.comparingInt(map::get));
        for (Integer key : map.keySet()) {
            if (pq.size() < k) {
                pq.add(key);
            } else if (map.get(key) > map.get(pq.peek())) {
                pq.remove();
                pq.add(key);
            }
        }
        // 取出最小堆中的元素
        List<Integer> res = new ArrayList<>();
        while (!pq.isEmpty()) {
            res.add(pq.remove());
        }
        int[] ress = new int[res.size()];
        for (int i = 0; i < res.size(); i++) {
            ress[i] = res.get(i);
        }
        return ress;

    }
}
