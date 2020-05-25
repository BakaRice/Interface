package Leetcode;

public class LeetCode11 {
    public int maxArea3(int[] height) {
        int s = 0;
        int max = 0;
        for (int i = 0; i < height.length; i++) {
            for (int j = i + 1; j < height.length; j++) {
                if (height[i] > height[j])
                    s = (j - i) * height[j];
                else
                    s = (j - i) * height[i];
                if (max < s)
                    max = s;
            }
        }
        return max;
    }

    public int maxArea2(int[] height) {
        int l = 0;
        int r = height.length - 1;
        int maxArea = 0;
        while (l < r) {
            maxArea = Math.max(maxArea, Math.min(height[l], height[r]) * (r - l));
            if (height[l] < height[r]) {
                l++;
            } else {
                r--;
            }
        }
        return maxArea;
    }

    public int maxArea(int[] height) {
        int l = 0, r = height.length;
        int area = 0;
        while (l < r) {
            area = Math.max(area, Math.min(height[l], height[r]) * (r - l));
            if (height[l] < height[r]) l++;
            else r--;
        }
        return area;
    }

    public static void main(String[] args) {
        LeetCode11 leetCode11 = new LeetCode11();
        int[] n = {1, 8, 6, 2, 5, 4, 8, 3, 7};
        System.out.print(leetCode11.maxArea(n));
    }
}
