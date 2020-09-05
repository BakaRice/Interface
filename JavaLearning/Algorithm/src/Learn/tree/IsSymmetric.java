package Learn.tree;

import java.util.LinkedList;
import java.util.Queue;

public class IsSymmetric {
    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    //递归 判断是否为对称二叉树
    public boolean isSymmetric(TreeNode root) {
        if (root == null) return true;
        boolean ans = helper(root.left, root.right);
        return ans;
    }

    private boolean helper(TreeNode leftNode, TreeNode rightNode) {
        if (leftNode == null && rightNode == null) return true;
        if (leftNode != null && rightNode != null) {
            if (leftNode.val != rightNode.val) return false;
            return helper(leftNode.left, rightNode.right) && helper(leftNode.right, rightNode.left);
        }

        return false;
    }

    //非递归遍历 本质上递归是把内容压入递归栈内，再弹出。所以如果能采用队列的方式将递归加以模拟，则可以达到迭代的写法。
    public boolean isSymmetric_2(TreeNode root) {
        if (root == null) return true;
        boolean iss = check(root, root);
        return iss;
    }

    private boolean check(TreeNode leftNode, TreeNode rightNode) {

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(leftNode);
        queue.add(rightNode);
        while (!queue.isEmpty()) {
            TreeNode pollLeft = queue.poll();
            TreeNode pollRight = queue.poll();
            if (pollLeft == null && pollRight == null) continue;
            //或的短路性质 两个判断条件不能反写
            if ((pollLeft == null || pollRight == null) || pollLeft.val != pollRight.val) return false;


            queue.add(pollLeft.right);
            queue.add(pollRight.left);

            queue.add(pollRight.right);
            queue.add(pollLeft.left);

        }
        return true;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode node0_1 = new TreeNode(2);
        TreeNode node0_2 = new TreeNode(2);
        TreeNode node1_1 = new TreeNode(3);
        TreeNode node1_2 = new TreeNode(4);
        TreeNode node1_3 = new TreeNode(4);
        TreeNode node1_4 = new TreeNode(3);

        root.left = node0_1;
        root.right = node0_2;
        node0_1.left = node1_1;
        node0_1.right = node1_2;
        node0_2.left = node1_3;
        node0_2.right = node1_4;
        IsSymmetric isSymmetric = new IsSymmetric();
        isSymmetric.isSymmetric(root);
    }
}
