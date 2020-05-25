package exam;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class ForthParadigm03 {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int k = s.nextInt();
        int capacity = s.nextInt();

        LRUCache lruCache = new LRUCache(capacity);
        for (int i = 0; i < k; i++) {
            String operate = s.next();
            if (operate.equals("GET")) {
                System.out.println(lruCache.get(s.nextInt()));
            } else if (operate.equals("PUT")) {
                lruCache.put(s.nextInt(), s.nextInt());
            }
        }

    }

    static class LRUCache extends LinkedHashMap<Integer, Integer> {

        private int capacity;

        LinkedHashMap list = new LinkedHashMap();

        public LRUCache(int capacity) {
            super(capacity, 0.75F, true);
            this.capacity = capacity;
        }

        public int get(int key) {
            return super.getOrDefault(key, -1);
        }

        public void put(int key, int value) {
            super.put(key, value);
        }

        @Override
        protected boolean removeEldestEntry(Map.Entry<Integer, Integer> eldest) {
            return super.size() > capacity;
        }
    }
}
