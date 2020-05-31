package Leetcode.Exercise.array;

/**
 * @author RiceFamily
 * @date 2020/5/30 17:46
 * https://leetcode-cn.com/explore/interview/card/top-interview-questions-easy/1/array/22/
 */
public class T2 {
    public int maxProfit(int[] prices) {
        int ans = 0;
        for (int i = 0; i < prices.length; i++) {
            if (prices[i] < prices[i + 1])
                ans += (prices[i + 1] - prices[i]);
        }
        return ans;
    }
}
