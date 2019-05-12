package chapter2;

import java.util.ArrayDeque;
import java.util.ArrayList;

public class P58_PrintListInReversedOrder {
    public static class Node{
        int val;
        Node next;
        public Node(int val){
            this.val=val;
            this.next=null;
        }
    }
    //递归版
    public static void printReversinglyRecursively(Node node){
        if(node==null)
            return;
        else{
            printReversinglyRecursively(node.next);
            System.out.println(node.val);
        }
    }
    //非递归版
    public static ArrayList<Integer> printReversinglyIteratively2(Node head){
        ArrayList<Integer> res=new ArrayList<>();
        ArrayDeque<Node> stack=new ArrayDeque<>();//官方文档推荐使用ArrayDeque代替Stack，注意操作双端队列的头端
        Node cur=head;
        while (cur!=null){
            stack.addFirst(cur);
            cur=cur.next;
        }
        while (!stack.isEmpty()){
            res.add(stack.pollFirst().val);
        }
        return res;
    }
    public static void main(String[] args){
        Node head=new Node(1);
        head.next=new Node(2);
        head.next.next=new Node(3);
        printReversinglyRecursively(head);
        System.out.println(printReversinglyIteratively2(head));
    }
}