import java.util.HashMap;
import java.util.Map;

public class myHashMap {
    public static void main(String[] args) {
//        HashMap<Integer, String> hp = new HashMap<>();
//        //插入及扩容测试
//        for (int i = 0; i < 17; i++) {
//            hp.put(i, "val_" + i);
//        }
//        for (Map.Entry<Integer, String> entry : hp.entrySet()) {
//            System.out.println(entry.getKey() + " ：" + entry.getValue());
//        }
        //重复key插入测试
        HashMap<Integer, String> hp_1 = new HashMap<>();
        hp_1.put(0,"val_0");
        hp_1.put(1,"val_1");
        hp_1.put(1,"newVal_1");

    }
}
