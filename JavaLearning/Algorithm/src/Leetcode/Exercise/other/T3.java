package Leetcode.Exercise.other;

/**
 * @author RiceFamily
 * @date 2020/6/26 18:00
 * https://leetcode-cn.com/explore/interview/card/top-interview-questions-easy/26/others/66/
 */
public class T3 {
    // you need treat n as an unsigned value
    public int reverseBits(int n) {
        int res = 0;
        for (int i = 0; i < 32; i++) {
            res = (res << 1) + (n & 1);
            n >>= 1;
        }
        return res;
    }

    public int reverseBits_2(int n) {
        int res = 0;
        for (int i = 0; i < 32; i++) {
            int curr = n & 1;
            res = (res << 1) + curr;
            n = n >> 1;
        }
        return res;
    }
}
