package chapter3;

import chapter2.ListNode;

public class P134_KthNodeFromEnd {
    public static ListNode<Integer> findKthToTail(ListNode<Integer> head,int k){
        if(head==null||k<=0)
            return null;
        ListNode<Integer> slow=head,fast=head;
        for(int i=0;i<k-1;++i){//注意点1：因为最后快指针停在倒数第一个节点处，所以是i<k-1.
            if(fast.next!=null)
                fast = fast.next;
            else
                return null;
        }
        while(fast.next!=null){//注意点2：让快指针最后停在最后一个节点处
            slow = slow.next;
            fast = fast.next;
        }
        return slow;
    }
    public static void main(String[] args){
        ListNode<Integer> head = new ListNode<>(1);
        head.next= new ListNode<>(2);
        head.next.next = new ListNode<>(3);
        System.out.println(findKthToTail(head,1).val);//3
        System.out.println(findKthToTail(head,2).val);//2
        System.out.println(findKthToTail(head,3).val);//1
        System.out.println(findKthToTail(head,4));//null
    }
}