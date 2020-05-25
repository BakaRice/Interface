package Leetcode;

public class LeetCodeInterview1603 {
    public double[] intersection(int[] start1, int[] end1, int[] start2, int[] end2) {
        double ret[] = new double[2];
        double k1, k2, b1, b2;
        double dy1 = end1[1] - start1[1];
        double dx1 = end1[0] - start1[0];
        double dy2 = end2[1] - start2[1];
        double dx2 = end2[0] - start2[0];
        k1 = dx1 == 0 ? 0 : dy1 / dx1;
        k2 = dx2 == 0 ? 0 : dy2 / dx2;
        b1 = k1 * start1[0] - start1[1];//b1 = k1*x1-y1;
        b2 = k2 * start2[0] - start2[1];//b2 = k2*x2-y2;

        double x_intersect = (b2 - b1) / (k1 - k2);
        double y_intersect = k1 * x_intersect + b1;
        if (x_intersect >= Math.max(start1[0], start2[0]) ||
                x_intersect <= Math.min(start1[0], start2[0]) ||
                y_intersect >= Math.max(start1[1], start2[1]) ||
                y_intersect <= Math.min(start1[1], start2[1])) {
            return ret;
        } else {
            ret[0] = x_intersect;
            ret[1] = y_intersect;
            return ret;
        }

    }

    public static void main(String[] args) {
        LeetCodeInterview1603 l = new LeetCodeInterview1603();
        int point1[] ={0, 0};
        int point2[] = {3, 3};
        int point3[] = {1,1};
        int point4[] = {2,2};
        System.out.println(l.intersection(point1, point2, point3, point4));
    }
}
