package org.killer.baba.datastructures.Tree.Traversal;

import org.killer.baba.datastructures.Tree.TreeNode;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;

public class LevelorderTraversal {

    public void iterativeTraversal(TreeNode treeNode){
        Deque<TreeNode> s = new LinkedList<>();
        s.offerLast(treeNode);
        System.out.println();
        while (!s.isEmpty()){
            TreeNode temp = s.pollFirst();
            if(temp.left !=null){
                s.offerLast(temp.left);
            }
            if(temp.right != null){
                s.offerLast(temp.right);
            }
            System.out.print(temp.data + "  ");
        }
        System.out.println();
    }
}
