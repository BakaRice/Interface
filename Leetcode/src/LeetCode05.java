class LeetCode05 {
    /*
    给定一个字符串 s，找到 s 中最长的回文子串。你可以假设 s 的最大长度为 1000。

    示例 1：
    输入: "babad"
    输出: "bab"
    注意: "aba" 也是一个有效答案。
    
    示例 2：
    输入: "cbbd"
    输出: "bb"
     */

    /**
     * 写成一坨屎啊 速度超级慢不说 还有很多很多的边界问题不能很好的考虑
     */
    public String longestPalindrome(String s) {
        String maxlen = new String();
        String templen = new String();
        for (int i =1 ; i<s.length()-1;i++) {
            if (s.charAt(i) == s.charAt(i + 1)) {//baab型偶对称
                templen = s.substring(i, i+1+1);
                for (int j = 1; j <= i; j++) {
                    if (i+j+1>s.length()-1) break;
                    if (s.charAt(i + j + 1) == s.charAt(i - j)) {
                        templen = s.substring(i-j,i + j+1+1);//左闭右开
                    } else break;//如果发现不是 立即 break；
                }
                if (maxlen.length()<templen.length()) {
                    maxlen = templen;
                }
            }
            if (s.charAt(i+1) == s.charAt(i - 1)){//bab型对称判断
                for (int j = 1; j<=i;j++){
                    if (i+j>s.length()-1||i-j<0) break;
                    if (s.charAt(i+j) == s.charAt(i-j)) {
                        templen = s.substring(i-j, i+j+1);}//左闭右开
                    else break;
                }
                    if (maxlen.length()<templen.length()) {
                        maxlen = templen;
                    }
            }

        }
        if (maxlen.length()==0)//如果不存在回文字
        {if (s.length()==0)
            return  maxlen;
        else if (s.length()==2||s.length()==3)
            if(s.charAt(0)==s.charAt(1)&&s.length()==2) return s;
               else if(s.charAt(0)==s.charAt(1)&&s.length()==3) return s.substring(0, 2);
            maxlen = s.substring(0, 1);
        }
        return maxlen;
    }

    /*
    其他人快速且优雅的写法
     */
    public String longestPalindrome2(String s) {
        if (s == null || s.length() == 0) {
            return s;
        }
        int start = 0;
        int end = 0;
        for (int i = 0; i < s.length(); i++) {
            int len1 = getPalindromeLen(s, i, i);//奇对称
            int len2 = getPalindromeLen(s, i, i + 1);//偶对称
            int len = Math.max(len1, len2);
            if (len > end - start + 1) {//如果当前长度比之前记录的最长还要长
                start = i - (len - 1) / 2;
                end = i + len / 2;
            }
        }
        return s.substring(start, end + 1);
    }

    public int getPalindromeLen(String s, int i, int j) {
        while (i >= 0 && j < s.length() && s.charAt(i) == s.charAt(j)) {
            i--;
            j++;
        }
        return j - i - 1;
    }
    public static void main(String[] args) {
        LeetCode05 leetCode05 = new LeetCode05();
        System.out.println(leetCode05.longestPalindrome2("FOR_TEST_TSET_ROF"));
    }
}