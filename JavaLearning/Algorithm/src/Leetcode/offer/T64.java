package Leetcode.offer;

/**
 * @author RiceFamily
 * @date 2020/6/2 8:46
 * https://leetcode-cn.com/problems/qiu-12n-lcof/
 */
public class T64 {
    public int sumNums(int n) {
        boolean b = n > 1 && (n += sumNums(n - 1)) > 0;
        return n;
    }
}
