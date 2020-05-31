package Leetcode;

public class LeetCode69 {
    public int mySqrt(int x) {
        if (x == 1)
            return 1;
        int min = 0;
        int max = x;
        while (max - min > 1) {
            int m = max +(max-min)/ 2;
            if (x / m < m)
                max = m;
            else
                min = m;
        }
        return min;
    }

    public static void main(String[] args) {
        LeetCode69 leetCode69 = new LeetCode69();
        System.out.println(leetCode69.mySqrt(2147483647));
    }
}
