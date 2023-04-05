package com.LeetCode.algorithm.uploaded;

import java.util.ArrayList;
import java.util.List;

/**
 * 682. 棒球比赛
 */
public class LeetCode_0682 {
    public int calPoints(String[] ops) {
        if (ops == null) {
            return 0;
        }

        List<Integer> list = new ArrayList<>();
        int total = 0;
        for (String op : ops) {
            switch (op) {
                case "+":
                    list.add(list.get(list.size() - 1) + list.get(list.size() - 2));
                    break;
                case "D":
                    list.add(list.get(list.size() - 1) * 2);
                    break;
                case "C":
                    list.remove(list.size() - 1);
                    break;
                default:
                    list.add(Integer.valueOf(op));
            }
        }
        for (Integer integer : list) {
            total += integer;
        }
        return total;
    }
}
