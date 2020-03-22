package nowcoder;

/**
 * 写一个函数，求两个整数之和，要求在函数体内不得使用+、-、*、/四则运算符号。
 */

public class Solution46 {
    //非常像计算机组成原理的 加法器

    /**
     * 利用 异或 和 与 进行计算
     */
    public int Add(int num1, int num2) {
        int a = num1 ^ num2;
        int b = num1 & num2;
        b = b << 1;
        if (b == 0) return a;
        else return Add(a, b);
    }

    public static void main(String[] args) {
        Solution46 solution46 = new Solution46();
        System.out.println(solution46.Add(111, 899));
    }
}