package org.killer.baba.datastructures.Tree;

import com.sun.source.tree.Tree;
import org.killer.baba.datastructures.Tree.Traversal.InorderTraversal;

import org.killer.baba.datastructures.Tree.Traversal.PreorderTraversal;
import org.killer.baba.datastructures.Tree.Traversal.TreePair;

import java.util.*;

public class TreeProblems {

    PreorderTraversal preorderTraversal = new PreorderTraversal();

    public boolean identicalTrees(TreeNode treeNode1,TreeNode treeNode2){
        if(treeNode1 == null && treeNode2 == null){
            return true;
        }
        else if (treeNode1 == null || treeNode2 == null){
            return false;
        }

        return (treeNode1.data == treeNode2.data) && identicalTrees(treeNode1.left,treeNode2.left) && identicalTrees(treeNode1.left,treeNode2.left);
    }

    //wrong, need modification
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

    public ArrayList<Integer> boundaryTraversalOfBinaryTree(TreeNode treeNode){

        if(treeNode==null){
            return null;
        }

        ArrayList<Integer> answerList = new ArrayList<>();
        TreeNode counter = treeNode;
        while (counter != null){
            if(counter.left != null && counter.right != null) {
                answerList.add(counter.data);
            }
            if(counter.left!= null){
                counter = counter.left;
            }else {
                counter = counter.right;
            }
        }
        ArrayList<TreeNode> preorderList = new ArrayList<>();
        preorderTraversal.recursiveTraverseWithArrayList(treeNode, preorderList);
        for (TreeNode treeNode1 : preorderList){
            if(treeNode1.left == null && treeNode1.right == null){
                answerList.add(treeNode1.data);
            }
        }

        if(treeNode.right!= null) {
            ArrayList<Integer> temp = new ArrayList<>();
            counter = treeNode.right;
            while (counter != null) {
                if(counter.left != null && counter.right != null) {
                    temp.addFirst(counter.data);
                }
                if (counter.right != null) {
                    counter = counter.right;
                } else {
                    counter = counter.left;
                }
            }
            answerList.addAll(temp);
        }


        return answerList;
    }

    public int childrenSum(TreeNode treeNode){
        if(treeNode == null){
            return 0;
        }
        int leftData=0,rightData=0;
        if(treeNode.left!=null){
            leftData = treeNode.left.data;
        }
        if(treeNode.right!=null){
            rightData = treeNode.right.data;
        }

        if(leftData+rightData<treeNode.data){
            if(treeNode.left!=null){
                treeNode.left.data = treeNode.data;
            }
            if(treeNode.right!=null){
                treeNode.right.data = treeNode.data;
            }
        }

        leftData = childrenSum(treeNode.left);
        rightData = childrenSum(treeNode.right);

        if(leftData + rightData > treeNode.data){
            treeNode.data = leftData + rightData;
        }
        return treeNode.data;
    }

    public int maximumWidth(TreeNode treeNode){
        if(treeNode==null){
            return 0;
        }
        Queue<TreePair> travor = new LinkedList<>();
        travor.add(new TreePair(treeNode,0));
        int width=0;

        while (!travor.isEmpty()){
            int size = travor.size();
            int first=0,last=0;
            int min = travor.peek().value;
            for (int i = 0; i < size; i++) {
                TreePair temp = travor.poll();
                TreeNode tempNode = temp.treeNode;
                int pointerVal = temp.value-min;
                if(i==0){
                    first = temp.value;
                }
                if(i==size-1){
                    last = temp.value;
                }
                if(tempNode.left != null){
                    travor.add(new TreePair(tempNode.left,(2*pointerVal+1)));
                }
                if(tempNode.right != null){
                    travor.add(new TreePair(tempNode.right,(2*pointerVal+2)));
                }
            }
            width = Math.max(width,last-first+1);
        }
        return width;
    }

    public void parentMapper(HashMap<TreeNode,TreeNode> hashMap, TreeNode treeNode){
        if(treeNode == null){
            return;
        }
        if(treeNode.left != null){
            hashMap.put(treeNode.left,treeNode);
        }
        if(treeNode.right != null){
            hashMap.put(treeNode.right,treeNode);
        }

        parentMapper(hashMap,treeNode.left);
        parentMapper(hashMap,treeNode.right);

    }

