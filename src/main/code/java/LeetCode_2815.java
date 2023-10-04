package com.LeetCode.algorithm.没有上传的;

import java.util.*;

public class LeetCode_2815 {
    public int maxSum(int[] nums) {
        if (nums == null || nums.length < 2) {
            return -1;
        }
        HashMap<Integer, List<Integer>> map = new HashMap<>();
        for (int num : nums) {
            int maxValue = process(num);
            if (map.containsKey(maxValue)) {
                map.get(maxValue).add(num);
            } else {
                List<Integer> list = new ArrayList<>();
                list.add(num);
                map.put(maxValue, list);
            }
        }
        int ans = -1;
        for (Map.Entry<Integer, List<Integer>> entry : map.entrySet()) {
            entry.getValue().sort((o1, o2) -> o2 - o1);
            if (entry.getValue().size() > 1) {
                ans = Math.max(entry.getValue().get(0) + entry.getValue().get(1), ans);
            }
        }
        return ans;
    }

    private int process(int num) {
        int ans = Integer.MIN_VALUE;
        while (num != 0) {
            int mod = num % 10;
            ans = Math.max(mod, ans);
            num /= 10;
        }
        return ans;
    }
}
