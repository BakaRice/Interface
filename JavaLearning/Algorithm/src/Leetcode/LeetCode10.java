package Leetcode;

public class LeetCode10 {

    /*
    给你一个字符串 s 和一个字符规律 p，请你来实现一个支持 '.' 和 '*' 的正则表达式匹配。

'.' 匹配任意单个字符
'*' 匹配零个或多个前面的那一个元素
所谓匹配，是要涵盖 整个 字符串 s的，而不是部分字符串。

说明:

s 可能为空，且只包含从 a-z 的小写字母。
p 可能为空，且只包含从 a-z 的小写字母，以及字符 . 和 *。
示例 1:

输入:
s = "aa"
p = "a"
输出: false
解释: "a" 无法匹配 "aa" 整个字符串。
示例 2:

输入:
s = "aa"
p = "a*"
输出: true
解释: 因为 '*' 代表可以匹配零个或多个前面的那一个元素, 在这里前面的元素就是 'a'。因此，字符串 "aa" 可被视为 'a' 重复了一次。
示例 3:

输入:
s = "ab"
p = ".*"
输出: true
解释: ".*" 表示可匹配零个或多个（'*'）任意字符（'.'）。
示例 4:

输入:
s = "aab"
p = "c*a*b"
输出: true
解释: 因为 '*' 表示零个或多个，这里 'c' 为 0 个, 'a' 被重复一次。因此可以匹配字符串 "aab"。
示例 5:

输入:
s = "mississippi"
p = "mis*is*p*."
输出: false
            */
    //自己的错误想法
    public boolean isMatch(String s, String p) {
    String Match = new String();
    int n = 0;
    int i = 0;
    if (s.length()==0)//待匹配串为空
        if (p.length()==0)return true;
        else if (p.equals(".*")) return true;
        else return false;
    if (p.length()==0)//正则式为空
        if (s.length()==0) return true;
        else  return  false;
    //for (int i = 0;n<p.length();i++)
        for (;;){
            if (p.charAt(n)=='.'){ //匹配任意字符
                Match = Match + s.charAt(i);//将已匹配内容存入匹配串内
                i++;//原字符串向下遍历
            };
            if (p.charAt(n)=='*'){ //如果是* 即前一个元素可以有 也可以没有
                for (int j = i;j<s.length();j++){//查找所有内容
                    if (p.charAt(n-1)==s.charAt(j)){//如果等于上一个字符
                        { Match = Match + s.charAt(j);}
                    }else if (p.charAt(n-1)=='.'){//如果上一个字符是  . 【任意匹配 直到下一个正则式字符】
                        { int temp = 0;
                            for ( temp = i ;temp<s.length();temp++){
                              if (n<p.length()-1){//确保不越界
                                if (s.charAt(temp)!=p.charAt(n+1))//判断是否匹配下一正则字符
                                 Match = Match + s.charAt(temp);
                              }
                              else{
                                  Match = Match +s.charAt(temp);
                              }
                            }
                        i = temp;}
                    }else{
                        i = j;
                        break;
                    }
                }
            }
            if (p.charAt(n)>='a'&&p.charAt(n)<='z'){ //在a-z
                if (p.charAt(n) == s.charAt(i))
                {Match = Match + s.charAt(i);
                i++;}//原字符串向下遍历
            }
            n++;//正则表达式字符串++
           if(i==s.length()||n==p.length()){
           if (Match.equals(s))
               return true;
            else return false;
           }
        }

    }

    public boolean isMatch2(String s, String p) {
        int m = s.length(), n = p.length();
        boolean[][] f = new boolean[m + 1][n + 1];

        f[0][0] = true;
        for(int i = 2; i <= n; i++){//判断 正则式中 *的匹配
            f[0][i] = f[0][i - 2] && p.charAt(i - 1) == '*';
        }

        for(int i = 1; i <= m; i++){
            for(int j = 1; j <= n; j++){
                if(s.charAt(i - 1) == p.charAt(j - 1) || p.charAt(j - 1) == '.'){
                    f[i][j] = f[i - 1][j - 1];
                }
                if(p.charAt(j - 1) == '*'){
                    f[i][j] = f[i][j - 2] || f[i - 1][j] && (s.charAt(i - 1) == p.charAt(j - 2) || p.charAt(j - 2) == '.');
                }
            }
        }

        return f[m][n];
    }

    public boolean isMatch3(String s,String p){
            if (s == null || p == null) {
                return false;
            }
            boolean[][] dp = new boolean[s.length() + 1][p.length() + 1];
            dp[0][0] = true;//dp[i][j] 表示 s 的前 i 个是否能被 p 的前 j 个匹配
            for (int i = 0; i < p.length(); i++) { // here's the p's length, not s's
                if (p.charAt(i) == '*' && dp[0][i - 1]) {
                    dp[0][i + 1] = true; // here's y axis should be i+1
                }
            }
            for (int i = 0; i < s.length(); i++) {
                for (int j = 0; j < p.length(); j++) {
                    if (p.charAt(j) == '.' || p.charAt(j) == s.charAt(i)) {//如果是任意元素 或者是对于元素匹配
                        dp[i + 1][j + 1] = dp[i][j];
                    }
                    if (p.charAt(j) == '*') {
                        if (p.charAt(j - 1) != s.charAt(i) && p.charAt(j - 1) != '.') {//如果前一个元素不匹配 且不为任意元素
                            dp[i + 1][j + 1] = dp[i + 1][j - 1];
                        } else {
                            dp[i + 1][j + 1] = (dp[i + 1][j] || dp[i][j + 1] || dp[i + 1][j - 1]);
                            /*
                            dp[i][j] = dp[i-1][j] // 多个字符匹配的情况
                            or dp[i][j] = dp[i][j-1] // 单个字符匹配的情况
                            or dp[i][j] = dp[i][j-2] // 没有匹配的情况

                            看 ### 匹不匹配，不是直接只看 ### 匹不匹配，要综合后面的 b b* 来分析
                            这三种情况是 oror 的关系，满足任意一种都可以匹配上，同时是最难以理解的地方：
                            dp[i-1][j] 就是看 s 里 b 多不多， ### 和 ###b * 是否匹配，一旦匹配，s 后面再添个 b 也不影响，
                            因为有 * 在，也就是 ###b 和 ###b *也会匹配。
                            dp[i][j-1] 就是去掉 * 的那部分，###b 和 ###b 是否匹配，比如 qqb qqb
                            dp[i][j-2] 就是 去掉多余的 b *，p 本身之前的能否匹配，###b 和 ### 是否匹配，
                            比如 qqb qqbb* 之前的 qqb qqb 就可以匹配，
                            那多了的 b * 也无所谓，因为 b * 可以是匹配 00 次 b，相当于 b * 可以直接去掉了。
                            三种满足一种就能匹配上。
                            为什么没有 dp[i-1][j-2] 的情况？ 就是 ### 和 ### 是否匹配？因为这种情况已经是 dp[i][j-1] 的子问题。
                            也就是 s[i]==p[j-1]，则 dp[i-1][j-2]=dp[i][j-1]。

                             */

                        }
                    }
                }
            }
            return dp[s.length()][p.length()];
        }
    public static void main(String[] args) {
        LeetCode10 leetCode10 = new LeetCode10();
        System.out.print(leetCode10.isMatch3("aab", "c*a*b*"));
//""
//".*"
    }
}
