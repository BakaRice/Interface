package Leetcode.Exercise.array;

import java.util.Arrays;
import java.util.HashMap;

/**
 * @author RiceFamily
 * @date 2020/5/31 10:48
 */
public class T5 {
    public int singleNumber(int[] nums) {
        int ans = 0;
        for (int num : nums) {
            ans ^= num;
        }
        return ans;
    }
}
