package com.sirdave.data_structures;

import java.util.Stack;

public class StackWithMin extends Stack<Integer> {
    private static final Stack<Integer> minimum = new Stack<>();

    public Integer pop(){
        int value = super.pop();
        if (value == min()) minimum.pop();
        return value;
    }

    public void push(int value){
        if (value < min()){
            minimum.push(value);
        }
        super.push(value);
    }

    public int min(){
        if (minimum.isEmpty()){
            return Integer.MAX_VALUE;
        }
        else {
            return minimum.peek();
        }
    }

    public static void main(String[] args) {
        StackWithMin stack = new StackWithMin();
        stack.push(5);
        System.out.println(stack.min());
        stack.push(6);
        System.out.println(stack.min());
        stack.push(7);
        System.out.println(stack.min());
        stack.push(3);
        System.out.println(stack.min());
    }
}
