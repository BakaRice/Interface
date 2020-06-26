package JVMDemo.OOM;

import java.util.ArrayList;
import java.util.List;

/**
 * Description: JavaLearning
 * Created by Rice on 2020/6/6 21:38
 */
public class HeapOOM {

    static class OOMObject {
    }

    public static void main(String[] args) {
        List<OOMObject> list = new ArrayList<OOMObject>();
        while (true) {
            list.add(new OOMObject());
        }

    }
}
