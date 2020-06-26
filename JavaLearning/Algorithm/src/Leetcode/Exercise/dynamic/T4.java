package Leetcode.Exercise.dynamic;

/**
 * Description: JavaLearning
 * Created by Rice on 2020/6/25 19:46
 */
public class T4 {
    public int rob(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int length = nums.length;
        if (length == 1) {
            return nums[0];
        }
        int[] dp = new int[length];
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);
        for (int i = 2; i < length; i++) {
            dp[i] = Math.max(dp[i - 2] + nums[i], dp[i - 1]);
        }
        return dp[length - 1];
    }

    public static void main(String[] args) {
        T4 t4 = new T4();
        System.out.println(t4.rob(new int[]{1, 2, 3, 1}));
    }
}
