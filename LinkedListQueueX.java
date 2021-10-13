package com.sirdave.data_structures;

public class LinkedListQueueX {
    DoubleEndedList list;

    public LinkedListQueueX(){
        list = new DoubleEndedList();
    }

    public void enqueue(int data){
        list.insertLast(data);
    }

    public double dequeue(){
        Link data = list.deleteFirst();
        return data.dData;
    }

    public boolean isEmpty(){
        return list.isEmpty();

    }

    public void display(){
        System.out.println("Queue from front to back");
        list.display();
    }

    public static void main(String[] args){
        LinkedListQueueX queueX = new LinkedListQueueX();
        queueX.enqueue(20);
        queueX.enqueue(40);
        queueX.enqueue(60);
        queueX.enqueue(80);
        queueX.enqueue(100);

        queueX.display();

        System.out.println(queueX.dequeue());
        System.out.println(queueX.dequeue());
        System.out.println(queueX.dequeue());

        queueX.display();
    }

}
