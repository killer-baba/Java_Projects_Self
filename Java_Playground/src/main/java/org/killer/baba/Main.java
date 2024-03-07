package org.killer.baba;

import org.killer.baba.datastructures.Tree.Traversal.InorderTraversal;
import org.killer.baba.datastructures.Tree.Traversal.LevelorderTraversal;
import org.killer.baba.datastructures.Tree.Traversal.PostorderTraversal;
import org.killer.baba.datastructures.Tree.Traversal.PreorderTraversal;
import org.killer.baba.datastructures.Tree.TreeNode;

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


    }



}