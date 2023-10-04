package com.LeetCode.algorithm.没有上传的;

import java.util.Arrays;

/**
 * 打表更快
 */
public class LeetCode_2729 {
    public boolean isFascinating(int n) {
        String builder = String.valueOf(n) +
                2 * n +
                3 * n;
        char[] array = builder.toCharArray();
        Arrays.sort(array);
        if (array.length != 9) {
            return false;
        }
        for (int i = 0; i < array.length; ++i) {
            if (array[i] != (char) (i + 1 + 48)) {
                return false;
            }
        }
        return true;
    }
}
