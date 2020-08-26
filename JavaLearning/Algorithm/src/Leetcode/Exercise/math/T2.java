package Leetcode.Exercise.math;

import java.util.Arrays;
import java.util.HashSet;

/**
 * @author RiceFamily
 * @date 2020/6/26 20:11
 */
public class T2 {
    public int countPrimes(int n) {
        boolean[] isPrim = new boolean[n];
        Arrays.fill(isPrim, true);
        for (int i = 2; i * i < n; i++)
            if (isPrim[i])
                for (int j = i * i; j < n; j += i)
                    isPrim[j] = false;

        int count = 0;
        for (int i = 2; i < n; i++)
            if (isPrim[i]) count++;

        return count;
    }

    public static void main(String[] args) {
        T2 t2 = new T2();
        System.out.println(t2.countPrimes(10));
    }
}
