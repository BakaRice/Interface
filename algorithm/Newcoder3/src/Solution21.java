

public class Solution21 {
    /**
     * 分析发现一旦递减就不能递增
     *
     * @param pushA
     * @param popA
     * @return
     */
    public boolean IsPopOrder(int[] pushA, int[] popA) {
        int temps[] = new int[popA.length];
        for (int i = 0; i < pushA.length; i++) {
            for (int j = 0; j < pushA.length; j++) {
                if (popA[i] == pushA[j]) {
                    temps[i] = j;
                    break;
                } else temps[i] = Integer.MAX_VALUE;
            }
            if (temps[i] == Integer.MAX_VALUE) return false;
        }
        int flag = 0;
        int temp = temps[0];
        for (int i = 1; i < popA.length; i++) {
            if (temp > temps[i])
                flag = 1;
            if (temp < temps[i] && flag == 1)
                return false;
            temp = temps[i];
        }
        return true;
    }

    public static void main(String[] args) {
        Solution21 solution21 = new Solution21();
        int[] pusha = {11, 22};
        int[] popa = {22, 111};
        System.out.println(solution21.IsPopOrder(pusha, popa));
    }
}