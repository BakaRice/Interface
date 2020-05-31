package Leetcode;

/**
 * @author RiceFamily
 * @date 2020/5/26 9:55
 * https://leetcode-cn.com/problems/longest-continuous-increasing-subsequence/
 */
public class LeetCode674 {
    public int findLengthOfLCIS(int[] nums) {
        if (nums.length == 0) return 0;
        int[] dp = new int[nums.length];
        int max = 0;
        dp[0] = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] - nums[i - 1] > 0) dp[i] = dp[i - 1] + 1;
            else dp[i] = 1;
            if (dp[i] > max) max = dp[i];
        }
        return max;
    }

    public static void main(String[] args) {
        LeetCode674 leetCode674 = new LeetCode674();
        leetCode674.findLengthOfLCIS(new int[]{1, 3, 5, 4, 7});
    }
}
