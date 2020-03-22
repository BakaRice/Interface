package nowcoder;

/*
请实现一个函数用来匹配包括'.'和'*'的正则表达式。
模式中的字符'.'表示任意一个字符，而'*'表示它前面的字符可以出现任意次（包含0次）。
 在本题中，匹配是指字符串的所有字符匹配整个模式。
 例如，字符串"aaa"与模式"a.a"和"ab*ac*a"匹配，但是与"aa.a"和"ab*a"均不匹配
 */
public class Solution50 {
    public boolean match(char[] str, char[] pattern) {

        if (str.length == 0)//匹配串为0
        {
            if (pattern.length == 0) return true;
            else {
                if (pattern.length % 2 == 1) return false;
                else {
                    for (int i = 1; i < pattern.length; i++)
                        if (pattern[i] != '*') return false;
                    return true;
                }
            }

        } else if (pattern.length == 0) {//匹配串为0，肯定不行
            return false;
        }
        int dp[][] = new int[str.length][pattern.length];
        for (int i = 0; i < str.length; i++) {
            for (int j = i; j < pattern.length; j++) {
                if (pattern[j] == '.' && i >= j) {
                    dp[i][j] = 1;
                } else if (pattern[j] == '*') {
//                    if (i >= 1) {
//                        if (dp[i - 1][j - 1] == 1)
//                            dp[i][j] = 1;
//                    } else if (j >= 2) {
//                        if (dp[i][j - 2] == 1 || dp[i][j - 1] == 1) dp[i][j] = 1;
//                    } else if (j >= 1) {
//                        if (dp[i][j - 1] == 1) dp[i][j] = 1;
//                    } else dp[i][j] = 0;
                    if (i == 0 && j >= 1) {
                        if (dp[i][j - 1] == 1) {
                            dp[i][j] = 1;
                            continue;
                        }
                    }
                    if (i == 0 && j >= 2) {
                        if (dp[i][j - 1] == 1 || dp[i][j - 2] == 1) {
                            dp[i][j] = 1;
                            continue;
                        }
                    }
                    if (i >= 1 && j >= 1) {
                        if (dp[i - 1][j - 1] == 1||dp[i-1][j]==1) {
                            dp[i][j] = 1;
                            continue;
                        }
                    }
                    if (i >= 1 && j >= 2) {
                        if (dp[i - 1][j - 1] == 1 || dp[i - 1][j - 2] == 1) {
                            dp[i][j] = 1;
                            continue;
                        }
                    }



                    dp[i][j] = 0;

                } else if (str[i] == pattern[j] && i >= j) {
                    dp[i][j] = 1;
                }
                //if (dp[i - 1][j - 1] == 0) dp[i][j] = 0;
            }
        }
        if (dp[str.length - 1][pattern.length - 1] == 1) return true;
        else return false;
    }

    public static void main(String[] args) {
        Solution50 solution50 = new Solution50();
        char[] c1 = {'a', 'a', 'a'};
        char[] c2 = {'a', 'b', '*', 'a', 'c', '*', 'a'};
        System.out.println(solution50.match(c1, c2));
    }
}
