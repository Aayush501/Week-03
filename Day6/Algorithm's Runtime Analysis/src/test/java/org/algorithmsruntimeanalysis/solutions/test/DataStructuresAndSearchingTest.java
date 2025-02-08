package org.algorithmsruntimeanalysis.solutions.test;

import org.algorithmsruntimeanalysis.solutions.DataStructuresAndSearching;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.TreeSet;

import static org.junit.jupiter.api.Assertions.*;

public class DataStructuresAndSearchingTest {
    // created a method to test searchInArray method of DataStructuresAndSearching class
    @Test
    public void searchInArray() {
        DataStructuresAndSearching obj = new DataStructuresAndSearching();

        // creating large datasets to test the method
        int [] test1 = new int[1000];
        int [] test2 = new int[100000];
        int [] test3 = new int[1000000];

        // adding data in the datasets
        for (int i = 0; i < 1000; i++) {     test1[i] = i+1;    }
        for (int i = 0; i < 100000; i++) {     test2[i] = i+1;    }
        for (int i = 0; i < 1000000; i++) {     test3[i] = i+1;    }

        // performing tests
        assertTrue(obj.searchInArray(test1, 1000));
        assertTrue(obj.searchInArray(test2, 100000));
        assertTrue(obj.searchInArray(test3, 1000000));
        assertFalse(obj.searchInArray(test1, 1001));
    }

    // created a method to test arrayPerformance method of DataStructuresAndSearching class
    @Test
    public void arrayPerformance() {
        DataStructuresAndSearching obj = new DataStructuresAndSearching();

        // creating large datasets to test the method
        int [] test1 = new int[1000];
        int [] test2 = new int[100000];
        int [] test3 = new int[1000000];

        // adding data in the datasets
        for (int i = 0; i < 1000; i++) {     test1[i] = i+1;    }
        for (int i = 0; i < 100000; i++) {     test2[i] = i+1;    }
        for (int i = 0; i < 1000000; i++) {     test3[i] = i+1;    }

        // performing tests
        assertEquals("Search in array is completed.", obj.arrayPerformance(test1, 1000));
        assertEquals("Search in array is completed.", obj.arrayPerformance(test2, 100000));
        assertEquals("Search in array is completed.", obj.arrayPerformance(test3, 1000000));
        assertEquals("Search in array is completed.", obj.arrayPerformance(test1, 1001));
    }

    // created a method to test searchInHashSet method of DataStructuresAndSearching class
    @Test
    public void searchInHashSet() {
        DataStructuresAndSearching obj = new DataStructuresAndSearching();

        // creating large datasets to test the method
        HashSet <Integer> test1 =  new HashSet<>(); // will contain 1000 elements
        HashSet <Integer> test2 =  new HashSet<>(); // will contain 100000 elements
        HashSet <Integer> test3 =  new HashSet<>(); // will contain 1000000 elements

        // adding data in the datasets
        for (int i = 0; i < 1000; i++) {     test1.add(i+1);    }
        for (int i = 0; i < 100000; i++) {     test2.add(i+1);    }
        for (int i = 0; i < 1000000; i++) {     test3.add(i+1);    }

        // performing tests
        assertTrue(obj.searchInHashSet(test1, 1000));
        assertTrue(obj.searchInHashSet(test2, 100000));
        assertTrue(obj.searchInHashSet(test3, 1000000));
        assertFalse(obj.searchInHashSet(test1, 1001));
    }

    // created a method to test hashSetPerformance method of DataStructuresAndSearching class
    @Test
    public void hashSetPerformance() {
        DataStructuresAndSearching obj = new DataStructuresAndSearching();

        // creating large datasets to test the method
        HashSet <Integer> test1 =  new HashSet<>(); // will contain 1000 elements
        HashSet <Integer> test2 =  new HashSet<>(); // will contain 100000 elements
        HashSet <Integer> test3 =  new HashSet<>(); // will contain 1000000 elements

        // adding data in the datasets
        for (int i = 0; i < 1000; i++) {     test1.add(i+1);    }
        for (int i = 0; i < 100000; i++) {     test2.add(i+1);    }
        for (int i = 0; i < 1000000; i++) {     test3.add(i+1);    }

        // performing tests
        assertEquals("Search in Hash Set is completed.", obj.hashSetPerformance(test1, 1000));
        assertEquals("Search in Hash Set is completed.", obj.hashSetPerformance(test2, 100000));
        assertEquals("Search in Hash Set is completed.", obj.hashSetPerformance(test3, 1000000));
        assertEquals("Search in Hash Set is completed.", obj.hashSetPerformance(test1, 1001));
    }

