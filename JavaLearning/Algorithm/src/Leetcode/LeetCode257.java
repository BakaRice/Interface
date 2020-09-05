package Leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 257. 二叉树的所有路径
 * https://leetcode-cn.com/problems/binary-tree-paths/
 */
public class LeetCode257 {
    //Definition for a binary tree node.
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }


    public List<String> binaryTreePaths(TreeNode root) {
        List<String> res = new ArrayList<>();
        dfs(root, "", res);
        return res;
    }

    //深度优先遍历的方式
    private void dfs(TreeNode root, String path, List<String> res) {
        if (root != null) {
            StringBuffer pathSB = new StringBuffer(path);
            pathSB.append(root.val);
            if (root.left == null && root.right == null) {
                res.add(pathSB.toString());
            } else {
                pathSB.append("->");
                dfs(root.left, pathSB.toString(), res);
                dfs(root.right, pathSB.toString(), res);
            }
        }
    }

    //广度优先遍历的方式 使用 node队列和path队列，实际上是有一一对应的关系的
    private List<String> bfs(TreeNode root) {
        List<String> paths = new ArrayList<>();
        Queue<TreeNode> node_queue = new LinkedList<>();
        Queue<String> path_queue = new LinkedList<>();
        node_queue.offer(root);
        path_queue.offer(Integer.toString(root.val));
        while (!node_queue.isEmpty()) {
            TreeNode node = node_queue.poll();
            String path = path_queue.poll();
            if (node.left == null && node.right == null)
                paths.add(path);
            else {
                if (node.left != null) {
                    node_queue.add(node.left);
                    path_queue.offer(new StringBuffer(path).append("->").append(node.left.val).toString());
                }
                if (node.right != null) {
                    node_queue.add(node.right);
                    path_queue.offer(new StringBuffer(path).append("->").append(node.right.val).toString());
                }
            }
        }
        return paths;
    }

}
