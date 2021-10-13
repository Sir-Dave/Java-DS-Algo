package com.sirdave.data_structures;

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

    public boolean insertAfter(int key, int value) {
        DoubleLink newLink = new DoubleLink(value);
        DoubleLink current = first;
        while (current.data != key){
            current = current.next;
            if (current == null){
                return false;
            }
        }
        if (current == last){
            newLink.next = null;
            last = newLink;
        }
        else {
            newLink.next = current.next;
            current.next.previous = newLink;
        }
        newLink.previous = current;
        current.next = newLink;
        return true;
    }

    public DoubleLink deleteKey(int key) {
        DoubleLink current = first;
        while (current.data != key){
            current = current.next;
            if (current == null){
                return null;
            }
        }

        if (current == first)
            first = current.next;
        else
            current.previous.next = current.next;

        if (current == last)
            last = current.previous;
        else
            current.next.previous = current.previous;

        return current;
    }

    public void displayForward() {
        DoubleLink current = first;
        while (current != null){
            current.displayLink();
            current = current.next;
        }
        System.out.println();
    }

    public void displayBackward() {
        DoubleLink current = last;
        while (current != null){
            current.displayLink();
            current = current.previous;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        DoublyLinkedListX list = new DoublyLinkedListX();
        list.insertFirst(30);
        list.insertFirst(20);
        list.insertFirst(10);
        list.insertLast(40);
        list.insertLast(50);

        list.insertAfter(10, 15);
        list.deleteKey(20);

        list.displayForward();
        list.displayBackward();
    }

}
