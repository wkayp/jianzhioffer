package chapter4;
import java.util.ArrayList;
import java.util.ArrayDeque;

public class P171_printTreeInSpecial {
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
    public static ArrayList<ArrayList<Integer>> printFromTopToBottom(TreeNode root){
        ArrayList<ArrayList<Integer>> result=new ArrayList<>();
        ArrayDeque<TreeNode> queue=new ArrayDeque<>();
        queue.addLast(root);
        while (!queue.isEmpty()){
            ArrayList<Integer> level=new ArrayList<>();
            for(int i=queue.size()-1;i>=0;i--){//分层
                TreeNode p=queue.pollFirst();
                level.add(p.val);
                if(p.left!=null)
                    queue.addLast(p.left);
                if(p.right!=null)
                    queue.addLast(p.right);
            }
            result.add(level);
        }
        return result;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);
        System.out.println(printFromTopToBottom(root));//分层打印
    }
}
