package org.killers.algorithms.sorting;

import java.util.Arrays;

public class RadixSort {

    public int getMax(int[] arr){
        int max=Integer.MIN_VALUE;
        for (int j : arr) {
            if (j > max) {
                max = j;
            }
        }
        return max;
    }
    public void countingSort(int[] arr, int size, int exp){
        int[] output = new int[arr.length];
        int[] count = new int[10];

        //increasing the count array based on exp
        for (int i = 0; i < size; i++) {
            count[(arr[i]/exp)%10]++;
        }

        //InPlace arrangement of count Array
        for (int i = 1; i < 10; i++) {
            count[i] += count[i-1];
        }

        //Changing output array according to sorted digit
        for (int i = 0; i < size; i++) {
            output[count[(arr[i]/exp)%10]-1] = arr[i];
            count[(count[i]/exp)%10]--;
        }

        //copy output array back to original one
        for (int i = 0; i < size; i++) {
            arr[i] = output[i];
        }
    }

    public int[] radixSort(int[] arr){
        int max = getMax(arr);
        int exp=1;
        while(max/exp>0){
            countingSort(arr,arr.length,exp);
            exp*=10;
        }
        return arr;
    }
}
