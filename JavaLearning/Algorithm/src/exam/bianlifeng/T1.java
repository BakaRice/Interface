package exam.bianlifeng;

import java.util.Scanner;
/*
已知包含 n 个元素的整数数组（可能包含负数），设计算法找出一个连续子序列 A(i)...A(j)，使其元素之和最大。
输入
包含 n 个元素的数组A(1)...A(n)

输出
子序列的最大和


样例输入
-2,11,-4,13,-5,2
样例输出
20

 */

public class T1{
    public static void main(String[] args){
        Scanner s = new Scanner(System.in);
        int sum =0;
        String line = s.nextLine();
        String[] split = line.split(",");
        int nums[] = new int[split.length];
        int max = nums[0];
        for (int i =0;i<split.length;i++){
            nums[i] = Integer.valueOf(split[i]);
        }
        for (int num:nums){
            if(sum>0)
                sum += num;
            else
                sum = num;
            max = Math.max(sum,max);
        }

        System.out.println(max);
    }
}