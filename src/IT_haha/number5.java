package IT_haha;

import java.util.ArrayDeque;

public class number5 {
    public static ArrayDeque<Integer> stack1=new ArrayDeque<>();
    public static ArrayDeque<Integer> stack2=new ArrayDeque<>();
    public  void push(int val){
        stack1.offerFirst(val);
    }
    public  int pop()throws Exception{
        if(stack1.isEmpty()&&stack2.isEmpty())
            throw new Exception("stack is empty");
        if(!stack2.isEmpty())
            return stack2.pop();
        while (!stack1.isEmpty()){
            stack2.offerFirst(stack1.pop());
        }
        return stack2.pop();
    }
    public static void main(String[] args)throws Exception{
        number5 queue=new number5();
        queue.push(1);
        queue.push(2);
        queue.push(3);
        System.out.println(queue.pop());
        System.out.println(queue.pop());
        System.out.println(queue.pop());
        //System.out.println(queue.pop());
    }
}
