package com.LeetCode.algorithm.没有上传的;

import java.util.*;

public class LCS_02 {
    public int halfQuestions(int[] questions) {
        if (questions == null || questions.length == 0) {
            return 0;
        }

        HashMap<Integer, Integer> map = new HashMap<>();
        for (int num : questions) {
            if (map.containsKey(num)) {
                map.put(num, map.get(num) + 1);
            } else {
                map.put(num, 1);
            }
        }
        List<Integer> list = new ArrayList<>(map.values());
        list.sort((o1, o2) -> o2 - o1);
        int N = questions.length / 2;
        int count = 0;
        int ans = 0;
        for (Integer integer : list) {
            if (count < N) {
                count += integer;
                ++ans;
            } else {
                break;
            }
        }
        return ans;
    }
}
