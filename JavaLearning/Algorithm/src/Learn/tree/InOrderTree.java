package Learn.tree;


import java.util.Stack;

public class InOrderTree {

    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }



    /*
    二叉搜索树 本质也就是 二叉树的中序遍历有序
     */

    //递归写法
    int prev = Integer.MIN_VALUE;
    boolean flag = true;

    public boolean isValidBST_recursive(TreeNode root) {
        if (root == null) return true;
        if (root.left != null) {
            boolean validBSTleft = isValidBST_recursive(root.left);
            if (!validBSTleft) return false;
        }

        if (flag) {
            prev = root.val;
            flag = false;
        } else if (prev >= root.val) return false;
        prev = root.val;

        if (root.right != null) {
            boolean validBSTright = isValidBST_recursive(root.right);
            if (!validBSTright) return false;
        }
        return true;
    }

    //辅助栈 非递归写法
    public boolean isValidBST_stack(TreeNode root) {
        Stack<TreeNode> stack = new Stack();
        double inorder = -Double.MAX_VALUE;

        while (!stack.isEmpty() || root != null) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            // 如果中序遍历得到的节点的值小于等于前一个 inorder，说明不是二叉搜索树
            if (root.val <= inorder) return false;
            inorder = root.val;
            root = root.right;
        }
        return true;
    }

}
