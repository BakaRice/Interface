package Leetcode;

public class LeetCode03 {
    /*
    "abcabcbb"
    3 abc
    "bbbbb"
    1 b
    "pwwkew"
    3 wke
     */
    private int lengthOfLongestSubstring(String s) {
        int max=0;
        int start=0;
        int end = 0;
        int count = 0;
        if (s.length()==1)//坑爹的极端情况、例えば　すべては　ゼロ 、数字は一つだけのとき！
            return 1;
        while(end<s.length()-1){
            end=end+1;
            char endc=  s.charAt(end);
            //每次探索下一个字符的时候 需要和前面的所有字符进行比较
            for (int p = start;p<end;p++){
                char tempc = s.charAt(p);
                if (tempc == endc){//如果中间任何一个字符等于新插入的字符
                    start = p+1;
                }
            }
            count = end - start + 1;
            if (count>max)
                max = count;

        }
        return max;
    }

    public static void main(String[] args) {
        LeetCode03 leetCode03 = new LeetCode03();
        String str = "LeetCode";
        System.out.println( leetCode03.lengthOfLongestSubstring(str));
       }
}
