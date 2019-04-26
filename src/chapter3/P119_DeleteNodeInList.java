package chapter3;

import chapter2.ListNode;

public class P119_DeleteNodeInList {
    public static ListNode<Integer> deleteNode(ListNode<Integer> head, ListNode<Integer> node){
        if(head==null||node==null)//注意点1：特殊输入测试
            return head;

        if(node==head){//仅有一个节点（既是头也是尾）
            return head.next;
        }
        else if(node.next!=null){//要删除的不是尾节点
            node.val = node.next.val;
            node.next = node.next.next;
            return head;
        }
        else{//node.next==null，即删除尾节点，则仍然从链表的头节点开始，顺序遍历，完成删除。
            ListNode<Integer> temp=head;
            while(temp.next!=node)//注意点2：需要在node前一个节点返回。
                temp = temp.next;
            temp.next = null;
            return head;
        }
    }
    public static void main(String[] args){
        ListNode<Integer> head = new ListNode<>(1);
        ListNode<Integer> node2 = new ListNode<>(2);
        ListNode<Integer> node3 = new ListNode<>(3);
        head.next = node2;
        node2.next = node3;
        System.out.println(head);
        head = deleteNode(head,node3);
        System.out.println(head);
        head = deleteNode(head,head);
        System.out.println(head);
//        head = deleteNode(head,head);
//        System.out.println(head);
//        head = deleteNode(head,head);
//        System.out.println(head);
    }
}