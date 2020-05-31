package Leetcode;

import java.util.HashMap;

/**
 * @author RiceFamily
 * @date 2020/5/29 16:14
 * https://leetcode-cn.com/problems/sub-sort-lcci/
 */
public class LeetCode16interview16 {
    public int[] subSort(int[] array) {
        if (array == null || array.length == 0) return new int[]{-1, -1};
        int last = -1, first = -1;
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        int len = array.length;
        for (int i = 0; i < len; i++) {
            if (array[i] < max) {
                last = i;
            } else {
                max = Math.max(max, array[i]);
            }

            if (array[len - 1 - i] > min) {
                first = len - 1 - i;
            } else {
                min = Math.min(min, array[len - 1 - i]);
            }
        }
        return new int[]{first, last};
    }

    public int[] subSort2(int[] array) {
        if (array == null || array.length == 0) return new int[]{-1, -1};
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        int first = -1, last = -1;
        int len = array.length;
        for (int i = 0; i < array.length; i++) {
            if (array[i] >= max) max = array[i];
            else {
                last = i;
            }
            if (array[len - i - 1] <= min) min = array[len - i - 1];
            else {
                first = len - i - 1;
            }
        }
        return new int[]{first,last};
    }

    public static void main(String[] args) {
        LeetCode16interview16 l1616 = new LeetCode16interview16();
        l1616.subSort(new int[]{1, 2, 4, 7, 10, 11, 7, 12, 6, 7, 16, 18, 19});
    }
}
