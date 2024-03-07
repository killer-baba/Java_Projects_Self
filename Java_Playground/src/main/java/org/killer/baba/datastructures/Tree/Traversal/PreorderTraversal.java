package org.killer.baba.datastructures.Tree.Traversal;

import org.killer.baba.datastructures.Tree.TreeNode;

import java.util.Stack;

public class PreorderTraversal {

    public void recursiveTraverse(TreeNode treeNode){
        if(treeNode == null){
            return;
        }

        System.out.print( treeNode.data + " , ");

        recursiveTraverse(treeNode.left);

        recursiveTraverse(treeNode.right);
    }

    public void iterativeTraverse(TreeNode treeNode){
        Stack<TreeNode> s = new Stack<>();
        s.add(treeNode);
        while (!s.isEmpty()){
            TreeNode temp = s.peek();

            s.pop();
            System.out.print(temp.data + "  ");

            if(temp.left!=null){
                s.add(temp.right);
            }
            if(temp.right!=null){
                s.add(temp.left);
            }
        }
        System.out.println(" ");
    }

}
