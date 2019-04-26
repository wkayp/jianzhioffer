package IT_haha;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Stack;

public class number3 {
    public static class ListNode{
        int val;
        ListNode next;
        public  ListNode(int val){
            this.val=val;
            this.next=null;
        }
    }
    public static ArrayList<Integer> printListFromTailToHead(ListNode node){
        ArrayList<Integer> result=new ArrayList<>();
        //Stack<Integer> stack=new Stack<>();
        ArrayDeque<Integer> stack=new ArrayDeque<>();//用ArrayDeque代替传统的堆
        while (node!=null){
            stack.offerFirst(node.val);//从头部插入
            node=node.next;
        }
        while (!stack.isEmpty()){
            result.add(stack.pop());
        }
        return result;
    }
    public static void main(String[] args){
        ListNode node=new ListNode(1);
        node.next=new ListNode(3);
        node.next.next=new ListNode(5);
        node.next.next.next=new ListNode(7);
        System.out.println(printListFromTailToHead(node));
    }
}
