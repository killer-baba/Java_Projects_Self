package org.killer.baba.playground.LeetCode;


import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

class TreeNode {
     int val;
      TreeNode left;
      TreeNode right;
      TreeNode() {}
      TreeNode(int val) { this.val = val; }
      TreeNode(int val, TreeNode left, TreeNode right) {
          this.val = val;
         this.left = left;
          this.right = right;
      }
 }
public class LeetCodeTree {

    public boolean isSameTree(TreeNode p, TreeNode q) {
        Deque<TreeNode> q1 = new LinkedList<>();
        Deque<TreeNode> q2 = new LinkedList<>();
        boolean isSame = false;
        q1.offerLast(p);
        q2.offerLast(q);
        q1.offerLast(null);

        while (!q1.isEmpty() && !q2.isEmpty()){
            TreeNode temp1 = q1.peek();
            TreeNode temp2 = q2.peek();
            if(temp1==null && temp2 == null){
                return true;
            }
            q1.offerLast(temp1.left);
            q1.offerLast(temp1.right);
            q2.offerLast(temp2.left);
            q2.offerLast(temp2.right);
            if(temp1.val!=temp2.val){
                return false;}

            q1.pollFirst();
            q2.pollFirst();

        }
        return true;
    }



}
