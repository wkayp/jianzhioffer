package chapter3;

public class P142_ReverseList {
    public static class ListNode{
        int val;
        ListNode next;
        ListNode(int val){
            this.val=val;
            next=null;
        }
    }
    public static void printListNode(ListNode l){
        if(l==null) return;
        while (l!=null){
            System.out.print(l.val);
            System.out.print(" ");
            l=l.next;
        }
        System.out.println();
        return;
    }
    public static ListNode reverseList(ListNode head){
        if(head==null||head.next==null) return head;
        ListNode pre=null,cur=head;
        while (cur!=null){
            ListNode post= cur.next;
            cur.next=pre;
            pre=cur;
            cur=post;
        }
        return pre;
    }
    public static void main(String[] args){
        ListNode l1=new ListNode(1);
        l1.next=new ListNode(2);
        l1.next.next=new ListNode(3);


        printListNode(l1);//1 2 3
        printListNode(reverseList(l1));//3 2 1
    }
}
