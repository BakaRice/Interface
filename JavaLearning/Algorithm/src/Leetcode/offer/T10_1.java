package Leetcode.offer;

/**
 * @author RiceFamily
 * @date 2020/6/2 14:15
 */
public class T10_1 {
    public int fib(int n) {
        int f0 = 0, f1 = 1;
        if (n == 0) return f0;
        for (int i = 1; i < n; i++) {
            int tmp = f0 + f1;
            f0 = f1;
            f1 = tmp%1000000007;
        }
        return f1;
    }

    public static void main(String[] args) {
        T10_1 t10_1 = new T10_1();
        System.out.println(t10_1.fib(45));
    }
}
