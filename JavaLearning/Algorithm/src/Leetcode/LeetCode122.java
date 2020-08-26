package Leetcode;

/**
 * Description: JavaLearning
 * Created by Rice on 2020/7/10 20:35
 */
public class LeetCode122 {
    public int maxProfit(int[] prices) {
        int[] dp = new int[prices.length];
        dp[0] = 0;
        for (int i = 1; i < dp.length; i++) {
            int max = 0;
            for (int j = 0; j < i; j++) {
                max = Math.max(prices[i] - prices[j], max);
            }
            dp[i] = Math.max(dp[i - 1], Math.max(max, dp[i - 1] + prices[i] - prices[i - 1]));
        }
        return dp[prices.length - 1];
    }

    public static void main(String[] args) {
        LeetCode122 leetCode122 = new LeetCode122();
        System.out.println(leetCode122.maxProfit(new int[]{7, 1, 5, 3, 6, 4}));
    }
}
