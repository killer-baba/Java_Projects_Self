package org.killer.baba.datastructures.Tree;

public class TreeNode {

    public int data;

    public TreeNode left;

    public TreeNode right;

    TreeNode(int data){
        this.data = data;
        this.left = null;
        this.right = null;
    }

    public static  TreeNode SampleTree(){
        TreeNode treeNode = new TreeNode(1);
        treeNode.left = new TreeNode(2);
        treeNode.right = new TreeNode(3);
        treeNode.left.left = new TreeNode(4);
        treeNode.left.right = new TreeNode(5);
        treeNode.right.left = new TreeNode(6);
        treeNode.right.right = new TreeNode(7);

        return treeNode;
    }

}
