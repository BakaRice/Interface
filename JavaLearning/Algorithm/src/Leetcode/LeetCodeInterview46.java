package Leetcode;

/**
 * Description: JavaLearning
 * Created by Rice on 2020/6/9 15:08
 * https://leetcode-cn.com/problems/ba-shu-zi-fan-yi-cheng-zi-fu-chuan-lcof/
 */
public class LeetCodeInterview46 {
    private int res = 0;
    public int translateNum(int num) {
        String s = String.valueOf(num);
        dfs(s,0);
        return res;
    }

    //s = 原始字符串
    //start = 当前翻译的开始点
    private void dfs(String s,int start){
        if (start == s.length()){
            //get result!
            res++;
            return;
        }
        char ch1 = s.charAt(start);
        if (ch1 == '0' || ch1 >= '3'){
            //以0开头，不需要拼接，直接下一步
            //大于2，就不能和下一个拼接
            dfs(s,start + 1);
        }else if (ch1 == '1'){
            dfs(s,start + 1);
            if (start + 2 <= s.length()){   //如果start + 2 == s.length()表示已经遍历到结尾，可以输出结果
                dfs(s,start + 2);
            }
        }else if (ch1 == '2'){
            dfs(s,start + 1);
            if (start + 2 <= s.length() && s.charAt(start + 1) <= '5'){
                dfs(s,start + 2);
            }
        }
    }


    public int translateNum2(int num) {
        String s = String.valueOf(num);
        int[] dp = new int[s.length()+1];
        dp[0] = 1;
        dp[1] = 1;
        for(int i = 2; i <= s.length(); i ++){
            String temp = s.substring(i-2, i);
            if(temp.compareTo("10") >= 0 && temp.compareTo("25") <= 0)
                dp[i] = dp[i-1] + dp[i-2];
            else
                dp[i] = dp[i-1];
        }
        return dp[s.length()];
    }

        public int translateNum3(int num) {
            String s = String.valueOf(num);
            int a = 1, b = 1;
            for(int i = 2; i <= s.length(); i++) {
                String tmp = s.substring(i - 2, i);
                int c = tmp.compareTo("10") >= 0 && tmp.compareTo("25") <= 0 ? a + b : a;
                b = a;
                a = c;
            }
            return a;
        }


    public static void main(String[] args) {
        LeetCodeInterview46 l46 = new LeetCodeInterview46();
        System.out.println(l46.translateNum(2163));
    }
}
