package org.killers.datastructures;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class HashSet {
    private List<Integer>[] hashSet;
    public HashSet() {}

    public static int generateHash( int key){
        return key%1000;

    }
    public void add(int key) {
        int hash = generateHash(key);
        if(hashSet==null || hashSet.length==0){
            hashSet = new List[1000];
            hashSet[hash] = new ArrayList<>();
            hashSet[hash].add(key);
            System.out.println("After Add :: " + hashSet[hash]);
            return;
        }
        List<Integer> tempList = hashSet[hash];
        if(tempList!=null) {
            if (!tempList.contains(key)) {
                hashSet[hash].add(key);
            }
        }
        else {
            hashSet[hash] = new ArrayList<>();
            hashSet[hash].add(key);
        }
        System.out.println("After Add :: " + hashSet[hash]);
    }

    public void remove(int key) {
        int hash = generateHash(key);
        if(hashSet==null || hashSet.length==0 || hashSet[hash] == null || hashSet[hash].isEmpty()){
            return;
        }

        List<Integer> tempList = hashSet[hash];
        if(tempList.contains(key)){
            tempList.remove(Integer.valueOf(key));
        }
        System.out.println("After Remove :: " + hashSet[hash]);
    }

    public boolean contains(int key) {
        int hash = generateHash(key);
        if(hashSet==null || hashSet.length==0 || hashSet[hash] == null){
            return false;
        }

        List<Integer> tempList = hashSet[hash];
        System.out.println("After contains :: " + tempList);
        return tempList.contains(key);

    }


}
