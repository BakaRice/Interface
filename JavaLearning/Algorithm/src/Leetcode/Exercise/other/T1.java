package Leetcode.Exercise.other;

/**
 * @author RiceFamily
 * @date 2020/6/26 17:45
 * https://leetcode-cn.com/explore/interview/card/top-interview-questions-easy/26/others/64/
 */
public class T1 {
    // you need to treat n as an unsigned value
    public int hammingWeight(int n) {
        int curr = 1;
        int sum = 0;
        for (int i = 0; i < 32; i++) {
            if ((n & curr << i) != 0) {
                sum++;
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        T1 t1 = new T1();
        System.out.println(t1.hammingWeight(-3));
    }
}
