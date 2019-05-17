package chapter3;


public class P145_MergeSortedLists {
    public static class ListNode{
        int val;
        ListNode next;
        public ListNode(int val){
            this.val=val;
            this.next=null;
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
    //递归实现：
    public static ListNode mergeSortedList(ListNode head1,ListNode head2){
        if(head1==null) return head2;
        if(head2==null) return head1;
        ListNode cur=null;
        if(head1.val<head2.val){
            cur=head1;
            cur.next=mergeSortedList(head1.next,head2);
        }else {//大于等于的情况都含有
            cur=head2;
            cur.next=mergeSortedList(head1,head2.next);
        }
        return cur;
    }

    //非递归实现：
    public static ListNode mergeSortedList2(ListNode head1,ListNode head2){
        if(head1==null) return head2;
        if(head2==null) return head1;
        ListNode cur1=head1;
        ListNode cur2=head2;
        ListNode cur=null;
        if(cur1.val<cur2.val){//首先将temp指向一个头
            cur=cur1;
            cur1=cur1.next;
        }else{
            cur=cur2;
            cur2=cur2.next;
        }
        while(cur1!=null&&cur2!=null){
            if(cur1.val<cur2.val){
                cur.next=cur1;
                cur1=cur1.next;
            }else {
                cur.next=cur2;
                cur2=cur2.next;
            }
            cur=cur.next;//注意点1：必须每次将temp指针向后移动，才能延长链表
        }
        if(cur1!=null){
            cur.next=cur1;
            //cur1=cur1.next;//注意点2：不必一个一个移动，temp1本身是连接好的
        }else{
            cur.next=cur2;
            //cur2=cur2.next;
        }
        return head1.val<head2.val?head1:head2;
    }

    public static void main(String[] args){
        ListNode head1 = new ListNode(1);
        head1.next= new ListNode(3);
        head1.next.next = new ListNode(5);
        head1.next.next.next = new ListNode(7);
        ListNode head2 = new ListNode(2);
        head2.next= new ListNode(4);
        head2.next.next = new ListNode(6);
        head2.next.next.next = new ListNode(8);
        printListNode(head1);
        printListNode(head2);
        ListNode head =mergeSortedList2(head1,head2);
        printListNode(head);
    }
}
