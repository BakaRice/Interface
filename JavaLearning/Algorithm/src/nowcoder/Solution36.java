package nowcoder;
/*
输入一棵二叉树，求该树的深度。从根结点到叶结点依次经过的结点（含根、叶结点）形成树的一条路径，最长路径的长度为树的深度。
 可以自己定义一个包含次数的结构体或者类用队列或者栈进行遍历找到最大
 */

import java.util.LinkedList;

class TreeNode {
    int val = 0;
    TreeNode left = null;
    TreeNode right = null;

    public TreeNode(int val) {
        this.val = val;

    }

}

public class Solution36 {
    public int TreeDepth(TreeNode root) {
        if (root == null) return 0;
        return Math.max(TreeDepth(root.left), TreeDepth(root.right)) + 1;
    }

    /**
     * 求二叉树的深度（不使用递归）
     *
     * @param root
     * @return
     */
    public int getHeight2(TreeNode root) {
        if (root == null) {
            return 0;
        }
        LinkedList<TreeNode> list = new LinkedList<>();
        list.offer(root);
        //最大宽度留备用
        int max = 0;
        //二叉树的深度
        int level = 0;
        //本层中元素总数
        int size = 0;
        //本层已经访问过的元素个数
        int cur = 0;
        while (!list.isEmpty()) {
            size = list.size();
            max = Math.max(max, size);
            cur = 0;
            while (cur < size) {
                TreeNode node = list.poll();
                cur++;
                if (node.left != null) {
                    list.offer(node.left);
                }
                if (node.right != null) {
                    list.offer(node.right);
                }
            }
            level++;
        }
        System.out.println("二叉树最大宽度为:" + max);
        return level;
    }
}