    public ArrayList<Integer> nodesAtDistanceK(TreeNode root, TreeNode treeNode, int k){
        if(treeNode==null){
            return null;
        }
        ArrayList<Integer> answer = new ArrayList<>();
        HashMap<TreeNode,TreeNode> parentsTracker = new HashMap<>();
        parentMapper(parentsTracker,root);
        Queue<TreeNode> traverse = new LinkedList<>();
        traverse.add(treeNode);
        int distance = 0;
        Set<TreeNode> visits = new HashSet<>();
        visits.add(treeNode);

        while (!traverse.isEmpty()){
            distance++;
            int size = traverse.size();
            for (int i = 0; i < size; i++) {
                TreeNode parent = null;

                TreeNode temp = traverse.poll();
                if (temp.left != null && !visits.contains(temp.left)) {
                    traverse.add(temp.left);
                    visits.add(temp.left);
                }
                if (temp.right != null && !visits.contains(temp.right)) {
                    traverse.add(temp.right);
                    visits.add(temp.right);
                }
                if(parentsTracker.containsKey(temp)){
                    parent = parentsTracker.get(temp);
                }
                if(parent!=null && !visits.contains(parent)){
                    traverse.add(parent);
                    visits.add(parent);
                }
            }
            if(distance==k){
                break;
            }
        }
        while (!traverse.isEmpty()){
            answer.add(traverse.poll().data);
        }
        return answer;
    }

    public int minTimeToBurnBinaryTree(TreeNode root, TreeNode treeNode){
        if(treeNode==null){
            return 0;
        }
        HashMap<TreeNode,TreeNode> parentsTracker = new HashMap<>();
        parentMapper(parentsTracker,root);
        Queue<TreeNode> traverse = new LinkedList<>();
        traverse.add(treeNode);
        int distance = -1;
        Set<TreeNode> visits = new HashSet<>();
        visits.add(treeNode);

        while (!traverse.isEmpty()){
            distance++;
            int size = traverse.size();
            for (int i = 0; i < size; i++) {
                TreeNode parent = null;

                TreeNode temp = traverse.poll();
                if (temp.left != null && !visits.contains(temp.left)) {
                    traverse.add(temp.left);
                    visits.add(temp.left);
                }
                if (temp.right != null && !visits.contains(temp.right)) {
                    traverse.add(temp.right);
                    visits.add(temp.right);
                }
                if(parentsTracker.containsKey(temp)){
                    parent = parentsTracker.get(temp);
                }
                if(parent!=null && !visits.contains(parent)){
                    traverse.add(parent);
                    visits.add(parent);
                }
            }
        }
        return distance;
    }

    public TreeNode flattenBinaryTreeWithStack(TreeNode treeNode){
        Stack<TreeNode> travor = new Stack<>();
        travor.add(treeNode);
        while (!travor.isEmpty()){
            TreeNode temp = travor.pop();
            if(temp.right != null){
                travor.add(temp.right);
            }
            if(temp.left != null){
                travor.add(temp.left);
            }
            if(!travor.isEmpty()){
                temp.right = travor.peek();
            }
            temp.left = null;
        }
        return treeNode;
    }

    public TreeNode flattenBinaryTreeWithMorrisTraversal(TreeNode treeNode){
        TreeNode curr = treeNode;
        while (curr!=null){
            if(curr.left!=null) {
                TreeNode prev = curr.left;
                while (prev.right != null) {
                    prev = prev.right;
                }
                prev.right = curr.right;
                curr.right = curr.left;
            }
            curr = curr.right;
        }
        return treeNode;
    }

    public TreeNode flattenBinaryTreeByRecursion(TreeNode treeNode){
        TreeNode[] prev = new TreeNode[1];
        prev[0] = null;
        recursionCodeForFlattening(treeNode,prev);
        return treeNode;
    }

    public void recursionCodeForFlattening(TreeNode treeNode, TreeNode[] prev){
        if(treeNode==null){
            return;
        }
        recursionCodeForFlattening(treeNode.right,prev);
        recursionCodeForFlattening(treeNode.left,prev);

        treeNode.right = prev[0];
        treeNode.left = null;

        prev[0] = treeNode;
    }

}