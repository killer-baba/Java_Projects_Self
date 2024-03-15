package org.killer.baba.datastructures.Tree.Traversal;

import org.killer.baba.datastructures.Tree.TreeNode;

import java.util.ArrayList;
import java.util.Stack;

public class PreorderTraversal {

    public void recursiveTraverse(TreeNode treeNode){
        ArrayList<TreeNode> answerList = new ArrayList<>();
        if(treeNode == null){
            return;
        }

        System.out.print( treeNode.data + "  ");
        answerList.add(treeNode);

        recursiveTraverse(treeNode.left);

        recursiveTraverse(treeNode.right);
    }

    public void iterativeTraverse(TreeNode treeNode){
        Stack<TreeNode> s = new Stack<>();
        s.add(treeNode);
        System.out.println(" ");

        while (!s.isEmpty()){
            TreeNode temp = s.peek();

            s.pop();
            System.out.print(temp.data + "  ");

            if(temp.right!=null){
                s.add(temp.right);
            }
            if(temp.left!=null){
                s.add(temp.left);
            }
        }
        System.out.println(" ");
    }

    public void recursiveTraverseWithArrayList(TreeNode treeNode, ArrayList<TreeNode> answerList){
        if(treeNode == null){
            return;
        }

        answerList.add(treeNode);

        recursiveTraverseWithArrayList(treeNode.left,answerList);

        recursiveTraverseWithArrayList(treeNode.right,answerList);
    }

}
