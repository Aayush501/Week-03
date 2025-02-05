package org.example;

import java.util.HashSet;
import java.util.Scanner;

public class RemoveDuplicates {

    // created a method to remove duplicate characters from the string
    public StringBuilder removeDuplicates(String string) {
        // removing duplicates from the string using HashSet and StringBuilder
        StringBuilder uniqueCharacterString = new StringBuilder();
        HashSet<Character> set = new HashSet<>();

        // iterating through the string to remove the duplicates from the string
        for (int i = 0; i < string.length(); i++) {
            if (!set.contains(string.charAt(i))) {
                set.add(string.charAt(i));
                uniqueCharacterString.append(string.charAt(i));
            }
        }

        return uniqueCharacterString;
    }

    // main method
    public static void main(String[] args) {
        // created object of scanner class and taking a String input from the user
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter a string:");
        String string = sc.next();

        // displaying initial input
        System.out.println("Entered string is " + string);

        // removing duplicates from the string
        RemoveDuplicates obj = new RemoveDuplicates();
        StringBuilder uniqueCharacterString = obj.removeDuplicates(string);

        // displaying string without duplicate characters
        System.out.println("String after removing duplicate characters: " + uniqueCharacterString);
    }
}
