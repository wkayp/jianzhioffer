package chapter3;

public class P134_KthNodeFromEnd {
    public static class ListNode{
        int val;
        ListNode next;
        public ListNode(int val){
            this.val=val;
            this.next=null;
        }
    }
    public static ListNode findKthToTail(ListNode head,int k){
        if(head==null||k<=0)
            return null;
        ListNode cur=head,fast=head;
        for(int i=0;i<k-1;++i){//注意点1：因为最后快指针停在倒数第一个节点处，所以是i<k-1.
            fast=fast.next;
            if(fast==null)//判断是否小于k
                return null;
        }
        while(fast.next!=null){//注意点2：让快指针最后停在最后一个节点处
            cur = cur.next;
            fast = fast.next;
        }
        return cur;
    }
    public static void main(String[] args){
        ListNode head = new ListNode(1);
        head.next= new ListNode(2);
        head.next.next = new ListNode(3);
        System.out.println(findKthToTail(head,1).val);//3
        System.out.println(findKthToTail(head,2).val);//2
        System.out.println(findKthToTail(head,3).val);//1
        System.out.println(findKthToTail(head,4));//null
    }
}