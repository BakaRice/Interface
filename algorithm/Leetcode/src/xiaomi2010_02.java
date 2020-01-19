import java.math.BigInteger;
import java.util.Scanner;

public class xiaomi2010_02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        BigInteger[] count = new BigInteger[n];
        count[0] = new BigInteger("1");
        count[1] = new BigInteger("1");
        count[2] = new BigInteger("2");
        for (int i = 3; i < n; i++) {
            count[i] = count[i - 1].add(count[i - 3]);
        }
        System.out.println(count[n - 1]);
    }
}


