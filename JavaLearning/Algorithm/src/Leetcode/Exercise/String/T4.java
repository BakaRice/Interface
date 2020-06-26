package Leetcode.Exercise.String;

/**
 * Description: JavaLearning
 * Created by Rice on 2020/6/17 7:42
 */
public class T4 {
    public boolean isAnagram(String s, String t) {
        int[] seq = new int[26];
        for (char ch : s.toCharArray()) {
            seq[ch - 'a']++;
        }
        for (char ch : t.toCharArray()) {
            seq[ch - 'a']--;
        }
        int sum = 0;
        for (int curr : seq) {
            sum += curr;
        }
        for (int curr : seq) {
            if (curr != 0) return false;
        }
        return true;
    }
}
