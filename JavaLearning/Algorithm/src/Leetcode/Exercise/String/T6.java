package Leetcode.Exercise.String;

/**
 * Description: JavaLearning
 * Created by Rice on 2020/6/17 10:10
 */
public class T6 {
    public int myAtoi(String str) {
        str = str.trim();
        int postive = 1;
        char[] array = str.toCharArray();
        int sum = 0;
        if (str.length() == 0) return sum;
        if (array[0] == '-')
            postive = -1;
        else if (array[0] == '+')
            postive = 1;
        else if (array[0] < '0' || array[0] > '9') return sum;
        else sum = array[0] - '0';
        for (int i = 1; i < str.length(); i++) {
            if (array[i] >= '0' && array[i] <= '9') {
                if (sum > Integer.MAX_VALUE / 10)
                    return postive > 0 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
                if (postive == 1 && sum == Integer.MAX_VALUE / 10 && array[i] > '7')
                    return Integer.MAX_VALUE;
                if (postive == -1 && sum == Integer.MAX_VALUE / 10 && array[i] > '8')
                    return Integer.MIN_VALUE;
                sum = sum * 10 + (array[i] - '0');
            } else return postive*sum;
        }
        return postive*sum;
    }
}
