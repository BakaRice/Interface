package Leetcode;

/**
 * @author RiceFamily
 * @date 2020/5/26 10:09
 * https://leetcode-cn.com/problems/find-the-duplicate-number/
 */
public class LeetCode287 {
    public int findDuplicate_bin(int[] nums) {
        int n = nums.length, ans = 0;
        int bit_max = 31;
        while (((n - 1) >> bit_max) == 0) {
            bit_max -= 1;
        }
        //计算每一个二进制数的位置
        for (int bit = 0; bit <= bit_max; ++bit) {
            int x = 0, y = 0;
            //每一个数的遍历
            for (int i = 0; i < n; ++i) {
                if ((nums[i] & (1 << bit)) != 0) {
                    x += 1;
                }
                if (i >= 1 && ((i & (1 << bit)) != 0)) {
                    y += 1;
                }
            }
            if (x > y) {
                ans |= 1 << bit;
            }
        }
        return ans;
    }

    public int findDuplicate(int[] nums) {
        int fast = 0, slow = 0;
        do {
            slow = nums[slow];
            //移动两步
            fast = nums[nums[fast]];
        } while (slow != fast);//直到找到了环
        slow = 0;
        while (slow != fast) {
            slow = nums[slow];
            fast = nums[fast];
        }
        return slow;
    }

    public static void main(String[] args) {
        LeetCode287 leetCode287 = new LeetCode287();
        System.out.println(leetCode287.findDuplicate(new int[]{3, 1, 3, 4, 2}));
    }
}
