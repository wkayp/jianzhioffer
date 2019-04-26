package chapter2;
import java.util.*;

public class P60_TraversalOfBinaryTree {
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
    //前序遍历递归版
    public static ArrayList<Integer> preorderRecursively(TreeNode root){//递归
        ArrayList<Integer> result=new ArrayList<>();
        preoder(root,result);
        return result;
    }
    public static void preoder(TreeNode root,ArrayList<Integer> result){
        if(root==null) return;
        result.add(root.val);
        if(root.left!=null) preoder(root.left,result);
        if(root.right!=null) preoder(root.right,result);
    }

    //中序遍历递归版
    public static ArrayList<Integer> inorderRecursively(TreeNode root){
        ArrayList<Integer> result=new ArrayList<>();
        inorder(root,result);
        return result;
    }
    public static void inorder(TreeNode root,ArrayList<Integer> result){//递归
        if(root==null) return;
        if(root.left!=null) inorder(root.left,result);
        result.add(root.val);
        if(root.right!=null) inorder(root.right,result);
    }

    //后序遍历递归版
    public static ArrayList<Integer> postorderRecursively(TreeNode root){
        ArrayList<Integer> result=new ArrayList<>();
        postorder(root,result);
        return result;
    }
    public static void postorder(TreeNode root,ArrayList<Integer> result){//递归
        if(root==null) return;
        if(root.left!=null) postorder(root.left,result);
        if(root.right!=null) postorder(root.right,result);
        result.add(root.val);
    }

    //前序遍历非递归版
    public static ArrayList<Integer> preorderIteratively(TreeNode root){//非递归
        ArrayList<Integer> result=new ArrayList<>();
        Stack<TreeNode> stack=new Stack<>();
        TreeNode p=root;
        while (!stack.isEmpty()||p!=null){
            if(p!=null){
                stack.add(p);
                result.add(p.val);
                p=p.left;
            }else {
                TreeNode t=stack.pop();
                p=t.right;
            }
        }
        return result;
    }

    //中序遍历非递归版
    public static ArrayList<Integer> inorderIteratively(TreeNode root){//非递归
        ArrayList<Integer> result=new ArrayList<>();
        Stack<TreeNode> stack=new Stack<>();
        TreeNode p=root;
        while(!stack.isEmpty()||p!=null){
            if(p!=null){
                stack.add(p);
                p=p.left;
            }else {
                TreeNode t=stack.pop();
                result.add(t.val);
                p=t.right;
            }
        }
        return result;
    }

    //后序遍历非递归版
    public static ArrayList<Integer> postorderIteratively(TreeNode root){//非递归
        ArrayList<Integer> result=new ArrayList<>();
        Stack<TreeNode> stack=new Stack<>();
        TreeNode p=root;
        while(!stack.isEmpty()||p!=null){
            if(p!=null){
                stack.add(p);
                result.add(0,p.val);//从头插入
                p=p.right;
            }else {
                TreeNode t=stack.pop();
                p=t.left;
            }
        }
        return result;
    }

    //层序遍历
    public static ArrayList<Integer> levelorder(TreeNode root){
        ArrayList<Integer> result=new ArrayList<>();
        ArrayDeque<TreeNode> queue=new ArrayDeque<>();
        queue.addLast(root);
        while (!queue.isEmpty()){
            TreeNode p=queue.pollFirst();
            result.add(p.val);
            if(p.left!=null)
                queue.addLast(p.left);
            if(p.right!=null)
                queue.addLast(p.right);
        }
        return result;
    }

    public static void main(String[] args){
        TreeNode root=new TreeNode(1);
        root.left=new TreeNode(2);
        root.right=new TreeNode(3);
        root.left.left=new TreeNode(4);
        root.left.right=new TreeNode(5);
        root.right.left=new TreeNode(6);
        root.right.right=new TreeNode(7);

        List<Integer> list_preorderRecursively = preorderRecursively(root);
        System.out.print("preorderRecursively: "+'\t');
        System.out.println(list_preorderRecursively.toString());

        List<Integer> list_inorderRecursively = inorderRecursively(root);
        System.out.print("inorderRecursively: "+'\t');
        System.out.println(list_inorderRecursively.toString());

        List<Integer> list_postorderRecursively = postorderRecursively(root);
        System.out.print("postorderRecursively: "+'\t');
        System.out.println(list_postorderRecursively.toString());
        System.out.println();


        List<Integer> list_preorderIteratively = preorderIteratively(root);
        System.out.print("preorderIteratively: "+'\t');
        System.out.println(list_preorderIteratively.toString());

        List<Integer> list_inorderIteratively = inorderIteratively(root);
        System.out.print("inorderIteratively: "+'\t');
        System.out.println(list_inorderIteratively.toString());

        List<Integer> list_postorderIteratively = postorderIteratively(root);
        System.out.print("postorderIteratively: "+'\t');
        System.out.println(list_postorderIteratively.toString());
        System.out.println();

        List<Integer> list_levelorder = levelorder(root);
        System.out.print("levelorder: "+'\t');
        System.out.println(list_levelorder.toString());
    }
}

