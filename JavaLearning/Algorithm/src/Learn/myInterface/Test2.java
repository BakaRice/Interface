package Learn.myInterface;

/**
 * @author RiceFamily
 * @date 2020/5/29 13:45
 */
public class Test2 {
    public static void main(String[] args) {
        Test1 test1 = new Test1();
        test1.cry();
        ITest.simle();
        System.out.println(ITest.s.getClass());
        System.out.println(ITest.s1.getClass());
    }
}
