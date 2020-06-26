package Leetcode.Exercise.String;

/**
 * Description: JavaLearning
 * Created by Rice on 2020/6/16 21:56
 */
public class T2 {
    public int reverse(int x) {
        boolean positive = false;
        if (x > 0) positive = true;
        else positive = false;

        int currx = Math.abs(x);
        int nx = 0;
        while (currx > 0) {
            int y = currx % 10;
            while (nx == 0 && y == 0) {
                currx = currx / 10;
                y = currx % 10;
            }
            currx = currx / 10;
            if (nx > Integer.MAX_VALUE / 10) return 0;
            else if (positive && nx == Integer.MAX_VALUE / 10 && y > 7) return 0;
            else if (positive && nx == Integer.MAX_VALUE / 10 && y > 8) return 0;

            nx = nx * 10 + y;
        }
        if (positive) return nx;
        else return -nx;
    }

    public static void main(String[] args) {
        T2 t1 = new T2();
        System.out.println(t1.reverse(1534236469));
    }
}
