import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LeetCode16 {
    public int threeSumClosest(int[] nums, int target) {
        int targetlike = Integer.MAX_VALUE;
        int cha = Integer.MAX_VALUE;
        int len = nums.length;
        if (nums == null)
            return targetlike;
        if (len <= 3) {
            for (int i = 0; i < len; i++)
                targetlike = targetlike + nums[i];
            return targetlike;
        }
        Arrays.sort(nums); // 排序
        for (int i = 0; i < len; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) continue; // 去重
            int L = i + 1;
            int R = len - 1;
            while (L < R) {
                int sum = nums[i] + nums[L] + nums[R];
                //while (L < R && nums[L] == nums[L + 1]) L++; // 去重
                //while (L < R && nums[R] == nums[R - 1]) R--; // 去重
                if ((sum - target) * (sum - target) <= cha) {
                    cha = (sum - target) * (sum - target);
                    targetlike = sum;
                }
               if (sum == target) return target;
                else if (sum < target) L++;
                else if (sum > target) R--;
            }
        }
        return targetlike;
    }

    public static void main(String[] args) {
        LeetCode16 leetCode16 = new LeetCode16();
        int nums[] = {0,0,0};
        System.out.println(leetCode16.threeSumClosest(nums, 3));
    }
}
