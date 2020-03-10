
public class Solution25 {

    public static class RandomListNode {
        int label;
        RandomListNode next = null;
        RandomListNode random = null;

        RandomListNode(int label) {
            this.label = label;
        }
    }

    public RandomListNode Clone(RandomListNode pHead) {
        if (pHead==null) return null;
        //在旧链表中，复制每一个结点，并将复制的结点插入该结点后面。
        RandomListNode currNode = pHead;
        while (currNode != null) {
            RandomListNode node = new RandomListNode(currNode.label);
            node.next = currNode.next;
            currNode.next = node;
            currNode = node.next;

        }
        //遍历链表，初始化复制结点的random指向。
        currNode = pHead;
        while (currNode != null && currNode.next != null) {
            if (currNode.random!=null)
                currNode.next.random = currNode.random.next;
            currNode = currNode.next.next;
        }
        //将链表拆分为原链表和复制所得链表。
        RandomListNode pCloneHead = pHead.next;
        RandomListNode temp=null;
        currNode = pHead;
        while (currNode.next != null) {
            temp = currNode.next;
            currNode.next = temp.next;
            currNode = temp;
        }
        return pCloneHead;
        /**
         *   var pCloneHead = pHead.next;
         *     var temp = null;
         *     currNode = pHead;
         *     while (currNode.next !== null) {
         *         tmp = currNode.next;
         *         currNode.next = tmp.next;
         *         currNode = tmp;
         *     }
         *     return pCloneHead;
         */
    }

    public static void main(String[] args) {
        Solution25 solution25 = new Solution25();
        RandomListNode n1 = new RandomListNode(11);
        RandomListNode n2 = new RandomListNode(12);
        RandomListNode n3 = new RandomListNode(13);
        RandomListNode n4 = new RandomListNode(14);
        n1.random = n4;
        n2.random = n3;
        n3.random = n2;
        n4.random = n1;

        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        solution25.Clone(n1);

    }
}