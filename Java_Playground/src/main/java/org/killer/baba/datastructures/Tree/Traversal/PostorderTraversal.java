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

        System.out.print( treeNode.data + "  ");
    }

    public void  iterativeTraverseTwoStack(TreeNode treeNode){
        Stack<TreeNode> s1 = new Stack<>();
        Stack<TreeNode> s2 = new Stack<>();

        s1.push(treeNode);

        while(!s1.isEmpty()){
            TreeNode temp = s1.pop();
            s2.push(temp);
            if(temp.left != null){
                s1.push(temp.left);
            }
            if(temp.right != null) {
                s1.push(temp.right);
            }
        }

        while (!s2.isEmpty()){
            System.out.print(s2.pop().data + "  ");
        }
        System.out.println();
    }

    public void iterativeTraverseSingleStack(TreeNode treeNode){
        Stack<TreeNode> stack = new Stack<>();
        TreeNode curr = treeNode;
        System.out.println();
        while (curr!=null || !stack.isEmpty()){
            if(curr != null){
                stack.push(curr);
                curr = curr.left;
            }else {
                TreeNode temp = stack.peek().right;
                if(temp != null){
                    curr = temp;
                }else {
                    temp = stack.pop();
                    System.out.print(temp.data + "  ");
                    while (!stack.isEmpty() && temp == stack.peek().right){
                        temp = stack.pop();
                        System.out.print(temp.data + "  ");
                    }
                }
            }
        }
        System.out.println();
    }
}
