package org.linearandbinarysearch.solutioncodes;

import java.util.Scanner;

public class ChallengeProblem {

    // method to find the first missing element in the array
    public int findMissing(int [] arr) { // arr needs to be sorted
        // iterating through the array
        for (int i = 0; i < arr.length-1; i++) {
            if (arr[i+1] - arr[i] > 1) {
                return arr[i]+1; // this element is missing in the array
            }
        }
        return arr[arr.length-1]+1; // if nothing is returned by loop that means no element is missing in the array
    }

    // method to find the index of target element in the array
    public int searchElement(int [] arr, int target) {
        // applying binary search using while loop to find the index of target element in the array
        int left = 0, right = arr.length-1, index=-1;
        while (left <= right) {

            // finding the middle element
            int mid = (left + right) / 2;

            if (arr[mid] == target) { // element is found
                index = mid;
                break;
            }

            if(arr[mid] > target) {
                // if middle element is greater than target, traversing left half of the array
                right = mid-1;
                continue;
            }
            if (arr[mid] < target ) {
                // if middle element is smaller than target, traversing right half of the array
                left = mid + 1;
            }
        }
        return index; // returning the array, this will return -1 if the target is not found
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
        System.out.println("Enter elements of array in sorted manner:");
        for (int i = 0; i < sizeOfArray; i++) {
            arr[i] = sc.nextInt();
        }

        // creating the object of ChallengeProblem class
        ChallengeProblem obj = new ChallengeProblem();

        // finding the first missing positive integer in the array
        int firstMissing = obj.findMissing(arr);
        // displaying the output
        System.out.println("The first missing element in the array is " + firstMissing);

        // finding the index of a target element
        System.out.println("Enter the target element: ");
        int target = sc.nextInt();

        int indexOfTarget = obj.searchElement(arr, target);

        // displaying the output
        if (indexOfTarget == -1) {
            System.out.println(target + " is not present in the array.");
        } else {
            System.out.println("The index of " + target + " is " + indexOfTarget);
        }
    }
}
