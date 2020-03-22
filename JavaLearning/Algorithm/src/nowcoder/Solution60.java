package nowcoder;

import java.util.ArrayList;
import java.util.Stack;

public class Solution60 {
    class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;

        }

    }

    ArrayList<TreeNode> list = new ArrayList<>(); // (1)

    TreeNode KthNode(TreeNode pRoot, int k) {

        addNode(pRoot);

        if (k >= 1 && list.size() >= k) {
            return list.get(k - 1);
        }

        return null;
    }

    // 中序遍历 递归
    void addNode(TreeNode cur) {   // (2)
        if (cur != null) {
            addNode(cur.left);
            list.add(cur);
            addNode(cur.right);
        }
    }

    //中序 非递归
    void addNode2(TreeNode cur) {
        Stack<TreeNode> stack = new Stack<>();
        // Stack<TreeNode> stack1 = new Stack<>();
        stack.push(cur);
        if (cur == null) return;
        while (cur.left != null) {
            cur = cur.left;
            stack.push(cur);
        }
        while (!stack.isEmpty()) {
            cur = stack.pop();
            //  stack1.push(cur);
            list.add(cur);
            if (cur.right != null) {
                cur = cur.right;
                stack.push(cur);
                while (cur.left != null) {
                    cur = cur.left;
                    stack.push(cur);
                }
            }
        }
    }

    //中序遍历 非递归
    void addNode3(TreeNode cur) {
        Stack<TreeNode> stack = new Stack<>();
        if (cur.left==null&&cur.right==null)return;
        if (cur==null)return;
        if (cur.val==0) return;
        while (!stack.isEmpty() || cur != null) {
            if (cur.left != null) {
                stack.push(cur);
                cur = cur.left;
            } else {
                if (stack.isEmpty()) return;
                cur = stack.pop();
                list.add(cur);
                cur = cur.right;
            }
        }
    }
}
