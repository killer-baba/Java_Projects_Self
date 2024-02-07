package org.killer.baba.algorithms.recursion;

public class ThreePoleTowerOfHanoi {

    public void towerOfHanoi(int noOfDisks, String beginningPole, String auxiliaryPole, String destinationPole){
        if(noOfDisks==1){
            System.out.println("Move Disk 1 from Pole " + beginningPole + " to Pole " + destinationPole);
            return;
        }

        towerOfHanoi(noOfDisks-1, beginningPole, destinationPole, auxiliaryPole);

        System.out.println("Move Disk " + (noOfDisks) + " from Pole " + beginningPole + " to Pole " + destinationPole);

        towerOfHanoi(noOfDisks-1, auxiliaryPole, beginningPole, destinationPole);
    }
}
