package com.LeetCode.algorithm.没有上传的;

import java.util.HashSet;

public class LeetCode_2670 {
    public int[] distinctDifferenceArray(int[] nums) {
        if (nums == null || nums.length == 0) {
            return nums;
        }
        int N = nums.length;
        int[] ans = new int[N];
        int[] left = new int[N];
        int[] right = new int[N];
        HashSet<Integer> hashSet = new HashSet<>();
        left[0] = 1;
        hashSet.add(nums[0]);
        for (int i = 1; i < N; ++i) {
            hashSet.add(nums[i]);
            left[i] = hashSet.size();
        }
        hashSet = new HashSet<>();
        right[N - 1] = 0;
        hashSet.add(nums[N - 1]);
        for (int i = N - 2; i >= 0; --i) {
            right[i] = hashSet.size();
            hashSet.add(nums[i]);
        }
        for (int i = 0; i < N; ++i) {
            ans[i] = left[i] - right[i];
        }
        return ans;
    }
}
