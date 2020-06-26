package Leetcode.Exercise.String;

import java.security.KeyStore;
import java.util.HashMap;
import java.util.Map;

/**
 * Description: JavaLearning
 * Created by Rice on 2020/6/16 22:28
 */
public class T3 {
    public int firstUniqChar(String s) {
        char[] charArray = s.toCharArray();
        HashMap<Character, Integer> hp = new HashMap<>();
        for (int i = 0; i < charArray.length; i++) {
            int t = hp.getOrDefault(charArray[i], 0);
            hp.put(charArray[i], ++t);
        }
        for (int i = 0; i < charArray.length; i++) {
            if (hp.get(charArray[i]) == 1) return i;
        }
        return -1;
    }

    public int firstUniqChar_1(String s) {
        int[] alphabet = new int[26];
        char[] charArray = s.toCharArray();
        for (char ch : charArray) {
            alphabet[ch - 'a']++;
        }
        for (int i = 0; i < charArray.length; i++) {
            if (alphabet[charArray[i] - 'a'] == 1) return i;
        }
        return -1;
    }

    public static void main(String[] args) {
        T3 t3 = new T3();
        t3.firstUniqChar_1("leetcode");
    }
}
