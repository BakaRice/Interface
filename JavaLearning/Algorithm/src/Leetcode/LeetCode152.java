package Leetcode;

/**
 * @author RiceFamily
 * @date 2020/5/18 21:29
 * https://leetcode-cn.com/problems/maximum-product-subarray/
 */
public class LeetCode152 {
    public int maxProduct(int[] nums) {
        int maxF[] = new int[nums.length];
        int minF[] = new int[nums.length];
        maxF[0] = nums[0];
        minF[0] = nums[0];
        int max = maxF[0];
        for (int i = 1; i < nums.length; i++) {
            maxF[i] = Math.max(Math.max(maxF[i - 1] * nums[i], minF[i - 1] * nums[i]), nums[i]);
            minF[i] = Math.min(Math.min(maxF[i - 1] * nums[i], minF[i - 1] * nums[i]), nums[i]);
            if (max < maxF[i]) max = maxF[i];
        }
        return max;
    }

    public static void main(String[] args) {
        LeetCode152 leetCode152 = new LeetCode152();
        int[] nums = {-1,-2,-9,-6};
        leetCode152.maxProduct(nums);
    }
}
