package Leetcode;

import java.util.Arrays;

public class LeetCode845 {


    /*
       神奇的暴力dp
     */
    public int longestMountain(int[] A) {
        if (A.length == 0) return 0;
        int[] dp1 = new int[A.length];
        int[] dp2 = new int[A.length];
        int max = 0;
        for (int i = 1; i < A.length; i++) {
            if (A[i] > A[i - 1]) {
                dp1[i] = dp1[i - 1] + 1;
            }
        }

        for (int i = A.length - 2; i >= 0; i--) {
            if (A[i] > A[i + 1]) {
                dp2[i] = dp2[i + 1] + 1;
            }
        }
        for (int i = 0; i < A.length; i++) {
            int curr = 0;
            curr = 0;
            if (dp1[i] != 0 && dp2[i] != 0) {
                curr = dp1[i] + dp2[i];
            }
            max = Math.max(max, curr);
        }
        if (max == 0) return 0;
        else return max + 1;
    }

    /*
    Leetcode官方题解
     */
    public int longestMountain_2(int[] A) {
        int n = A.length;
        if (n == 0) {
            return 0;
        }
        int[] left = new int[n];
        for (int i = 0; i < n; i++) {
            left[i] = A[i - 1] < A[i] ? left[i - 1] + 1 : 0;
        }
        int[] right = new int[n];
        for (int i = n - 2; i >= 0; --i) {
            right[i] = A[i + 1] < A[i] ? right[i + 1] + 1 : 0;
        }
        int ans = 0;
        for (int i = 0; i < n; i++) {
            if (left[i] > 0 && right[i] > 0) {
                ans = Math.max(ans, left[i] + right[i] + 1);
            }
        }
        return ans;
    }


    public static void main(String[] args) {
        LeetCode845 leetCode845 = new LeetCode845();
        int[] A = {2, 1, 4, 7, 3, 2, 5};
        int[] A2 = {2, 2, 2};
        int[] A1 = {2, 3};
        System.out.println(Arrays.toString(A1));
        System.out.println(leetCode845.longestMountain(A1));
    }
}
