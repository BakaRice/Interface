package companies.jinshan;

import java.util.ArrayList;
import java.util.List;

public class Jinshan02 {
    public static void main(String[] args) {
        List<String> dataList = new ArrayList<>();
        dataList.add("a");
        dataList.add("b");
        dataList.add("c");
        dataList.add("d");
        dataList.add("e");
        for (int i = 0; i < dataList.size(); ++i) {
            String data = dataList.get(i);
            if ("c".equals(data) || "d".equals(data)) {
                dataList.remove(data);
            }
        }
        System.out.println(dataList);
    }
}
