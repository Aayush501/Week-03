package org.linearandbinarysearch.solutioncodes;

import java.util.Scanner;

public class RotationPoint {
    // created a method to apply binary search on array to find the Rotation Point
    public int search(int[] arr, int left, int right) {
        if(left == right) return arr[left]; // condition for Rotation Point

        // finding the middle index of the array
        int mid = (right+left) / 2;

        if (arr[mid] > arr[right]) {
            return search(arr, mid+1, right); // the smallest element is in the right half
        }

        return search(arr, left, mid); // the smallest element is in the left half
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
        System.out.println("Enter elements of array in a rotated sorted manner:");
        for (int i = 0; i < sizeOfArray; i++) {
            arr[i] = sc.nextInt();
        }
        // creating object of RotationPoint class to call the search method since it is not static
        RotationPoint obj = new RotationPoint();

        // performing binary search in this array to find the Rotation Point
        int rotationPoint = obj.search(arr, 0, sizeOfArray-1);

        // displaying the result
        System.out.println("Rotation Point in this array is: " + rotationPoint);
    }
}
