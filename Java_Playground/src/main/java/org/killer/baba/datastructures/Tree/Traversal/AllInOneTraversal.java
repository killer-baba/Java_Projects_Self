package org.killer.baba.datastructures.Tree.Traversal;

import org.killer.baba.datastructures.Tree.TreeNode;

import java.util.*;


class Pair{
    TreeNode treeNode;
    int value;

    Pair(TreeNode treeNode, int value){
        this.treeNode = treeNode;
        this.value = value;
    }
}
public class AllInOneTraversal {

    public void allTraversalInOne(TreeNode t){
        Stack<Pair> stack = new Stack<>();
        stack.push(new Pair(t,1));
        List<Integer> pre = new ArrayList<>();
        List<Integer> in = new ArrayList<>();
        List<Integer> post = new ArrayList<>();

        while (!stack.isEmpty()){
            Pair temp = stack.pop();

            //Conditions for preorder
            if(temp.value == 1){
                pre.add(temp.treeNode.data);
                temp.value++;
                stack.push(temp);
                if(temp.treeNode.left!=null){
                    stack.push(new Pair(temp.treeNode.left,1));
                }
            }

            //Conditions for inorder
            else if(temp.value == 2){
                in.add(temp.treeNode.data);
                temp.value++;
                stack.push(temp);
                if(temp.treeNode.right != null){
                    stack.push(new Pair(temp.treeNode.right,1));
                }
            }

            //Conditions for postorder
            else if(temp.value == 3){
                post.add(temp.treeNode.data);
            }
        }

        //Printing Results
        for (Integer i : pre){
            System.out.print(i + "  ");
        }
        System.out.println();

        for (Integer i : in){
            System.out.print(i + "  ");
        }
        System.out.println();

        for (Integer i : post){
            System.out.print(i + "  ");
        }
        System.out.println();
    }
}
