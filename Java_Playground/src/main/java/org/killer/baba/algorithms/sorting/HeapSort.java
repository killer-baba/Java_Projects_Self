package org.killers.algorithms.sorting;

public class HeapSort {
    public void heapify(int [] arr, int size, int i){
        int largest = i;
        int leftChild = 2*i+1;
        int rightChild = 2*i+2;
        if (leftChild < size && arr[leftChild] > arr[largest]){
            largest = leftChild;
        }
        if (rightChild < size && arr[rightChild] > arr[largest]){
            largest = rightChild;
        }
        if(largest!=i){
            int temp = arr[largest];
            arr[largest] = arr[i];
            arr[i] = temp;

            //Recursion
            heapify(arr,size,largest);
        }
    }

    public void maxHeap(int[] arr,int size){
        for (int i = size/2-1; i >= 0; i--) {
            heapify(arr,size,i);
        }
    }

    public void heapSort(int[] arr){
        int size = arr.length;
        maxHeap(arr, size);
        for(int i = arr.length-1; i>0; i--){
            int temp = arr[i];
            arr[i] = arr[0];
            arr[0] = temp;
            heapify(arr,i,0);
        }
    }
}


