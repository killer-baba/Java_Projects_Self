package org.killers.algorithms.sorting;

public class Main {
    public static void main(String[] args) {
        RadixSort rs = new RadixSort();
        int [] sortedArray = rs.radixSort(new int[]{23,36,12,98,54});
    }
}
