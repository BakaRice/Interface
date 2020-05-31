package Leetcode.Exercise.array;

import java.util.Arrays;

/**
 * @author RiceFamily
 * @date 2020/5/31 12:31
 */
public class T7 {
    public int[] plusOne(int[] digits) {
        int plus = 1;
        for (int n = digits.length - 1; n >= 0; n--) {
            int cur = digits[n] + plus;
            if (cur >= 10) {
                cur -= 10;
                plus = 1;
            } else plus = 0;
            digits[n] = cur;
        }
        if (plus == 1) {
            int[] ans = new int[digits.length + 1];
            ans[0] = 1;
//            System.arraycopy(digits, 0, ans, 1, digits.length); 没必要
            return ans;
        }

        return digits;
    }

    public static void main(String[] args) {
        T7 t7 = new T7();
        t7.plusOne(new int[]{9, 9, 9});
    }
}
