package Leetcode;

import java.util.*;

/**
 * @author RiceFamily
 * @date 2020/5/23 10:29
 * 最小覆盖子串
 * https://leetcode-cn.com/problems/minimum-window-substring/
 */
public class LeetCode76 {
    public String minWindow(String s, String t) {
        //hp表示待匹配子串
        HashMap<Character, Integer> hp = new HashMap<>();
        for (char c : t.toCharArray()) {
            hp.put(c, hp.getOrDefault(c, 0) + 1);
        }
        //subHp表示滑动窗口子串
        HashMap<Character, Integer> subHp = new HashMap<>();
        int left = 0, right = 0;
        int min = Integer.MAX_VALUE;
        String sub = new String();
        char[] sc = s.toCharArray();
        while (left <= right) {
            //当前的窗口中包含的子串数量小于t
            if (!isSub(hp, subHp, t) && right < s.length()) {
                //该说明包含在子串中
                if (hp.get(sc[right]) != null) {
                    subHp.put(sc[right], subHp.getOrDefault(sc[right], 0) + 1);
                }
                if (right < s.length())//判断是否到达右边界
                    right++;
            } else {
                //判断当前字符串
                boolean flag = true;
                if (subHp.size() == hp.size()) {
                    //判断滑动窗口中的每一个元素数量符合子串数量
                    for (char c : t.toCharArray()) {
                        if (subHp.get(c) < hp.get(c)) flag = false;
                    }
                    boolean b = isSub(subHp, hp, t);
                    if (right - left < min && flag) {
                        min = right - left;
                        sub = s.substring(left, right);
                        System.out.println(sub + " " + right + " " + left);
                    }
                }
                if (left == s.length()) break;
                if (hp.get(sc[left]) != null) {
                    if (subHp.get(sc[left]) == 1)
                        subHp.remove(sc[left]);
                    else if (subHp.get(sc[left]) > 1)
                        subHp.put(sc[left], subHp.get(sc[left]) - 1);
                }
                if (left < s.length())//判断是否到达右边界
                    left++;
            }
        }
        return sub;
    }

    private boolean isSub(HashMap<Character, Integer> hp , HashMap<Character, Integer> subHp, String t) {
        boolean flag = true;
        if (subHp.size() == hp.size()) {
            for (char c : t.toCharArray()) {
                if (subHp.get(c) < hp.get(c)) flag = false;
            }
        } else
            flag = false;
        return flag;
    }

    Map<Character, Integer> ori = new HashMap<Character, Integer>();
    Map<Character, Integer> cnt = new HashMap<Character, Integer>();

    public String minWindow2(String s, String t) {
        int tLen = t.length();
        for (int i = 0; i < tLen; i++) {
            char c = t.charAt(i);
            ori.put(c, ori.getOrDefault(c, 0) + 1);
        }
        int l = 0, r = -1;
        int len = Integer.MAX_VALUE, ansL = -1, ansR = -1;
        int sLen = s.length();
        while (r < sLen) {
            ++r;
            if (r < sLen && ori.containsKey(s.charAt(r))) {
                cnt.put(s.charAt(r), cnt.getOrDefault(s.charAt(r), 0) + 1);
            }
            while (check() && l <= r) {
                if (r - l + 1 < len) {
                    len = r - l + 1;
                    ansL = l;
                    ansR = l + len;
                }
                if (ori.containsKey(s.charAt(l))) {
                    cnt.put(s.charAt(l), cnt.getOrDefault(s.charAt(l), 0) - 1);
                }
                ++l;
            }
        }
        return ansL == -1 ? "" : s.substring(ansL, ansR);
    }

    public boolean check() {
        Iterator iter = ori.entrySet().iterator();
        while (iter.hasNext()) {
            Map.Entry entry = (Map.Entry) iter.next();
            Character key = (Character) entry.getKey();
            Integer val = (Integer) entry.getValue();
            if (cnt.getOrDefault(key, 0) < val) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        LeetCode76 leetCode76 = new LeetCode76();
        System.out.println(leetCode76.minWindow("ADOBECODEBANC", "ABC"));
        System.out.println(leetCode76.minWindow("bbaac", "aba"));
    }
}
