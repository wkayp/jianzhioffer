package chapter4;

public class P179_SequenceOfBST {
    public static boolean verifySquenceOfBST(int[] data){
        //空树
        if(data==null||data.length==0)
            return false;
        return verifySquenceOfBST(data,0,data.length-1);
    }
    public static boolean verifySquenceOfBST(int[] data,int start,int end){
        //数组长度为2，一定能够组成BST
        if(end-start<=1)
            return true;
        //根节点的值
        int root = data[end];

        // 在二叉搜索树中左子树节点的值小于根节点的值
        int i=start;
        for(;i<=end-1;i++){
            if(data[i]>root)//在右子树的第一个节点跳出
                break;
        }

        // 在二叉搜索树中右子树节点的值大于根节点的值
        int j=i;
        for(;j<end;j++){
            if(data[j]<root)
                return false;
        }

        //判断左右子树是不是二叉搜索树
        return verifySquenceOfBST(data,start,i-1)&&verifySquenceOfBST(data,i+1,end);
    }
    public static void main(String[] args){
        //            8
        //          /   \
        //         6     10
        //       /  \   / \
        //      5    7 9   11
        int[] data = {5,7,6,9,11,10,8};
        int[] data1={7,4,6,5};
        System.out.println(verifySquenceOfBST(data));
        System.out.println(verifySquenceOfBST(data1));
    }
}