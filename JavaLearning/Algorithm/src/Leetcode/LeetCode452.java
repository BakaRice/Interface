package Leetcode;

import java.util.Arrays;

public class LeetCode452 {
    public int findMinArrowShots(int[][] points) {
        Arrays.sort(points, (o1, o2) -> (o1[0] - o2[0]));
        int times = 0;
        for (int i = 0; i < points.length; ) {
            int temp = points[i][1];
            int min = Integer.MAX_VALUE;
            int j;
            for (j = i; j < points.length; j++) {
                if (points[j][1] < min) min = points[j][1];
                if (points[j][0] > temp) break;
                if (min < points[j][0]) break;
            }
            i = j;
            times++;
        }
        return times;
    }

    public int findMinArrowShots2(int[][] points) {
        Arrays.sort(points, (o1, o2) -> (o1[1] - o2[1]));
        int times = 0;
        int start, end;
        int firstEnd = points[0][1];
        for (int[] point : points) {
            start = point[0];
            end = point[1];
            if (firstEnd < start) {
                times++;
                firstEnd = end;
            }
        }
        return times;
    }

    public static void main(String[] args) {
        LeetCode452 l = new LeetCode452();
        int[][] list = {{3, 9}, {7, 12}, {3, 8}, {6, 8}, {9, 10}, {2, 9}, {0, 9}, {3, 9}, {0, 6}, {2, 8}};
        l.findMinArrowShots(list);
    }
}
