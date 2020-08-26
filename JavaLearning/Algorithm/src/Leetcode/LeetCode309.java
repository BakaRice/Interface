package Leetcode;

/**
 * Description: JavaLearning
 * Created by Rice on 2020/7/10 20:57
 */
public class LeetCode309 {

    public int maxProfit(int[] prices) {
        if (prices.length == 0) return 0;
        int[] hold = new int[prices.length];
        int[] unhold = new int[prices.length];

        hold[0] = -prices[0];
        unhold[0] = 0;
        for (int i = 1; i < prices.length; i++) {
            if (i == 1)
                hold[i] = Math.max(hold[i - 1], -prices[i]);
            else
                hold[i] = Math.max(hold[i - 1], unhold[i - 2] - prices[i]);
            unhold[i] = Math.max(unhold[i - 1], hold[i - 1] + prices[i]);
        }
        return unhold[prices.length - 1];
    }

    public int maxProfit_2(int[] prices) {
        int rest = 0;
        int sold = 0;
        int hold = Integer.MIN_VALUE;
        for (int p : prices) {
            int preSold = sold;
            int preHold = hold;
            hold = Math.max(preHold, rest - p);
            sold = preHold + p;
            rest = Math.max(rest, preSold);
        }
        return Math.max(rest, sold);
    }

    public static void main(String[] args) {
        LeetCode309 leetCode309 = new LeetCode309();
        System.out.println(leetCode309.maxProfit(new int[]{2, 1, 2, 1, 0, 1, 2}));

    }
}
