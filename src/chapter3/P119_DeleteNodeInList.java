package chapter3;


public class P119_DeleteNodeInList {
    public static class ListNode{
        int val;
        ListNode next;
        public ListNode(int val){
            this.val=val;
            this.next=null;
        }
    }
    public static ListNode deleteNode(ListNode head, ListNode node){
        if(head==null||node==null)//注意点1：特殊输入测试
            return head;

        if(node==head){//仅有一个节点（既是头也是尾）
            return head.next;
        }
        else if(node.next==null){//要删除的是尾节点
            ListNode cur=head;
            while (cur.next!=node){//需要在node前一个节点返回
                cur=cur.next;
            }
            cur.next=null;
            return head;
        }
        else{//node.next!=null，
            node.val=node.next.val;
            node.next=node.next.next;
            return head;
        }
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
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        head.next = node2;
        node2.next = node3;
        printNode(head);
        head = deleteNode(head,node3);
        printNode(head);
        head = deleteNode(head,head);
        printNode(head);
    }
}