package Leetcode;

/**
 * @author RiceFamily
 * @date 2020/6/4 8:43
 */
public class LeetCode238 {
    public int[] productExceptSelf(int[] nums) {
        int len = nums.length;
        int[] left = new int[len];
        int[] right = new int[len];
        left[0] = nums[0];
        right[len - 1] = nums[len - 1];
        for (int i = 1; i < len; i++) {
            left[i] = left[i - 1] * nums[i];
            right[len - 1 - i] =
                    right[len - 1 - i + 1] * nums[len - 1 - i];
        }
//        可以拆成两个 属于常数级别的优化 避免缓存的不断切换
//        for (int i = 1; i < len; i++) {
//            right[len - 1 - i] =
//                    right[len - 1 - i + 1] * nums[len - 1 - i];
//        }
        nums[0] = right[1];
        nums[len - 1] = left[len - 2];
        for (int i = 1; i < len - 1; i++) {
            nums[i] = left[i - 1] * right[i + 1];
        }
        return nums;
    }

    public static void main(String[] args) {
        LeetCode238 leetCode238 = new LeetCode238();
        long l = System.nanoTime();
        leetCode238.productExceptSelf(new int[]{1, 2, 3, 4});
        System.out.println(System.nanoTime() - l);
    }
}
