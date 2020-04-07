package companies.jinshan;

import java.util.Scanner;

public class Jinshan01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Integer x = scanner.nextInt();
        if (x < 10) {
            System.out.println("Yes");
            return;
        }
        String s = x.toString();
        int l = 0;
        int r = s.length() - 1;
        int flag = 0;
        while (l < r) {
            if (s.charAt(l) == s.charAt(r)) {
                l++;
                r--;
            } else {
                flag = 1;
                System.out.println("No");
                break;
            }
        }
        if (flag == 0) System.out.println("Yes");
    }
}
