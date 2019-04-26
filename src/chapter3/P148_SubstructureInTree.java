package chapter3;

public class P148_SubstructureInTree {
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
    public static boolean hasSubtree(TreeNode root1, TreeNode root2){
        boolean result=false;
        if(root1!=null&&root2!=null){
            if(root1.val==root2.val)
                result=tree1HasTree2FromRoot(root1,root2);
            if(!result)//上述没有找到
                result=hasSubtree(root1.left,root2);
            if(!result)//左子树没有找到
                result=hasSubtree(root1.right,root2);
        }
        return result;
    }
    public static boolean tree1HasTree2FromRoot(TreeNode root1, TreeNode root2){
        if(root2==null)
            return true;
        if(root1==null)
            return false;
        if(root1.val!=root2.val)
            return false;
       return tree1HasTree2FromRoot(root1.left,root2.left)&&tree1HasTree2FromRoot(root1.right,root2.right);

    }

    //[LeetCode NO.572] Subtree of Another Tree 另一个树的子树
    public static boolean isSameTree(TreeNode root1,TreeNode root2){
        if(root1==null&&root2==null) return true;
        if((root1==null&&root2!=null)||(root1!=null&&root2==null)||(root1.val!=root2.val)) return false;
        return isSameTree(root1.left,root2.left)&&isSameTree(root1.right,root2.right);
    }
    public static boolean isSubtree(TreeNode root1,TreeNode root2){
        if(root1==null) return false;
        boolean result=false;
        result=isSameTree(root1,root2);
        if(!result)
            result=isSubtree(root1.left,root2);
        if(!result)
            result=isSubtree(root1.right,root2);
        return result;
    }

    public static void main(String[] args){
        TreeNode root1 = new TreeNode(8);
        root1.left = new TreeNode(8);
        root1.right = new TreeNode(7);
        root1.left.left = new TreeNode(9);
        root1.left.right = new TreeNode(2);
        root1.left.right.left = new TreeNode(4);
        root1.left.right.right = new TreeNode(7);
        TreeNode root2 = new TreeNode(8);
        root2.left = new TreeNode(9);
        root2.right = new TreeNode(2);
        TreeNode root3 = new TreeNode(2);
        root3.left = new TreeNode(4);
        root3.right = new TreeNode(3);
        TreeNode root4 = new TreeNode(2);
        root4.left = new TreeNode(4);
        root4.right = new TreeNode(7);

        System.out.println(hasSubtree(root1,root2));
        System.out.println(hasSubtree(root1,root3));
        System.out.println(isSubtree(root1,root4));
        System.out.println(isSameTree(root3,root2));
        System.out.println(isSameTree(root3,root4));
    }
}
