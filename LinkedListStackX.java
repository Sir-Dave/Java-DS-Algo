package com.sirdave.data_structures;

public class LinkedListStackX {
    DoubleEndedList list;

    public LinkedListStackX(){
        list = new DoubleEndedList();
    }

    public void push(int value){
        list.insertFirst(value);
    }

    public double pop(){
        Link data =  list.deleteFirst();
        return data.dData;
    }

    public boolean isEmpty(){
        return list.isEmpty();
    }

    public void displayStack(){
        System.out.println("Stack from top to bottom");
        list.display();
    }

    public static void main(String[] args){
        LinkedListStackX stack = new LinkedListStackX();
        stack.push(12);
        stack.push(28);
        stack.push(2);
        stack.push(4);
        stack.push(7);
        stack.push(19);

        stack.displayStack();

        while (!stack.isEmpty()){
            double value = stack.pop();
            System.out.println("value is " + value);
        }
    }
}
