import java.util.Scanner;

public class BASIC_15 {
    public static void main(String args[]){
        Scanner cin = new Scanner(System.in);
        String str1 = cin.nextLine();
        String str2 = cin.nextLine();
        if (str1.length() == str2.length()){
            if (str1.equals(str2))
                System.out.println(2);
            else if (str1.toUpperCase().equals(str2.toUpperCase()))
                System.out.println(3);
            else
                System.out.println(4);
        }else
            System.out.println(1);

    }
}
