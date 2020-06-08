package exam.virtual;

import java.util.ArrayList;

/**
 * @author RiceFamily
 * @date 2020/6/3 10:36
 * 统计所有小于非负整数 n 的质数的数量。
 */
public class T2_2 {
    public int countPrimes(int n) {
        ArrayList<Integer> list = new ArrayList<>();
        if (n == 1 || n == 0 || n == 2) return 0;
        if (n == 3) return 1;
        if (n == 4 || n == 5) return 2;
        if (n == 6) return 3;
        list.add(2);
        list.add(3);
        list.add(5);
        int curr = 6;
        while (curr < n) {
            boolean flag = true;
            for (int num : list) {
                if (curr % num == 0) {
                    flag = false;
                    break;
                }
            }
            if (flag) list.add(curr);
            curr++;
        }
        return list.size();
    }

    public int countPrimes2(int n) {
        int result = 0;
        boolean[] b = new boolean[n];
        if (2 < n) result++;

        for (int i = 3; i < n; i += 2) {
            if (!b[i]) {
                for (int j = 3; i * j < n; j += 2) {
                    b[i * j] = true;
                }
                result++;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        T2_2 t2 = new T2_2();
        long l = System.nanoTime();
        System.out.println(t2.countPrimes(499979));
        System.out.println(System.nanoTime() - l);
    }
}
