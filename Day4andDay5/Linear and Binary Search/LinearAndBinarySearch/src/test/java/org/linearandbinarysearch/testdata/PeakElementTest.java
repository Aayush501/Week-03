package org.linearandbinarysearch.testdata;

import org.junit.jupiter.api.Test;
import org.linearandbinarysearch.solutions.PeakElement;
import static org.junit.jupiter.api.Assertions.*;

// created class PeakElementTest to test the methods of PeakElement class
class PeakElementTest {
    // created a method to test the isSorted method of PeakElement class
    @Test
    void isSorted() {
        // created an object of PeakElement class
        PeakElement obj = new PeakElement();

        // created different testcases
        int [] case1 = {10, 20, 30, 40, 50}; // array is sorted in ascending order
        int [] case2 = {50, 40, 30, 20, 10}; // array is sorted in descending order
        int [] case3 = {40, 50, 10, 20, 30}; // array is rotated sorted
        int [] case4 = {20, 30, 10, 50, 40}; // array is not sorted

        // testing the method for all testcases
        assertTrue(obj.isSorted(case1));
        assertTrue(obj.isSorted(case2));
        assertFalse(obj.isSorted(case3));
        assertFalse(obj.isSorted(case4));
    }

    // created a method to test the search method of PeakElement class
    @Test
    void search() {
        // created an object of PeakElement class
        PeakElement obj = new PeakElement();

        // created different testcases
        int [] case1 = {10, 20, 30, 40, 50}; // array is sorted in ascending order
        int [] case2 = {50, 40, 30, 20, 10}; // array is sorted in descending order
        int [] case3 = {40, 50, 10, 20, 30}; // array contains one peak element
        int [] case4 = {20, 30, 10, 50, 40}; // array contains multiple peak elements

        // testing the search method (that returns the peak element in an array) for all testcases
        assertEquals(-1, obj.search(case1, 0, 4));
        assertEquals(-1, obj.search(case2, 0, 4));
        assertEquals(50, obj.search(case3, 0, 4));
        assertTrue((obj.search(case4, 0, 4) == 30) || (obj.search(case4, 0, 4) == 50));
    }
}
