package chapter3;

import chapter2.ListNode;

public class P139_MeetingNode {
    public static class ListNode{
        int val;
        ListNode next;
        public ListNode(int val){
            this.val=val;
            this.next=null;
        }
    }
    public static ListNode meetingNode(ListNode head){
        if(head==null||head.next==null)
            return null;
        ListNode fast=head,slow=head;
        while(fast!=null&&fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;
            //if(slow!=null&&slow==fast)//注意点1：不需要单独讨论slow，因为fast在slow前面，讨论fast是否为空即可
            if(slow==fast)  break;
        }
        if(fast==null||fast.next==null) return null;//注意点2：没有环，则直接返回null。
        slow=head;
        while(slow!=fast){
            slow=slow.next;
            fast=fast.next;
        }
        return slow;
    }

    public static void main(String[] args){
        ListNode head = new ListNode(1);
        head.next= new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        head.next.next.next.next.next = new ListNode(6);
        head.next.next.next.next.next.next =head.next.next ;
        System.out.println(meetingNode(head).val);
    }
}
