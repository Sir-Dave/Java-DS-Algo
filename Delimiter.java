package com.sirdave.java_ds_book;

import java.util.Scanner;

public class Delimiter {
    private final String input;

    public Delimiter(String in){
        input = in;
    }

    public void check(){
        int maxSize = input.length();
        StackX stack = new StackX(maxSize);
        for (int i = 0; i < input.length(); i++){
            char letter = input.charAt(i);
            switch (letter){
                case '[':
                case '(':
                case '{':
                    stack.push(letter);
                    break;

                case ']':
                case ')':
                case '}':
                   if (!stack.isEmpty()){
                       char poppedLetter = stack.pop();
                       if (letter == ']' && poppedLetter != '[' ||
                               letter == ')' && poppedLetter != '(' ||
                               letter == '}' && poppedLetter != '{'){
                           System.out.println("Error at character: " + letter);
                       }
                   }
                   else {
                       System.out.println("Error at character: " + letter);
                   }
                    break;
                default:
                    break;
            }
        }
        if (!stack.isEmpty()){
            System.out.println("ERROR: Right delimiter is missing");
        }
    }

    public static void main(String[] args){
        System.out.println("Please enter a string of characters: ");
        Scanner scanner = new Scanner(System.in);
        String word = scanner.next();
        Delimiter delimiter = new Delimiter(word);
        delimiter.check();
    }
}
