package exam.virtual;

import java.util.Arrays;
import java.util.HashMap;

public class T2 {
    public int longestConsecutive(int[] nums) {
        if (nums.length == 0) return 0;
        Arrays.sort(nums);
        int max = 1;
        int[] dp = new int[nums.length];
        dp[0] = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == nums[i - 1]) dp[i] = dp[i - 1];
            else if (nums[i] == nums[i - 1] + 1)
                dp[i] = dp[i - 1] + 1;
            else dp[i] = 1;
            if (dp[i] > max) max = dp[i];
        }
        return max;
    }

    public int longestConsecutive1(int[] nums) {
        HashMap<Integer, Integer> mp = new HashMap<>();
        int max = 0;
        for (int num : nums) {
            if (mp.containsKey(num)) continue;
            Integer left = mp.getOrDefault(num - 1, 0);
            Integer right = mp.getOrDefault(num + 1, 0);
            int len = 1 + left + right;
            mp.put(num, len);
            if (len > max) max = len;
            mp.put(num, len);
            mp.put(num - left, len);
            mp.put(num + right, len);
        }
        return max;

    }

    public static void main(String[] args) {
        T2 t2 = new T2();
        System.out.println(t2.longestConsecutive(new int[]{1, 2, 0, 1}));
    }
}
