package Leetcode;

public class LeetCode53 {
    //dp 时间复杂度 O(N) 空间复杂度 O(N)
    public int maxSubArray(int[] nums) {
        int dp[] = new int[nums.length];
        if (nums.length == 0) return 0;
        if (nums.length == 1) return nums[0];
        dp[0] = nums[0];
        int max = nums[0];
        for (int i = 1; i <= nums.length - 1; i++) {
            if (dp[i - 1] + nums[i] > nums[i])
                dp[i] = dp[i - 1] + nums[i];
            else
                dp[i] = nums[i];
            if (dp[i] > max) max = dp[i];
        }
        return max;
    }
    //dp 时间复杂度 O(N) 空间复杂度 O(1)
    public int maxSubArray1(int[] nums) {
        int max = nums[0], prev = 0;
        for (int num : nums) {
            prev = Math.max(prev + num, num);
            max = Math.max(max, prev);
        }
        return max;
    }

    public static void main(String[] args) {
        LeetCode53 leetCode53 = new LeetCode53();
        int[] nums = new int[]{-1, -2};
        leetCode53.maxSubArray(nums);
    }
}
