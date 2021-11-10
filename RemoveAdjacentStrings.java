package com.sirdave.data_structures;

import java.util.Stack;

class Pair{

    Character character;
    int num;

    public Pair(Character character, int num){
        this.character = character;
        this.num = num;
    }
}

public class RemoveAdjacentStrings {

    static String removeDuplicates(String s, int k){

        Stack<Pair> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++){
            char letter = s.charAt(i);
            if (!stack.isEmpty() && stack.peek().character == letter) {
                int c = stack.peek().num + 1;
                stack.pop();
                stack.push(new Pair(letter, c));

                if (c == k) stack.pop();
            }
            else stack.push(new Pair(letter, 1));
        }

        StringBuilder output = new StringBuilder();
        while (!stack.isEmpty()){
            while(stack.peek().num-- > 0) {
                output.append(stack.peek().character);
            }

            stack.pop();
        }
       return output.reverse().toString();
    }

    public static void main(String[] args) {
        System.out.println(removeDuplicates("pbbcggttciiippooaais", 2));
        System.out.println(removeDuplicates("deeedbbcccbdaa", 3));
    }
}
