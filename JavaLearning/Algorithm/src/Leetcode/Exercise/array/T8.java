package Leetcode.Exercise.array;

/**
 * @author RiceFamily
 * @date 2020/5/31 13:10
 */
public class T8 {
    //    输入: [0,1,0,3,12]
//    输出: [1,3,12,0,0]
    public void moveZeroes(int[] nums) {
        int slow = 0;
        int fast = 0;
        while (fast < nums.length) {
            if (nums[fast] != 0) {
                nums[slow] = nums[fast];
                slow++;
            }
            fast++;
        }
        while (slow < nums.length) {
            nums[slow] = 0;
            slow++;
        }
    }

    public static void main(String[] args) {
        T8 t8 = new T8();
        t8.moveZeroes(new int[]{0, 1, 0, 3, 12});
    }

}
