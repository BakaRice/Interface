package Leetcode;

import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.Map;
import java.util.Queue;

public class LeetCode460 {
    static class LFUCache {

        class KV {
            int key;
            int value;
            KV next_kv;

            public KV(int key, int value) {
                this.key = key;
                this.value = value;
            }

            public KV() {
            }
        }

        int capacity = 0;
        int len = 0;
        KV head = new KV(-1, -1);


        public LFUCache(int capacity) {
            this.capacity = capacity;
        }

        public int get(int key) {
            KV target = new KV();
            KV pre = head;
            KV currget = head.next_kv;
            int value = -1;
            while (currget != null) {
                if (currget.key == key) {
                    target.key = key;
                    target.value = currget.value;
                    value = target.value;
                    pre.next_kv = currget.next_kv;
                } else {
                    pre = currget;
                }
                currget = currget.next_kv;
            }
            if (value != -1)
                pre.next_kv = target;
            return value;
        }

        public void put(int key, int value) {
            KV curr1 = head;
            if (get(key) != -1) {
                while (curr1.next_kv != null)
                    curr1 = curr1.next_kv;
                curr1.value = value;
                return;
            }
            if (len == capacity) {
                head = head.next_kv;
                len--;
            }
            if (len == 0) {
                head.next_kv = new KV(key, value);
            } else {
                KV curr = head.next_kv;
                if (curr.next_kv != null) {
                    curr = curr.next_kv;
                }
                curr.next_kv = new KV(key, value);
            }

            len++;
        }
    }

    public static void main(String[] args) {
        LFUCache cache = new LFUCache(2);
//        cache.put(1, 1);
//        cache.put(2, 2);
//        System.out.println(cache.get(1)); //1
//        cache.put(3, 3);    // 去除 key 2
//        System.out.println(cache.get(2));//-1
//        System.out.println(cache.get(3));//3
//        cache.put(4, 4);    // 去除 key 1
//        System.out.println(cache.get(1));//-1
//        System.out.println(cache.get(3));//3
//        System.out.println(cache.get(4));//4
        cache.put(2, 1);
        cache.put(1, 1);
        cache.put(2, 3);
        cache.put(4, 1);
        System.out.println(cache.get(1));
        System.out.println(cache.get(2));
    }
}
