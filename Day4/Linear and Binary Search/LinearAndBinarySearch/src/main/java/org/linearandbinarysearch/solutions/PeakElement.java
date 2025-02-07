package org.linearandbinarysearch.solutioncodes;
import java.util.Scanner;

public class PeakElement {
    // created a method to check if array is sorted or not
    private boolean isSorted(int [] arr) {
        // forward iteration through array to check if array is sorted in ascending order
        boolean f=true;
        for (int i = 0; i < arr.length-1; i++) {
            if(arr[i]>arr[i+1]){
                f=false;
                break;
            }
        }
        // backward iteration through array to check if array is sorted in descending order
        boolean b=true;
        for (int i = arr.length-1; i > 0; i--) {
            if(arr[i]>arr[i-1]){
                b=false;
            }
        }
        return (f || b);
    }

    // created a method to apply binary search on array to find the peak element
    public int search(int[] arr, int left, int right) {
        if (left<0 || right >= arr.length) return -1;

        // finding the middle index of the array
        int mid = (right+left) / 2;

        // to avoid ArrayIndexOutOfBoundsException
        if (mid == 0){
            mid++;
        } else if(mid == arr.length-1) {
            mid--;
        }

        if (arr[mid] > arr[mid+1] && arr[mid] > arr[mid-1]) { // condition for peak element
            return arr[mid];
        }

        if (arr[mid] < arr[mid-1]){
            // traversing the left half of the array if middle element is less than its previous element
            return search(arr, left, mid-1);
        }

        // traversing the right half of the array if middle element is not less than its previous element
        return search(arr, mid+1, right);
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
        // creating object of PeakElement class to call the methods since they are not static
        PeakElement obj = new PeakElement();

        if (obj.isSorted(arr)) {
            // if the array is sorted then there cannot exist a peak element
            System.out.println("There is no peak element in this array.");
        } else { // at least one peak element exists in the array

            // performing binary search in this array to find the peak element in this array
            int peakElement = obj.search(arr, 0, sizeOfArray-1);

            // displaying the result
            if (peakElement == -1) {
                System.out.println("There is no peak element in this array.");
            }else {
                System.out.println("Peak element in this array is: " + peakElement);
            }
        }
    }
}