package org.killer.baba.datastructures;

public class LinkedList {
    private Node head;

    //Constructor 1
    public LinkedList(){}
    //Constructor 2
    public LinkedList(int value){
        head = new Node();
        this.head.setValue(value);
    }
    //Constructor 3
    public LinkedList(int value,Node next){
        head = new Node();
        this.head.setValue(value);
        this.head.setNext(next);
    }
    public int add(int value){
        //If head is null, Create a node and assign new value
        if(head==null){
            head=new Node();
            head.setValue(value);
            return head.getValue();
        }

        //If head is not null we will use a temp variable to get to the end of node and assign value to the last node
        Node temp = head;
        while(temp.getNext()!=null) {
            temp = temp.getNext();
        }
        temp.setNext(new Node(value));
        return temp.getNext().getValue();
    }

    public int size(){
        if(head==null) {
            return 0;
        }
        int size=1;
        Node temp = head;
        while(temp.getNext()!=null){
            size++;
            temp = temp.getNext();
        }
        return size;
    }

    public void print(){
        if(head==null){
            System.out.println("Linked List is Empty");
        }
        Node temp = head;
        while(temp!=null){
            System.out.print(temp.getValue() + "  " );
            temp=temp.getNext();
        }
        System.out.println();
    }

    public void remove(int index){
        if(head==null){
            System.out.println("LinkedList is Empty, Can't remove");
            return;
        }
        int size = size();
        if(size <= index){
            System.out.println("Index is Greater then size of LinkedList, Can't remove");
            return;
        }
        if(index==0){
            int val = head.getValue();
            head = head.getNext();
            System.out.println("Successfully removed " + val);
            return;
        }
        Node temp = head;
        Node prev = null;
        int count=0;
        while (count!=index){
            prev=temp;
            temp=temp.getNext();
            count++;
        }
        int val = temp.getValue();
        if(temp.getNext()!=null) {

            prev.setNext(temp.getNext());
            System.out.println("Successfully removed " + val);
            return;
        }
        prev.setNext(null);
        System.out.println("Successfully removed " + val);
        return;
    }
}
