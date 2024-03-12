package org.killer.baba.datastructures.Tree.Traversal;

import org.killer.baba.datastructures.Tree.TreeNode;

import java.util.Deque;
import java.util.LinkedList;

public class MaximumHeight {

    public int maximumHeightByRecursion(TreeNode treeNode){

        if(treeNode == null){
            return 0;
        }
        int leftHeight = 0,rightHeight = 0;
        leftHeight = maximumHeightByRecursion(treeNode.left);
        rightHeight = maximumHeightByRecursion(treeNode.right);

        return 1+Math.max(leftHeight,rightHeight);

    }

    public int maximumHeightByLevelOrderTraversal(TreeNode treeNode){

        if(treeNode==null){
            return 0;
        }
        int maxHeight = 0;
        Deque<TreeNode> queue = new LinkedList<>();
        queue.offerLast(treeNode);
        while (!queue.isEmpty()){
            int lenght = queue.size();
            maxHeight += 1;
            while (lenght>0){
                lenght -= 1;
                TreeNode temp = queue.pollFirst();
                if(temp.left!=null) {
                    queue.offerLast(temp.left);
                }
                if(temp.right!=null) {
                    queue.offerLast(temp.right);
                }
            }

        }

        return maxHeight;
    }
}
