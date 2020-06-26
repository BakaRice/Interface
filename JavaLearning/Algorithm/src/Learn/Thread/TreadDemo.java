package Learn.Thread;

public class TreadDemo {
    public static void main(String[] args) {//main函数也是一个线程
        Demo d = new Demo();
        Thread t1 = new Thread(d);//3.通过Thread类建立线程对象     4.将Runnable接口的子类对象作为实际参数传递给Thread类的构造函数
        Thread t2 = new Thread(d);
        t1.start();//5.调用Thread类的start方法开启线程并调用Runnable接口子类的run()方法
        t2.start();
        for (int i = 0; i < 2000; i++) {
            System.out.println("main...." + i);
        }
    }

    static class Demo implements Runnable {// 1.定义类实现Runnable接口

        public void run() { //2.重写run方法
            for (int i = 0; i < 100; i++) {
                System.out.println(Thread.currentThread().getName() + "run..." + i);
            }
        }
    }
}