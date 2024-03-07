package org.killer.baba.datastructures.Tree.Traversal;

import org.killer.baba.datastructures.Tree.TreeNode;

import java.util.Stack;

public class InorderTraversal {

    public void recursiveTraverse(TreeNode treeNode){
        if(treeNode == null){
            return;
        }

        recursiveTraverse(treeNode.left);

        System.out.print( treeNode.data + "  ");

        recursiveTraverse(treeNode.right);
    }

    public void iterativeTraverse(TreeNode treeNode){
        Stack<TreeNode> s = new Stack<>();
        System.out.println();
        while (true){
            if(treeNode == null){
                if(s.isEmpty()){
                    break;
                }
                treeNode = s.pop();
                System.out.print( treeNode.data + "  ");
                treeNode = treeNode.right;
            }else {
                s.add(treeNode);
                treeNode = treeNode.left;
            }
        }
        System.out.println();
    }


}
