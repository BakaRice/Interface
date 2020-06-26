package Learn.Thread.Sync;

import java.util.Random;

public class Counter {
    private Random random = new Random();
    private  int c;
    public synchronized void increment(){
        try {
            Thread.sleep(random.nextInt(50));
            c++;
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    int getC(){
        return c;
    }
}
