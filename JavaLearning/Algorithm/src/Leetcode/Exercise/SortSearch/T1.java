package Leetcode.Exercise.SortSearch;

import java.util.Arrays;

/**
 * Description: 合并两个有效数组
 * Created by Rice on 2020/6/5 22:18
 * https://leetcode-cn.com/explore/interview/card/top-interview-questions-easy/8/sorting-and-searching/52/
 */
public class T1 {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        if (n == 0) return;
        if (m == 0) {
            for (int i = 0; i < n; i++) {
                nums1[i] = nums2[i];
            }
            return;
        }
        int[] tnums1 = Arrays.copyOfRange(nums1, 0, m);
        int curr = 0;
        int p1 = 0, p2 = 0;
        while (curr < m + n) {
            if (p2 < nums2.length && tnums1[p1] > nums2[p2]) {
                nums1[curr] = nums2[p2];
                p2++;
            } else if (p1 < tnums1.length && tnums1[p1] <= nums2[p2]) {
                nums1[curr] = tnums1[p1];
                p1++;
            }
            curr++;

            if (p1 == m) {
                while (curr < m + n && p2 < n) {
                    nums1[curr++] = nums2[p2++];
                }
                break;
            }
            if (p2 == n) {
                while (curr < m + n && p1 < m) {
                    nums1[curr++] = tnums1[p1++];
                }
                break;
            }
        }
    }

    public static void main(String[] args) {
        T1 t1 = new T1();
        t1.merge(new int[]{2,0}, 1, new int[]{1}, 1);
    }
}
