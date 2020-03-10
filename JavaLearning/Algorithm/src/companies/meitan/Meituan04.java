package companies.meitan;

import java.util.Scanner;

public class Meituan04 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int s[] = new int[n];
        for (int i = 0; i < n; i++) {
            s[i] = scanner.nextInt();
        }
        int sum = 0;
        for (int i = 0; i < n-1; i++) {
            if (s[i] > s[i + 1])
                sum = sum + s[i] - s[i +1];
        }
        sum += s[n - 1];
        System.out.println(sum);
    }
}
