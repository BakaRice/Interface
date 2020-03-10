package companies.meitan;

import java.util.Scanner;

public class Meituan05{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] value = new int[n][2];
        int[][] weight = new int[n][2];
        for(int i = 0; i < n; i++){
            weight[i][0] = sc.nextInt();
            value[i][0] = sc.nextInt();
            weight[i][1] = sc.nextInt();
            value[i][1] = sc.nextInt();
        }
        int[] dp = new int[121];
        for(int i=0; i < n; i++){
            for(int j = 120; j >= weight[i][0] || j >= weight[i][1]; j--){
                if(j >= weight[i][0] && j >= weight[i][1]){
                    dp[j] = Math.max(Math.max(dp[j - weight[i][1]] + value[i][1],
                            dp[j - weight[i][0]] + value[i][0]),
                            dp[j]);
                }else if(j >= weight[i][0]){
                    dp[j] = Math.max(dp[j - weight[i][0]] + value[i][0], dp[j]);

                }else
                    dp[j] = Math.max(dp[j-weight[i][1]] + value[i][1], dp[j]);
            }
        }
        System.out.println(dp[120]);
    }
}