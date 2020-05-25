package Leetcode;

public class LeetCode1114 {

    private boolean firstFinshed;
    private boolean secondFinshed;
    private Object lock = new Object();

    class Foo {

        public Foo() {

        }

        public void first(Runnable printFirst) throws InterruptedException {
            synchronized (lock) {
                // printFirst.run() outputs "first". Do not change or remove this line.
                printFirst.run();
                firstFinshed = true;
                lock.notifyAll();
            }
        }

        public void second(Runnable printSecond) throws InterruptedException {

            synchronized (lock) {
                while (!firstFinshed) {
                    lock.wait();
                }
                // printSecond.run() outputs "second". Do not change or remove this line.
                printSecond.run();
                secondFinshed = true;
                lock.notifyAll();
            }
        }

        public void third(Runnable printThird) throws InterruptedException {
            synchronized (lock){
                while (!secondFinshed){
                    lock.wait();
                }
            }
            // printThird.run() outputs "third". Do not change or remove this line.
            printThird.run();
        }
    }

}
