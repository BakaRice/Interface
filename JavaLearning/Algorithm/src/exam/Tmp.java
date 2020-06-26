package exam;

/**
 * @author RiceFamily
 * @date 2020/6/3 15:02
 */
public class Tmp {
    int a = 100;

    public void miner() {
        a--;
    }

    public static void main(String[] args) {
        Tmp x = new Tmp();
        Son y = new Son();
        System.out.println(y.a+" "+y.getA());
        y.miner();
        System.out.println(y.a+" "+y.getA());
    }

    static class Son extends Tmp {
        int a = 0;

        public void plus() {
            a++;
        }

        public int getA() {
            return super.a;
        }
    }
}
