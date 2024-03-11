package org.killer.baba.datastructures.Tree;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;

public class TreeProblems {

    public boolean identicalTrees(TreeNode treeNode1,TreeNode treeNode2){
        if(treeNode1 == null && treeNode2 == null){
            return true;
        }
        else if (treeNode1 == null || treeNode2 == null){
            return false;
        }

        return (treeNode1.data == treeNode2.data) && identicalTrees(treeNode1.left,treeNode2.left) && identicalTrees(treeNode1.left,treeNode2.left);
    }

    public int maxSumPath(TreeNode treeNode){
        if(treeNode == null){
            return 0;
        }

        int leftSum = maxSumPath(treeNode.left);
        int rightSum = maxSumPath(treeNode.right);

        return treeNode.data + Math.max(leftSum,rightSum);
    }

    public int maxDiameterOfBinaryTree(TreeNode treeNode){
        int maxDiameter = Integer.MIN_VALUE;

        if(treeNode == null){
            return 0;
        }

        int leftHeight = maxDiameterOfBinaryTree(treeNode.left);
        int rightHeight = maxDiameterOfBinaryTree(treeNode.right);

        maxDiameter = Math.max(maxDiameter,leftHeight+rightHeight);;

        return 1 + maxDiameter;
    }

    //Need revision
    public int maxDiameterOfBinaryTree(TreeNode treeNode, int[] dia) {
        if (treeNode == null) {
            return 0;
        }

        int leftHeight = maxDiameterOfBinaryTree(treeNode.left, dia);
        int rightHeight = maxDiameterOfBinaryTree(treeNode.right, dia);

        dia[0] = Math.max(dia[0], leftHeight + rightHeight);

        return 1 + Math.max(leftHeight, rightHeight);
    }

    public int balancedBinaryTree(TreeNode treeNode, boolean[] arr){
        if(treeNode == null){
            return 0;
        }

        int leftHeight = balancedBinaryTree(treeNode.left, arr);
        int rightHeight = balancedBinaryTree(treeNode.right, arr);

        if(Math.abs(leftHeight-rightHeight)>1){
            arr[0] = false;
        }

        return 1 + Math.max(leftHeight,rightHeight);
    }

    public ArrayList<TreeNode> zigZagTraversal(TreeNode treeNode){
        Deque<TreeNode> deque = new LinkedList<>();
        ArrayList<TreeNode> answerList = new ArrayList<>();
        deque.offerLast(treeNode);
        boolean tracker = true;
        while (!deque.isEmpty()){
            int length = deque.size();
            ArrayList<TreeNode> temp = new ArrayList<>(length);
            for (int i = 0; i < length; i++) {
                if(deque.getFirst().left != null){
                    deque.offerLast(deque.getFirst().left);
                }
                if(deque.getFirst().right != null){
                    deque.offerLast(deque.getFirst().right);
                }
                if(tracker){
                    temp.add(deque.pollFirst());
                }else {
                    temp.addFirst(deque.pollFirst());
                }
            }
            tracker = !tracker;
            answerList.addAll(temp);
        }
        return answerList;
    }
}