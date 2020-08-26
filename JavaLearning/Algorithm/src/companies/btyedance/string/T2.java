package companies.btyedance.string;

/**
 * Description: JavaLearning
 * Created by Rice on 2020/6/29 8:33
 * 最长公共前缀
 * <p>
 * https://leetcode-cn.com/explore/interview/card/bytedance/242/string/1014/
 */
public class T2 {
    public String longestCommonPrefix(String[] strs) {
        if (strs.length == 0) return "";
        String refer = strs[0];
        for (int i = 1; i < strs.length; i++) {
            int index = 0;
            while (index < refer.length() && index < strs[i].length()) {
                if (refer.charAt(index) != strs[i].charAt(index))
                    break;
                else index++;
            }
            refer = strs[0].substring(0, index);
        }
        return refer;
    }
}
