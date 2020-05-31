package Learn.myString;

/**
 * @author RiceFamily
 * @date 2020/5/29 17:02
 */
public class Test {
    public static void main(String[] args) {
        String h1 = "we";
        String h2 = new String("we");
        System.out.println(System.identityHashCode(h1));
        System.out.println(System.identityHashCode(h2));
        System.out.println(h1==h2);
    }
}
