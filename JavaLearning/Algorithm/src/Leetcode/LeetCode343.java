package Leetcode;

//https://leetcode-cn.com/problems/integer-break
public class LeetCode343 {
    public int integerBreak(int n) {
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            for (int j = 1; j < i; j++) {
                dp[i] = max3(dp[i], j * dp[i - j], j * (i - j));
            }
        }
        return dp[n];
    }

    private int max3(int num1, int num2, int num3) {
        return Math.max(Math.max(num1, num2), num3);
    }


    public int integerBreak1(int n) {
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            for (int j = 1; j < i; j++) {//多套一层循环就是为了解决子问题的最大值
//                dp[3]  = dp[2]*1   dp[1]*2 两个值中最大的一个 由此 从下到上产生的递推关系
//                这里我的理解是 所谓的子问题是一个大型的子问题 他包含了所有的可能长度的子问题，这样就避免的截取任意长度后 影响子问题的结果
//                把所有的子问题都列举出来构成了大型的子问题来进行求解/.
//                dp[n] = max(i*dp[n-i),i*(n-i)) i=1:n-1
//                套了一层循环遍历的所有的可能性
                //这里的本质是在统计当前的长度 拆分后可能的最大值
                dp[i] = Math.max(dp[i], Math.max(j * dp[i - j], j * (i - j)));
            }
        }
        return dp[n];
    }

    public static void main(String[] args) {
        LeetCode343 leetCode343 = new LeetCode343();
        System.out.println(leetCode343.integerBreak(3));
    }
}
