package com.sirdave.java_ds_book;

class Link {
    public int iData;
    public double dData;
    public Link next;

    public Link(int id, double dd){
        iData = id;
        dData = dd;
    }

    public void displayLink(){
        System.out.println("{" +  iData + ", " + dData + "} ");
    }
}

public class LinkedListX{
    public Link first;

    public LinkedListX(){
        first = null;
    }

    public boolean isEmpty(){
        return first == null;
    }

    public void insertFirst(int iData, double dData){
        Link newLink = new Link(iData, dData);
        newLink.next = first;
        first = newLink;
    }

    public Link deleteFirst(){
        Link temp = first;
        first = first.next;
        return temp;
    }

    public void display(){
        System.out.println("first ==> last");
        Link current = first;
        while (current != null){
            current.displayLink();
            current = current.next;
        }
    }

    public Link find(int key){
        Link current = first;
        while(current.iData != key){
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
        while (current.iData != key){
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
        linkedList.insertFirst(1, 10);
        linkedList.insertFirst(2, 20);
        linkedList.insertFirst(3, 30);
        linkedList.insertFirst(4, 40);
        linkedList.insertFirst(5, 50);

        Link num = linkedList.find(2);
        if (num != null)
            System.out.println("Found link with data " + num.iData);
        else
            System.out.println("Couldn't find link");

        Link del = linkedList.delete(4);
        if (del != null)
            System.out.println("Deleted link with data " + del.iData);
        else
            System.out.println("Couldn't delete link");

        linkedList.display();
    }
}
