package companies.btyedance.string;

/**
 * Description: JavaLearning
 * Created by Rice on 2020/6/29 10:02
 */
public class T4 {
    public String multiply(String num1, String num2) {
        if (num1.equals("0") || num2.equals("0")) return "0";

        int[] sum = new int[num1.length() + num2.length()];
        char[] xs2 = num2.toCharArray();
        char[] xs1 = num1.toCharArray();
        int max = 0;
        for (int i = xs2.length - 1; i >= 0; i--) {
            int mult = xs2[i] - '0';
            for (int j = xs1.length - 1; j >= 0; j--) {
                int curr = xs1[j] - '0';
                int curr_res = curr * mult;
                int index = (xs1.length - 1 - j) + (xs2.length - 1 - i);

                sum[index] += curr_res % 10;
                sum[index + 1] += curr_res / 10;

                sum[index + 1] += sum[index] / 10;
                sum[index] = sum[index] % 10;

            }
        }
        boolean flag = false;
        StringBuilder sb = new StringBuilder();
        for (int i = sum.length - 1; i >= 0; i--) {
            if (sum[i] == 0 && !flag)
                continue;
            if (sum[i] != 0 || flag) {
                flag = true;
                sb.append(sum[i]);
            }
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        T4 t4 = new T4();
        System.out.println(t4.multiply("123", "456"));
    }
}
