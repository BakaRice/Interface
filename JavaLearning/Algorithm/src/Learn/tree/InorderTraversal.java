package Learn.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class InorderTraversal {
    private class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        helper(root, res);
        return res;
    }

    //中序 递归 遍历二叉树
    public void helper(TreeNode root, List<Integer> res) {
        if (root != null) {
            if (root.left != null) {
                helper(root.left, res);
            }
            res.add(root.val);
            if (root.right != null) {
                helper(root.right, res);
            }
        }
    }

    /**中序 非递归 遍历二叉树
     * 有左子树时，向下遍历左子树，并且使用栈的方式记录遍历的路径。
     * 在发现不存在左子树时，将当前的无左子树的节点弹出，输出并且寻找他的右子树。
     * 总结就是不断的寻找左子树，在没有左子树的情况下，迫不得寻找右子树，但一定有左子树又会继续寻找左子树。
     * 将保存的寻找路径弹出即为中序遍历的过程。
     * https://blog.csdn.net/qq_40693171/article/details/99745321
     * @param root
     * @return
     */
    public List<Integer> inorderTraversal_2(TreeNode root) {
        LinkedList<TreeNode> stack = new LinkedList<>();
        LinkedList<Integer> ans = new LinkedList<>();
        TreeNode curr = root;
        while (curr != null || !stack.isEmpty()) {
            //节点不为空一直压栈
            while (curr != null) {
                stack.addLast(curr);
                curr = curr.left;//压入左子树
            }
            //左子树为空，出栈
            curr = stack.pollLast();
            ans.addLast(curr.val);
            //考虑右子树
            curr = curr.right;
        }
        return ans;
    }
}
