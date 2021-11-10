package com.sirdave.data_structures;

import java.util.Stack;

public class SortStack {

    static void sortStack(Stack<Integer> stack){
        Stack<Integer> tempStack = new Stack<>();
        while (!stack.isEmpty()){
            int value = stack.pop();

            while (!tempStack.isEmpty() && tempStack.peek() > value){
                if (tempStack.peek() > value){
                    int num = tempStack.pop();
                    stack.push(num);
                }
            }
            tempStack.push(value);
        }

        while (!tempStack.isEmpty()){
            stack.push(tempStack.pop());
        }
    }

    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        stack.push(4);
        stack.push(3);
        stack.push(7);
        stack.push(9);
        stack.push(2);
        stack.push(1);

        sortStack(stack);

        while (!stack.isEmpty()){
            System.out.println(stack.pop());
        }
    }
}
