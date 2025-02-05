package org.example;

import java.util.Scanner;

public class SearchInA2DMatrix {

    // created a method to find the presence of target value in a 2d array
    public boolean search(int [][] arr, int target) {
        // performing binary search on all rows of the array
        int left = 0, right = arr.length - 1, index=-1;
        while (left <= right) {
            // finding the middle element
            int mid = (left + right) / 2;

            if(left == right){ // the
                if (arr[mid][0] > target) {
                    index = mid-1;
                } else {
                    index = mid;
                }
                break;
            }

            if(arr[mid][0] > target) {
                // if middle element is greater than target, traversing left half of the array
                right = mid-1;
                continue;
            }
            if (arr[mid][0] < target) {
                // if middle element is smaller than target, traversing right half of the array
                left = mid + 1;
            }
        }

        // performing binary search on the row that contains the target value
        left = 0; right = arr[index].length - 1;
        boolean answer=false;
        while (left <= right) {
            // finding the middle element
            int mid = (left + right) / 2;

            if (arr[index][mid] == target){
                answer = true;
                break;
            }

            if(arr[index][mid] > target) {
                // if middle element is greater than target, traversing left half of the array
                right = mid-1;
                continue;
            }
            if (arr[index][mid] < target) {
                // if middle element is smaller than target, traversing right half of the array
                left = mid + 1;
            }
        }

        return answer;
    }

    // main method
    public static void main(String[] args) {
        // object of scanner class to get inputs from the user
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter number of rows in the array: ");
        int numberOfRows = sc.nextInt();
        System.out.println("Enter number of columns in the array: ");
        int numberOfColumns = sc.nextInt();

        // created an 2D integer array
        int [][] arr = new int[numberOfRows][numberOfColumns];

        // taking inputs for the elements of arr
        System.out.println("Enter elements of array in sorted manner:");
        for (int i = 0; i < numberOfRows; i++) {
            for (int j = 0; j < numberOfColumns; j++) {
                arr[i][j] = sc.nextInt();
            }
        }

        // taking input for target value
        System.out.println("Enter the target value:");
        int target = sc.nextInt();

        // creating the object of SearchInA2DMatrix class
        SearchInA2DMatrix obj = new SearchInA2DMatrix();

        // finding if target is present in the array of not and printing the output
        if(obj.search(arr, target)){
            System.out.println(target + " is present in the array.");
        } else {
            System.out.println(target + " is not present in the array.");
        }
    }
}
