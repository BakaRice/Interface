package Leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class LeetCode56 {
    class Solution {
        public int[][] merge(int[][] intervals) {
            // 先按照区间起始位置排序
            Arrays.sort(intervals, (v1, v2) -> v1[0] - v2[0]);
            // 遍历区间
            int[][] res = new int[intervals.length][2];
            int idx = -1;
            for (int[] interval : intervals) {
                //如果是开头 或者是 当前第一个数 比 前一个的第二个数大则不合并
                if (idx == -1 || res[idx][1] < interval[0]) {
                    idx++;
                    res[idx] = interval;
                } else {
                    res[idx][1] = interval[1];
                }
            }
            return res;
        }
    }

    public static void main(String[] args) {

    }

}
