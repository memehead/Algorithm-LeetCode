package com.LeetCode.algorithm.没有上传的;

import java.util.HashMap;
import java.util.Objects;

public class LCR_034 {
    public boolean isAlienSorted(String[] words, String order) {
        if (words == null || words.length == 0) {
            return true;
        }
        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < order.length(); ++i) {
            map.put(order.charAt(i), i + 1);
        }

        for (int i = 0; i < words.length; ++i) {
            for (int j = i + 1; j < words.length; ++j) {
                if (process(words, map, i, j)) {
                    return false;
                }
            }
        }
        return true;
    }

    private boolean process(String[] words, HashMap<Character, Integer> map, int i, int j) {
        int N = words[i].length();
        int M = words[j].length();
        int s1 = 0;
        int s2 = 0;
        char[] array1 = words[i].toCharArray();
        char[] array2 = words[j].toCharArray();
        boolean flag = false;
        while (s1 < N && s2 < M) {
            if (map.get(array1[s1]) > map.get(array2[s2])) {
                return true;
            } else if (Objects.equals(map.get(array1[s1]), map.get(array2[s2]))) {
                s1++;
                s2++;
            } else {
                flag = true;
                break;
            }
        }
        return !flag && s1 < N;
    }
}
