package com.sirdave.java_ds_book;

public class OrderedArray {
    private final long[] array;
    private int nElems;

    public OrderedArray(int size){
        array = new long[size];
        nElems = 0;
    }

    public int find(long searchKey){
        int lowerBound = 0;
        int upperBound = nElems - 1;
        int mid;
        while (true){
            mid = (lowerBound + upperBound)/2;

            if (array[mid] == searchKey){
                return mid;
            }
            else if (lowerBound > upperBound){
                return nElems;
            }
            else {
                if (array[mid] < searchKey){
                    lowerBound = mid + 1;
                }
                else {
                    upperBound = mid - 1;
                }
            }
        }
    }

    public int size(){
        return nElems;
    }

    public void insert(long value){
        int i;
        for (i = 0; i < nElems; i++){
            if (array[i] > value)
                break;
        }
        for (int j = nElems; j > i; j--){
            array[j] = array[j - 1];
        }
        array[i] = value;
        nElems++;
    }

    public boolean delete(long value){
        int j = find(value);
        if (j == nElems){
            return false;
        }
        else {
            for(int k=j; k<nElems -1; k++) { // move higher ones down
                array[k] = array[k + 1];
            }
            nElems--;
            return true;
        }
    }

    public void display(){
        for (int i = 0; i < nElems; i++){
            System.out.println(array[i]);
        }
        System.out.println("");
    }


    public static void main(String[] args){
        OrderedArray array = new OrderedArray(10);
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

        array.delete(70);
        array.display();
        System.out.println("The array size is " + array.size());

        array.display();
    }

}