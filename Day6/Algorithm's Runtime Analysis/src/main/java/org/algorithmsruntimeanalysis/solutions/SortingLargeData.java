package org.algorithmsruntimeanalysis.solutions;

import java.util.Arrays;

// definition of SortingLargeData class
public class SortingLargeData {
    // created bubbleSort method
    public int [] bubbleSort(int [] arr){
        int sizeOfArr = arr.length;

        // sorting the array using bubble sort algorithm
        for (int i = 0; i < sizeOfArr; i++) {
            for (int j = 0; j < sizeOfArr-1-i; j++) {
                if (arr[j] > arr[j+1]) {
                    // swapping elements
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }
        }

        return arr; // returning the sorted array
    }

    // method to measure the performance of bubble sort
    public String bubbleSortPerformance(int [] arr) {
        // created variables start and end to measure the performance of mergesort
        long start, end;
        start = System.nanoTime();

        // sorting arr
        bubbleSort(arr);

        end = System.nanoTime();

        // displaying the performance
        System.out.println("Time of Bubble sort: " + (end - start));
        return "Bubble sort completed.";
    }

    // created mergeSort method
    public int [] mergeSort(int [] arr, int left, int right){
        if (left == right) {
            return new int[]{arr[left]};
        }

        int mid = left + (right - left) / 2;
        int [] leftSide = mergeSort(arr, left, mid);
        int [] rightSide = mergeSort(arr, mid+1, right);

        // using for loop to merge the left and right halves
        int [] sorted = new int [leftSide.length + rightSide.length];
        int i=0, j=0, k=0;
        for ( ; i < leftSide.length && j < rightSide.length; k++) {
            /*
                iterators in this loop
                i: to iterate through leftSide array
                j: to iterate through rightSide array
                k: to add data in sorted array
            */
            if (leftSide[i] <= rightSide[j]) {
                sorted[k] = leftSide[i];
                i++;
            } else {
                sorted[k] = rightSide[j];
                j++;
            }
        }

        // adding data in sorted array from leftSide or rightSide arrays if there are elements in them
        for ( ; i < leftSide.length; i++, k++) {
            sorted[k] = leftSide[i];
        }
        for ( ; i < rightSide.length; i++, k++) {
            sorted[k] = rightSide[i];
        }

        return sorted; // returning the sorted array
    }

    // method to measure the performance of merge sort
    public String mergeSortPerformance(int [] arr) {
        // created variables start and end to measure the performance of mergesort
        long start, end;
        start = System.nanoTime();

        // sorting arr
        mergeSort(arr, 0, arr.length-1);

        end = System.nanoTime();

        // displaying the performance
        System.out.println("Time of merge sort: " + (end - start));
        return "Merge sort completed.";
    }

    // created quickSort method
    public void quickSort(int[] arr, int left, int right) {
        if (left < right) {
            // Calculation of middle index and pivot element
            int mid = left + (right - left) / 2;
            int pivot = arr[mid];

            // Performing quick sort using while loop
            int leftI = left, rightI = right; // Replicating left and right
            while (leftI <= rightI) {
                // Increasing leftI until element in this index is smaller than pivot
                while (arr[leftI] < pivot) {
                    leftI++;
                }

                // Decreasing rightI until element in this index is greater than pivot
                while (arr[rightI] > pivot) {
                    rightI--;
                }

                if (leftI <= rightI) {
                    // Swapping elements at rightI and leftI positions
                    int temp = arr[leftI];
                    arr[leftI] = arr[rightI];
                    arr[rightI] = temp;
                    leftI++;
                    rightI--;
                }
            }

            // Corrected recursive calls
            if (left < rightI) quickSort(arr, left, rightI);
            if (leftI < right) quickSort(arr, leftI, right);
        }
    }

    // method to measure the performance of quick sort
    public String quickSortPerformance(int [] arr) {
        // created variables start and end to measure the performance of quick sort
        long start, end;
        start = System.nanoTime();

        // sorting arr
        quickSort(arr, 0, arr.length-1);

        end = System.nanoTime();

        // displaying the performance
        System.out.println("Time of quick sort: " + (end - start));
        return "Quick sort completed.";
    }

    // main method
    public static void main(String[] args) {
        // creating test datasets
        int [] dataset1 = new int[100];
        int [] dataset2 = new int[100];
        int [] dataset3 = new int[100];

        // adding elements in datasets in unsorted order
        for (int i = 0; i < 100; i++) {  dataset1[i] = (i%2 == 0)? i+10 : i+5;    }
        for (int i = 0; i < 100; i++) {  dataset2[i] = (i%2 == 0)? i+15 : i+7;    }
        for (int i = 0; i < 100; i++) {  dataset3[i] = (i%2 == 0)? i+20 : i+10;   }

        // sorting these datasets using various sorting algorithms
        SortingLargeData obj = new SortingLargeData();
        System.out.println("Performance of various sorting algorithms: ");
        System.out.println("Bubble Sort Performance: " + obj.bubbleSortPerformance(dataset1));
        System.out.println("Merge Sort Performance: " + obj.mergeSortPerformance(dataset2));
        System.out.println("Quick Sort Performance: " + obj.quickSortPerformance(dataset3));
        System.out.println();
    }

}
