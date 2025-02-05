package org.example;

import java.util.Scanner;

public class ConcatenateStrings {

    // created a method to concatenate all strings of a string array
    public String concatenate(String[] arr) {
        // creating StringBuffer for smooth concatenation of strings
        StringBuffer string = new StringBuffer();
        for (String s : arr) {
            string.append(s);
        }

        // converting the StringBuffer to String
        return new String(string);
    }

    // main method
    public static void main(String[] args) {
        // object of scanner class to get inputs from the user
        Scanner sc = new Scanner(System.in);

        // taking input for number of words from the user
        System.out.println("Enter number of words: ");
        int noOfWords = sc.nextInt();

        // creating an array of words
        String [] words = new String[noOfWords];
        String temp = sc.nextLine(); // to avoid conflicts while taking input

        // taking sentence inputs from user
        System.out.println("Enter words");
        for (int i = 0; i < noOfWords; i++) {
            words [i] = sc.next();
        }

        // concatenating all the strings entered by user
        ConcatenateStrings obj = new ConcatenateStrings();
        String concatenatedString = obj.concatenate(words);

        // displaying the output
        System.out.println("Concatenated string: " + concatenatedString);
    }
}
