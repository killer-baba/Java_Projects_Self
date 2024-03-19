package org.killer.baba.datastructures.Tree.Traversal;

import org.killer.baba.datastructures.Tree.TreeNode;

public class TreePair {
    public TreeNode treeNode;
    public int value;

    public TreePair(TreeNode treeNode, int value){
        this.treeNode = treeNode;
        this.value = value;
    }

    @Override
    public String toString() {
        return "TreePair{" +
                "treeNode=" + treeNode +
                ", value=" + value +
                '}';
    }
}
