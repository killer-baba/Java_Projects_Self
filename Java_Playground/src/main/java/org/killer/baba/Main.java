package org.killer.baba;

import org.killer.baba.datastructures.Tree.Traversal.*;
import org.killer.baba.datastructures.Tree.TreeNode;
import org.killer.baba.datastructures.Tree.TreeProblems;

import java.util.ArrayList;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.


public class Main {
    public static void main(String[] args) {

        TreeNode treeNode = TreeNode.SampleTree();

        InorderTraversal inorderTraversal = new InorderTraversal();
        inorderTraversal.recursiveTraverse(treeNode);
        inorderTraversal.iterativeTraverse(treeNode);
        System.out.println();

        PreorderTraversal preorderTraversal = new PreorderTraversal();
        preorderTraversal.recursiveTraverse(treeNode);
        preorderTraversal.iterativeTraverse(treeNode);
        System.out.println();

        PostorderTraversal postorderTraversal = new PostorderTraversal();
        postorderTraversal.iterativeTraverseTwoStack(treeNode);
        postorderTraversal.recursiveTraverse(treeNode);
        postorderTraversal.iterativeTraverseSingleStack(treeNode);
        System.out.println();

        LevelorderTraversal levelorderTraversal = new LevelorderTraversal();
        levelorderTraversal.iterativeTraversal(treeNode);
        System.out.println();

        TreeNode treeNode1 = TreeNode.SampleTree();
        TreeProblems treeProblems = new TreeProblems();
        treeNode1.data =10;
        System.out.println(treeProblems.identicalTrees(treeNode,treeNode1));
        System.out.println();

        int sum = treeProblems.maxSumPath(treeNode);
        System.out.println("sum = " + sum);

        int maxDiameter = treeProblems.maxDiameterOfBinaryTree(treeNode);
        System.out.println(maxDiameter);
        int [] arr = new int[1];
        System.out.println(treeProblems.maxDiameterOfBinaryTree(treeNode,arr));
        System.out.println(arr[0]);

        boolean[] answerArray = new boolean[1];
        answerArray[0] = true;
        treeProblems.balancedBinaryTree(treeNode,answerArray);
        System.out.println(answerArray[0]);

        ArrayList<TreeNode> answer = treeProblems.zigZagTraversal(treeNode);
        System.out.println("ZigZag Traversal :");
        for (TreeNode tn : answer){
            System.out.print(tn.data + " ");
        }
        System.out.println();

        VerticalOrderTraversal verticalOrderTraversal = new VerticalOrderTraversal();
        ArrayList<Integer> val = verticalOrderTraversal.verticalOrderTraversal(treeNode);
        for (Integer i : val){
            System.out.print(i + " ");
        }
        System.out.println();

        ArrayList<Integer> val2 = verticalOrderTraversal.binaryTreeTopView(treeNode);
        for (Integer i : val2){
            System.out.print(i + " ");
        }
        System.out.println();

        ArrayList<Integer> val3 = verticalOrderTraversal.binaryTreeBottomView(treeNode);
        for (Integer i : val3){
            System.out.print(i + " ");
        }
        System.out.println();

        ArrayList<Integer> val4 = treeProblems.leftView(treeNode);
        for (Integer i : val4){
            System.out.print(i + " ");
        }
        System.out.println();

        ArrayList<Integer> val5 = treeProblems.rightView(treeNode);
        for (Integer i : val5){
            System.out.print(i + " ");
        }
        System.out.println();

        System.out.println(treeProblems.isBinaryTreeSymmetrical(treeNode));

        ArrayList<Integer> val6 = new ArrayList<>();
        System.out.println(treeProblems.printRootToNodePath(val6,treeNode,3));
        for (Integer i : val6){
            System.out.print(i + " ");
        }
        System.out.println();

        TreeNode treeNode2 = treeProblems.lowestCommonAncestor(treeNode, 4,5);
        System.out.println(treeNode2.data);

        System.out.println(treeProblems.totalNodesInCompleteBinaryTree(treeNode));

        String str = treeProblems.serializeBinaryTree(treeNode);
        System.out.println(str);
        treeProblems.deserializeBinaryTree(str);
        System.out.println();

        ArrayList<Integer> boundaryTraversal = treeProblems.boundaryTraversalOfBinaryTree(treeNode);
        System.out.println("Boundary Traversal : ");
        for (Integer i : boundaryTraversal){
            System.out.print(i + " ");
        }
        System.out.println();

        TreeNode tn = treeProblems.childrenSum(treeNode);
        preorderTraversal.recursiveTraverse(tn);
    }

}