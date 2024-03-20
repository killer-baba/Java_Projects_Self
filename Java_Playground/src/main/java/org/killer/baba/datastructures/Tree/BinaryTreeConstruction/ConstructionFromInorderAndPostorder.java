package org.killer.baba.datastructures.Tree.BinaryTreeConstruction;

import org.killer.baba.datastructures.Tree.TreeNode;

import java.util.ArrayList;

public class ConstructionFromInorderAndPostorder {

    public TreeNode treeFromInorderAndPostorder(ArrayList<Integer> inOrder, ArrayList<Integer> postOrder){
        if(inOrder.isEmpty()){
            return null;
        }
        int rootValue = postOrder.getLast();
        int rootLength = 0;
        TreeNode root = new TreeNode(rootValue);
        for (int i = 0; i < inOrder.size(); i++) {
            if(inOrder.get(i) == rootValue){
                rootLength = i;
                break;
            }
        }
        ArrayList<Integer> subListLeftInorder = new ArrayList<>(inOrder.subList(0,rootLength));
        ArrayList<Integer> subListLeftPostorder = new ArrayList<>(postOrder.subList(0,rootLength));
        ArrayList<Integer> subListRightInorder = new ArrayList<>(inOrder.subList(rootLength+1,inOrder.size()));
        ArrayList<Integer> subListRightPostorder = new ArrayList<>(postOrder.subList(rootLength,postOrder.size()-1));

        root.left = treeFromInorderAndPostorder(subListLeftInorder, subListLeftPostorder);
        root.right = treeFromInorderAndPostorder(subListRightInorder, subListRightPostorder);

        return root;
    }
}
