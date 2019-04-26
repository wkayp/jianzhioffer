package chapter4;

import java.util.ArrayDeque;
import java.util.ArrayList;

public class P182_FindPath {
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
    public static boolean hasPathSum(TreeNode root,int sum){//determine if the tree has a root-to-leaf path
        if(root==null) return false;
        if(root.left==null&&root.right==null&&root.val==sum) return true;//递归的终止条件
        return hasPathSum(root.left,sum-root.val)||hasPathSum(root.right,sum-root.val);
    }
    public static ArrayList<ArrayList<Integer>> pathSum(TreeNode root,int sum){
        ArrayList<ArrayList<Integer>> result=new ArrayList<>();
        ArrayList<Integer> out=new ArrayList<>();//ArrayDeque<Integer>
        helper(root,sum,result,out);
        return result;
    }
    public static void helper(TreeNode root,int sum,ArrayList<ArrayList<Integer>> result,ArrayList<Integer> out){
        if(root==null) return;
        out.add(new Integer(root.val));//out.add(root.val)
        if(root.left==null&&root.right==null&&root.val==sum){
            result.add(new ArrayList(out));//每次都要新开辟空间
        }
        helper(root.left,sum-root.val,result,out);
        helper(root.right,sum-root.val,result,out);
        out.remove(out.size()-1);//don't forget to remove the last integer
    }

    public static void main(String[] args){
        int sum=22;
        TreeNode root=new TreeNode(10);
        root.left=new TreeNode(5);
        root.right=new TreeNode(12);
        root.left.left=new TreeNode(2);
        root.left.right=new TreeNode(7);
        System.out.println(hasPathSum(root,sum));
        System.out.println(pathSum(root,sum));
    }
}
