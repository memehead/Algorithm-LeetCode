package com.LeetCode.algorithm.没有上传的;


public class LCP_66 {
    public static int minNumBooths(String[] demand) {
        if (demand == null || demand.length == 0) {
            return 0;
        }
        int[] array = new int[26];
        int ans = 0;
        for (String s : demand) {
            int[] map = new int[26];
            char[] charArray = s.toCharArray();
            for (char c : charArray) {
                map[c - 'a']++;
            }
            for (char c : charArray) {
                if (array[c - 'a'] < map[c - 'a']) {
                    ans += map[c - 'a'] - array[c - 'a'];
                    array[c - 'a'] = map[c - 'a'];
                }
            }
        }
        return ans;
    }
}

