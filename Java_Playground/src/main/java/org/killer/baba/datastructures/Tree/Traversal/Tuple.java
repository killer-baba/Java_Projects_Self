package org.killer.baba.datastructures.Tree.Traversal;

import org.killer.baba.datastructures.Tree.TreeNode;

public class Tuple {

    int vertical;
    int level;
    TreeNode treeNode;

    Tuple(TreeNode treeNode, int vertical, int level){
        this.treeNode = treeNode;
        this.vertical = vertical;
        this.level = level;
    }
}
