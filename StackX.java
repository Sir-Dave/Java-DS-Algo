package com.sirdave.java_ds_book;

public class StackX {
    private final int maxSize;
    private final char[] array;
    private int top;

    public StackX(int s){
        maxSize = s;
        array = new char[s];
        top = -1;
    }

    public void push(char value){
        array[++top] = value;
    }

    public char pop(){
        return array[top--];
    }

    public char peek(){
        return array[top];
    }


    public boolean isFull(){
        return top == maxSize - 1;
    }

    public boolean isEmpty(){
        return top == -1;

    }

}