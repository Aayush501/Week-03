package org.linearandbinarysearch.solutioncodes;

import java.util.Scanner;

public class FirstAndLastOccurrence {

    // method for finding the first occurrence of the target element
    public int findFirstOccurrence(int [] arr, int target) {
        // finding the first occurrence of the target element using while loop by performing binary search
        int left = 0, right = arr.length-1, firstOccurrence=-1;
        while (left <= right) {
            if (left == right) {
                firstOccurrence = left;
                break;
            }

            // finding the middle element
            int mid = (left + right) / 2;

            if(arr[mid] > target) {
                right = mid-1;
                continue;
            }
            if (arr[mid] < target ) {
                left = mid + 1;
                continue;
            }
            if (arr[mid] == target) {
                right = mid;
            }
        }
        return firstOccurrence;
    }

    // method for finding the last occurrence of the target element
    public int findLastOccurrence (int [] arr, int target) {
        // finding the last occurrence of the target element using while loop by performing binary search
        int left = 0, right = arr.length-1, lastOccurrence=-1;
        while (left <= right) {
            if (left == right && arr[left] == target) {
                lastOccurrence = left;
                break;
            }

            if (left == right) {
                break;
            }

            // finding the middle element
            int mid = (left + right) / 2;

            if(arr[mid] > target) {
                right = mid-1;
                continue;
            }
            if (arr[mid] < target ) {
                left = mid + 1;
                continue;
            }
            if (arr[mid] == target) {
                lastOccurrence = mid;
                left = mid+1;
            }
        }
        return lastOccurrence;
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

        System.out.println("Enter the target element: ");
        int target = sc.nextInt();

        // created the object of FirstAndLastOccurrence class
        FirstAndLastOccurrence obj = new FirstAndLastOccurrence();

        int firstOccurrence = obj.findFirstOccurrence(arr, target);

        if (firstOccurrence == -1) {
            System.out.println(target + " is not present in this array.");
            return;
        }

        int lastOccurrence = obj.findLastOccurrence(arr, target);

        // displaying the output
        System.out.println(target + "'s first occurrence is at index " + firstOccurrence + " and last occurrence is at index " + lastOccurrence);
    }
}
