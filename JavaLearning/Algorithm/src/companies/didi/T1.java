package companies.didi;

import java.io.IOException;
import java.util.Scanner;

/*
输入为两行。 第一行一个整数n(1 <= n <= 100000)，表示一共有n个元素 第二行为n个数，即每个元素,每个整数都在32位int范围内。以空格分隔。
 */
public class T1 {
    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        String arr[] = br.readLine().trim().split(" ");
//        int n = Integer.parseInt(arr[0]);

        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int dp[] = new int[n + 1];
        int num[] = new int[n];
        for (int i = 0; i < n; i++) {
//            num[i] = Integer.parseInt(arr[i + 1]);
            num[i] = scanner.nextInt();
        }
        dp[0] = num[0];
        int max = dp[0];
        for (int i = 1; i < n; i++) {
            if (num[i] > dp[i - 1] + num[i])
                dp[i] = num[i];
            else
                dp[i] = dp[i - 1] + num[i];
            if (dp[i] > max) max = dp[i];
        }
        System.out.println(max);
    }

}
