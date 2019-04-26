package chapter7;
import java.util.*;

public class P326CommonParentInTree {
    public static class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int val){
            this.val=val;
            this.left=null;
            this.right=null;
        }
    }
    public static class ListNode{
        int val;
        ListNode next;
        ListNode(int val){
            this.val=val;
            this.next=null;
        }
    }
    //特殊情况一：当树是一颗二叉搜索树
    public static TreeNode lowparent(TreeNode root,TreeNode root1,TreeNode root2){
        if(root==null||root1==null||root2==null) return null;
        if(root1.val==root.val||root2.val==root.val) return root;//其中一个节点为根节点
        if(root1.val<root.val){
            if(root2.val>root.val) return root;
            else
                return lowparent(root.left,root1,root2);
        }else{
            if(root2.val<root.val) return root;
            return lowparent(root.right,root1,root2);
        }
    }

    //特殊情况二：当树有指向父节点的指针，转换为两个链表的交点处、
    public static ListNode getIntersectionNode(ListNode head1,ListNode head2){
        if(head1==null||head2==null) return null;
        ListNode a=head1,b=head2;
        while (a!=b){
            a=(a!=null)?a.next:head2;
            b=(b!=null)?b.next:head1;
        }
        return a;
    }


    //情况三：二叉树为普通的树
    public static TreeNode lowparent2(TreeNode root,TreeNode root1,TreeNode root2){
        if(root==null||root1==null||root2==null) return null;
        if(root.val==root1.val||root.val==root2.val) return root;
        if(findNode(root.left,root1)){
            if(findNode(root.right,root2)){
                return root;
            }else
                return lowparent2(root.left,root1,root2);
        }else {
            if(findNode(root.left,root2)){
                return root;
            }else {
                return lowparent2(root.right,root1,root2);
            }
        }
    }
    public static boolean findNode(TreeNode root,TreeNode root1){
        if(root==null||root1==null) return false;
        if(root.val==root1.val) return true;
        boolean Foud=findNode(root.left,root1);
        if(!Foud)
            Foud=findNode(root.right,root1);
        return Foud;
    }

    //
    public static class CommonTreeNode{//定义一棵普通的树
        public char val;
        public List<CommonTreeNode> children;
        public CommonTreeNode(char val){
            this.val = val;
            children = new LinkedList<>();
        }
        public void addChildren(CommonTreeNode... children){//java中多参数的传递方法...
            for(CommonTreeNode child:children)
                this.children.add(child);
        }
    }

    // 3.1所述的解法
    public static CommonTreeNode getLastParent1(CommonTreeNode root,CommonTreeNode node1,CommonTreeNode node2){
        if(root==null || node1==null || node2==null || !isInSubTree(root,node1,node2))
            return null;
        CommonTreeNode curNode = root;
        while (true){
            for(CommonTreeNode child:curNode.children){//遍历当前节点的所有子树
                if(isInSubTree(child,node1,node2)){
                    curNode = child;
                    break;
                }
                if(child==curNode.children.get(curNode.children.size()-1))
                    return curNode;
            }
        }
    }
    public static boolean isInSubTree(CommonTreeNode root,CommonTreeNode node1,CommonTreeNode node2){
        Queue<CommonTreeNode> queue = new LinkedList<>();
        CommonTreeNode temp = null;
        int count = 0;
        queue.add(root);
        while (count!=2 && !queue.isEmpty()){
            temp = queue.poll();
            if(temp==node1||temp==node2)
                count++;
            if(!temp.children.isEmpty())
                queue.addAll(temp.children);
        }
        if(count==2)
            return true;
        return false;
    }
    // 3.2所述的解法
    public static CommonTreeNode getLastParent2(CommonTreeNode root,CommonTreeNode node1,CommonTreeNode node2){
        List<CommonTreeNode> path1 = new ArrayList<>();
        List<CommonTreeNode> path2 = new ArrayList<>();
        getPath(root,node1,path1);
        getPath(root,node2,path2);
        CommonTreeNode lastParent = null;
        for(int i=0;i<path1.size()&&i<path2.size();i++){
            if(path1.get(i)==path2.get(i))
                lastParent = path1.get(i);
            else
                break;
        }
        return lastParent;
    }
    public static boolean getPath(CommonTreeNode root,CommonTreeNode node,List<CommonTreeNode> curPath){
        if(root==node)
            return true;
        curPath.add(root);
        for(CommonTreeNode child:root.children){
            if(getPath(child,node,curPath))
                return true;
        }
        curPath.remove(curPath.size()-1);
        return false;
    }

    public static void main(String[] args){
        TreeNode root1=new TreeNode(4);
        root1.left=new TreeNode(2);
        root1.right=new TreeNode(6);
        root1.left.left=new TreeNode(1);
        root1.left.right=new TreeNode(3);
        root1.right.left=new TreeNode(5);
        root1.right.right=new TreeNode(7);
        TreeNode n1= root1.left.left;
        TreeNode n2=root1.left.right;
        System.out.println(lowparent2(root1,n1,n2).val);

        ListNode head1=new ListNode(1);
        head1.next=new ListNode(2);
        head1.next.next=new ListNode(5);
        head1.next.next.next=new ListNode(6);
        ListNode head2=new ListNode(3);
        head2.next=new ListNode(4);
        head2.next.next=head1.next.next;
        //System.out.println(getIntersectionNode(head1,head2).val);



//        CommonTreeNode root = new CommonTreeNode('A');
//        CommonTreeNode b = new CommonTreeNode('B');
//        CommonTreeNode c = new CommonTreeNode('C');
//        CommonTreeNode d = new CommonTreeNode('D');
//        CommonTreeNode e = new CommonTreeNode('E');
//        CommonTreeNode f = new CommonTreeNode('F');
//        CommonTreeNode g = new CommonTreeNode('G');
//        CommonTreeNode h = new CommonTreeNode('H');
//        CommonTreeNode i = new CommonTreeNode('I');
//        CommonTreeNode j = new CommonTreeNode('J');
//        root.addChildren(b,c);
//        b.addChildren(d,e);
//        d.addChildren(f,g);
//        e.addChildren(h,i,j);
//        System.out.println(getLastParent1(root,f,h).val);
//        System.out.println(getLastParent2(root,f,h).val);
//        System.out.println(getLastParent1(root,h,i).val);
//        System.out.println(getLastParent2(root,h,i).val);

    }
}