package org.killers.playground;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class LeetCodeBasics {
    static int[] arr1 = new int[]{1,6,3,9,1};
    static int[][] arr2 = new int[][]{{1,4,6,2,1},{5,7,4,2,1},{2,4,6,3,1}};

    public static int[] parallelProcessing(int[] arr){
        int[] newArr = new int[arr.length];
        newArr[0] = arr[0];
        for(int i = 1;i < arr.length ; i++){
            newArr[i] = newArr[i-1]+arr[i];
        }
        return newArr;
    }
    public static List<String> fizzbuzz(int n){
        List<String> strList = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            int num = i+1;
            if (num%3==0 && num%5==0){
                strList.add("FizzBuzz");
            }
            else if (num%3==0){
                strList.add("Fizz");
            }
            else if (num%5==0){
                strList.add("Buzz");
            }
            else {
                strList.add(String.valueOf(num));
            }
        }

        return strList;
    }

    public static int numberOfSteps(int num) {
        int flag=0;
        while(num!=0){
        if(num%2==0){
            num/=2;
        }
        else{
            num-=1;
        }
        flag++;
        }
        return flag;
    }
    public class ListNode {
      int val;
     ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }

    public ListNode middleNode(ListNode head) {
        ListNode temp = head;
        int size=1;
        while(temp.next!=null){
            temp=temp.next;
            size++;
        }
        if(size%2==0){
            size=size/2;
            size+=1;
        }else{
            size = (size/2)+1;
        }
        for (int i = 1; i < size; i++) {
            head=head.next;
        }
        return head;
    }

    public boolean canConstruct(String ransomNote, String magazine) {
        HashMap<Character, Integer> magazineCount = new HashMap<>();
        for (int i = 0; i < magazine.length(); i++) {
            magazineCount.put(magazine.charAt(i), magazineCount.getOrDefault(magazine.charAt(i), 0) + 1);
        }

        for (int i = 0; i < ransomNote.length(); i++) {
            if (magazineCount.containsKey(ransomNote.charAt(i)) && magazineCount.getOrDefault(ransomNote.charAt(i), 0) > 0) {
                magazineCount.put(ransomNote.charAt(i), magazineCount.getOrDefault(ransomNote.charAt(i), 0) - 1);
            } else {
                return false;
            }
        }
            return true;


    }
    public static void main(String[] args) {

    }

}
