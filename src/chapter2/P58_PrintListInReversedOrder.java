package chapter2;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;

public class P58_PrintListInReversedOrder {
    //递归版
    public static void printReversinglyRecursively(ListNode<Integer> node){
        if(node==null)
            return;
        else{
            printReversinglyRecursively(node.next);
            System.out.println(node.val);
        }
    }
    //非递归版
    public static void printReversinglyIteratively(ListNode<Integer> node){
        //Stack<Integer> stack = new Stack<>();
        Deque<Integer> stack=new ArrayDeque<>();//注意点2：官方文档推荐使用ArrayDeque代替Stack，注意操作双端队列的头端
        for(ListNode<Integer> temp=node;temp!=null;temp=temp.next)
            //stack.add(temp.val);
            //stack.addFirst(temp.val);
            stack.push(temp.val);//注意点3：ArrayDeque中push方法为，将元素推入此双端队列所表示的堆栈。
        while(!stack.isEmpty())
            //System.out.println(stack.pop());
            //System.out.println(stack.removeFirst());
            System.out.println(stack.poll());//注意点4：ArrayDeque中poll方法为，获取并移除此双端队列所表示的队列的头。类似的有remove方法，但pop方法不移除。
    }
    public static void main(String[] args){
        ListNode<Integer> head = new ListNode<Integer>(1);
        head.next = new ListNode<Integer>(2);
        head.next.next = new ListNode<Integer>(3);
        printReversinglyRecursively(head);
        System.out.println();
        printReversinglyIteratively(head);
    }
}