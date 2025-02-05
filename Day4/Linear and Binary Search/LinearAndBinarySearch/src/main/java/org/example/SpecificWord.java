package org.example;

import java.util.Scanner;

public class SpecificWord {

    // linearSearch method to find the sentence that contains the target word
    public String linearSearch(String[] arr, String target) {
        // iterating through all elements of arr to find the occurrence of target word using foreach loop
        for (String s : arr) {
            // using nested loop to find if the target word is present in current sentence
            for (int i = 0; i <= s.length()-target.length(); i++) {
                String check = s.substring(i, i+target.length());
                if (target.equals(check)) return s;
            }
        }

        /*
            if nothing is returned from the loop that means target word is not present in the array
            hence returning "Not Found"
        */

        return "Not Found";
    }

    // main method
    public static void main(String[] args) {
        // object of scanner class to get inputs from the user
        Scanner sc = new Scanner(System.in);

        // taking input for number of sentences from the user
        System.out.println("Enter number of sentences");
        int noOfSentences = sc.nextInt();

        // creating an array of sentences
        String [] sentences = new String[noOfSentences];
        String temp = sc.nextLine(); // to avoid conflicts while taking input

        // taking sentence inputs from user
        System.out.println("Enter sentences");
        for (int i = 0; i < noOfSentences; i++) {
            sentences [i] = sc.nextLine();
        }

        // taking input for target word
        System.out.println("Enter target word:");
        String target = sc.next();

        // creating the object of SpecificWord Class to call the linearSearch method since it is not static
        SpecificWord obj = new SpecificWord();

        // applying linear search algorithm to find the occurrence of the target word
        System.out.println("The first sentence to contain " + target + " is " + ": " + obj.linearSearch(sentences, target));
    }
}
