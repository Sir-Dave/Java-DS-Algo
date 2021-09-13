package com.sirdave.java_ds_book;

class Link {
    public int dData;
    public Link next;

    public Link(int dd){
        dData = dd;
    }

    public void displayLink(){
        System.out.print(dData + " ");
    }
}

public class LinkedListX {
    public Link first;

    public LinkedListX(){
        first = null;
    }

    public boolean isEmpty(){
        return first == null;
    }

    public void insertFirst(int dData){
        Link newLink = new Link(dData);
        newLink.next = first;
        first = newLink;
    }

    public Link deleteFirst(){
        Link temp = first;
        first = first.next;
        return temp;
    }

    public void display(){
        Link current = first;
        while (current != null){
            current.displayLink();
            current = current.next;
        }
    }

    public Link find(int key){
        Link current = first;
        while(current.dData!= key){
            if (current.next == null)
                return null;
            else
                current = current.next;
        }
        return current;
    }

    public Link delete(int key){
        Link current = first;
        Link previous = first;
        while (current.dData != key){
            if (current.next == null)
                return null;
            else{
                previous = current;
                current = current.next;
            }
        }
        if (current == first){
            first = first.next;
        }
        else {
            previous.next = current.next;
        }

        return current;
    }

    public static void main(String[] args){
        LinkedListX linkedList = new LinkedListX();
        linkedList.insertFirst(10);
        linkedList.insertFirst(20);
        linkedList.insertFirst(30);
        linkedList.insertFirst(40);
        linkedList.insertFirst(50);

        Link num = linkedList.find(20);
        if (num != null)
            System.out.println("Found link with data " + num.dData);
        else
            System.out.println("Couldn't find link");

        Link del = linkedList.delete(4);
        if (del != null)
            System.out.println("Deleted link with data " + del.dData);
        else
            System.out.println("Couldn't delete link");

        linkedList.display();
    }
}
