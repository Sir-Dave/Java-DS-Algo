package com.sirdave.java_ds_book;

public class QueueX {
    private final int maxSize;
    private final long[] array;
    private int front;
    private int rear;
    private int numItems;

    public QueueX(int s) {
        maxSize = s;
        array = new long[maxSize];
        front = 0;
        rear  = -1;
        numItems = 0;
    }

    private long dequeue(){
        long temp = array[front++];
        if (front == maxSize){
            front = 0;
        }
        numItems--;
        return temp;

    }

    private void enqueue(long value){
        if (rear == maxSize - 1){
            rear = -1;
        }
        array[++rear] = value;
        numItems++;
    }

    private boolean isFull(){
        return numItems == maxSize;
    }

    private boolean isEmpty(){
        return numItems == 0;
    }

    private long peek(){
        return array[front];
    }

    public static void main(String[] args){
        QueueX queue = new QueueX(10);
        queue.enqueue(10);
        queue.enqueue(20);
        queue.enqueue(30);
        queue.enqueue(40);

        /*queue.dequeue();
        queue.dequeue();
        queue.dequeue();*/

        while (!queue.isEmpty()){
            long value = queue.dequeue();
            System.out.print(value + " ");
        }

    }
}
