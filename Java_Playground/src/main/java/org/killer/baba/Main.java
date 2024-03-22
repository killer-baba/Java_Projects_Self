package org.killer.baba;

import org.killer.baba.datastructures.Tree.BinarySearchTree.BinarySearchTree;
import org.killer.baba.datastructures.Tree.BinaryTreeConstruction.ConstructionFromInorderAndPostorder;
import org.killer.baba.datastructures.Tree.BinaryTreeConstruction.ConstructionFromInorderAndPreorder;
import org.killer.baba.datastructures.Tree.Traversal.*;
import org.killer.baba.datastructures.Tree.TreeNode;
import org.killer.baba.datastructures.Tree.TreeProblems;
import org.killer.baba.playground.InterviewBit.ListNode;
import org.killer.baba.playground.LeetCode.LeetCodeDailyStreak;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

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

        System.out.println("Morris Inorder");
        inorderTraversal.morrisInorder(treeNode);
        System.out.println();

        System.out.println("Morris Preorder");
        preorderTraversal.morrisPreorder(treeNode);
        System.out.println();

        System.out.println();
        System.out.println(treeProblems.maximumWidth(treeNode));

        HashMap<TreeNode,TreeNode> parentmapper = new HashMap<>();
        treeProblems.parentMapper(parentmapper,treeNode);
        for (TreeNode tn : parentmapper.keySet()){
            System.out.println("Key : " + tn.data + " Value : " + parentmapper.get(tn).data);
        }

        ArrayList<Integer> ans = treeProblems.nodesAtDistanceK(treeNode,treeNode.left,3);
        System.out.println("Nodes at distance K");
        for (Integer in : ans){
            System.out.print(in + " ");
        }
        System.out.println();

        System.out.println("Max Time Needed : " + treeProblems.minTimeToBurnBinaryTree(treeNode,treeNode.right));

        ConstructionFromInorderAndPreorder treeConstructor = new ConstructionFromInorderAndPreorder();
        ConstructionFromInorderAndPostorder treeConstructor2 = new ConstructionFromInorderAndPostorder();
        ArrayList<Integer> inorderList = new ArrayList<>();
        ArrayList<Integer> preorderList = new ArrayList<>();
        ArrayList<Integer> postorderList = new ArrayList<>();
        inorderList.add(4);
        inorderList.add(2);inorderList.add(5);
        inorderList.add(1);inorderList.add(6);
        inorderList.add(3);inorderList.add(7);

        preorderList.add(1);preorderList.add(2);
        preorderList.add(4);preorderList.add(5);
        preorderList.add(3);preorderList.add(6);
        preorderList.add(7);

        postorderList.add(4);postorderList.add(5);
        postorderList.add(2);postorderList.add(6);
        postorderList.add(7);postorderList.add(3);
        postorderList.add(1);



        System.out.println(preorderList.subList(0,1).isEmpty());


        TreeNode newTreeNode = treeConstructor.treeFromInorderAndPreorder(inorderList,preorderList);
        preorderTraversal.recursiveTraverse(newTreeNode);
        System.out.println();
        inorderTraversal.recursiveTraverse(newTreeNode);
        System.out.println();

        TreeNode newTreeNode2 = treeConstructor2.treeFromInorderAndPostorder(inorderList,postorderList);
        preorderTraversal.recursiveTraverse(newTreeNode2);
        System.out.println();
        inorderTraversal.recursiveTraverse(newTreeNode2);
        System.out.println();

        TreeNode newTreeNode3 = treeConstructor2.treeFromInorderAndPostorder(inorderList,postorderList);
        preorderTraversal.recursiveTraverse(newTreeNode2);
        System.out.println();
        inorderTraversal.recursiveTraverse(newTreeNode2);
        System.out.println();

        TreeNode flatennedList1 = treeProblems.flattenBinaryTreeWithStack(newTreeNode2);
        while (flatennedList1!=null) {
            System.out.print(flatennedList1.data);
            flatennedList1 = flatennedList1.right;
        }
        System.out.println();

        TreeNode flatennedList2 = treeProblems.flattenBinaryTreeWithMorrisTraversal(newTreeNode);
        while (flatennedList2 != null) {
            System.out.print(flatennedList2.data);
            flatennedList2 = flatennedList2.right;
        }
        System.out.println();

        TreeNode flatennedList3 = treeProblems.flattenBinaryTreeByRecursion(newTreeNode3);
        while (flatennedList3 != null) {
            System.out.print(flatennedList3.data);
            flatennedList3 = flatennedList3.right;
        }
        System.out.println();
        ArrayList<Integer> bstInorder = new ArrayList<>(Arrays.asList(1,3,4,5,6,7,8,10,13,15,16,17,18));
        ArrayList<Integer> bstPreorder = new ArrayList<>(Arrays.asList(10,5,3,1,4,7,6,8,15,13,17,16,18));
        TreeNode bstTree = treeConstructor.treeFromInorderAndPreorder(bstInorder,bstPreorder);
        BinarySearchTree bst = new BinarySearchTree();
        System.out.println(bst.search(bstTree,16).data);
        System.out.println(bst.findCeil(bstTree,14).data);
        System.out.println(bst.findFloor(bstTree,9).data);
    }

}