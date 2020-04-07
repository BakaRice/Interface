package Leetcode;

public class LeetCode72 {
    public int minDistance(String word1, String word2) {
        if (word1.length() == 0 && word2.length() == 0) return 0;
        int dp[][] = new int[word1.length() + 1][word2.length() + 1];
        for (int i = 0; i <= word1.length(); i++) {
            dp[i][0] = i;
        }
        for (int i = 0; i <= word2.length(); i++) {
            dp[0][i] = i;
        }
        int flag =0;
        for (int i = 1; i <= word1.length(); i++) {
            for (int j = 1; j <= word2.length(); j++) {
                int min = Math.min(dp[i][j - 1], Math.min(dp[i - 1][j - 1], dp[i - 1][j]));
                if (word2.charAt(j - 1) == word1.charAt(i - 1)) {
                    dp[i][j] = dp[i-1][j-1];
                } else
                    dp[i][j] = min + 1;
            }
        }
        return dp[word1.length()][word2.length()];
    }

    public static void main(String[] args) {
        LeetCode72 leetCode72 = new LeetCode72();
        System.out.println(leetCode72.minDistance("zoolo", "zoo"));
//        "zoologicoarchaeologist"
//        "zoogeologist"
    }
}
