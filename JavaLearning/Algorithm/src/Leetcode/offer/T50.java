package Leetcode.offer;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

//剑指 Offer 50. 第一个只出现一次的字符
public class T50 {
    //直接使用哈希表
    public char firstUniqChar(String s) {
        HashMap<Character, Boolean> hp = new HashMap<>();
        char[] charArray = s.toCharArray();
        for (char c : charArray) {
            hp.put(c, !hp.containsKey(c));
        }
        for (char c : charArray) {
            if (hp.get(c)) return c;
        }
        return ' ';
    }

    //使用有序哈希表 减少一次循环遍历
    public char firstUniqChar_2(String s) {
        Map<Character, Boolean> mp = new LinkedHashMap<>();
        char[] charArray = s.toCharArray();
        for (char c : charArray) {
            mp.put(c, !mp.containsKey(c));
        }
        for (var d : mp.entrySet()) {
            if (d.getValue()) return d.getKey();
        }
        return ' ';
    }
}
