package Leetcode;

/**
 * @author RiceFamily
 * @date 2020/5/9 16:04
 * https://leetcode-cn.com/problems/capacity-to-ship-packages-within-d-days/
 */
public class LeetCode1011 {
    //笨
    public int shipWithinDays1(int[] weights, int D) {
        //这里的最大最小 指的是运载能力
        // 船的单日运载能力最小必须大于最大的包裹，而最大运载能力不超过总活动重量即可
        int max = 0, min = 0;
        for (int weight : weights) {
            max += weight;
            if (weight > min) min = weight;
        }
        //二分法查找 最小的最大运载能力
        while (min < max) {
            int mid = min + (max - min) / 2;
            int count = 0, currSum = 0;
            for (int weight : weights) {
                if (currSum + weight <= mid) {
                    currSum += weight;
                } else {
                    currSum = weight;
                    count++;
                }
            }
            System.out.println("mid:" + mid);
            if (count < D)
                max = mid;
            else
                min = mid + 1;
        }
        return min;
    }


    public int shipWithinDays(int[] weights, int D) {
        //最低运载能力在 最重包裹 和 所有包裹重量之和 之间
        int max = 0, min = 0;
        for (int num : weights) {
            max += num;
            if (min < num) {
                min = num;
            }
        }

        //采用二分法寻找最低运载能力
        while (min < max) {
            int mid = (max + min) / 2;
            int count = 1, attempD = 0;

            for (int num1 : weights) {
                if ((attempD + num1) <= mid)
                    attempD += num1;
                else {
                    attempD = num1;
                    count++;
                }
            }

            if (count <= D)
                max = mid;
            else
                min = mid + 1;
        }
        return min;
    }

    public static void main(String[] args) {
        LeetCode1011 leetCode1011 = new LeetCode1011();
        int[] weights = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        System.out.println(leetCode1011.shipWithinDays1(weights, 5));
    }
}
