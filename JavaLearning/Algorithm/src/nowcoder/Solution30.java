package nowcoder;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
/*
输入一个正整数数组，把数组里所有数字拼接起来排成一个数，打印能拼接出的所有数字中最小的一个。
例如输入数组{3，32，321}，则打印出这三个数字能排成的最小数字为321323。
 */

public class Solution30 {
    public String PrintMinNumber(int[] numbers) {
        Integer[] nums = new Integer[numbers.length];
        for (int i = 0; i < numbers.length; i++) {
            nums[i] = numbers[i];
        }
        Arrays.sort(nums, cmp);
        StringBuilder str = new StringBuilder();
        for (int i = 0; i < numbers.length; i++) {
            str.append(nums[i]);
        }
        return str.toString();
    }

    static Comparator<Integer> cmp = (t, t1) -> {
        String s1 = t + "";
        String s2 = t1 + "";
        return Integer.parseInt(s1 + s2) - Integer.parseInt(s2 + s1);
    };
}