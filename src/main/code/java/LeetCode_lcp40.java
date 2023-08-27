package com.LeetCode.algorithm.uploaded;

import java.util.Arrays;
import java.util.HashSet;

/**
 * LCP 40. 心算挑战 https://leetcode.cn/problems/uOAnQW/
 */
public class LeetCode_lcp40 {
    public static void main(String[] args) {
        boolean flag = false;
        for (int i = 0; i < 100000; ++i) {
            int[] array1 = generateRandomArray(20, 10);
            int[] array2 = copyArray(array1);
            int cnt = (int) (Math.random() * 10) + 1;
            int res = maxmiumScore(array1, cnt);
            int ans = dp(array2, cnt);
            if (ans != res) {
                System.out.println(Arrays.toString(array2));
                System.out.println("cnt is: " + cnt);
                System.out.println("res is: " + res);
                System.out.println("ans is: " + ans);
                flag = true;
                break;
            }
        }
        System.out.println(!flag ? "Nice" : "Fuck!");
//        int[] array = {3, 1, 5, 1};
//        int[] array = {5, 1, 2, 1, 3, 4, 5};
//        System.out.println(maxmiumScore(array, 3));
    }

    public static int maxmiumScore(int[] cards, int cnt) {
        if (cards == null || cards.length < cnt) {
            return 0;
        }
        Arrays.sort(cards);
        int sum = 0;
        int i = 1;
        int N = cards.length;
        while (i <= cnt) {
            sum += cards[N - i];
            ++i;
        }
        if (sum % 2 == 0) {
            return sum;
        }
        int minEven = Integer.MAX_VALUE;
        int minOdd = Integer.MAX_VALUE;
        i = 1;
        while (i <= cnt) {
            // 找到最小的偶数，剩下的元素中找一个最大奇数
            if (cards[N - i] % 2 == 0) {
                minEven = Math.min(minEven, cards[N - i]);
            } else { // 找到最小的奇数，剩下的元素中找一个最大的偶数
                minOdd = Math.min(minOdd, cards[N - i]);
            }
            ++i;
        }
        int newNum2 = -1;
        if (minEven != Integer.MAX_VALUE) {
            for (int j = N - i; j >= 0; --j) {
                if (cards[j] % 2 == 1) {
                    newNum2 = sum - minEven + cards[j];
                    break;
                }
            }

        }
        int newNum1 = -1;
        if (minOdd != Integer.MAX_VALUE) {
            for (int j = N - i; j >= 0; --j) {
                if (cards[j] % 2 == 0) {
                    newNum1 = sum - minOdd + cards[j];
                    break;
                }
            }
        }
        int ans;
        if (newNum1 != -1 && newNum2 != -1) {
            ans = Math.max(newNum1, newNum2);
        } else if (newNum1 != -1) {
            ans = newNum1;
        } else {
            ans = newNum2;
        }
        return ans == -1 ? 0 : ans;
    }


    public static int dp(int[] cards, int cnt) {
        if (cards == null || cards.length < cnt) {
            return 0;
        }

        HashSet<Integer> set = new HashSet<>();
        process(cards, 0, cnt, 0, set);
        int ans = 0;
        for (Integer num : set) {
            ans = Math.max(ans, num);
        }

        return ans;
    }

    private static void process(int[] cards, int index, int cnt, int curSum, HashSet<Integer> set) {
        if (index == cards.length) {
            if (cnt == 0 && curSum % 2 == 0) {
                set.add(curSum);
            }
            return;
        }
        process(cards, index + 1, cnt, curSum, set);
        process(cards, index + 1, cnt - 1, curSum + cards[index], set);
    }

    private static int[] generateRandomArray(int maxSize, int maxValue) {
        int N = (int) (Math.random() * maxSize) + 1;
        int[] array = new int[N];
        for (int i = 0; i < N; ++i) {
            array[i] = (int) (Math.random() * maxValue) + 1;
        }

        return array;
    }

    private static int[] copyArray(int[] array) {
        if (array == null || array.length == 0) {
            return new int[]{};
        }
        int N = array.length;
        int[] result = new int[N];
        System.arraycopy(array, 0, result, 0, N);
        return result;
    }
}
