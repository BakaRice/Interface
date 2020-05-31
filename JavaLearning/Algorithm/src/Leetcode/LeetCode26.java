package Leetcode;

/**
 * @author RiceFamily
 * @date 2020/5/25 22:34
 * https://leetcode-cn.com/problems/remove-duplicates-from-sorted-array/
 */
public class LeetCode26 {
    //循环 -> 慢
    public int removeDuplicates(int[] nums) {
        int len = -1;
        for (int i = 0; i < nums.length; i++) {
            //如果已确认单一串内包含
            if (!had(nums, len, nums[i])) {
                len++;
                int temp = nums[len];
                nums[len] = nums[i];
                nums[i] = temp;
            }
        }
        return len;
    }

    private boolean had(int[] nums, int tail, int curNum) {
        for (int i = 0; i <= tail; i++) {
            if (nums[i] == curNum) return true;
        }
        return false;
    }

    //如果能够把他变成双指针的方式 扭头循环 是很容易变成双指针的
    public int removeDuplicates2(int[] nums) {
        int slow = 0;
        int fast = 0;
        while (fast < nums.length - 1) {
            fast++;
            if (nums[slow] != nums[fast]) {
                nums[++slow] = nums[fast];
            }
        }
        return slow + 1;
    }

    public static void main(String[] args) {
        LeetCode26 leetCode26 = new LeetCode26();
        leetCode26.removeDuplicates(new int[]{1, 1, 2});
    }
}
