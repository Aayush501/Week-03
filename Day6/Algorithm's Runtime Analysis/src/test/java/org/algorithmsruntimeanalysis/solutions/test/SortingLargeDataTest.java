package org.algorithmsruntimeanalysis.solutions.test;

import org.algorithmsruntimeanalysis.solutions.SortingLargeData;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

// definition of SortingLargeDataTest class
public class SortingLargeDataTest {
    // created method to test the bubbleSort method of SortingLargeData class
    @Test
    public void bubbleSort() {
        // created object of SortingLargeData class
        SortingLargeData obj = new SortingLargeData();

        // creating large datasets to measure the performance of bubble sort
        int [] dataset1 = new int[1000];
        int [] dataset2 = new int[10000];
        int [] dataset3 = new int[1000000]; // not to be tested because of the complexity of bubble sort

        // adding elements in datasets in unsorted order
        for (int i = 0; i < 1000; i++) {   dataset1[i] = (i%2 == 0)? i+3 : i;    }
        for (int i = 0; i < 10000; i++) {  dataset2[i] = (i%2 == 0)? i+5 : i+2;    }
        for (int i = 0; i < 1000000; i++) {    dataset3[i] = (i%2 == 0)? i+3 : i+1;   }

        // testing bubbleSort method
        assertEquals("Bubble sort completed.", obj.bubbleSortPerformance(dataset1));
        assertEquals("Bubble sort completed.", obj.bubbleSortPerformance(dataset2));
        /*
            assertEquals("Bubble sort completed.", obj.bubbleSortPerformance(dataset3));

            testing bubble sort for such a large dataset is not a good option since time complexity of bubble sort is O(n^2)
            it can take a lot of time
        */

        // testing bubbleSort method for already sorted arrays
        assertEquals("Bubble sort completed.", obj.bubbleSortPerformance(dataset1));
        assertEquals("Bubble sort completed.", obj.bubbleSortPerformance(dataset2));
    }

    // created method to test the mergeSort method of SortingLargeData class
    @Test
    public void mergeSort() {
        // created object of SortingLargeData class
        SortingLargeData obj = new SortingLargeData();

        // creating large datasets to measure the performance of merge sort
        int [] dataset1 = new int[1000];
        int [] dataset2 = new int[10000];
        int [] dataset3 = new int[1000000];

        // adding elements in datasets
        for (int i = 0; i < 1000; i++) {   dataset1[i] = (i%2 == 0)? i+3 : i;    }
        for (int i = 0; i < 10000; i++) {  dataset2[i] = (i%2 == 0)? i+5 : i+2;    }
        for (int i = 0; i < 1000000; i++) {    dataset3[i] = (i%2 == 0)? i+3 : i+1;   }

        // testing mergeSort method
        assertEquals("Merge sort completed.", obj.mergeSortPerformance(dataset1));
        assertEquals("Merge sort completed.", obj.mergeSortPerformance(dataset2));
        assertEquals("Merge sort completed.", obj.mergeSortPerformance(dataset3));

        // testing mergeSort method for already sorted arrays
        assertEquals("Merge sort completed.", obj.mergeSortPerformance(dataset1));
        assertEquals("Merge sort completed.", obj.mergeSortPerformance(dataset2));
        assertEquals("Merge sort completed.", obj.mergeSortPerformance(dataset3));
    }

    // created method to test the quickSort method of SortingLargeData class
    @Test
    public void quickSort() {
        // created object of SortingLargeData class
        SortingLargeData obj = new SortingLargeData();

        // creating large datasets to measure the performance of quick sort
        int [] dataset1 = new int[1000];
        int [] dataset2 = new int[10000];
        int [] dataset3 = new int[1000000];

        // adding elements in datasets in unsorted order
        for (int i = 0; i < 1000; i++) {   dataset1[i] = (i%2 == 0)? i+3 : i;    }
        for (int i = 0; i < 10000; i++) {  dataset2[i] = (i%2 == 0)? i+5 : i+2;    }
        for (int i = 0; i < 1000000; i++) {    dataset3[i] = (i%2 == 0)? i+3 : i+1;   }

        // testing quickSort method
        assertEquals("Quick sort completed.", obj.quickSortPerformance(dataset1));
        assertEquals("Quick sort completed.", obj.quickSortPerformance(dataset2));
        assertEquals("Quick sort completed.", obj.quickSortPerformance(dataset3));

        // testing quickSort method for already sorted arrays
        assertEquals("Quick sort completed.", obj.quickSortPerformance(dataset1));
        assertEquals("Quick sort completed.", obj.quickSortPerformance(dataset2));
        assertEquals("Quick sort completed.", obj.quickSortPerformance(dataset3));
    }
}
