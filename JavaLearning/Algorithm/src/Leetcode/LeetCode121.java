package Leetcode;

/**
 * 给定一个数组，它的第 i 个元素是一支给定股票第 i 天的价格。
 * <p>
 * 如果你最多只允许完成一笔交易（即买入和卖出一支股票一次），设计一个算法来计算你所能获取的最大利润。
 * <p>
 * 注意：你不能在买入股票前卖出股票。
 */
public class LeetCode121 {
    public int maxProfit(int[] prices) {
        int minday = Integer.MAX_VALUE;
        int max = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i - 1] < minday)
                minday = prices[i - 1];
            int temp =prices[i] - minday;
            if (temp > max)
                max = temp;
        }
        return max;
    }
}
