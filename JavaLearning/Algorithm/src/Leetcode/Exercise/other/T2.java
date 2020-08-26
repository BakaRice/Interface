package Leetcode.Exercise.other;

/**
 * @author RiceFamily
 * @date 2020/6/26 17:55
 * https://leetcode-cn.com/explore/interview/card/top-interview-questions-easy/26/others/65/
 */
public class T2 {
    public int hammingDistance(int x, int y) {
        int curr = 1;
        int sum = 0;
        for (int i = 0; i < 32; i++) {
            if ((x & curr << i) != (y & curr << i)) {
                sum++;
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        T2 t2 = new T2();
        System.out.println(t2.hammingDistance(1, 4));
    }
}
