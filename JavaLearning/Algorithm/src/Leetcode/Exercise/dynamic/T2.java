package Leetcode.Exercise.dynamic;

/**
 * Description: JavaLearning
 * Created by Rice on 2020/6/25 19:16
 */
public class T2 {
    public int maxProfit(int[] prices) {
        int min = Integer.MAX_VALUE;
        int max = 0;
        for (int i = 0; i < prices.length; i++) {
            min = Math.min(min, prices[i]);
            max = Math.max(max, prices[i] - min);
        }
        return max;
    }
}
