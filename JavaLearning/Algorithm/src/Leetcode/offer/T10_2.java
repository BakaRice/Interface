package Leetcode.offer;

/**
 * @author RiceFamily
 * @date 2020/6/2 14:28
 */
public class T10_2 {
    public int numWays(int n) {
        if (n == 0) return 0;
        if (n == 1) return 1;
        if (n == 2) return 2;
        n = n - 2;
        int f0 = 1, f1 = 2;
        while (n-- > 0) {
            int tmp = f1 + f0;
            f0 = f1;
            f1 = tmp % 1000000007;
        }
        return f1;
    }

    public static void main(String[] args) {
        T10_2 t10_2 = new T10_2();
        System.out.println(t10_2.numWays(7));
    }
}
