package Learn.Thread.Sync;

import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;

public class Counter2 {
    private static Random random = new Random();
    private static AtomicInteger c = new AtomicInteger(0);
    public static void increment(){
        try {
            Thread.sleep(random.nextInt(50));
            c.incrementAndGet();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

   public static int getC(){
        return c.get();
    }
}
