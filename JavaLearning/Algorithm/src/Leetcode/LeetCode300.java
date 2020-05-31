package Leetcode;

import java.util.Arrays;

/**
 * @author RiceFamily
 * @date 2020/5/26 13:05
 * https://leetcode-cn.com/problems/longest-increasing-subsequence/
 */
public class LeetCode300 {
    public int lengthOfLIS(int[] nums) {
        int dp[] = new int[nums.length];
        Arrays.fill(dp, 1);
        int max = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            if (dp[i] > max) max = dp[i];
        }
        return max;
    }

    public static void main(String[] args) {
        LeetCode300 leetCode300 = new LeetCode300();
        System.out.println(leetCode300.lengthOfLIS(new int[]{10, 9, 2, 5, 3, 7, 101, 18}));
    }
}
