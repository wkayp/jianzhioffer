package chapter2;

import java.util.List;

/**
 * Created by ryder on 2017/6/20.
 * 重新编辑时间 2019/03/28
 * 重建二叉树:
 * 可以完成重建，而前序+后序无法完成
 */
public class P62_ConstructBinaryTree {
    //前序+中序
    public static TreeNode construct(int[] preorder,int[] inorder){
        if(preorder==null || inorder==null || preorder.length==0 || preorder.length!=inorder.length)
            return null;
        return constructCore(preorder,0,preorder.length-1,inorder,0,inorder.length-1);
    }
    public static TreeNode constructCore(int[] preorder,int pLeft,int pRight,int[] inorder,int iLeft,int iRight){
        if(pLeft>pRight||iLeft>iRight)
            return null;
        int i=0;
        for(i=iLeft;i<=iRight;i++){
            if(preorder[pLeft]==inorder[i])
                break;
        }
        TreeNode node=new TreeNode(preorder[pLeft]);
        node.left=constructCore(preorder,pLeft+1,pLeft+i-iLeft,inorder,iLeft,i-1);
        node.right=constructCore(preorder,pLeft+i-iLeft+1,pRight,inorder,i+1,iRight);
        return node;
    }
    //后续+中序
    public static TreeNode construct2(int[] postorder,int[] inorder){
        if(postorder==null || inorder==null || postorder.length==0 || postorder.length!=inorder.length)
            return null;
        return constructCore2(postorder,0,postorder.length-1,inorder,0,inorder.length-1);
}
    public static TreeNode constructCore2(int[] postorder,int pLeft,int pRight,int[] inorder,int iLeft,int iRight){
        if(pRight<pLeft||iRight<iLeft)
            return null;
        int i=0;
        for(i=iLeft;i<=iRight;i++){
            if(postorder[pRight]==inorder[i])
                break;
        }
        TreeNode node=new TreeNode(postorder[pRight]);

        node.left=constructCore(postorder,pLeft,pLeft+i-iLeft-1,inorder,iLeft,i-1);
        node.right=constructCore(postorder,pLeft+i-iLeft,pRight-1,inorder,i+1,iRight);
        return node;
    }
    public static void preprinttree(TreeNode root){
        if(root==null) return;
        System.out.print(" "+root.val);
        if(root.left!=null)
            preprinttree(root.left);
        if(root.right!=null)
            preprinttree(root.right);
    }
    public static void main(String[] args){
        int[] pre={1,2,4,7,3,5,6,8};
        int[] in={4,7,2,1,5,3,8,6};
        TreeNode root = construct(pre,in);
        preprinttree(root);//先序遍历验证
    }
}