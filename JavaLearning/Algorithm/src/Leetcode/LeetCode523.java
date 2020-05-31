package Leetcode;

import java.util.HashMap;

/**
 * @author RiceFamily
 * @date 2020/5/11 22:27
 * https://leetcode-cn.com/problems/continuous-subarray-sum/
 */
public class LeetCode523 {
    public boolean checkSubarraySum(int[] nums, int k) {
        int pre = 0;
        HashMap<Integer, Integer> mp = new HashMap<>();
        mp.put(0, -1);
        for (int i = 0; i < nums.length; i++) {
            pre += nums[i];
            if (k != 0) pre = pre % k;
            if (mp.containsKey(pre)) {
                if (i - mp.get(pre) > 1) return true;
            } else
                mp.put(pre, i);
        }
        return false;
    }

    public static void main(String[] args) {
        LeetCode523 leetCode523 = new LeetCode523();
        System.out.println(leetCode523.checkSubarraySum(new int[]{1,1,1}, 0));
    }

}
