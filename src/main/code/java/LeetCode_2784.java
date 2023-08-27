package com.LeetCode.algorithm.uploaded;

import java.util.HashMap;

/**
 * 2784. 检查数组是否是好的 https://leetcode.cn/problems/check-if-array-is-good/description/
 */
public class LeetCode_2784 {
    public boolean isGood(int[] nums) {
        if (nums == null || nums.length == 0) {
            return false;
        }
        int N = nums.length;
        int maxValue = Integer.MIN_VALUE;
        for (int num : nums) {
            maxValue = Math.max(maxValue, num);
        }
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            if (map.containsKey(num)) {
                map.put(num, map.get(num) + 1);
            } else {
                map.put(num, 1);
            }
        }
        if (map.get(maxValue) != 2 || N != maxValue + 1) {
            return false;
        }
        for (int num : nums) {
            if (num != maxValue && map.get(num) != 1) {
                return false;
            }
        }
        return true;
    }
}
