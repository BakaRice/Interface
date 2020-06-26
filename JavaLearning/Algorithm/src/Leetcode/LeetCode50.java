package Leetcode;

import java.util.Map;

public class LeetCode50 {
    public double myPow(double x, int n) {
        long N = n;
        if (x == 1 || n == 0) return 1;
        if (n < 1) {
            return 1 / myPowHelper(x, Math.abs(N));
        } else
            return myPowHelper(x, n);

    }

    private double myPowHelper(double x, long n) {
        if (n == 1) return x;
        if (n % 2 == 1) {
            double half = myPowHelper(x, n / 2);
            System.out.println("half:" + half);
            return half * half * x;
        } else {
            double half = myPowHelper(x, n / 2);
            System.out.println("half:" + half);
            return half * half;
        }
    }


    public double myPow2(double x, int n) {
        long N = n;
        if (x == 1 || x == 0) return 1;
        if (n < 1) return 1 / cal(x, Math.abs(N));
        else return cal(x, n);
    }

    private double cal(double x, long n) {
        if (n == 1) return x;
//        if (n % 2 == 1) {
//            double half = cal(x, n / 2);
//            return half * half * x;
//        } else {
//            double half = cal(x, n / 2);
//            return half * half;
//        }
        return x * cal(x, n - 1);
    }

    public static void main(String[] args) {
        LeetCode50 leetCode50 = new LeetCode50();
        leetCode50.myPow(2, -2147483648);
    }

}
