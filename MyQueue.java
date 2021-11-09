package com.sirdave.data_structures;

import java.util.Stack;

public class MyQueue<T> {
    Stack<T> stackOldest, stackNewest;

    public MyQueue(){
        stackOldest = new Stack<>();
        stackNewest = new Stack<>();
    }

    public T peek(){
        shiftStacks();
        return stackOldest.peek();
    }

    public void add(T value){
        stackNewest.push(value);
    }

    public void shiftStacks(){
        if (stackOldest.isEmpty()){
            while (!stackNewest.isEmpty()){
                stackOldest.push(stackNewest.pop());
            }
        }
    }

    public T remove(){
        shiftStacks();
        return stackOldest.pop();
    }

    public static void main(String[] args) {
        MyQueue<Integer> queue = new MyQueue<>();
        queue.add(1);
        queue.add(2);
        queue.add(3);
        queue.add(4);
        queue.add(5);

        queue.remove();
        System.out.println(queue.peek());
    }
}
