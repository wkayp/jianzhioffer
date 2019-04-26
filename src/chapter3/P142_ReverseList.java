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
        ListNode newhead=null;
        while (head!=null){
            ListNode temp=head.next;
            head.next=newhead;
            newhead=head;
            head=temp;
        }
        return newhead;
    }
    public static void main(String[] args){
        ListNode l1=new ListNode(1);
        l1.next=new ListNode(2);
        l1.next.next=new ListNode(3);

        printListNode(l1);//1 2 3
        printListNode(reverseList(l1));//3 2 1
    }
}
