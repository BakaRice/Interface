package Leetcode;

import java.util.HashMap;
import java.util.Stack;

/*
https://leetcode-cn.com/problems/single-number/
 */
public class LeetCode136 {
    public int singleNumber(int[] nums) {
        int ans = 0;
        for (int num : nums) {
            ans ^= num;
        }
        return ans;
    }

    public int singleNumber_HashMap(int[] nums) {
        HashMap<Integer, Integer> mp = new HashMap<>();
        int ans = -1;
        for (int num : nums) {
            Integer curr = mp.getOrDefault(num, 0);
            mp.put(num, ++curr);
        }
        for (int num : nums) {
            Integer curr = mp.get(num);
            if (curr == 1) ans = num;
        }
        return ans;
    }

    public static void main(String[] args) {
        LeetCode136 l = new LeetCode136();
        l.singleNumber_HashMap(new int[]{2, 1, 1});
    }
}
