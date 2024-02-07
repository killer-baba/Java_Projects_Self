package org.killers;

import org.killers.datastructures.CircularQueue;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {

        CircularQueue cq = new CircularQueue(5);
        cq.enQueue(78);
        cq.enQueue(88);
        cq.enQueue(98);
        cq.enQueue(65);
        cq.enQueue(45);
        cq.deQueue();
        cq.deQueue();
        cq.deQueue();
        cq.deQueue();
        cq.printTestArray();
        cq.enQueue(32);
        cq.printTestArray();
        System.out.println(cq.isEmpty());
        cq.enQueue(7);
        cq.enQueue(45);
        cq.print();
        System.out.println(cq.isEmpty());
        cq.printTestArray();
    }
}