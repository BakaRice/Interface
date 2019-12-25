public class LeetCode14 {
    public String longestCommonPrefix(String[] strs) {
        String longest = "";
        int flag = 0;
        int i;
        if (strs == null || strs.length == 0 || (strs.length == 1 && strs[0].length() == 0))
            return longest;
        int min = Integer.MAX_VALUE;
        for (String str : strs)
            if (str.length() < min)
                min = str.length();
        for (i = 0; i < min; i++) {
            for (int j = 1; j < strs.length; j++) {
                if (strs[j].charAt(i) != strs[j - 1].charAt(i)) {
                    flag = 2;
                    break;
                }
            }
            if (flag == 2) {
                break;
            }
        }
        if (i == 0)
            return longest;
        longest = strs[0].substring(0, i);
        return longest;
    }

    public String longestCommonPrefix2(String[] strs) {
        if (strs.length == 0) return "";
        String prefix = strs[0];
        for (int i = 1; i < strs.length; i++)
            while (strs[i].indexOf(prefix) != 0) {
                prefix = prefix.substring(0, prefix.length() - 1);
                if (prefix.isEmpty()) return "";
            }
        return prefix;
    }

    public static void main(String[] args) {
        LeetCode14 leetCode14 = new LeetCode14();
        String[] agrgs = {"leet","leets","leetcode","le"};
        System.out.println(leetCode14.longestCommonPrefix2(agrgs));
    }
}
