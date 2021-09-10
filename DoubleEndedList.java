package com.sirdave.java_ds_book;

public class DoubleEndedList {
    Link first;
    Link last;

    public DoubleEndedList(){
        first = null;
        last = null;
    }

    public boolean isEmpty(){
        return first == null;
    }

    public void insertFirst(double data){
        Link newLink = new Link(data);
        if (isEmpty())
            last = newLink;
        newLink.next = first;
        first = newLink;
    }

    public void insertLast(double data){
        Link newLink = new Link(data);
        if (isEmpty())
            first = newLink;
        else
            last.next = newLink;
        last = newLink;
    }

    public Link deleteFirst(){
        if (first == null)
            last = null;

        Link temp = first;
        first = temp.next;
        return temp;
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
        DoubleEndedList list = new DoubleEndedList();

        list.insertFirst(30);
        list.insertFirst(20);
        list.insertFirst(10);
        list.insertLast(40);
        list.insertLast(50);


        list.display();

        list.deleteFirst();
        list.display();
    }
}
