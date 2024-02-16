package org.killer.baba.playground.LeetCode;

import java.util.*;

public class LeetCodeArrays101 {

    //Max Consecutive Ones
    public int findMaxConsecutiveOnes(int[] nums) {
        int maxVal=0,tempVar=0;
        for(Integer i : nums){
            if(i==1){
                tempVar++;
                if(maxVal<tempVar){
                    maxVal=tempVar;
                }
            }
            else {
                tempVar=0;
            }
        }
        return maxVal;
    }

    //Find Numbers with Even Number of Digits
    public int findNumbers(int[] nums) {
        int evenNum=0;
        for (Integer in : nums){
            int count = 0;
            while(in !=0){
                in = in/10;
                count++;
            }
            if(count%2==0){
                evenNum++;
            }
        }
        return evenNum;
    }

    //Squares of a Sorted Array
    public static int[] sortedSquares(int[] nums) {
        //two pointer
        int p1 = 0,p2=nums.length-1;
        int []sortedSquareArray = new int[nums.length];
        for (int i=nums.length-1;i>=0;i--){
            if(Math.abs(nums[p1])>Math.abs(nums[p2])){
                sortedSquareArray[i] = nums[p1]*nums[p1];
                p1++;
                System.out.println("if " + sortedSquareArray[i] );
            }
            else {
                sortedSquareArray[i] = nums[p2]*nums[p2];
                p2--;
                System.out.println("else " + sortedSquareArray[i] );
            }
        }
        return sortedSquareArray;
    }

    //Duplicate Zeros
    public static void duplicateZeros(int[] arr) {
        for(int i=arr.length-2;i>=0;i--) {
            if (arr[i] == 0) {
                for (int j = arr.length - 2; j >= i; j--) {
                        arr[j+1] = arr[j];
                }
            }
        }

        for (Integer i : arr){
            System.out.println(i);
        }
    }

