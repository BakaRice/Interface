package Lanqiao;

import java.util.Scanner;

public class ALGO_116 {
    /*
    问题描述
　　题目很简单，给出N个数字，不改变它们的相对位置，在中间加入K个乘号和N-K-1个加号，（括号随便加）使最终结果尽量大。因为乘号和加号一共就是N-1个了，所以恰好每两个相邻数字之间都有一个符号。例如：
　　N=5，K=2，5个数字分别为1、2、3、4、5，可以加成：
　　1*2*(3+4+5)=24
　　1*(2+3)*(4+5)=45
　　(1*2+3)*(4+5)=45
　　……
    输入格式
    　　输入文件共有二行，第一行为两个有空格隔开的整数，表示N和K，其中（2<=N<=15, 0<=K<=N-1）。第二行为 N个用空格隔开的数字（每个数字在0到9之间）。
    输出格式
    　　输出文件仅一行包含一个整数，表示要求的最大的结果
    样例输入
    5 2
    1 2 3 4 5
    样例输出
    120
    样例说明
　　(1+2+3)*4*5=120
     */

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();int k = scanner.nextInt();// N K 输入
        int [] b  = new int[n];
        long [][] dp = new long[16][16];
        long sum = 0;
        for (int i = 1;i<=n;i++) {
            int temp = scanner.nextInt();
            sum  = sum +temp;
            dp[i][0] = sum; }//数组输入
        //dp[i][j]表示前i个数中使用了j个乘号的所得到最大值。
        for(int i=1;i<=n;i++)//n个数
        {
            for(int j=1;j<=i-1;j++)//最多有i-1个乘号，数量级较小，就不剪枝了
            {
                for(int p=2;p<=i;p++)//第j个乘号插入的位置，如果和前面的乘号位置重叠了，也不影响，还是原来的dp[i][j]
                {
                    dp[i][j]=Math.max(dp[i][j],dp[p-1][j-1]*(dp[i][0]-dp[p-1][0]));//从车如位置到i的和，一起乘总比一个乘要大
                }
            }
        }
        System.out.print(dp[n][k]);
    }
}
