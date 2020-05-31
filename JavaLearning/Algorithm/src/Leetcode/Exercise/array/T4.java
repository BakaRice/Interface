package Leetcode.Exercise.array;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

/**
 * @author RiceFamily
 * @date 2020/5/31 10:26
 */
public class T4 {
    public boolean containsDuplicate(int[] nums) {
        HashMap<Integer, Integer> hp = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int t = hp.getOrDefault(nums[i], 0);
            if (++t <= 1) {
                hp.put(nums[i], t);
            } else return true;
        }
        return false;
    }

    public boolean containsDuplicate2(int[] nums) {
        List<Integer> list = new LinkedList<>();
        for (int i = 0; i < nums.length; i++) {
            boolean contains = list.contains(nums[i]);
            list.add(nums[i]);
            if (contains) return contains;
        }
        return false;
    }
}
