package chapter4;

import chapter2.ComplexListNode;

public class P187_CopyComplexList {
    //解法三
    //time:o(n) space:o(1)
    public static ComplexListNode clone3(ComplexListNode head) {
        if(head==null)
            return null;
        cloneNodes(head);
        connectRandomNodes(head);
        return reconnectNodes(head);
    }

    public static void cloneNodes(ComplexListNode head){
        ComplexListNode cur = head;
        ComplexListNode temp = null;//注意点1：可以先声明之后要用的变量，但这样会扩大temp的作用范围。
        while (cur!=null){
            temp = new ComplexListNode(cur.val);//创建新节点，以备链接
            temp.next = cur.next;
            cur.next = temp;
            cur = cur.next.next;//直接跳过刚复制的新节点
        }
    }

    public static void connectRandomNodes(ComplexListNode head){
        ComplexListNode cur=head;
        //ComplexListNode curNext=head.next;//注意点2：同上，将变量声明放在循环内部
        while(cur!=null){//注意点3：最好不用true无限循环的方式
            ComplexListNode curNext=cur.next;
            if(cur.random!=null)
                curNext.random=cur.random.next;
            cur=cur.next.next;
        }
    }

    public static ComplexListNode reconnectNodes(ComplexListNode head){
        ComplexListNode newHead = head.next;//用于最后返回复制之后的链表头
        ComplexListNode cur = head;
        ComplexListNode newCur = newHead;
        while (cur!=null){
            cur.next = cur.next.next;
            cur = cur.next;//指向单数的下一个节点
            if(cur==null){
                newCur.next = null;
                break;
            }
            newCur.next = newCur.next.next;//注意点3：只要cur不空，newcur必然不为空，直接移到下一个复制出的节点即可
            newCur = newCur.next;//指向偶数的下一个节点
        }
        return newHead;
    }
    public static void main(String[] args){
        ComplexListNode head = new ComplexListNode(1);
        ComplexListNode c2 = new ComplexListNode(2);
        ComplexListNode c3 = new ComplexListNode(3);
        ComplexListNode c4 = new ComplexListNode(4);
        ComplexListNode c5 = new ComplexListNode(5);
        head.next = c2;
        head.random = c3;
        head.next.next = c3;
        head.next.random = c5;
        head.next.next.next = c4;
        head.next.next.next.next = c5;
        head.next.next.next.random = c2;
        System.out.println("original:"+'\t'+head);
//        System.out.println("clone1:  "+'\t'+clone1(head));
//        System.out.println("clone2:  "+'\t'+clone2(head));
        System.out.println("clone3:  "+'\t'+clone3(head));
    }
}