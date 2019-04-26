package IT_haha;

public class number4 {
    public static class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        public  TreeNode(int val){
            this.val=val;
            this.left=null;
            this.right=null;
        }
    }
    public static TreeNode reConstructBinaryTree(int[] pre,int[] in){
        return reConstructBinaryTreeCore(pre,0,pre.length-1,in,0,in.length-1);
    }
    public static TreeNode reConstructBinaryTreeCore(int[] pre,int pleft,int pright,int[] in,int ileft,int iright){
        if(pleft>pright||ileft>iright) return null;
        int i=0;
        for(i=ileft;i<iright;i++){
            if(in[i]==pre[pleft]) break;
        }
        TreeNode node=new TreeNode(pre[pleft]);
        node.left=reConstructBinaryTreeCore(pre,pleft+1,pleft+i-ileft,in,ileft,i-1);
        node.right=reConstructBinaryTreeCore(pre,pleft+i-ileft+1,pright,in,i+1,iright);
        return node;
    }
    public static void main(String[] args) {
        int[] pre = {1, 2, 4, 5, 3, 6, 7};
        int[] in = {4, 2, 5, 1, 6, 3, 7};
        TreeNode node=reConstructBinaryTree(pre, in);
        System.out.println(node.val);
        System.out.println(node.left.val+" "+node.right.val);
        System.out.println(node.left.left.val+" "+node.left.right.val+" "+node.right.left.val+" "+node.right.right.val);
    }
}
