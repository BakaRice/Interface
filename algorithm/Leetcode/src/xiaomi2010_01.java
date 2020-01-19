import java.util.Scanner;

public class xiaomi2010_01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String in = scanner.nextLine();
        int max = 0;
        int temp = 0;
        for (int i = 0; i < in.length(); i++) {
            if (in.charAt(i) == '[')
                temp++;
            else if (in.charAt(i)==']')
                temp--;
            if (max<temp)
                max = temp;
        }
        System.out.println(max);
    }
}
