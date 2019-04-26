package chapter4;

public class P191_ConvertBinarySearchTree {
    public static class BinaryTreeNode{//内部类，当结构体用
        int val;
        BinaryTreeNode leftNode;
        BinaryTreeNode rightNode;
        BinaryTreeNode(int val){
            this.val=val;
            this.leftNode=null;
            this.rightNode=null;
        }
    }

    public static BinaryTreeNode convert(BinaryTreeNode root) {//返回的是一个二叉树，但已经具有排序双链表的性质

        //lastNode指向双向链表的尾节点，开始传入空指针
        BinaryTreeNode lastNode = null;
        lastNode=baseconvert(root, lastNode);

        //我们需要返回的是头节点
        BinaryTreeNode headNode = lastNode;
        while (headNode.leftNode != null)
            headNode = headNode.leftNode;
        return headNode;

    }
    //lastNode指向已经转换好的链表的最后一个节点（值最大的节点）。//并且返回的也是lastNode
    public static BinaryTreeNode baseconvert(BinaryTreeNode root, BinaryTreeNode lastNode) {//中序遍历思路

        if (root == null)
            return lastNode;

        BinaryTreeNode current = root;
        if (current.leftNode != null)
            lastNode=baseconvert(current.leftNode, lastNode);
        current.leftNode = lastNode;

        if (lastNode != null)
            lastNode.rightNode = current;
        lastNode = current;//更新链表中的最后一个节点（新的值最大的节点）。

        if (current.rightNode != null)
            lastNode=baseconvert(current.rightNode, lastNode);//接下来把lastNode作为参数传入函数递归遍历右子树
        return lastNode;

    }


    public static void main(String[] args){
        //            10
        //          /   \
        //         6     14
        //       /  \   / \
        //      4    8 12  16
        BinaryTreeNode root = new BinaryTreeNode(10);
        root.leftNode = new BinaryTreeNode(6);
        root.rightNode = new BinaryTreeNode(14);
        root.leftNode.leftNode = new BinaryTreeNode(4);
        root.leftNode.rightNode = new BinaryTreeNode(8);
        root.rightNode.leftNode = new BinaryTreeNode(12);
        root.rightNode.rightNode = new BinaryTreeNode(16);
        BinaryTreeNode result = convert(root);
        //转化后不可再使用二叉树的层序遍历显示结果，层序遍历会进入无限循环。
        while (result!=null) {

            System.out.println(result.val);

            result=result.rightNode;

        }

    }
}