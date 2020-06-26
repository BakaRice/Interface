package Leetcode.Exercise.SortSearch;

import java.util.Random;

/**
 * Description: JavaLearning
 * Created by Rice on 2020/6/25 17:57
 */
public class T2 {
    /* The isBadVersion API is defined in the parent class VersionControl.
      boolean isBadVersion(int version); */
    boolean isBadVersion(int version) {
        if (version == 4 || version == 5) return false;
        else return true;
    }

    public int firstBadVersion(int n) {
        int left = 1, right = n;
        int mid = left;
        while (left < right) {
            mid = left + (right - left) / 2;
            if (isBadVersion(mid)) {
                right = mid;
            } else left = mid + 1;
        }
        mid = left + (right - left) / 2;
        return mid;
    }

    public static void main(String[] args) {
        T2 t2 = new T2();
        System.out.println(t2.firstBadVersion(4));

    }
}
