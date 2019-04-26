package chapter3;

import chapter2.ListNode;

public class P145_MergeSortedLists {
    //递归实现：
    public static ListNode<Integer> mergeSortedList(ListNode<Integer> head1,ListNode<Integer> head2){
        if(head1==null) return head2;
        if(head2==null) return head1;
        ListNode<Integer> head=null;
        if(head1.val<head2.val){
            head=head1;
            head.next=mergeSortedList(head1.next,head2);
        }else {//大于等于的情况都含有
            head=head2;
            head.next=mergeSortedList(head1,head2.next);
        }
        return head;
    }

    //非递归实现：
    public static ListNode<Integer> mergeSortedList2(ListNode<Integer> head1,ListNode<Integer> head2){
        if(head1==null) return head2;
        if(head2==null) return head1;
        ListNode<Integer> temp1=head1;
        ListNode<Integer> temp2=head2;
        ListNode<Integer> temp=null;
        if(temp1.val<temp2.val){//首先将temp指向一个头
            temp=temp1;
            temp1=temp1.next;
        }else{
            temp=temp2;
            temp2=temp2.next;
        }
        while(temp1!=null&&temp2!=null){
            if(temp1.val<temp2.val){
                temp.next=temp1;
                temp=temp.next;//注意点1：必须每次将temp指针向后移动，才能延长链表
                temp1=temp1.next;
            }else {
                temp.next=temp2;
                temp=temp.next;
                temp2=temp2.next;
            }
        }
        if(temp1!=null){
            temp.next=temp1;
            //temp1=temp1.next;//注意点2：不必一个一个移动，temp1本身是连接好的
        }else{
            temp.next=temp2;
            //temp2=temp2.next;
        }
        return head1.val<head2.val?head1:head2;
    }

    public static void main(String[] args){
        ListNode<Integer> head1 = new ListNode<>(1);
        head1.next= new ListNode<>(3);
        head1.next.next = new ListNode<>(5);
        head1.next.next.next = new ListNode<>(7);
        ListNode<Integer> head2 = new ListNode<>(2);
        head2.next= new ListNode<>(4);
        head2.next.next = new ListNode<>(6);
        head2.next.next.next = new ListNode<>(8);
        System.out.println(head1);
        System.out.println(head2);
        ListNode<Integer> head =mergeSortedList2(head1,head2);
        System.out.println(head);
    }
}
