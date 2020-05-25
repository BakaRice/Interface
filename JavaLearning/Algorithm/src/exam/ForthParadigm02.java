package exam;

import java.util.Scanner;

//给定不同面额的硬币和一个总金额。写出函数来计算可以凑成总金额的硬币组合数。假设每一种面额的硬币有无限个。
public class ForthParadigm02 {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int len = s.nextInt();
        int amount = n;
        int coins[] = new int[len];
        for (int i = 0; i < len; i++) {
            coins[i] = s.nextInt();
        }
        int[] dp = new int[amount + 1];
        dp[0] = 1;

        for (int coin : coins) {
            for (int x = coin; x < amount + 1; ++x) {
                dp[x] += dp[x - coin];
            }
        }
        System.out.println(dp[amount]);

    }
}
