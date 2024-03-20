package org.killer.baba.datastructures.Tree.BinaryTreeConstruction;

import org.killer.baba.datastructures.Tree.TreeNode;

import java.util.ArrayList;

public class ConstructionFromInorderAndPreorder {

    public TreeNode treeFromInorderAndPreorder(ArrayList<Integer> inOrder, ArrayList<Integer> preOrder){
        if(inOrder.isEmpty()){
            return null;
        }
        int rootVal = preOrder.getFirst();
        int rootLength = 0;
        TreeNode root = new TreeNode(rootVal);
        for (int i = 0; i < inOrder.size(); i++) {
            if(inOrder.get(i)==rootVal){
                rootLength = i;
                break;
            }
        }
        ArrayList<Integer> subListLeftInorder = new ArrayList<>(inOrder.subList(0,rootLength));
        ArrayList<Integer> subListLeftPreorder = new ArrayList<>(preOrder.subList(1,rootLength+1));
        ArrayList<Integer> subListRightInorder = new ArrayList<>(inOrder.subList(rootLength+1,inOrder.size()));
        ArrayList<Integer> subListRightPreorder = new ArrayList<>(preOrder.subList(rootLength+1,preOrder.size()));
        root.left = treeFromInorderAndPreorder(subListLeftInorder, subListLeftPreorder);
        root.right = treeFromInorderAndPreorder(subListRightInorder, subListRightPreorder);

        return root;
    }
}
