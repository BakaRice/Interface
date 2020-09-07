package Leetcode;

import java.util.*;

/*
347. 前 K 个高频元素
给定一个非空的整数数组，返回其中出现频率前 k 高的元素。
https://leetcode-cn.com/problems/top-k-frequent-elements/
 */
public class LeetCode347 {
    public int[] topKFrequent(int[] nums, int k) {
        if (nums.length == 0 || k == 0) return null;
        int[] ans = new int[k];
        HashMap<Integer, Integer> hp = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            hp.put(nums[i], hp.getOrDefault(nums[i], 0) + 1);
        }
        PriorityQueue<Map.Entry<Integer, Integer>> queue = new PriorityQueue<>(hp.size(), (o1, o2) -> o2.getValue() - o1.getValue());
        for (Map.Entry<Integer, Integer> e : hp.entrySet()) {
            queue.add(e);
        }
        for (int i = 0; i < k; i++) {
            ans[i] = queue.poll().getKey();
        }
        return ans;
    }

    public static void main(String[] args) {
        LeetCode347 leetCode347 = new LeetCode347();
        int[] ints = leetCode347.topKFrequent(new int[]{1, 1, 1, 2, 2, 3}, 2);
        System.out.println(Arrays.toString(ints));

    }
}
