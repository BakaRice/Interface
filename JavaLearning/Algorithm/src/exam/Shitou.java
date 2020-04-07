package exam;

import java.util.Scanner;

public class Shitou {
    public static void main(String[] args) {
        int n=0;
        int num = 1;
        int maxline = 1;
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        int stone[] = new int[n];
        int stone2[] = new int[n];
        for (int i = 0; i < n; i++) {
            stone[i] = scanner.nextInt();
        }
        for (int i = 0; i < n; i++) {
            stone2[i] = stone[i];
            for (int j = i + 1; j < n; j++) {
               stone2[j]= stone[j];
                if (stone2[i] + 1 == stone2[j]) {
                    stone2[i] = stone2[j];
                    num++;
                }
            }
            if (num >= maxline) {
                maxline = num;
            }
            num =1;
        }
        int minmove = n-maxline;
        System.out.println(minmove);
    }
}
