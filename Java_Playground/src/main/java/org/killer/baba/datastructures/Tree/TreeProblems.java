package org.killer.baba.datastructures.Tree;

import com.sun.source.tree.Tree;
import org.killer.baba.datastructures.Tree.Traversal.InorderTraversal;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

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

    public ArrayList<Integer> leftView(TreeNode treeNode){
        ArrayList<Integer> answer = new ArrayList<>();
        TreeNode curr = treeNode;
        while (curr != null){
            answer.add(curr.data);
            if(curr.left!=null){
                curr = curr.left;
            }else {
                curr = curr.right;
            }
        }
        return answer;
    }

    public ArrayList<Integer> rightView(TreeNode treeNode){
        ArrayList<Integer> answer = new ArrayList<>();
        TreeNode curr = treeNode;
        while (curr != null){
            answer.add(curr.data);
            if(curr.right!=null){
                curr = curr.right;
            }else {
                curr = curr.left;
            }
        }
        return answer;
    }

    public boolean isSymmetrical(TreeNode leftNode, TreeNode rightNode){
        if(leftNode==null || rightNode==null){
            return leftNode == rightNode;
        }
        return leftNode == rightNode && isSymmetrical(leftNode.left , rightNode.right) && isSymmetrical(leftNode.right , rightNode.left);
    }

    public boolean isBinaryTreeSymmetrical(TreeNode treeNode){
        if(treeNode==null){return true;}
        return isSymmetrical(treeNode.left,treeNode.right);
    }

    public boolean printRootToNodePath(ArrayList<Integer> pathList,TreeNode treeNode, int value){
        if(treeNode == null){
            return false;
        }
        pathList.add(treeNode.data);
        if(treeNode.data == value){
            return true;
        }
        boolean result = printRootToNodePath(pathList,treeNode.left,value) || printRootToNodePath(pathList,treeNode.right,value);

        if(!result){
            pathList.removeLast();
            return false;
        }
        return true;

    }

    public TreeNode lowestCommonAncestor(TreeNode treeNode,int x,int y){
        if(treeNode == null || treeNode.data == x || treeNode.data == y){
            return treeNode;
        }

        TreeNode left = lowestCommonAncestor(treeNode.left,x,y);
        TreeNode right = lowestCommonAncestor(treeNode.right,x,y);

        if(left == null ){
            return right;
        }

        if(right == null){
            return left;
        }

        return treeNode;
    }

    public int totalNodesInCompleteBinaryTree(TreeNode treeNode){
        int leftHeight = calculateLeftHeight(treeNode);
        int rightHeight = calculateRightHeight(treeNode);

        if(leftHeight == rightHeight){
            return (1<<leftHeight)-1;
        }else {
            return totalNodesInCompleteBinaryTree(treeNode.left) + maxDiameterOfBinaryTree(treeNode.right) + 1;
        }
    }

    public int calculateLeftHeight(TreeNode treeNode){
        int height = 0;
        while (treeNode!=null){
            height++;
            treeNode = treeNode.left;
        }
        return height;
    }

    public int calculateRightHeight(TreeNode treeNode){
        int height = 0;
        while (treeNode!=null){
            height++;
            treeNode = treeNode.right;
        }
        return height;
    }

    public String serializeBinaryTree(TreeNode treeNode){
        if(treeNode == null){
            return "#";
        }
        StringBuilder result = new StringBuilder();
        Queue<TreeNode> counter = new LinkedList<>();
        counter.add(treeNode);
        while (!counter.isEmpty()){
            TreeNode temp = counter.poll();
            if(temp == null){
                result.append("#");
                continue;
            }
            result.append(temp.data);
            if(temp.left!=null){
                counter.add(temp.left);
            }else {
                counter.add(null);
            }
            if(temp.right!=null){
                counter.add(temp.right);
            }else {
                counter.add(null);
            }
        }
        return result.toString();
    }

    public TreeNode deserializeBinaryTree(String serializedTree){
        Queue<TreeNode> counter = new LinkedList<>();
        TreeNode treeNode = new TreeNode(serializedTree.charAt(0)-'0');
        counter.add(treeNode);
        int i=1;
        while (!counter.isEmpty()){
            TreeNode temp = counter.poll();
            if(i<serializedTree.length() && serializedTree.charAt(i) != '#'){
                TreeNode leftTree = new TreeNode(serializedTree.charAt(i)-'0');
                temp.left = leftTree;
                counter.add(leftTree);
            }
            i++;
            if(i<serializedTree.length() && serializedTree.charAt(i) != '#'){
                TreeNode rightTree = new TreeNode(serializedTree.charAt(i)-'0');
                temp.right = rightTree;
                counter.add(rightTree);
            }
            i++;
        }
        InorderTraversal inorderTraversal = new InorderTraversal();
        inorderTraversal.recursiveTraverse(treeNode);

        return treeNode;
    }
}