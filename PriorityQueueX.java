package com.sirdave.data_structures;

public class PriorityQueueX {
    // array always sorted from max at 0 to min at size - 1
    private final int maxSize;
    private final long[] array;
    private int numItems;

    public PriorityQueueX(int s) {
        maxSize = s;
        array = new long[maxSize];
        numItems = 0;
    }

    private void insert(long value){
        int i;
        if (numItems == 0){
            array[numItems++] = value;
        }
        else {
            for(i = numItems - 1; i >= 0; i--){
                if (value > array[i]){
                    array[i+1] = array[i]; // shift items forward
                }
                else
                    break;
            }
            array[i+1] = value;
            numItems++;
        }
    }

    private long remove(){
        return array[--numItems];
    }

    private boolean isFull(){
        return numItems == maxSize;
    }

    private boolean isEmpty(){
        return numItems == 0;
    }

    private long peek(){
        return array[numItems - 1];
    }

    public static void main(String[] args){
        PriorityQueueX queue = new PriorityQueueX(10);
        queue.insert(30);
        queue.insert(20);
        queue.insert(10);
        queue.insert(40);

        while (!queue.isEmpty()){
            long value = queue.remove();
            System.out.print(value + " ");
        }

    }

}