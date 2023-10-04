package com.LeetCode.algorithm.没有上传的;

import java.util.Arrays;

public class LeetCode_2418 {
    private class Info {
        private String name;
        private int height;

        public Info(String name, int height) {
            this.name = name;
            this.height = height;
        }
    }

    public String[] sortPeople(String[] names, int[] heights) {
        if (names == null || heights == null || names.length != heights.length) {
            return new String[]{};
        }
        int N = names.length;
        Info[] array = new Info[N];
        for (int i = 0; i < N; ++i) {
            array[i] = new Info(names[i], heights[i]);
        }
        Arrays.sort(array, (o1, o2) -> o2.height - o1.height);
        String[] ans = new String[N];
        for (int i = 0; i < N; ++i) {
            ans[i] = array[i].name;
        }
        return ans;
    }
}
