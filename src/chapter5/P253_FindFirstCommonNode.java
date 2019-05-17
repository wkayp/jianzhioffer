package chapter5;

public class P253_FindFirstCommonNode{
    public static class ListNode{
        int val;
        ListNode next;
        public ListNode(int val){
            this.val=val;
            this.next=null;
        }
    }
    //解法一：
    public static ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) return null;
        ListNode cur1=headA,cur2=headB;
        int lenA = getLength(cur1), lenB = getLength(cur2);
        if (lenA > lenB) {
            for (int i = 0; i < lenA - lenB; ++i) cur1 = cur1.next;
        } else {
            for (int i = 0; i < lenB - lenA; ++i) cur2 = cur2.next;
        }
        while (cur1 != null && cur2 != null && cur1 != cur2) {
            cur1 = cur1.next;
            cur2 = cur2.next;
        }
        return (cur1 != null && cur2 != null) ? cur1 : null;//注意点1：考虑两个链表没有公共节点的情况
    }
    public static int getLength(ListNode head) {
        int cnt = 0;
        ListNode cur=head;
        while (cur != null) {
            ++cnt;
            cur = cur.next;
        }
        return cnt;
    }

    //解法二：
    public static ListNode getIntersectionNode2(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) return null;//注意点1：特殊情况一定要考虑
        ListNode a = headA, b = headB;
        while (a != b) {
            a = (a != null) ? a.next : headB;//注意点2：条件运算符用得恰当的话，可以简化代码
            b = (b != null) ? b.next : headA;
        }
        return a;
    }

    public static void main(String[] args){
        // 1->2->3->6->7
        //    4->5↗
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);
        ListNode node6 = new ListNode(6);
        ListNode node7 = new ListNode(7);
        node1.next = node2;
        node2.next = node3;
        node3.next = node6;
        node4.next = node5;
        node5.next = node6;
        node6.next = node7;
        ListNode commonNode = getIntersectionNode(node1,node4);
        System.out.println(commonNode.val);
        ListNode commonNode2 = getIntersectionNode2(node1,node4);
        System.out.println(commonNode2.val);
    }
}
