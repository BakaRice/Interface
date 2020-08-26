package companies.btyedance.string;

import exam.Tmp;

import java.security.KeyStore;
import java.util.*;
import java.util.stream.Collectors;

/**
 * Description: JavaLearning
 * Created by Rice on 2020/6/29 8:43
 * 字符串的排列
 * https://leetcode-cn.com/explore/interview/card/bytedance/242/string/1016/
 */
public class T3 {
//    List<List<Character>> res = new LinkedList<>();

    public boolean checkInclusion(String s1, String s2) {
        StringBuilder sb = new StringBuilder();
        LinkedList<Character> track = new LinkedList<>();
        return backtrack(s1, track, s2);
    }

    private boolean backtrack(String s1, LinkedList<Character> track, String s2) {
        if (track.size() == s1.length()) {
//            res.add(new LinkedList(track));
            StringBuilder sb = new StringBuilder();
            for (Character c : track) {
                sb.append(c);
            }
            if (s2.contains(sb.toString())) return true;
            else return false;
        }
        for (int i = 0; i < s1.length(); i++) {
            // 排除不合法的选择
            if (track.contains(s1.charAt(i)))
                continue;
            // 做选择
            track.add(s1.charAt(i));
            // 进入下一层决策树
            boolean backtrack = backtrack(s1, track, s2);
            if (backtrack) return true;
            // 取消选择
            track.removeLast();
        }
        return false;

    }

    public boolean checkInclusion_2(String s1, String s2) {
        if (s1.length() > s2.length()) return false;
        HashMap<Character, Integer> hp = new HashMap<>();
        for (char c : s1.toCharArray()) {
            Integer orDefault = hp.getOrDefault(c, 0);
            Integer put = hp.put(c, ++orDefault);
        }
        int start = 0, end = s1.length() - 1;
        while (end < s2.length()) {
            String sub = s2.substring(start, end + 1);
            start++;
            end++;
            boolean flag = false;
            HashMap<Character, Integer> curr_hp = new HashMap<>(hp);
            for (char c : sub.toCharArray()) {
                if (!curr_hp.containsKey(c)) {
                    flag = true;
                    break;
                }
                Integer orDefault = curr_hp.get(c);
                Integer put = curr_hp.put(c, --orDefault);
            }
            for (Map.Entry<Character, Integer> entry : curr_hp.entrySet()) {
                if (entry.getValue() != 0) {
                    flag = true;
                    break;
                }
            }
            if (flag) continue;
            else return true;
        }
        return false;
    }


    public static void main(String[] args) {
        T3 t3 = new T3();
        System.out.println(t3.checkInclusion_2("ab", "eidbaooo"));

//        "ab"
//        "eidboaoo"
    }
}
