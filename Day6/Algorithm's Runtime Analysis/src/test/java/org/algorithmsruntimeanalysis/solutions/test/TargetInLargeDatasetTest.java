package org.algorithmsruntimeanalysis.solutions.test;

import org.algorithmsruntimeanalysis.solutions.TargetInLargeDataset;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import static org.junit.jupiter.api.Assertions.assertEquals;

// definition of TargetInLargeDatasetTest class
public class TargetInLargeDatasetTest {
    // created a method to test the linearSearch method of TargetInLargeDataset class
    @Test
    public void linearSearch(){
        // created object of TargetInLargeDataset class
        TargetInLargeDataset obj = new TargetInLargeDataset();

        // created large test datasets
        ArrayList<Integer> dataSet1 = new ArrayList<>(); // will contain 1,000 elements
        ArrayList<Integer> dataSet2 = new ArrayList<>(); // will contain 10,000 elements
        ArrayList<Integer> dataSet3 = new ArrayList<>(); // will contain 1,000,000 elements

        // adding elements in datasets
        for (int i = 1; i <= 1000; i++) {   dataSet1.add(i);    }
        for (int i = 1; i <= 10000; i++) {   dataSet2.add(i);    }
        for (int i = 1; i <= 1000000; i++) {   dataSet3.add(i);    }

        // performing tests
        assertEquals(1000 + " is present in the array at index " + 999 + ".", obj.linearSearch(dataSet1, 1000));
        assertEquals(10000 + " is present in the array at index " + 9999 + ".", obj.linearSearch(dataSet2, 10000));
        assertEquals(1000000 + " is present in the array at index " + 999999 + ".", obj.linearSearch(dataSet3, 1000000));
        assertEquals(1001 + " is not present in the array.", obj.linearSearch(dataSet1, 1001));
    }

    // created a method to test the binarySearch method of TargetInLargeDataset class
    @Test
    public void binarySearch(){
        // created object of TargetInLargeDataset class
        TargetInLargeDataset obj = new TargetInLargeDataset();

        // created large test datasets
        ArrayList<Integer> dataSet1 = new ArrayList<>(); // will contain 1,000 elements
        ArrayList<Integer> dataSet2 = new ArrayList<>(); // will contain 10,000 elements
        ArrayList<Integer> dataSet3 = new ArrayList<>(); // will contain 1,000,000 elements

        // adding elements in datasets
        for (int i = 1; i <= 1000; i++) {   dataSet1.add(i);    }
        for (int i = 1; i <= 10000; i++) {   dataSet2.add(i);    }
        for (int i = 1; i <= 1000000; i++) {   dataSet3.add(i);    }

        // performing tests
        assertEquals(1000 + " is present in the array at index " + 999 + ".", obj.binarySearch(dataSet1, 1000));
        assertEquals(10000 + " is present in the array at index " + 9999 + ".", obj.binarySearch(dataSet2, 10000));
        assertEquals(1000000 + " is present in the array at index " + 999999 + ".", obj.binarySearch(dataSet3, 1000000));
        assertEquals(1001 + " is not present in the array.", obj.binarySearch(dataSet1, 1001));
    }
}