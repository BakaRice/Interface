import java.util.HashMap;
import java.util.Map;

public class Solution28 {
    public int MoreThanHalfNum_Solution(int[] array) {
        if (array.length == 0) return 0;
        Map<Integer, Integer> hasNum = new HashMap<>();
        for (int i = 0; i < array.length; i++) {
            if (hasNum.containsKey(array[i])) {
                hasNum.put(array[i], hasNum.get(array[i]) + 1);
                if ((hasNum.get(array[i]) * 2) >= array.length)
                    return array[i];
            } else
                hasNum.put(array[i], 1);
            if ((hasNum.get(array[i]) * 2) >= array.length)
                return array[i];
        }

        return 0;
    }

    public static void main(String[] args) {
        Solution28 solution28 = new Solution28();
        int[] array = {1};
        System.out.println(solution28.MoreThanHalfNum_Solution(array));
    }
}