    //Merge Sorted Array
    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        int i=0,j=0;
        boolean afterZero = false;
        System.out.print("NUM1 :: ");
        for (Integer o : nums1){
            System.out.print(o + "  ");
        }
        System.out.println(" ");
        System.out.print("NUM2 :: ");
        for (Integer o : nums2){
            System.out.print(o + "  ");
        }
        System.out.println(" ");
        if(nums2!=null && n!=0){
            while(i<m && j<n){
                System.out.println("Values of I : " + i + " and J : " + j);
                if(nums1[i]<nums2[j]){
                    System.out.println("If ");
                    afterZero=true;
                    i++;
                } else if (nums1[i]>=nums2[j]) {
                    System.out.println("If-Else");
                    afterZero=true;
                    for (int k = m-1; k >= i ; k--) {
                        nums1[k+1] = nums1[k];
                    }
                    nums1[i] = nums2[j];
                    m++;
                    i++;
                    j++;
                }
                for (Integer o : nums1){
                    System.out.print(o + "  ");
                }
                System.out.println(" ");
            }
            while(j<n){
                nums1[i] = nums2[j];
                i++;j++;
            }
        }
        for (Integer o : nums1){
            System.out.print(o + "  ");
        }
        System.out.println(" ");

    }

    //Remove Element
    public static int removeElement(int[] nums, int val) {
        int i = 0, j = nums.length-1, counter =0;
        while (i<=j) {
            if (val == nums[i] && val == nums[j]) {
                j--;
                counter++;
            } else if (val == nums[i]) {
                nums[i] = nums[j];
                nums[j] = val;
                j--;
                i++;
                counter++;
            } else {
                i++;
            }
        }
        for (Integer x : nums){
            System.out.print(x + " ");
        }
        return i;
    }

    //Check If N and Its Double Exist
    public static boolean checkIfExist(int[] arr) {
        Hashtable<Integer,Integer> ht = new Hashtable<>();
        int zeroCount =0;
        for (int i = 0; i < arr.length; i++) {
            if(arr[i] != 0) {
                ht.put(i, arr[i]);

            if(ht.contains(arr[i]+arr[i]) ){
                System.out.println("Value at " + i + " is " +arr[i]);
                return true;
            }
            if(arr[i]%2==0 && ht.contains(arr[i]/2)){
                System.out.println("Value at " + i + " is " +arr[i]);
                return true;
            }
            }
            else {
                zeroCount++;
            }
            if(zeroCount==2){
                return true;
            }
        }
        return false;
    }

    //Valid Mountain Array
    public static boolean validMountainArray(int[] arr) {
        int ascFlag=0,descFlag=0,i=0;
        for (i = 0; i < arr.length-1; i++) {
            if(arr[i] < arr[i+1]){
                ascFlag++;
            }
            else if(arr[i] == arr[i+1]){
                return false;
            }
            else{
                break;
            }
        }
        for (int j = i; j < arr.length-1; j++) {
            if(arr[j] > arr[j+1]){
                descFlag++;
            }
            else if(arr[j] == arr[j+1] || arr[j] < arr[j+1]){
                return false;
            }
        }
        if(ascFlag>0 && descFlag>0) {
            return true;
        }
        return false;
    }

    // Remove Duplicates from Sorted Array
    public static int removeDuplicates(int[] nums) {
        for (Integer in : nums){
            System.out.print(in + "  ");
        }
        System.out.println(" ");
        int i=0,j=0,sameCount=0;
        int len = nums.length;
        boolean flag=true;
        if(nums==null){
            return 0;
        }

        while (j<len-1){
            System.out.println("I :: " + i + " J :: " + j);
            if(nums[i]<nums[i+1]) {
                i++;
                j++;
            }
            else if (nums[j]==nums[j+1]) {
                j++;
            } else if (nums[j]<nums[j+1]) {
                nums[i+1] = nums[j+1];
                i++;j++;
            }
        }
        for (Integer in : nums){
            System.out.print(in + "  ");
        }
        return i;
    }

    //Replace Elements with Greatest Element on Right Side
    public int[] replaceElements(int[] arr) {
        if(arr==null || arr.length==0){
            return arr;
        }
        if(arr.length==1){
            arr[0] = -1;
            return arr;
        }
        int max=arr[arr.length-1], temp=0;
        for (int i = arr.length-1; i > 0; i--) {
            if(max<temp){
                max = temp;
            }
            temp = arr[i-1];
            arr[i-1] = max;
        }
        arr[arr.length-1] = -1;

        return arr;
    }

    //Move Zeroes
    public static void moveZeroes(int[] nums) {

        int i = 0, j = 0;
        for (int k = 0; k < nums.length; k++) {
            if(nums[k] == 0){
                i=k;
                j=k;
                break;
            }
        }
        System.out.println("Hello");
        while (j<nums.length){
            if(nums[j]!=0 ){
                int temp = nums[j];
                nums[j] = nums[i];
                nums[i] = temp;
                i++;j++;
            }
            else{
                j++;
            }
        }

        for (Integer in : nums){
            System.out.print( in + "  ");
        }
    }

    //Sort Array By Parity
    public static int[] sortArrayByParity(int[] nums) {
        if(nums==null || nums.length ==0 || nums.length==1){
            return nums;
        }
         int i =0, j=nums.length-1;
         while(i<j){
             while (i<nums.length-1 && nums[i]%2==0 ){
                 i++;
             }
             while (j>=0 && nums[j]%2!=0){
                 j--;
             }
             if(i<j) {
                 int temp = nums[i];
                 nums[i] = nums[j];
                 nums[j] = temp;
                 i++;
                 j--;
             }

         }

        return nums;
    }

    //Height Checker
    public static int heightChecker(int[] heights) {
        int[] sortedArray = new int[heights.length];

        for (int i = 0; i < heights.length; i++) {
            sortedArray[i] = heights[i];
        }
        Arrays.sort(sortedArray);
        int count=0;
        for (int i = 0; i < heights.length; i++) {
            if(heights[i]!=sortedArray[i]){
                count++;
        }
    }
        return count;
}

    //Third Maximum Number
    public static int thirdMax(int[] nums) {
        Arrays.sort(nums);
        int count=1;
        for (Integer i : nums){
            System.out.print(i + " ");
        }
        System.out.println(" ");
        for (int i = nums.length-1; i > 0; i--) {
            System.out.println("COUNT :: " + count);
            if(nums[i] != nums[i-1]){
                count++;
            }
            if(count==3){
                System.out.println("break");
                return nums[i-1];
            }
        }
            return nums[nums.length-1];

    }

    //Find All Numbers Disappeared in an Array
    public static List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> answer = new ArrayList<>();
        for(int i=0;i<nums.length;i++){
            int val = Math.abs(nums[i])-1;
            if(nums[val]>0){
                nums[val]*=-1;
            }
        }

        for (Integer in : nums){
            System.out.print(in + "  ");
        }
        System.out.println(" ");

        for (int i = 0; i < nums.length; i++) {
            if(nums[i]>0){
                answer.add(i+1);
            }
        }
        return answer;
    }
    public static void main(String[] args) {
        List<Integer> answer = findDisappearedNumbers(new int[]{4,3,2,7,8,2,3,1});
        System.out.println(answer);

    }
}
