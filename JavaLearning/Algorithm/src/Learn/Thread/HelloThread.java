package Learn.Thread;

import java.util.HashMap;

public class HelloThread extends Thread {

    @Override
    public void run() {
//        super.run();
        System.out.println("Hello from HelloThread!");
    }

    public static void main(String[] args) {
        new HelloThread().start();
    }
}
