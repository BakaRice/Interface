package Leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author RiceFamily
 * @date 2020/6/1 8:47
 * https://leetcode-cn.com/problems/kids-with-the-greatest-number-of-candies/
 */
public class LeetCode1431 {
    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        int max = 0;
        for (int num : candies) {
            max = Math.max(num, max);
        }
        List<Boolean> ans = new ArrayList<>();
        for (int i = 0; i < candies.length; i++) {
            if (candies[i] + extraCandies >= max)
                ans.add(i, true);
            else
                ans.add(i, false);
        }
        return ans;
    }
}
