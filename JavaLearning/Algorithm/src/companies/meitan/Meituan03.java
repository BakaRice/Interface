package companies.meitan;

import java.util.Scanner;

import static java.lang.Integer.min;

public class Meituan03 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int arr[] = new int[n+1];
        int dp[][] = new int[n+1][m+1];
        for (int i = 1; i <= n; i++)
            arr[i] = scanner.nextInt();
        for (int i = 0; i <= m; i++)
            dp[0][i] = 100010;         // 用MAX_INT会越界
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j <= m; j++) {
                if (j <= arr[i]) {
                    dp[i][j] = min(arr[i], dp[i - 1][j]);
                } else dp[i][j] = min(dp[i - 1][j], dp[i - 1][j - arr[i]] + arr[i]);
            }
        }
        System.out.println(dp[n][m]);
    }
}
