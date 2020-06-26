package Leetcode;

import java.util.HashMap;
import java.util.UUID;

/**
 * @author RiceFamily
 * @date 2020/6/8 15:52
 */
public class LeetCode990 {
    public boolean equationsPossible(String[] equations) {
        int length = equations.length;
        int[] parent = new int[26];
        for (int i = 0; i < 26; i++) {
            parent[i] = i;
        }
        for (String str : equations) {
            if (str.charAt(1) == '=') {
                int index1 = str.charAt(0) - 'a';
                int index2 = str.charAt(3) - 'a';
                union(parent, index1, index2);
            }
        }
        for (String str : equations) {
            if (str.charAt(1) == '!') {
                int index1 = str.charAt(0) - 'a';
                int index2 = str.charAt(3) - 'a';
                if (find(parent, index1) == find(parent, index2)) {
                    return false;
                }
            }
        }
        return true;
    }

    public void union(int[] parent, int index1, int index2) {
        parent[find(parent, index1)] = find(parent, index2);
    }

    public int find(int[] parent, int index) {
        while (parent[index] != index) {
            parent[index] = parent[parent[index]];  //这句话存在的意义就是在优化并查集的高度 使得查询的速度能够有所提升
            index = parent[index];
        }
        return index;
    }

    public static void main(String[] args) {
        LeetCode990 leetCode990 = new LeetCode990();
        System.out.println(leetCode990.equationsPossible(new String[]{"b==d","c==a","h==a","d==d","a==b","h!=k","i==h"}));
    }
}
