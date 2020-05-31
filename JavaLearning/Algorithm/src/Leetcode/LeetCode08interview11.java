package Leetcode;

import java.util.HashMap;

/*
硬币。给定数量不限的硬币，币值为25分、10分、5分和1分，编写代码计算n分有几种表示法。
(结果可能会很大，你需要将结果模上1000000007)
 */
public class LeetCode08interview11 {
    public int waysToChange(int n) {
        int[][] dp = new int[4][n + 1];
        int[] coins = {1, 5, 10, 25};

        for (int i = 0; i <= n; i++) {
            dp[0][i] = 1;
        }
        for (int i = 0; i < 4; i++) {
            dp[i][0] = 1;
        }
        for (int i = 1; i < 4; i++) {
            for (int j = 1; j <= n; j++) {
                if (j >= coins[i])
                    dp[i][j] = (dp[i - 1][j] + dp[i][j - coins[i]]) % 1000000007;
                else
                    dp[i][j] = dp[i - 1][j];
            }
        }
        return dp[3][n];
    }

}
