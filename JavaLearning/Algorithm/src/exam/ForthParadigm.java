package exam;

import java.util.Scanner;

public class ForthParadigm {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str1 = scanner.nextLine();
        String str2 = scanner.nextLine();

        for (int i = 0; i < str1.length(); i++) {
            String tempStr = str1.substring(i) + str1.substring(0, i);
            if (tempStr.equals(str2)) {
                System.out.println("True");
                return;
            }
        }
        System.out.println("False");

    }
}
