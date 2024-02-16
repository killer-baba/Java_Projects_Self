package org.killer.baba.playground.LeetCode;



import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

public class LeetCodeHashTable {

    //Contains Duplicate
    public static boolean containsDuplicate(int[] nums) {
        HashSet<Integer> checker = new HashSet<>();
        for (Integer i : nums){
            if(checker.contains(i)){
                return true;
            }
            checker.add(i);
        }
        return false;
    }

    //Single Number
    public static int singleNumber(int[] nums) {
        int val = 0;
        HashSet<Integer> checker = new HashSet<>();
        for (Integer i : nums){
            if(checker.contains(i)){
                checker.remove(i);
            }else{
            checker.add(i);}
            }
        for (Integer il : checker){
            System.out.println(il);
            val = il;
        }
        return val;
    }

    //Intersection of Two Arrays
    public int[] intersection(int[] nums1, int[] nums2) {
        HashSet<Integer> hs1 = new HashSet<>();
        for (Integer i : nums1){
            hs1.add(i);
        }
        HashSet<Integer> solHs = new HashSet<>();
        for (Integer i : nums2){
            if (hs1.contains(i)){
                solHs.add(i);
            }
        }
        return solHs.stream().mapToInt(Integer::intValue).toArray();

    }

    //Happy Number
    public static boolean isHappy(int n) {
        HashSet<Integer> happyChecker = new HashSet<>();
        while (n!=1){
            if(happyChecker.contains(n)){
                return false;
            }
            happyChecker.add(n);
            n = sumOfSquareOfDigits(n);
        }
        return true;

    }
    public static int sumOfSquareOfDigits(int num){
        int value=0;
        while (num > 0){
            int temp = num%10;
            num = num/10;
            value+=(temp*temp);
        }
        return value;
    }
    
    //Two Sum
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer,Integer> indexer = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            indexer.put(nums[i],i);
        }
        int[] res = new int[2];
        for (int i = 0; i < nums.length; i++) {
            if(indexer.containsKey(target-nums[i]) && indexer.get(target-nums[i]) != i){
                res[0] = indexer.get(target-nums[i]);
                res[1] = i;
            }
        }
        return res;
    }
    public static void main(String[] args) {
        isHappy(19);
    }
}
