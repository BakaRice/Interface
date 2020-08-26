package dataStructure.stackandqueue;

/**
 * @author RiceFamily
 * @date 2020/7/22 14:31
 * temperatures = [73, 74, 75, 71, 69, 72, 76, 73]
 * [1, 1, 4, 2, 1, 1, 0, 0]
 */
public class DailyTemperatures {
    public int[] dailyTemperatures(int[] T) {
        if (T.length == 0 || T == null) return null;
        int[] res = new int[T.length];
        for (int i = 0; i < T.length; i++) {
            for (int j = i + 1; j < T.length; j++) {
                if (T[j] > T[i]) {
                    res[i] = j - i;
                    break;
                }
                if (j == T.length) res[i] = 0;
            }
        }
        return res;
    }
}
