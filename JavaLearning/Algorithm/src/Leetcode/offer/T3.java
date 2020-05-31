package Leetcode.offer;

import java.util.Arrays;
import java.util.HashMap;

/**
 * @author RiceFamily
 * @date 2020/5/31 13:52
 * https://leetcode-cn.com/problems/shu-zu-zhong-zhong-fu-de-shu-zi-lcof/
 */
public class T3 {
    public int findRepeatNumber(int[] nums) {
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] == nums[i + 1]) return nums[i];
        }
        return 0;
    }

    public int findRepeatNumber2(int[] nums) {
        HashMap<Integer, Integer> hp = new HashMap<>();
        for (int i = 0; i < nums.length - 1; i++) {
            int t = hp.getOrDefault(nums[i], 0);
            if (t != 0) return nums[i];
            else hp.put(nums[i], ++t);
        }
        return 0;
    }
}
