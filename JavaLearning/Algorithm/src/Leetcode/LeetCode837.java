package Leetcode;

/**
 * @author RiceFamily
 * @date 2020/6/3 9:04
 * https://leetcode-cn.com/problems/new-21-game/
 */
public class LeetCode837 {
    public double new21Game(int N, int K, int W) {
        if (K == 0) return 1.0;
        double[] dp = new double[K + W + 1];
        for (int i = K; i <= N && i < K + W; i++) {
            dp[i] = 1.0;
        }
        for (int i = K - 1; i >= 0; i--) {
            for (int j = 1; j <= W; j++) {
                dp[i] += dp[i + j] / W;
            }
        }
        return dp[0];
    }

    public double new21Game2(int N, int K, int W) {
        if (K == 0) return 1.0;
        double[] dp = new double[K + W + 1];
        for (int i = K; i <= N && i < K + W; i++) {
            dp[i] = 1.0;
        }
        dp[K - 1] = 1.0 * Math.min(N - K + 1, W) / W;
        for (int i = K - 2; i >= 0; i--) {
//            for (int j = 1; j <= W; j++) {
//                dp[i] += dp[i + j] / W;
//            }
            dp[i] = dp[i + 1] - (dp[i + W + 1] - dp[i + 1]) / W;
        }
        return dp[0];
    }
}
