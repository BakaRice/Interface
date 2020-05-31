package Leetcode;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.Map;

/**
 * LRU算法的实现
 * 如果想要实现复杂度为O(1),双向链表+哈希表
 * 为什么要双向链表呢？ 因为要实现删除 需要找到他的前驱结点。
 */
public class LeetCode146 {
    class LRUCache {
        class Node {
            public int key, val;
            public Node next, prev;

            public Node(int k, int v) {
                this.key = k;
                this.val = v;
            }
        }

        class DoubleList {
            private Node head, tail; // 头尾虚节点
            private int size; // 链表元素数

            public DoubleList() {
                head = new Node(0, 0);
                tail = new Node(0, 0);
                head.next = tail;
                tail.prev = head;
                size = 0;
            }

            // 在链表头部添加节点 x
            public void addFirst(Node x) {
                x.next = head.next;
                x.prev = head;
                head.next.prev = x;
                head.next = x;
                size++;
            }

            // 删除链表中的 x 节点（x 一定存在）
            public void remove(Node x) {
                x.prev.next = x.next;
                x.next.prev = x.prev;
                size--;
            }

            // 删除链表中最后一个节点，并返回该节点
            public Node removeLast() {
                if (tail.prev == head)
                    return null;
                Node last = tail.prev;
                remove(last);
                return last;
            }

            // 返回链表长度
            public int size() {
                return size;
            }
        }

        // key -> Node(key, val)
        private HashMap<Integer, Node> map;
        // Node(k1, v1) <-> Node(k2, v2)...
        private DoubleList cache;
        // 最大容量
        private int cap;

        public LRUCache(int capacity) {
            this.cap = capacity;
            map = new HashMap<>();
            cache = new DoubleList();
        }

        public int get(int key) {
            if (!map.containsKey(key))
                return -1;
            int val = map.get(key).val;
            put(key, val);
            return val;
        }

        public void put(int key, int value) {
            Node x = new Node(key, value);
            if (map.containsKey(key)) {
                cache.remove(map.get(key));
                cache.addFirst(x);
                map.put(key, x);
            } else {
                if (cap == cache.size()) {
                    Node last = cache.removeLast();
                    map.remove(last.key);
                }
                cache.addFirst(x);
                map.put(key, x);
            }
        }
    }

    class LRUCache2 extends LinkedHashMap<Integer, Integer> {
        private int capacity;

        public LRUCache2(int capacity) {
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
