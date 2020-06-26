package Leetcode.Exercise.String;

/**
 * Description: JavaLearning
 * Created by Rice on 2020/6/17 9:49
 */
public class T5 {
    public boolean isPalindrome(String s) {
        s = s.toLowerCase();
        char[] array = s.toCharArray();
        int left = 0, right = array.length - 1;
        while (left < right) {
            while (!(array[left] >= 'a' && array[left] <= 'z')&&!(array[left]>='0'&&array[left]<='9')&&left<right )
                left++;
            while (!(array[right] >= 'a' && array[right] <= 'z')&&!(array[right]>='0'&&array[right]<='9')&&left<right)
                right--;
            if (array[left] == array[right]) {
                left++;
                right--;
            } else return false;
        }
        return true;
    }

    public static void main(String[] args) {
        T5 t5 = new T5();
        System.out.println(t5.isPalindrome("0P"));
    }
}
