package Leetcode.Exercise.dynamic;

/**
 * Description: JavaLearning
 * Created by Rice on 2020/6/25 18:32
 */
public class T1 {
    public int climbStairs(int n) {
        if (n == 1) return 1;
        if (n == 2) return 2;
        int[] dp = new int[n];
        dp[0] = 1;//1
        dp[1] = 2;//2
        for (int i = 2; i < n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n - 1];
    }

    public int climbStairs_2(int n) {
        if (n == 1) return 1;
        if (n == 2) return 2;
        int p = 1;//1
        int q = 2;//2
        int t = p + q;
        for (int i = 2; i < n; i++) {
            t = p + q;
            p = q;
            q = t;

        }
        return t;
    }

    public static void main(String[] args) {
        T1 t1 = new T1();
        System.out.println(t1.climbStairs_2(4));
    }
}