    // created a method to test searchInTreeSet method of DataStructuresAndSearching class
    @Test
    public void searchInTreeSet() {
        DataStructuresAndSearching obj = new DataStructuresAndSearching();

        // creating large datasets to test the method
        TreeSet <Integer> test1 =  new TreeSet<>(); // will contain 1000 elements
        TreeSet <Integer> test2 =  new TreeSet<>(); // will contain 100000 elements
        TreeSet <Integer> test3 =  new TreeSet<>(); // will contain 1000000 elements

        // adding data in the datasets
        for (int i = 0; i < 1000; i++) {     test1.add(i+1);    }
        for (int i = 0; i < 100000; i++) {     test2.add(i+1);    }
        for (int i = 0; i < 1000000; i++) {     test3.add(i+1);    }

        // performing tests
        assertTrue(obj.searchInTreeSet(test1, 1000));
        assertTrue(obj.searchInTreeSet(test2, 100000));
        assertTrue(obj.searchInTreeSet(test3, 1000000));
        assertFalse(obj.searchInTreeSet(test1, 1001));
    }

    // created a method to test treeSetPerformance method of DataStructuresAndSearching class
    @Test
    public void treeSetPerformance() {
        DataStructuresAndSearching obj = new DataStructuresAndSearching();

        // creating large datasets to test the method
        TreeSet <Integer> test1 =  new TreeSet<>(); // will contain 1000 elements
        TreeSet <Integer> test2 =  new TreeSet<>(); // will contain 100000 elements
        TreeSet <Integer> test3 =  new TreeSet<>(); // will contain 1000000 elements

        // adding data in the datasets
        for (int i = 0; i < 1000; i++) {     test1.add(i+1);    }
        for (int i = 0; i < 100000; i++) {     test2.add(i+1);    }
        for (int i = 0; i < 1000000; i++) {     test3.add(i+1);    }

        // performing tests
        assertEquals("Search in Tree Set is completed.", obj.treeSetPerformance(test1, 1000));
        assertEquals("Search in Tree Set is completed.", obj.treeSetPerformance(test2, 100000));
        assertEquals("Search in Tree Set is completed.", obj.treeSetPerformance(test3, 1000000));
        assertEquals("Search in Tree Set is completed.", obj.treeSetPerformance(test1, 1001));
    }

    // created a method to test comparePerformances method of DataStructuresAndSearching class
    @Test
    public void comparePerformances() {
        DataStructuresAndSearching obj = new DataStructuresAndSearching();

        // creating large datasets to test the method
        TreeSet <Integer> treeTest1 =  new TreeSet<>(); // will contain 1000 elements
        TreeSet <Integer> treeTest2 =  new TreeSet<>(); // will contain 100000 elements
        TreeSet <Integer> treeTest3 =  new TreeSet<>(); // will contain 1000000 elements

        HashSet <Integer> hashTest1 =  new HashSet<>(); // will contain 1000 elements
        HashSet <Integer> hashTest2 =  new HashSet<>(); // will contain 100000 elements
        HashSet <Integer> hashTest3 =  new HashSet<>(); // will contain 1000000 elements

        int [] arrayTest1 = new int[1000];
        int [] arrayTest2 = new int[100000];
        int [] arrayTest3 = new int[1000000];

        // adding data in the datasets
        for (int i = 0; i < 1000; i++) {
            treeTest1.add(i+1); hashTest1.add(i+1); arrayTest1[i] = i+1;
        }
        for (int i = 0; i < 100000; i++) {
            treeTest2.add(i+1); hashTest2.add(i+1); arrayTest2[i] = i+1;
        }
        for (int i = 0; i < 1000000; i++) {
            treeTest3.add(i+1); hashTest3.add(i+1); arrayTest3[i] = i+1;
        }

        String testResult = "Completed the comparison of performances of various data structures on searching.";

        // performing tests
        assertEquals(testResult, obj.comparePerformances(arrayTest1, hashTest1, treeTest1, 1000));
        assertEquals(testResult, obj.comparePerformances(arrayTest2, hashTest2, treeTest2, 100000));
        assertEquals(testResult, obj.comparePerformances(arrayTest3, hashTest3, treeTest3, 1000000));
    }
}
