import java.util.ArrayList;
import java.util.Scanner;

public class Paradigm4_02 {
    public static void main(String[] args) {
        Scanner fileReader = new Scanner(System.in);
        ArrayList<String> logs = new ArrayList<>();

        while (fileReader.hasNextLine()) {
            String line = fileReader.nextLine();
            System.out.println(line);
            logs.add(line);
        }


    }
}
