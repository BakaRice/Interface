package Leetcode;

import java.util.HashMap;

//169. 多数元素
//https://leetcode-cn.com/problems/majority-element/
public class LeetCode169 {
    public int majorityElement(int[] nums) {
        HashMap<Integer, Integer> hp = new HashMap<>();
        for (int i : nums) {
            Integer orDefault = hp.getOrDefault(i, 0);
            hp.put(i, orDefault + 1);
            if (orDefault + 1 > nums.length / 2) return i;
        }
        return -1;
    }

    public static void main(String[] args) {
        LeetCode169 leetCode169 = new LeetCode169();
        System.out.println(leetCode169.majorityElement(new int[]{3, 2, 3}));
    }
}