package org.stringbuilderandstringbuffer.solutions;

import java.util.Scanner;

public class ReverseString {
    public String reverse(String sentence){
        // created object of StringBuilder
        StringBuilder newSentence = new StringBuilder();

        // appending the sentence to StringBuilder
        newSentence.append(sentence);

        // reversing the sentence
        newSentence.reverse();

        // converting StringBuilder back to String
        sentence = newSentence.toString();

        return sentence; // returning reverse sentence
    }
    public static void main(String[] args) {
        // created object of scanner class and taking a String input from the user
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter a string:");
        String sentence = sc.nextLine();

        // displaying initial input
        System.out.println("Entered string is " + sentence);
        
        // reversing the string using object of this class
        ReverseString obj = new ReverseString();

        sentence = obj.reverse(sentence);

        // displaying reversed string
        System.out.println("Reversed string is " + sentence);
    }
}