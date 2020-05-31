package Leetcode;

import java.util.HashMap;

/**
 * @author RiceFamily
 * @date 2020/5/11 22:45
 * https://leetcode-cn.com/problems/subarray-sum-equals-k/
 */
public class LeetCode560 {
    public int subarraySum(int[] nums, int k) {
        int count = 0, pre = 0;
        HashMap<Integer, Integer> mp = new HashMap<>();
        mp.put(0, 1);
        for (int i = 0; i < nums.length; i++) {
            pre += nums[i];
            if (mp.containsKey(pre - k))
                count += mp.get(pre - k);
            mp.put(pre, mp.getOrDefault(pre, 0) + 1);
        }
        return count;
    }

    public int subarraySum2(int[] nums, int k) {
        int count = 0, pre = 0;
        HashMap<Integer, Integer> mp = new HashMap<>();
        mp.put(0, 1);
        for (int i = 0; i < nums.length; i++) {
            pre += nums[i];
            if (mp.containsKey(pre - k))
                count += mp.get(pre - k);
            mp.put(pre, mp.getOrDefault(pre, 0) + 1);
        }
        return count;
    }

    public int subarraySum3(int[] nums, int k) {
        int count = 0, pre = 0;
        HashMap<Integer, Integer> mp = new HashMap<>();
        mp.put(0, 1);
        for (int i = 0; i < nums.length; i++) {
            pre += nums[i];
            if (mp.containsKey(pre - k)) count += mp.get(pre - k);
            mp.put(pre, mp.getOrDefault(pre, 0) + 1);
        }
        return count;
    }

    public static void main(String[] args) {
        LeetCode560 leetCode560 = new LeetCode560();
        leetCode560.subarraySum(new int[]{1, 1, 1}, 2);
    }
}
