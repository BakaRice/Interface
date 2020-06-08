package Leetcode.Exercise.array;

import java.util.HashMap;
import java.util.Map;

/**
 * @author RiceFamily
 * @date 2020/6/4 14:45
 * https://leetcode-cn.com/explore/interview/card/top-interview-questions-easy/1/array/29/
 */


/*
给定一个整数数组 nums 和一个目标值 target，
请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。
你可以假设每种输入只会对应一个答案。但是，数组中同一个元素不能使用两遍。
示例:
给定 nums = [2, 7, 11, 15], target = 9
因为 nums[0] + nums[1] = 2 + 7 = 9
所以返回 [0, 1]
 */
/*
题解： 我们知道如果使用双重for循环当然可以解决问题
但是我们应该思考一个优化的方案 如何牺牲空间 换取更高效的时间
一个比较常见的思路就是 HashMap 哈希表是典型的以空间换取时间的例子，
先通过哈希函数计算出实际存储地址，然后从数组中对应地址取出即可，哈希表的时间复杂度就是常数阶O(1)。
 */
public class T9 {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> hp = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            hp.put(nums[i], i);
        }
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if (hp.containsKey(complement) && hp.get(complement) != i) {
                return new int[]{i, hp.get(complement)};
            }
        }throw new IllegalArgumentException("No two sum solution");

    }
}
