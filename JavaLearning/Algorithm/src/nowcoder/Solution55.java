package nowcoder;

import java.util.Stack;

public class Solution55 {
    public class TreeLinkNode {
        int val;
        TreeLinkNode left = null;
        TreeLinkNode right = null;
        TreeLinkNode next = null;

        TreeLinkNode(int val) {
            this.val = val;
        }
    }

    public TreeLinkNode GetNext(TreeLinkNode pNode) {
        if (pNode.right != null) {
            pNode = pNode.right;
            while (pNode.left != null)
                pNode = pNode.left;
        }
        else if (pNode.next!=null&&pNode.next.left==pNode) {
            pNode=pNode.next;
        }
        else {
            while (pNode.next!=null&&pNode.next.right==pNode) {
                pNode=pNode.next;
            }
            if(pNode.next!=null)pNode=pNode.next;
            else {
                pNode=null;
            }
        }
        return pNode;
    }
}
