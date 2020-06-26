package Learn.Thread.Sync;


import java.time.LocalTime;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.Lock;

public class Synchronization {

    public static void main(String[] args) throws InterruptedException {
//        Counter2 counter2 = new Counter2();
//        for (int i =0;i<8_00;i++){
//            new Thread(Counter2::increment).start();
//        }
//        while (Thread.activeCount()!=2){
//            System.out.println("执行结果:"+counter2.getC());
//        }
//        ConcurrentHashMap<Integer, Integer> hp = new ConcurrentHashMap<>();
//        hp.put(1, 1);
//        Runnable r = () -> {
//            for (int j = 0; j < 1000; j++) {
//                Counter3.increment();
//            }
//            System.out.println(Counter3.getC());
//        };
//        for (int i = 0; i < 3; i++) {
//            new Thread(r).start();
//        }

//        Counter4 counter4 = new Counter4();
//        for (int i =0;i<8_000;i++){
//            new Thread(counter4::increment).start();
//        }
//        while (Thread.activeCount()!=2){
//            System.out.println("执行结果:"+counter4.getNum());
//        }

        ExecutorService service = Executors.newFixedThreadPool(3);
        for (int i = 0; i < 10; i++) {
            Runnable r1 = () -> {
                try {
                    Thread.sleep(500);
                    System.out.println(Thread.currentThread().getName() + "/" + LocalTime.now());
                } catch (InterruptedException e) {
//                    e.printStackTrace();
                    System.out.println("被中断");
                }
            };
            service.submit(r1);
            service.execute(r1);
        }
//        Thread.sleep(1000);
//        service.shutdown();
//        service.shutdownNow();
    }
}
