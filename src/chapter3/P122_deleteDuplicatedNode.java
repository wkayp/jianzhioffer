package chapter3;

import chapter2.ListNode;

public class P122_deleteDuplicatedNode {
    public static ListNode<Integer> deleteDuplication(ListNode<Integer> head){
        if(head==null||head.next==null)
            return head;
        ListNode<Integer> pre = null;
        ListNode<Integer> cur = head;
        ListNode<Integer> post = head.next;
        boolean needDelete = false;
        while (post!=null){
            if(cur.val.equals(post.val)){
                needDelete = true;
                post=post.next;
            }
            else if(needDelete && !cur.val.equals(post.val)){//删除cur-post之间部分，考虑是否头节点被删除。
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
        else if(needDelete && pre==null)
            head = null;
        return head;
    }
    public static void main(String[] args){
        ListNode<Integer> head = new ListNode<>(1);
        head.next= new ListNode<>(1);
        head.next.next = new ListNode<>(2);
        head.next.next.next = new ListNode<>(2);
        head.next.next.next.next = new ListNode<>(2);
        head.next.next.next.next.next = new ListNode<>(3);
        System.out.println(head);
        head = deleteDuplication(head);
        System.out.println(head);
    }
}