package org.killers.playground;

import org.killers.algorithms.sorting.RadixSort;

import java.util.*;
public class LeetCodeSorting {

    //Node
    public class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    //Sort Colors
    public static void sortColors(int[] nums) {
        int zeroCount = 0, oneCount = 0, twoCount = 0;
        for (int k = 0; k < nums.length; k++) {
            if (nums[k] == 0) {
                zeroCount++;
            } else if (nums[k] == 1) {
                oneCount++;
            } else if (nums[k] == 2) {
                twoCount++;
            }
        }
        for (int i = 0; i < nums.length; i++) {
            if (zeroCount > 0) {
                nums[i] = 0;
                zeroCount--;
                continue;
            }
            if (oneCount > 0) {
                nums[i] = 1;
                oneCount--;
                continue;
            }
            if (twoCount > 0) {
                nums[i] = 2;
                twoCount--;

            }
        }

        for (Integer in : nums) {
            System.out.print(in + " ");
        }
    }

    //Insertion Sort List
    public ListNode insertionSortList(ListNode head) {
        ListNode sortedNode = null;
        if(head==null || head.next == null){
            return head;
        }

        ListNode current = head;
        while(current !=null){
            ListNode nextu = current.next;
            sortedNode = insertInSortedNode(current, sortedNode);
            current = nextu;
        }


        return sortedNode;
    }
    public ListNode insertInSortedNode(ListNode current, ListNode sortedList){
        if(sortedList == null || current.val <= sortedList.val){
            current.next = sortedList;
            sortedList = current;
            return sortedList;
        }
        ListNode cursor = sortedList;
        while(cursor.next!=null && cursor.next.val < current.val){
            cursor = cursor.next;
        }
        current.next = cursor.next;
        cursor.next = current;
        return sortedList;
    }


    //Minimum Absolute Difference
    public static List<List<Integer>> minimumAbsDifference(int[] arr) {
        Arrays.sort(arr);
        for (Integer in : arr) {
            System.out.print(in + "  ");
        }
        System.out.println(" ");
        ArrayList<Integer> subList;
        List<List<Integer>> finalList = new ArrayList<>();
        int minDiff = Integer.MAX_VALUE;
        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i + 1] - arr[i] < minDiff) {
                minDiff = arr[i + 1] - arr[i];
            }
        }
        System.out.println(minDiff);
        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i + 1] - arr[i] == minDiff) {
                subList = new ArrayList<>();
                subList.add(arr[i]);
                subList.add(arr[i + 1]);
                System.out.println(subList);
                finalList.add(subList);
            }
        }
        return finalList;
    }

    //Query Kth Smallest Trimmed Number
    public int[] smallestTrimmedNumbers(String[] nums, int[][] queries) {
        return null;
    }

    //Maximum Gap
    public int maximumGap(int[] nums) {
        if(nums.length==1 || nums.length==0){
            return 0;
        }
        int max = Integer.MIN_VALUE;
        Arrays.sort(nums);
        for (int i = 1; i < nums.length; i++) {
            if(max<nums[i]-nums[i-1]){
                max = nums[i]-nums[i-1];
            }
        }
        return max;
    }

    //Top K Frequent Elements
    public static int[] topKFrequent(int[] nums, int k) {
        int count=0;
        int max = Arrays.stream(nums).max().getAsInt();
        Map<Integer,Integer> mapper= new HashMap<>();
        for (Integer i : nums){
                mapper.put(i,mapper.getOrDefault(i,0)+1);
        }

        for (Integer I : mapper.values()){
            System.out.println(I);
        }
        int maxFreq = 0;
        for(Integer i : mapper.values()){
            maxFreq =Math.max(maxFreq,i);
        }
        System.out.println(maxFreq);

        List<Integer>[] freqCount = new List[maxFreq+1];
        for (int i = 0; i < maxFreq+1; i++) {
            freqCount[i] = new ArrayList<>();
        }

        for (int num : mapper.keySet()){
            int freq = mapper.get(num);
            System.out.println("FREQ:: " + freq + "num :; " + num);
            freqCount[freq].add(num);
        }

        List<Integer> result = new ArrayList<>();
        for (int i = maxFreq  ; i >=0 &&  result.size()<k; i--) {
            result.addAll(freqCount[i]);
        }

        int[] ansArray = new int[k];
        for (int i = 0; i < ansArray.length; i++) {
            ansArray[i] = result.get(i);
            System.out.println(ansArray[i]);
        }


        return ansArray;
    }
    public static void main(String[] args) {
        topKFrequent(new int[]{1,1,1,2,2,3,4},2);
    }
}
