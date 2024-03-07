package org.killer.baba.datastructures.Tree.Traversal;

import org.killer.baba.datastructures.Tree.TreeNode;

import java.util.Stack;

public class PostorderTraversal {
    public void recursiveTraverse(TreeNode treeNode){
        if(treeNode == null){
            return;
        }

        recursiveTraverse(treeNode.left);

        recursiveTraverse(treeNode.right);

        System.out.print( treeNode.data + " , ");
    }

    public void  iterativeTraverse(TreeNode treeNode){

    }
}
