package chapter6;

import java.util.ArrayDeque;

public class P271_TreeDepth {
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
    //递归
    public static int treeDepth(TreeNode root){
        if(root==null)
            return 0;
        return 1+Math.max(treeDepth(root.left),treeDepth(root.right));
    }
    //非递归，广度优先/层序遍历
    public static int treeDepth2(TreeNode root){
        if(root==null) return 0;
        ArrayDeque<TreeNode> queue=new ArrayDeque<>();
        queue.addLast(root);
        int deep=0;
        while (!queue.isEmpty()){
            deep++;
            for(int i=queue.size();i>0;i--){
                TreeNode p=queue.pollFirst();
                if(p.left!=null) queue.addLast(p.left);
                if(p.right!=null) queue.addLast(p.right);
            }
        }
        return deep;
    }

    //二叉树的最小深度，问题
    //递归
    public static int mintreeDepth(TreeNode root){
        if(root==null)
            return 0;
        return 1+Math.min(treeDepth(root.left),treeDepth(root.right));
    }
    //非递归，广度优先/层序遍历
    public static int mintreeDepth2(TreeNode root){
        if(root==null) return 0;
        ArrayDeque<TreeNode> queue=new ArrayDeque<>();
        queue.addLast(root);
        int deep=0;
        while (!queue.isEmpty()){
            deep++;
            for(int i=queue.size();i>0;i--){
                TreeNode p=queue.pollFirst();
                if(p.left==null&&p.right==null) return deep;//当遇到叶子节点，即找到最小深度，返回
                if(p.left!=null) queue.addLast(p.left);
                if(p.right!=null) queue.addLast(p.right);
            }
        }
        return -1;
    }
    public static void main(String[] args){
        TreeNode root=new TreeNode(1);
        root.left=new TreeNode(2);
        root.right=new TreeNode(3);
        root.left.left=new TreeNode(4);
        root.left.right=new TreeNode(5);
//        root.right.left=new TreeNode(6);
//        root.right.right=new TreeNode(7);
        System.out.println(treeDepth(root));
        System.out.println(treeDepth2(root));
        System.out.println(mintreeDepth(root));
        System.out.println(mintreeDepth2(root));
    }
}
