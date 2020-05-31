package Leetcode.Exercise.array;

import java.util.HashMap;

/**
 * @author RiceFamily
 * @date 2020/5/30 17:28
 * https://leetcode-cn.com/explore/interview/card/top-interview-questions-easy/1/array/21/
 */
public class T1 {
    public int removeDuplicates(int[] nums) {
        if(nums.length == 0 || nums == null) {
            return 0;
        }

        int slow = 0;
        for(int fast = 1; fast < nums.length; fast++) {
            if(nums[slow] != nums[fast]) {
                slow++;
                nums[slow] = nums[fast];
            }
        }

        return slow+1;
    }

    public static void main(String[] args) {
        T1 t1 = new T1();
        t1.removeDuplicates(new int[]{1, 1, 2});
    }
}
