package Leetcode;

public class LeetCode191 {
    // you need to treat n as an unsigned value
    public int hammingWeight(int n) {
//        return Integer.bitCount(n);
        int res = 0;
        while (n > 0) {
            res += n & 1;
            n = n >>> 1;///>>>为无符号右移
        }
        return res;
    }

    public static void main(String[] args) {
        LeetCode191 leetCode191 = new LeetCode191();
        leetCode191.hammingWeight(1);
    }
};