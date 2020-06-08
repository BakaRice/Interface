package Leetcode.offer;

/**
 * @author RiceFamily
 * @date 2020/6/2 14:36
 */
public class T11 {
    public int minArray(int[] numbers) {
        if (numbers.length == 0 || numbers == null) return 0;
        int len = numbers.length;
        int min = numbers[0];
        for (int i = 0; i < numbers.length - 1; i++) {
            if (numbers[i] > numbers[i + 1]) {
                return numbers[i + 1];
            }
            if (numbers[len - i - 1] < numbers[len - i - 2]) {
                return numbers[len - i - 1];
            }
        }
        return min;
    }

    public int minArray_mid(int[] numbers) {
        int left = 0, right = numbers.length - 1;
        while (left < right) {
            int m = (left + right) / 2;
            if (numbers[m] > numbers[right]) left = m + 1;
            else if (numbers[m] < numbers[left]) right = m;
            else right--;
        }
        return numbers[left];
    }

    public static void main(String[] args) {
        T11 t11 = new T11();
        System.out.println(t11.minArray_mid(new int[]{2,2,2,2,3,1}));
    }
}
