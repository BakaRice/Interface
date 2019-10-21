

import java.util.ArrayList;
public class Solution {
    public class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }
    /*
    我写的shit
     */
    public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
        if (listNode==null)
            return  null;
        ListNode Nex = listNode.next;
        ListNode temp = listNode.next;
        ListNode pre = new ListNode(listNode.val);

        while(Nex!=null){
            Nex = temp.next;
            temp.next = pre;
            pre = temp;
            temp = Nex;
        }
        temp = pre;//把尾部的指向空回到最后一个结点
        ArrayList<Integer> arrayList = new ArrayList<>();
        while (temp.next!=null)
            arrayList.add(temp.val);
             temp = temp.next;
        return  arrayList;
    }
    /*
    正常调用
     */
    public ArrayList<Integer> printListFromTailToHead1(ListNode listNode) {
            ArrayList<Integer> list = new ArrayList<>();
            ListNode tmp = listNode;
            while(tmp!=null){
                list.add(0,tmp.val);
                tmp = tmp.next;
            }
            return list;
        }
        /*
        递归算法
         */
    ArrayList<Integer> arrayList=new ArrayList<Integer>();
    public ArrayList<Integer> printListFromTailToHead2(ListNode listNode) {
            if(listNode!=null){
                this.printListFromTailToHead(listNode.next);
                arrayList.add(listNode.val);
            }
            return arrayList;
        }
}