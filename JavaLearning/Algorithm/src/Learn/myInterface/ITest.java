package Learn.myInterface;

import java.util.List;

/**
 * @author RiceFamily
 * @date 2020/5/29 13:42
 */
public interface ITest {
     static String s = "Yes";
    String s1 = "YES";

    static private void private_simle() {
        System.out.println("private_simle!");
    }

    static void simle() {
        System.out.println("simle!");
        private_simle();
    }

    default void cry() {
        System.out.println("cry！");
    }
}
