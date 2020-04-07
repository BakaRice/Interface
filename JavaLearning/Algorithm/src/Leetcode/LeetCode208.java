package Leetcode;

public class LeetCode208 {
    static class Trie {
        TireNode root;

        class TireNode {
            char val;//本身数值
            boolean canWord;//记录当前节点及其前所有能否组成一个单词
            TireNode[] children = new TireNode[26];//子节点  他不是一个二叉树嗷 不要误解

            public TireNode() {
            }

            public TireNode(char val) {
                this.val = val;
            }
        }

        /**
         * Initialize your data structure here.
         */
        public Trie() {
            root = new TireNode();
        }

        /**
         * Inserts a word into the trie.
         */
        public void insert(String word) {
            TireNode cur = root;
            int len = word.length(), index = 0;
            char c[] = word.toCharArray();
            for (int i = 0; i < len; i++) {
                //char c = word.charAt(i);
                index = c[i] - 'a';
                if (cur.children[index] == null) {
                    cur.children[index] = new TireNode(c[i]);
                }
                cur = cur.children[index];
            }
            cur.canWord = true;
        }

        /**
         * Returns if the word is in the trie.
         */
        public boolean search(String word) {
            TireNode cur = root;
            int len = word.length(), index = 0;
            char c[] = word.toCharArray();
            for (int i = 0; i < len; i++) {
                //char c = word.charAt(i);
                index = c[i] - 'a';
                if (cur.children[index] == null)
                    return false;
                cur = cur.children[index];
            }
            return cur.canWord;
        }

        /**
         * Returns if there is any word in the trie that starts with the given prefix.
         */
        public boolean startsWith(String prefix) {
            TireNode cur = root;
            int len = prefix.length(), index = 0;
            char c[] = prefix.toCharArray();
            for (int i = 0; i < len; i++) {
               // char c = prefix.charAt(i);
                index = c[i] - 'a';
                if (cur.children[index] == null)
                    return false;
                cur = cur.children[index];
            }
            return true;
        }
    }

    /**
     * Your Trie object will be instantiated and called as such:
     * Trie obj = new Trie();
     * obj.insert(word);
     * boolean param_2 = obj.search(word);
     * boolean param_3 = obj.startsWith(prefix);
     */

    public static void main(String[] args) {
        Trie obj = new Trie();
        obj.insert("apple");
        boolean param_2 = obj.search("app");
        System.out.println(param_2);
        obj.insert("app");
        boolean param_4 = obj.search("app");
//        boolean param_3 = obj.startsWith("app");
        System.out.println(param_4);
    }
}
