package chapter5;

import chapter2.ListNode;

public class P253_FindFirstCommonNode{
    //解法一：
    public static ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) return null;
        int lenA = getLength(headA), lenB = getLength(headB);
        if (lenA > lenB) {
            for (int i = 0; i < lenA - lenB; ++i) headA = headA.next;
        } else {
            for (int i = 0; i < lenB - lenA; ++i) headB = headB.next;
        }
        while (headA != null && headB != null && headA != headB) {
            headA = headA.next;
            headB = headB.next;
        }
        return (headA != null && headB != null) ? headA : null;//注意点1：考虑两个链表没有公共节点的情况
    }
    public static int getLength(ListNode head) {
        int cnt = 0;
        while (head != null) {
            ++cnt;
            head = head.next;
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
        ListNode<Integer> node1 = new ListNode<>(1);
        ListNode<Integer> node2 = new ListNode<>(2);
        ListNode<Integer> node3 = new ListNode<>(3);
        ListNode<Integer> node4 = new ListNode<>(4);
        ListNode<Integer> node5 = new ListNode<>(5);
        ListNode<Integer> node6 = new ListNode<>(6);
        ListNode<Integer> node7 = new ListNode<>(7);
        node1.next = node2;
        node2.next = node3;
        node3.next = node6;
        node4.next = node5;
        node5.next = node6;
        node6.next = node7;
        ListNode<Integer> commonNode = getIntersectionNode(node1,node4);
        System.out.println(commonNode.val);
        ListNode<Integer> commonNode2 = getIntersectionNode2(node1,node4);
        System.out.println(commonNode2.val);
    }
}
