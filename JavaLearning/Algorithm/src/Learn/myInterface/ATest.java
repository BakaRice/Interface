package Learn.myInterface;

/**
 * @author RiceFamily
 * @date 2020/5/29 14:13
 */
public abstract class ATest {
    static String s = "Yes";
    String s1 = "YES";

    static private void private_simle() {
        System.out.println("private_simle!");
    }

    static void simle() {
        System.out.println("simle!");
        private_simle();
    }


}
