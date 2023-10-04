package com.LeetCode.algorithm.没有上传的;

import java.util.*;

public class LCR_075 {
    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        HashMap<Integer, Integer> map = new HashMap<>();
        HashSet<Integer> set = new HashSet<>();
        for (int num : arr2) {
            set.add(num);
        }
        for (int num : arr1) {
            if (map.containsKey(num)) {
                map.put(num, map.get(num) + 1);
            } else {
                if (set.contains(num)) {
                    map.put(num, 1);
                }
            }
        }
        List<Integer> list = new ArrayList<>();
        for (int num : arr2) {
            int count = map.get(num);
            for (int i = 0; i < count; ++i) {
                list.add(num);
            }
        }
        List<Integer> arrayList = new ArrayList<>();
        for (int num : arr1) {
            if (!map.containsKey(num)) {
                arrayList.add(num);
            }
        }
        arrayList.sort(Comparator.comparingInt(o -> o));
        int[] array = new int[list.size() + arrayList.size()];
        int index = 0;
        for (Integer num : list) {
            array[index++] = num;
        }
        for (Integer num : arrayList) {
            array[index++] = num;
        }
        return array;
    }
}
