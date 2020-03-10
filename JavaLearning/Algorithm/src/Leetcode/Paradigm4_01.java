package Leetcode;

import java.util.Scanner;

public class Paradigm4_01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] nums = new int[3];
        nums[0] = scanner.nextInt();
        nums[1] = scanner.nextInt();
        nums[2] = scanner.nextInt();
        int targetNum = scanner.nextInt();
        int sum = 0;
        for (int i = 0;i<=nums[0];i++)
            for (int j = 0;j<=nums[1];j++)
                for (int p = 0;p<=nums[2];p++)
                {
                    int tempNum = i+5*j+10*p;
                    if (tempNum==targetNum)
                    sum++;
                }
        System.out.println(sum);
    }
}
