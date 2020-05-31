package Leetcode;

import java.util.Arrays;

/**
 * @author RiceFamily
 * @date 2020/5/26 12:30
 */
public class LeetCode673 {
    public int findNumberOfLIS(int[] nums) {
        int dp[] = new int[nums.length];
        int memo[] = new int[nums.length+1];
        memo[1] = nums.length;
        int max = 0;
        Arrays.fill(dp, 1);
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i]) {
                    memo[dp[j] + 1]++;
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            if (dp[i] > max) max = dp[i];
        }
        return memo[max];
    }

    public static void main(String[] args) {
        LeetCode673 leetCode673 = new LeetCode673();
        System.out.println(leetCode673.findNumberOfLIS(new int[]{1,2,4,3,5,4,7,2}));
    }
}
