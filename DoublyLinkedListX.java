package com.sirdave.java_ds_book;

class DoubleLink{
    public int data;
    public DoubleLink next;
    public DoubleLink previous;

    public DoubleLink(int id){
        data = id;
    }

    public void displayLink(){
        System.out.print(data + " ");
    }
}

public class DoublyLinkedListX {
    DoubleLink first;
    DoubleLink last;

    public DoublyLinkedListX() {
        first = null;
        last = null;
    }

    public boolean isEmpty() {
        return first == null;
    }

    public void insertFirst(int value) {
        DoubleLink newLink =  new DoubleLink(value);
        if (isEmpty())
            last = newLink;
        else
            first.previous = newLink;
        newLink.next = first;
        first = newLink;
    }

    public void insertLast(int value) {
        DoubleLink newLink =  new DoubleLink(value);
        if (isEmpty())
            first = newLink;

        else{
            last.next = newLink;
            newLink.previous = last;
        }
        last = newLink;
    }

    public DoubleLink deleteFirst() {
        DoubleLink temp = first;
        if (first.next == null)
            last = null;
        else
            first.next.previous = null;
        first = first.next;
        return temp;
    }

    public DoubleLink deleteLast() {
        DoubleLink temp = last;
        if (first.next == null)
            first = null;
        else
            last.previous.next = null;
        last = last.previous;
        return temp;
    }

    public DoubleLink deleteKey(int value) {
        return null;
    }

    public void insertAfter(int value) {

    }

    public void displayForward() {

    }

    public void displayBackward() {

    }

    public static void main(String[] args) {
        DoublyLinkedListX list = new DoublyLinkedListX();
    }

}
