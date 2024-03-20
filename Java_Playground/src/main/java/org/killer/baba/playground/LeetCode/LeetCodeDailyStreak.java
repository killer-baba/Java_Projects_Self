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

}
