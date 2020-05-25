package Leetcode;

import java.util.*;

public class LeetCode202 {
    public boolean isHappy(int n) {
        int res = n;
        int curr = n;
//        List<Integer> list = new ArrayList<>();
        Set<Integer> set = new HashSet<>();
        while (res != 1) {
            res = 0;
            while (curr > 0) {
                res += (curr % 10) * (curr % 10);
                curr /= 10;
            }
            if (set.contains(res)) {
                return false;
            }
            set.add(res);
            curr = res;
        }
        return true;
    }

    public static void main(String[] args) {
        LeetCode202 leetCode202 = new LeetCode202();
        System.out.println(leetCode202.isHappy(Integer.MAX_VALUE));
    }
}
