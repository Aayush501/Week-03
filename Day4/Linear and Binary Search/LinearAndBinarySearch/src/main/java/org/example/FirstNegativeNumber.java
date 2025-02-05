package org.example;

import java.util.Scanner;

// definition of FirstNegativeNumber class to perform required operations
public class FirstNegativeNumber {

    // linearSearch method to perform linear search on the array
    public int linearSearch(int[] arr) {
        // iterating through arr using for loop to find the index of first negative element in the array
        for (int i = 0; i < arr.length; i++) {
            if(arr[i] < 0) return i; // this condition will return the index of first negative element in the array
        }

        /*
            if nothing is returned by the loop that means there is no negative element in the array
            hence returning -1
        */
        return -1;
    }

    // main method
    public static void main(String[] args) {
        // object of scanner class to get inputs from the user
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter number of elements in the array: ");
        int sizeOfArray = sc.nextInt();

        // created an integer array
        int [] arr = new int[sizeOfArray];

        // taking inputs for the elements of arr
        System.out.println("Enter elements of array:");
        for (int i = 0; i < sizeOfArray; i++) {
            arr[i] = sc.nextInt();
        }

        // creating object of FirstNegativeNumber class to call the linearSearch method since it is not static
        FirstNegativeNumber obj = new FirstNegativeNumber();

        // performing linear search in this array to find the index of first negative element in this array
        int requiredIndex = obj.linearSearch(arr);

        if (requiredIndex == -1) {
            // if the linearSearch method returns -1 that means no negative element is found in the array
            System.out.println("There is no negative index in this array.");
        } else {
            // displaying the result
            System.out.println("Index of first negative element in this array: " + requiredIndex);
            System.out.println("First negative element is: " + arr[requiredIndex]);
        }
    }
}