package Leetcode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class LeetCode139 {
    //错误 遇到 cars ： car ca rs 就会出现错误
    public boolean wordBreak(String s, List<String> wordDict) {
        StringBuilder sb = new StringBuilder(s);
        for (String str : wordDict) {
            int start = -1;
            while ((start = sb.indexOf(str)) != -1) {
                sb.delete(start, start + str.length());
            }
        }
        if (sb.toString().length() > 0) return false;
        else return true;
    }

    public boolean wordBreak_2(String s, List<String> wordDict) {
        Set<String> wordDictSet = new HashSet(wordDict);
        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;
        for (int i = 1; i <= s.length(); i++) {
            for (int j = 0; j < i; j++) {
                if (dp[j] && wordDictSet.contains(s.substring(j, i))) {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[s.length()];
    }

    public boolean wordBreak_3(String s, List<String> wordDict) {
        HashSet<String> hs = new HashSet<>();
        wordDict.forEach(u -> hs.add(u));

        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;
        for (int i = 1; i <= s.length(); i++) {
            for (int j = 0; j < i; j++) {
                if (dp[j] && wordDict.contains(s.substring(j, i))) {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[s.length()];
    }

    public static void main(String[] args) {
        LeetCode139 leetCode139 = new LeetCode139();
        System.out.println(leetCode139.wordBreak_2("aaaaaaa", List.of("aaaa", "aaa")));
//        "aaaaaaa"
//                ["aaaa","aaa"]

    }
}