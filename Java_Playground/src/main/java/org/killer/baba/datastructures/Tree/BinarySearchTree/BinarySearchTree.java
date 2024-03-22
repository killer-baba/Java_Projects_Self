package org.killer.baba.datastructures.Tree.BinarySearchTree;

import org.killer.baba.datastructures.Tree.TreeNode;

public class BinarySearchTree {

    public TreeNode search(TreeNode treenode, int value){
        if(treenode == null){
            return null;
        }
        if(treenode.data == value){
            return treenode;
        }
        return value < treenode.data ? search(treenode.left,value) : search(treenode.right,value);
    }

    public TreeNode findCeil(TreeNode treeNode, int value){
        TreeNode ceil = null;
        while (treeNode!=null) {
            if (value < treeNode.data) {
                ceil = treeNode;
                treeNode = treeNode.left;
            } else {
                treeNode = treeNode.right;
            }
        }
        return ceil;
    }

    public TreeNode findFloor(TreeNode treeNode, int value){
        TreeNode floor = null;
        while (treeNode!=null) {
            if (value > treeNode.data) {
                floor = treeNode;
                treeNode = treeNode.right;
            } else {
                treeNode = treeNode.left;
            }
        }
        return floor;
    }
}
