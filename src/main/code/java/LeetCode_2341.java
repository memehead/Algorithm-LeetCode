package com.LeetCode.algorithm.没有上传的;

public class LeetCode_2341 {
    public int[] numberOfPairs(int[] nums) {
        if (nums.length == 1) {
            return new int[]{0, 1};
        }
        int[] ans = new int[2];
        int[] array = new int[101];
        for (int num : nums) {
            array[num]++;
        }
        int count = 0;
        for (int j : array) {
            if (j != 0) {
                count += j / 2;
            }
        }
        ans[0] = count;
        ans[1] = nums.length - count * 2;
        return ans;
    }
}
