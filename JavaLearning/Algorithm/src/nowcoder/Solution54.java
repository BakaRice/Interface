package nowcoder;

//记得要考虑使用辅助头结点来帮助
public class Solution54 {

    public static class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }

    public ListNode deleteDuplication(ListNode pHead) {
        if (pHead == null) return null;
        ListNode teamnode = new ListNode(Integer.MAX_VALUE);//当作头节点
        teamnode.next = pHead;
        pHead = teamnode;
        while (teamnode.next != null) {
            System.out.println(teamnode.val);
            while (teamnode.next.next != null && teamnode.next.val == teamnode.next.next.val) {
                int delete = teamnode.next.val;
                while (teamnode.next != null && teamnode.next.val == delete) {
                    teamnode.next = teamnode.next.next;
                }
                if (teamnode.next == null) return pHead.next;
            }
            teamnode = teamnode.next;
        }
        return pHead.next;
    }


    public ListNode deleteDuplication2(ListNode pHead){
        if(pHead == null || pHead.next == null){
            return pHead;
        }
        // 自己构建辅助头结点
        ListNode head = new ListNode(Integer.MIN_VALUE);
        head.next = pHead;
        ListNode pre = head;
        ListNode cur = head.next;
        while(cur!=null){
            if(cur.next != null && cur.next.val == cur.val){
                // 相同结点一直前进
                while(cur.next != null && cur.next.val == cur.val){
                    cur = cur.next;
                }
                // 退出循环时，cur 指向重复值，也需要删除，而 cur.next 指向第一个不重复的值
                // cur 继续前进
                cur = cur.next;
                // pre 连接新结点
                pre.next = cur;
            }else{
                pre = cur;
                cur = cur.next;
            }
        }
        return head.next;
    }

    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(1);
        ListNode node3 = new ListNode(2);
        ListNode node4 = new ListNode(2);
        ListNode node5 = new ListNode(3);
        ListNode node6 = new ListNode(3);
        ListNode node7 = new ListNode(5);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = node6;
        node6.next = node7;
        Solution54 solution54 = new Solution54();
        System.out.println(solution54.deleteDuplication(node1));

    }
}
