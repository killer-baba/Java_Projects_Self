package org.killers.datastructures;

import javax.sound.midi.Soundbank;
import java.util.SortedMap;

public class CircularQueue {

    int[] cqueue;
    int head,tail,size;
    int counter=0;
    public CircularQueue(int k) {
        cqueue = new int[k];
        cqueue[0]=-1;
        size = k;
        head=-1;tail=-1;
    }

    public boolean enQueue(int value) {
        //Inserting very first element
       if(cqueue[0] == -1 && head == -1 && tail == -1){
           cqueue[0] = value;
           tail=0;
           head=0;
           counter++;
           return true;
       }
       if(tail < size-1){
           if(tail == head-1){
               System.out.println("QueueIB is full, Can't Insert");
               return false;
           }
           tail+=1;
           cqueue[tail] = value;
           counter++;
           return true;
       }
       if(cqueue[0] == -1){
           cqueue[0] = value;
           tail=0;
           counter++;
           return true;
       }
        System.out.println("QueueIB is full, Can't Insert");
        return false;
    }

    public boolean deQueue() {
        if(cqueue[0] == -1 && head == -1 && tail == -1){
            System.out.println("QueueIB is Empty, Can't Remove");
            return false;
        }
        if(head==tail){
            cqueue[head] = -1;
            head=-1;tail=-1;
            counter--;
            return true;
        }
        if(head < size-1){
            cqueue[head] = -1;
            head+=1;
            counter--;
            return true;
        }
        cqueue[head] = -1;
        head=0;
        counter--;
        return true;
    }

    public int Front() {
        if(head==-1){
            System.out.println("QueueIB is Empty,Can't return");
            return -1;
        }
        return cqueue[head];
    }

    public int Rear() {
        if(tail==-1){
            System.out.println("QueueIB is Empty,Can't return");
            return -1;
        }
        return cqueue[tail];
    }

    public boolean isEmpty() {
        return head == -1 && tail == -1;
    }

    public boolean isFull() {
        if(counter==size){
            return true;
        }
        return false;
    }

    public void print(){
        int p1=head,p2=tail;
        if(p1==-1 && p2==-1){
            System.out.println("QueueIB is Empty");
            return;
        }
        if(p1==p2){
            System.out.println(cqueue[p1]);
            return;
        }
        while (p1!=p2){
            if(p1==size-1){
                System.out.print(cqueue[p1] + " => ");
                p1=0;
            }
            System.out.print(cqueue[p1] + " => ");
            p1+=1;
        }
        System.out.print(cqueue[p1]);
        System.out.println(" ");
    }

    public void printTestArray(){
        for (Integer i : cqueue){
            System.out.print(i + " ");
        }
        System.out.println(" ");
    }
}
