package Leetcode.Exercise.dynamic;

/**
 * Description: JavaLearning
 * Created by Rice on 2020/6/25 19:19
 * https://leetcode-cn.com/explore/interview/card/top-interview-questions-easy/23/dynamic-programming/56/
 */
public class T3 {
    //时间复杂度为O(n)的动态规划
    public int maxSubArray(int[] nums) {
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        int max = dp[0];
        for (int i = 1; i < dp.length; i++) {
            dp[i] = Math.max(dp[i - 1] + nums[i], nums[i]);
            max = Math.max(dp[i], max);
        }
        return max;
    }

    public static void main(String[] args) {
        T3 t3 = new T3();
        System.out.println(t3.maxSubArray(new int[]{-2, 1}));
    }
}
