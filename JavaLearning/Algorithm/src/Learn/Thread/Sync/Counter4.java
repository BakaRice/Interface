package Learn.Thread.Sync;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Counter4 {
    private Integer num = 0;
    private Lock lock = new ReentrantLock();

    public void increment() {
        lock.lock();
        num++;
        lock.unlock();
    }

    public int getNum() {
        return num;
    }
}
