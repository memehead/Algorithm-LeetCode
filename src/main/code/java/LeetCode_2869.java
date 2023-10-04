package com.LeetCode.algorithm.没有上传的;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class LeetCode_2869 {
    public int minOperations(List<Integer> nums, int k) {
        if (nums == null || nums.size() < k) {
            return Integer.MAX_VALUE;
        }
        int ans = 0;
        int[] array = new int[k];
        for (int i = nums.size() - 1; i >= 0; i--) {
            if (nums.get(i) >= 1 && nums.get(i) <= k) {
                array[nums.get(i) - 1] = 1;
                if (process(array)) {
                    ++ans;
                    return ans;
                }
            }
            ++ans;
        }
        return ans;
    }

    private boolean process(int[] array) {
        for (int num : array) {
            if (num <= 0) {
                return false;
            }
        }
        return true;
    }
}
