package org.killer.baba.datastructures.Tree.Traversal;

import com.sun.source.tree.Tree;
import org.killer.baba.datastructures.Tree.TreeNode;

import java.util.*;

public class VerticalOrderTraversal {

    public ArrayList<Integer> verticalOrderTraversal(TreeNode treeNode){
        System.out.println("hello");
        TreeMap<Integer,TreeMap<Integer, PriorityQueue<Integer>>> answerLike = new TreeMap<>();
        Queue<Tuple> treeTraverser = new LinkedList<>();
        treeTraverser.add(new Tuple(treeNode,0,0));
        ArrayList<Integer> answer = new ArrayList<>();

        while (!treeTraverser.isEmpty()){
            int length = treeTraverser.size();
                Tuple temp = treeTraverser.poll();
                int x = temp.vertical;
                int y = temp.level;

                if (!answerLike.containsKey(temp.vertical)) {
                    answerLike.put(temp.vertical, new TreeMap<>());
                }

                if (!answerLike.get(temp.vertical).containsKey(temp.level)) {
                    answerLike.get(temp.vertical).put(temp.level, new PriorityQueue<>());
                }

                answerLike.get(x).get(y).add(temp.treeNode.data);

                if (temp.treeNode.left != null) {
                    treeTraverser.add(new Tuple(temp.treeNode.left,x-1,y+1));
                }

                if (temp.treeNode.right != null) {
                    treeTraverser.add(new Tuple(temp.treeNode.right,x+1,x+1));
                }
        }
        for (Integer i : answerLike.keySet()){
            TreeMap<Integer, PriorityQueue<Integer>> temp = answerLike.get(i);
            for(Integer j : temp.keySet()){
                answer.addAll(temp.get(j));
            }
        }
        return  answer;
    }

    //Top View Of Binary Tree
    public ArrayList<Integer> binaryTreeTopView(TreeNode treeNode){
        TreeMap<Integer,TreeMap<Integer, PriorityQueue<Integer>>> answerLike = new TreeMap<>();
        Queue<Tuple> treeTraverser = new LinkedList<>();
        treeTraverser.add(new Tuple(treeNode,0,0));
        ArrayList<Integer> answer = new ArrayList<>();

        while (!treeTraverser.isEmpty()){
            Tuple temp = treeTraverser.poll();
            int x = temp.vertical;
            int y = temp.level;

            if (!answerLike.containsKey(temp.vertical)) {
                answerLike.put(temp.vertical, new TreeMap<>());
            }

            if (!answerLike.get(temp.vertical).containsKey(temp.level)) {
                answerLike.get(temp.vertical).put(temp.level, new PriorityQueue<>());
            }

            answerLike.get(x).get(y).add(temp.treeNode.data);

            if (temp.treeNode.left != null) {
                treeTraverser.add(new Tuple(temp.treeNode.left,x-1,y+1));
            }

            if (temp.treeNode.right != null) {
                treeTraverser.add(new Tuple(temp.treeNode.right,x+1,x+1));
            }
        }
        for (Integer i : answerLike.keySet()){
            TreeMap<Integer, PriorityQueue<Integer>> temp = answerLike.get(i);
            boolean flag = true;
            for(Integer j : temp.keySet()){
                if(flag) {
                    answer.add(temp.get(j).poll());
                }
                flag = false;
            }
        }
        return  answer;
    }

    public ArrayList<Integer> binaryTreeTopViewSecondApproach(TreeNode treeNode){
        ArrayList<Integer> answer = new ArrayList<>();
        TreeMap<Integer,Integer> ansLike = new TreeMap<>();
        Queue<TreePair> queue = new LinkedList<>();
        queue.add(new TreePair(treeNode, 0));
        while (!queue.isEmpty()){
            TreePair temp = queue.remove();
            int x = temp.value;
            ansLike.put(x,ansLike.getOrDefault(x,temp.treeNode.data));

            if(temp.treeNode.left!=null){
                queue.add(new TreePair(temp.treeNode.left,x-1));
            }
            if(temp.treeNode.right!=null){
                queue.add(new TreePair(temp.treeNode.right,x+1));
            }
        }

        for (Integer i : ansLike.keySet()){
            answer.add(ansLike.get(i));
        }
        return answer;
    }

    public ArrayList<Integer> binaryTreeBottomView(TreeNode treeNode){
        ArrayList<Integer> answer = new ArrayList<>();
        TreeMap<Integer,Integer> ansLike = new TreeMap<>();
        Queue<TreePair> queue = new LinkedList<>();
        queue.add(new TreePair(treeNode, 0));
        while (!queue.isEmpty()){
            TreePair temp = queue.remove();
            int x = temp.value;
            ansLike.put(x,ansLike.getOrDefault(temp.treeNode.data,temp.treeNode.data));


            if(temp.treeNode.left!=null){
                queue.add(new TreePair(temp.treeNode.left,x-1));
            }
            if(temp.treeNode.right!=null){
                queue.add(new TreePair(temp.treeNode.right,x+1));
            }
        }

        for (Integer i : ansLike.keySet()){
            answer.add(ansLike.get(i));
        }
        return answer;
    }


}
