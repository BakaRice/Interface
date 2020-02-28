import java.util.ArrayList;
import java.util.Stack;

public class Solution26 {
    public class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;

        }

    }

    public TreeNode Convert(TreeNode pRootOfTree) {
        Stack<TreeNode> q1 = new Stack();
        TreeNode preNode=null;//前
        TreeNode headNode=null;
        while(!q1.isEmpty()||pRootOfTree!=null)
        {
            if (pRootOfTree!=null) {
                q1.push(pRootOfTree);
                pRootOfTree=pRootOfTree.left;

            }
            else {
                pRootOfTree=q1.pop();//弹出
                if(preNode==null){preNode=pRootOfTree;headNode=preNode;}
                else
                {
                    preNode.right=pRootOfTree;
                    pRootOfTree.left=preNode;
                }
                preNode=pRootOfTree;
                pRootOfTree=pRootOfTree.right;
            }
        }
        return headNode;
    }

    public ArrayList<TreeNode> zhongxv(TreeNode t) {
        ArrayList<TreeNode> list = new ArrayList<>();
        Stack<TreeNode> stack1 = new Stack<>();
        if (t == null) return list;
        if (t != null) stack1.push(t);
        TreeNode t1 = stack1.peek();
        while (t1.left != null) {
            t1 = t1.left;
            stack1.push(t1);
        }
        while (!stack1.isEmpty()) {
            TreeNode t2 = stack1.pop();
            //System.out.println(t2.val + " ");
            list.add(t2);
            if (t2.right != null) {
                t2 = t2.right;
                stack1.push(t2);
                while (t2.left != null) {
                    t2 = t2.left;
                    stack1.push(t2);
                }
            }
        }
        return list;
    }

//    public TreeNode Convertv(TreeNode pRootOfTree, int vector) {
//        if (isLeaf(pRootOfTree.left))
//            pRootOfTree.left = pRootOfTree;
//        if (isLeaf(pRootOfTree.right))
//            pRootOfTree.right = pRootOfTree;
//        if (vector == -1) {
//            while (pRootOfTree.right != null)
//                pRootOfTree = pRootOfTree.right;
//            return pRootOfTree;
//        }
//        if (vector == 1) {
//            while (pRootOfTree.left != null)
//                pRootOfTree = pRootOfTree.left;
//        }
//        if (pRootOfTree.left != null) pRootOfTree.left = Convertv(pRootOfTree.left, -1);
//        if (pRootOfTree.right != null) pRootOfTree.right = Convertv(pRootOfTree.right, 1);
//
//    }
//
//    public boolean isLeaf(TreeNode node) {
//        if (node.right == null && node.left == null)
//            return true;
//        else return false;
//    }
}