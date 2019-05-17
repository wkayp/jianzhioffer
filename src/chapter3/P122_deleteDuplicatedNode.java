package chapter3;

import chapter2.ListNode;

public class P122_deleteDuplicatedNode {
    public static class ListNode{
        int val;
        ListNode next;
        public ListNode(int val){
            this.val=val;
            this.next=null;
        }
    }
    public static ListNode deleteDuplication(ListNode head){
        if(head==null||head.next==null)
            return head;
        ListNode pre = null;
        ListNode cur = head;
        ListNode post = head.next;
        boolean needDelete = false;
        while (post!=null){
            if(cur.val==post.val){
                needDelete = true;
                post=post.next;
            }
            else if(needDelete && cur.val!=post.val){//删除cur-post之间部分，考虑是否头节点被删除。
                if(pre==null)//注意点1：所有特殊情况都出现在pre指针上，需要针对pre分情况讨论
                    head = post;
                else
                    pre.next=post;
                cur = post;//具体的删除操作
                post = post.next;
                needDelete = false;//注意点2：在完成一次删除操作之后，记得将needDelete置为false，为下一次判断做准备。
            }
            else{
                pre = cur;
                cur = post;
                post = post.next;
            }
        }
        if(needDelete && pre!=null)//尾部删除操作，尾部有重复的数字，例如112333
            pre.next = null;
        else if(needDelete && pre==null)//全部重复
            head = null;
        return head;
    }
    public static void printNode(ListNode node){
        if(node==null)
            System.out.println("no node!");
        ListNode cur=node;
        while (cur.next!=null){
            System.out.print(cur.val+"->");
            cur=cur.next;
        }
        System.out.print(cur.val);
        System.out.println();
    }
    public static void main(String[] args){
        ListNode head = new ListNode(1);
        head.next= new ListNode(1);
        head.next.next = new ListNode(2);
        head.next.next.next = new ListNode(2);
        head.next.next.next.next = new ListNode(2);
        head.next.next.next.next.next = new ListNode(3);
        printNode(head);
        head = deleteDuplication(head);
        printNode(head);
    }
}