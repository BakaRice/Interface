package Leetcode.Exercise.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * @author RiceFamily
 * @date 2020/5/31 12:04
 */
public class T6 {
    public int[] intersect(int[] nums1, int[] nums2) {
        int len1 = nums1.length;
        int len2 = nums2.length;
        List<Integer> ans = new ArrayList<>();
        HashMap<Integer, Integer> hp = new HashMap<>();
        if (len1 > len2) {
            for (int num : nums2) {
                int t = hp.getOrDefault(num, 0);
                hp.put(num, ++t);
            }
            for (int i = 0; i < nums1.length; i++) {
                int t = hp.getOrDefault(nums1[i], 0);
                if (t != 0) {
                    ans.add(nums1[i]);
                    hp.put(nums1[i], --t);
                }
            }

        } else {
            for (int num : nums1) {
                int t = hp.getOrDefault(num, 0);
                hp.put(num, ++t);
            }
            for (int i = 0; i < nums2.length; i++) {
                int t = hp.getOrDefault(nums2[i], 0);
                if (t != 0) {
                    ans.add(nums2[i]);
                    hp.put(nums2[i], --t);
                }
            }
        }
        int[] ansArray = new int[ans.size()];
        for (int i = 0; i < ans.size(); i++) {
            ansArray[i] = ans.get(i);
        }
        return ansArray;
    }
}
