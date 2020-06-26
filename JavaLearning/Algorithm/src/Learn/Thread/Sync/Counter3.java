package Learn.Thread.Sync;

import java.util.Random;

public class Counter3 {
    private static final Random r = new Random();
    private static ThreadLocal<Integer> c = new ThreadLocal<>();

    public static void increment() {
        try {
            Thread.sleep(r.nextInt(50));
            if (c.get() == null) c.set(0);
            c.set(c.get() + 1);
        } catch (InterruptedException e) {
        }
    }

    public static Integer getC() {
        return c.get();
    }
}
