package org.killer.baba.playground.InterviewBit;

import java.util.LinkedList;




public class LinkedListOne {
    public static void revert(ListNode l1){
        ListNode head = l1;

        ListNode swap1 = l1;
        ListNode swap2 = l1.next;

        while (swap2!=null){
            int swap = swap1.val;
            swap1.val = swap2.val;
            swap2.val = swap;
            swap1 = swap1.next.next;
            swap2 = swap2.next.next;
        }
        head = l1;
        while (head !=null){
            System.out.println(head.val);
            head=head.next;
        }
    }

    public static void removeDuplicates(ListNode l1){
        ListNode current = l1;
        ListNode prev = l1;
        boolean flag = false;
        while(current.val == current.next.val){
            current = current.next;
            flag = true;
        }
        if(flag) {
            l1 = current.next;
        }
        current = l1;
        prev = l1;
        while (current!=null){
            flag = false;
            while(current.next!=null && current.val == current.next.val){
                current = current.next;
                flag = true;
            }
            if(flag){
                prev.next = current.next;
            }else {
                prev = current;
            }
            current = current.next;
        }


        ListNode head = l1;
        while (head !=null){
            System.out.println(head.val);
            head=head.next;
        }
    }

    public static boolean listCycle(ListNode l1) {
        int length = 0, mid = 0;
        ListNode current = l1;
        while (current != null) {
            length++;
            current = current.next;
        }
        boolean answer = true;
        current = l1;
        ListNode p1 = l1;
        mid = length / 2;
        if (length % 2 == 0) {
            for (int i = 0; i < mid; i++) {
                p1 = p1.next;
            }
        } else {
            for (int i = 0; i <= mid; i++) {
                p1 = p1.next;
            }
        }
        ListNode head = p1;
        System.out.println("Printing p1");
        while (head !=null) {
            System.out.println(head.val);
            head = head.next;
        }

        head = p1;
        System.out.println("Printing p1");
        while (head !=null) {
            System.out.println(head.val);
            head = head.next;
        }

        ListNode p2 = reverseList(current, mid);
        while (p1 != null) {
            if (p1.val != p2.val) {
                answer = false;
                break;
            }
            p1 = p1.next;
            p2 = p2.next;
        }

        return answer;
    }

    public static ListNode reverseList(ListNode l1, int length){
        ListNode temp=l1,current =l1,prev=null;
        for (int i = 0; i < length; i++) {
            temp = temp.next;
            current.next = prev;
            prev = current;
            current = temp;
        }
        return prev;
    }

    public static ListNode addAtFront(ListNode l1, ListNode head){
        if(head == null){
            l1.next = null;
        }else{
            l1.next = head;
        }
        return l1;
    }


    public static void evenReverse(ListNode l1){
        if(l1==null){
            //return l1;
        }
        int count=1;
        ListNode current = l1, evenList = null, trackList = null;
        while(current!=null && current.next!=null){
            trackList = current.next.next;
            evenList = addAtFront(current.next,evenList);
            current.next = trackList;
            current = current.next;
        }

        // Removable Print
      /*  System.out.println("Print evenlist");
        while (evenList!=null){
            System.out.print(evenList.val + "==>");
            evenList = evenList.next;
        }
        System.out.println();

        System.out.println("Print oddList");
        while (l1!=null){
            System.out.print(l1.val + "==>");
            l1 = l1.next;
        }
        System.out.println();*/
        //Removable Print

        current = l1;
        //Merge List
        while (current!=null && evenList != null){
            trackList = current.next;
            current.next = evenList;
            current = current.next;
            evenList = evenList.next;
            current.next = trackList;
            current = trackList;
        }

        // Removable Print
       /* System.out.println("Print final");
        while (current !=null){
            System.out.print(current.val + "==>");
            current = current.next;
        }
        System.out.println();*/
        // Removable Print

    }

    public static void reversegivenSize(ListNode A,int B){
        ListNode prevNode = null, nextNode = null, current = A;
        int count = 0;
        while (count<B && current != null){
            nextNode = current.next;
            current.next = prevNode;
            prevNode = current;
            current = nextNode;
            count++;
        }

        if(nextNode!=null){
            A.next = reverseList(nextNode,B);
        }

    }

    public static void insertionSortLinkedList(ListNode A){
        ListNode sortedList = null;
        while (A.next != null){
            if(sortedList==null){
                sortedList = A;
                A=A.next;
                continue;
            }
            while (A.val>sortedList.val){
                sortedList = sortedList.next;
            }
        }

    }

    public static ListNode swap(ListNode A, ListNode prev){
        ListNode swap2 = A.next;
        if(prev==null){
            A.next = swap2.next;
            swap2.next = A;
            return swap2;
        }

        prev.next = swap2;
        A.next = swap2.next;
        swap2.next = A;
        prev = prev.next;
        return swap2;
    }

}
