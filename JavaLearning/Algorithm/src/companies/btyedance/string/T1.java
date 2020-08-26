package companies.btyedance.string;

import java.util.HashSet;

/**
 * Description: JavaLearning
 * Created by Rice on 2020/6/29 8:11
 * 无重复字符的最长子串
 * https://leetcode-cn.com/explore/interview/card/bytedance/242/string/1012/
 *
 * 滑动窗口
 */
public class T1 {
    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0) return 0;
        char[] xs = s.toCharArray();
        int[] dp = new int[xs.length];
        HashSet<Character> hs = new HashSet<>();
        dp[0] = 1;
        hs.add(xs[0]);
        int max = 0;
        for (int i = 1; i < xs.length; i++) {
            if (hs.contains(xs[i]))
                dp[i] = 1;
            else dp[i] = dp[i - 1] + 1;
            hs.add(xs[i]);
            max = Math.max(dp[i], max);
        }
        return max;
    }

    public int lengthOfLongestSubstring_2(String s) {
        if (s == null || s.length() == 0) return 0;
        char[] xs = s.toCharArray();
        HashSet<Character> hs = new HashSet<>();
        int left = 0, right = 0, max = 0;
        while (right < xs.length) {
            while (hs.contains(xs[right])) {
                hs.remove(xs[left]);
                left++;
            }
            hs.add(xs[right]);
            right++;
            max = Math.max(right - left, max);
        }
        return max;
    }

    public static void main(String[] args) {
        T1 t1 = new T1();
        System.out.println(t1.lengthOfLongestSubstring_2("dvdf"));
    }
}
