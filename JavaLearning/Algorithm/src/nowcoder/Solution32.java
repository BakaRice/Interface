package nowcoder;

import java.util.ArrayDeque;
import java.util.Queue;

public class Solution32 {
    public int FirstNotRepeatingChar(String str) {
        int[] first = new int[52];
        int[] s = new int[52];
        for (int i = 0; i < str.length(); i++) {
            int asc = (int) str.charAt(i);
            if (asc >= 97)
                asc = asc - 97;
            else asc = asc - 65 + 26;
            s[asc] = i;
            first[asc]++;
        }
        int min = 100001;
        for (int i = 0; i < first.length; i++) {
            if (first[i] == 1)
                if (min > s[i])
                    min = s[i];

        }
        if (min == 100001) return -1;
        return min;
    }

    public static void main(String[] args) {
        Solution32 solution32 = new Solution32();
        System.out.println(solution32.FirstNotRepeatingChar("sPeYjppjOPHoiYdzlTUufOOzlnSudHuHzbWXzZnyPWrnkFfmQX"));

    }
}