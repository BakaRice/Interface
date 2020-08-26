package Leetcode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class LeetCode131 {
    public List<List<String>> partition(String s) {
        int len = s.length();
        List<List<String>> res = new ArrayList<>();
        if (len == 0) return res;
        Deque<String> stack = new ArrayDeque<>();
        backtracking(s, 0, len, stack, res);
        return res;
    }

    private void backtracking(String s, int start, int len, Deque<String> path, List<List<String>> res) {
        if (start == len) {
            res.add(new ArrayList<>(path));
            return;
        }

        for (int i = start; i < len; i++) {
            // 因为截取字符串是消耗性能的，因此，采用传子串索引的方式判断一个子串是否是回文子串
            // 不是的话，剪枝
            if (checkP(s, start, i)) {
                path.addLast(s.substring(start, i + 1));
                backtracking(s, i + 1, len, path, res);
                path.removeLast();
            }

        }
    }

    private boolean checkP(String s, int left, int right) {
//        int left = 0;
//        int right = s.length();
        char[] charArray = s.toCharArray();
        while (left < right) {
            if (charArray[left] != charArray[right]) return false;
            left++;
            right--;
        }
        return true;
    }


}
