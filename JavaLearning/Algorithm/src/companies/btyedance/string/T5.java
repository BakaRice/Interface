package companies.btyedance.string;

import java.util.Arrays;
import java.util.Collections;
import java.util.stream.Collectors;

/**
 * Description: JavaLearning
 * Created by Rice on 2020/6/29 11:57
 */
public class T5 {
    public String reverseWords(String s) {
        String[] s1 = s.trim().split("\\s*");
        int left = 0, right = s1.length - 1;
        while (left < right) {
            String curr = s1[left];
            s1[left] = s1[right];
            s1[right] = curr;
            left++;
            right--;
        }
        StringBuilder sb = new StringBuilder();
        for (String curr : s1) {

        }
        for (int i = 0; i < s1.length - 1; i++) {
            sb.append(s1[i] + " ");
        }
        sb.append(s1[s1.length - 1]);
        return sb.toString();
    }
}
