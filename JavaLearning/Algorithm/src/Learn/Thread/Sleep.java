package Learn.Thread;

public class Sleep {
    public static void main(String[] args) throws InterruptedException {
        System.out.println("main thread running");
        Thread t = new Thread(new Runnable() {
            private int amount = 5;
            @Override
            public void run() {
                for (int i = 0; i < amount; i++) {
                    System.out.println(i);
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
//                        e.printStackTrace();
                        System.out.println("Interrupted");
                        return;
                    }
                }
            }
        });
        t.start();

//        joins()方法，允许一个线程等待另一个线程的完成
        t.join();
//        中断测试
//        Thread.sleep(2000);
//        t.interrupt();
        System.out.println("main thread ending");
    }
}
