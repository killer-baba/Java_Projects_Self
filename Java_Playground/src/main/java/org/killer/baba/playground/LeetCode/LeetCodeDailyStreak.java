package org.killer.baba.playground.LeetCode;

import org.killer.baba.playground.InterviewBit.ListNode;

public class LeetCodeDailyStreak {

    public int pivotInteger(int n) {

        double root = Math.sqrt(n);

        if(root%1==0){
            return (int) root;
        }
        return (int)root;

    }

    public static ListNode mergeInBetween(ListNode list1, int a, int b, ListNode list2) {
        if(list1==null || list2==null){
            return null;
        }
        ListNode secondListLastNode = null;
        ListNode temp = list2;
        while (temp !=null){
            secondListLastNode = temp;
            temp = temp.next;
        }
        temp = list1;
        for (int i = 1; i <= b+1 && temp.next != null; i++) {
            if(i == a){
                ListNode prev = temp;
                temp = temp.next;
                prev.next = list2;
                i+=1;
            }
            temp = temp.next;
        }
        if(temp!=null){
            secondListLastNode.next = temp;
        }

        return list1;
    }

    public ListNode reverseList(ListNode head) {
        if(head==null || head.next == null){
            return head;
        }
        ListNode prevnode = head, curr = head.next, nextNode = head.next;
        while (curr != null){
            nextNode = nextNode.next;
            curr.next = prevnode;
            prevnode = curr;
            curr = nextNode;
        }
        return prevnode;
    }

    public boolean isPalindrome(ListNode head) {
        if(head==null || head.next==null){
            return true;
        }
        int middle = 0,tocheck=0;
        ListNode middleNode = head,curr = head;
        while (curr!=null){
            middle += 1;
            curr = curr.next;
        }
        tocheck = middle/2;
        if(middle%2==0){
            middle = middle/2;
        }else {
            middle = middle/2+1;
        }
        for (int i = 0; i < middle; i++) {
            middleNode = middleNode.next;
        }
        middleNode = reverseList(middleNode);

        for (int i = 0; i < tocheck; i++) {
            if(middleNode.val!=head.val){
                return false;
            }
            middleNode = middleNode.next;
            head = head.next;

        }
        return true;
    }


}
