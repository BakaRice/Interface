package Leetcode.Exercise.math;

/**
 * Description: JavaLearning
 * Created by Rice on 2020/6/25 20:59
 */
public class T3 {
    public boolean isPowerOfThree(int n) {
        double epsilon = 0.00001;
        return (Math.log(n) / Math.log(3) + epsilon) % 1 <= 2 * epsilon;
    }
}
