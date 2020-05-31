package Leetcode;

/**
 * @author RiceFamily
 * @date 2020/5/29 9:07
 */
public class LeetCode198 {
    public int rob(int[] nums) {
        if (nums.length == 0) return 0;
        int[] dp = new int[nums.length];
        int max = nums[0];
        dp[0] = nums[0];
        if (nums.length >= 2) {
            if (nums[0] > nums[1]) max = nums[0];
            else max = nums[1];
            dp[1] = max;
        }
        for (int i = 2; i < nums.length; i++) {
            dp[i] = Math.max(dp[i - 2] + nums[i], Math.max(nums[i], dp[i - 1]));
            if (max < dp[i]) max = dp[i];
        }
        return max;
    }

    public int rob_1(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        int len = nums.length;
        if (len == 1) return nums[0];
        int[] dp = new int[len];
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);
        for (int i = 2; i < len; i++) {
            dp[i] = Math.max(dp[i - 2] + nums[i], dp[i - 1]);
        }
        return dp[len - 1];
    }

    public static void main(String[] args) {
        LeetCode198 leetCode198 = new LeetCode198();
        System.out.println(leetCode198.rob(new int[]{2, 1, 1, 2}));
    }
}
