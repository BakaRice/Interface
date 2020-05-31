package Leetcode;

/**
 * @author RiceFamily
 * @date 2020/5/9 17:21
 * https://leetcode-cn.com/problems/next-permutation/
 */
public class LeetCode31 {
    public void nextPermutation(int[] nums) {
        int i = nums.length - 2;
        //找到第一个升序的位置
        while (i >= 0 && nums[i] >= nums[i+1]) {
            i--;
        }

        if (i >= 0) {
            int j = nums.length - 1;
            //找到第一个比nums[i]大的数，确定j
            while(j >= 0 && nums[j] <= nums[i]){
                j--;
            }
            //将i与j的数进行交换
            swap(nums,i,j);
        }
        int p = i + 1;
        int q = nums.length - 1;
        while (p < q) {
            swap(nums, p++, q--);
        }
    }

    void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
