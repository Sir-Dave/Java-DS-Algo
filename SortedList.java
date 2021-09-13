package com.sirdave.java_ds_book;

public class SortedList {
    Link first;


    public SortedList(){
        first = null;
    }

    public void insert(int data){
        Link newLink = new Link(data);
        Link previous = null;
        Link current = first;

        while (current != null && current.dData < data){
            previous = current;
            current = current.next;
        }

        if (previous == null)
            first = newLink;
        else
            previous.next = newLink;
        newLink.next = current;
    }

    public Link remove(){
        Link temp = first;
        first = first.next;
        return temp;
    }

    public boolean isEmpty(){
        return first == null;
    }

    public void display(){
        Link current = first;
        while (current != null){
            current.displayLink();
            current = current.next;
        }
        System.out.println("");
    }

    public static void main(String[] args){
        SortedList list = new SortedList();
        list.insert(23);
        list.insert(1);
        list.insert(13);
        list.insert(3);
        list.insert(18);
        list.insert(23);
        list.insert(32);
        list.insert(19);

        list.display();

        list.remove();
        list.remove();
        list.display();
    }
}
