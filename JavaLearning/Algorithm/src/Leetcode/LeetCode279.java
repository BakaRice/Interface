package Leetcode;

import java.util.Arrays;

/**
 * @author RiceFamily
 * @date 2020/7/21 18:02
 */
public class LeetCode279 {
    public int numSquares(int n) {
        int dp[] = new int[n + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        int max_square_index = (int) Math.sqrt(n) + 1;
        int square_nums[] = new int[max_square_index];
        for (int i = 1; i < max_square_index; ++i) {
            square_nums[i] = i * i;
        }
        for (int i = 1; i <= n; ++i) {
            for (int s = 1; s < max_square_index; ++s) {
                if (i < square_nums[s])
                    break;
                dp[i] = Math.min(dp[i], dp[i - square_nums[s]] + 1);
            }
        }
        return dp[n];
    }

    public static void main(String[] args) {
        LeetCode279 leetCode279 = new LeetCode279();
        System.out.println(leetCode279.numSquares(12));
    }
}
