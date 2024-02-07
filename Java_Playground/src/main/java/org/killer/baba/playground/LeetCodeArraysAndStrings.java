package org.killers.playground;

import java.util.Arrays;

public class LeetCodeArraysAndStrings {

    //Find Pivot Index
    public static int pivotIndex(int[] nums) {
        int index=-1;
        int rightSum=0,leftSum=0;
        for (int i = 0; i < nums.length; i++) {
            rightSum += nums[i];
        }
        System.out.println(rightSum);
        for (int i = 0; i < nums.length; i++) {
            rightSum-=nums[i];
            if(leftSum==rightSum){
                return i;
            }
            leftSum+=nums[i];
        }

        return index;
    }

    //Largest Number At Least Twice of Others
    public int dominantIndex(int[] nums) {
        int index=-1;
        int maxInt=Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            if(maxInt<nums[i]){
                maxInt = nums[i];
                index = i;
            }
        }

        for (int i = 0; i < nums.length; i++) {
            if(maxInt!=nums[i] && maxInt<2*nums[i]){
                return -1;
            }
        }
        return index;
    }

    //Plus One
    public static int[] plusOne(int[] digits) {
        int size = digits.length;
        int unitDigit = digits[size-1];
        if(unitDigit!=9){
            digits[size-1] += 1;
            return digits;
        }
        while (size>0 && digits[size-1]==9){
            digits[size-1] = 0;
            size--;
        }
        if(size==0){
            int[] newDigit = new int[digits.length+1];
            newDigit[0] = 1;
            return newDigit;
        }
        else{
            digits[size-1]+=1;
        }
        return digits;
    }

    //Reverse String
    public static void reverseString(char[] s) {
        int i = 0;
        int j = s.length-1;
        while (i<=j){
            char temp = s[i];
            s[i]=s[j];
            s[j]=temp;
            i++;j--;
        }
    }

    //Array Partition I
    public static int arrayPairSum(int[] nums) {
        Arrays.sort(nums);
        int sum=0;
        for (int i = 0; i < nums.length-1; i+=2) {
            sum+=Math.min(nums[i],nums[i+1]);
        }
        return sum;
    }

    //Two Sum II - Input array is sorted
    public static int[] twoSum(int[] numbers, int target) {
        int i=0,j=numbers.length-1;
        int[] ans = new int[2];
        while (i<=j){
            if(numbers[i]+numbers[j]==target){
                ans[0]=i+1;
                ans[1]=j+1;
                System.out.println("Found Ans");
                break;
            }
            else if(numbers[i]+numbers[j]>target){
                j--;
                System.out.println("Entered J : " + j);
            }
            else if(numbers[i]+numbers[j]<target){
                i++;
                System.out.println("Entered I : " + i);
            }
        }
        return ans;
    }

    //Implement strStr()
    public static int strStr(String haystack, String needle) {
        int ans=-1;
        return ans;
    }
    public static void main(String[] args) {
        int x= strStr("hello","lo");
        System.out.println(x);
    }
}
