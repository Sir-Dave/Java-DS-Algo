package com.sirdave.java_ds_book;

public class Array {
    private final long[] array;
    private int nElements;

    public Array(int max) {
        array = new long[max];
        nElements = 0;
    }

    public boolean find(long searchKey) {
        int i;
        for (i = 0; i < nElements; i++) {
            if (array[i] == searchKey) {
                break;
            }
        }
        return i != nElements;
    }

    public void insert(long value) {
        array[nElements] = value;
        nElements++;
    }


    public boolean delete(long value) {
        int j;
        for(j=0; j<nElements; j++) {
            if (array[j] == value) {
                break;
            }
        }
        if (j==nElements) {
            return false;
        }
        else {
            for(int k=j; k<nElements-1; k++) { // move higher ones down
                array[k] = array[k + 1];
            }
            nElements--;
            return true;
        }
    }

    public void bubbleSort(){
        int i,j;
        for (i = nElements - 1; i> 1; i--){
            for (j = 0; j < i; j++){
                if (array[j] > array[j+1]){
                    long temp = array[j];
                    array[j] = array[j + 1];
                    array[j+1] = temp;
                }
            }
        }
    }

    public void selectionSort(){
        int i, j, min;
        for (i = 0; i < nElements; i++){
            min = i;
            for (j = i+1; j < nElements; j++){
                if (array[j] < array[min]){
                    min = j;
                }
            }

            long swap = array[i];
            array[i] = array[min];
            array[min] = swap;
        }
    }

    public void insertionSort() {
        int i, j;
        for (i = 1; i < nElements; i++) {
            long temp = array[i];
            j = i;

            while (j > 0 && array[j - 1] >= temp) {
                array[j] = array[j - 1];
                --j;
            }
            array[j] = temp;
        }
    }

    public void display(){
        for (int i = 0; i < nElements; i++){
            System.out.println(array[i]);
        }
        System.out.println("");
    }


    public static void main(String[] args){
        Array array = new Array(10);
        array.insert(70);
        array.insert(20);
        array.insert(50);
        array.insert(30);
        array.insert(100);
        array.insert(10);
        array.insert(40);
        array.insert(90);
        array.insert(60);
        array.insert(80);

        array.display();

        array.delete(60);
        array.insertionSort();
        array.display();
    }
}