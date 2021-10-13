package com.sirdave.data_structures;

import java.util.Scanner;

class Reverser{
    private final String input;

    public Reverser(String in){
        input = in;
    }

    public String doReverse(){
        int length = input.length();
        StackX stack = new StackX(length);
        for (int i = 0; i < length; i++){
            stack.push(input.charAt(i));
        }
        StringBuilder output = new StringBuilder();
        while (!stack.isEmpty()){
            char letter = stack.pop();
            output.append(letter);
        }
        return output.toString();
    }

    public static void main(String[] args){
        System.out.println("Please enter a word: ");
        Scanner scanner = new Scanner(System.in);
        String word = scanner.next();
        Reverser reverser = new Reverser(word);
        String reversedWord = reverser.doReverse();
        System.out.println("reversed word is " + reversedWord);
    }
}