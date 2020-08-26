package Leetcode.Exercise.other;

/**
 * @author RiceFamily
 * @date 2020/6/26 19:51
 */
public class T6 {
    public int missingNumber(int[] nums) {
        int sum = 0;
        int tlen = nums.length + 1;
        sum = (tlen * (tlen - 1)) / 2;
//        for (int i = 0; i <= nums.length; i++) {
//            sum += i;
//        }
        for (int i : nums) {
            sum -= i;
        }
        return sum;
    }

    public static void main(String[] args) {
        T6 t6 = new T6();
        System.out.println(t6.missingNumber(new int[]{3, 0, 1}));
    }
}
