package org.linearandbinarysearch.testdata;

import org.junit.jupiter.api.Test;
import org.linearandbinarysearch.solutions.FirstAndLastOccurrence;

import static org.junit.jupiter.api.Assertions.assertEquals;

// created class FirstAndLastOccurrenceTest to test the methods of FirstAndLastOccurrence class
class FirstAndLastOccurrenceTest {
    // created a test method to test findFirstOccurrence method
    @Test
    void findFirstOccurrence() {
        // created an object of FirstAndLastOccurrence class
        FirstAndLastOccurrence obj = new FirstAndLastOccurrence();

        // created sorted test array
        int [] test = {1, 1, 2, 2, 2, 3, 3, 3, 3, 4, 4, 5, 6, 6, 7, 8, 8};

        // testing the method for multiple testcases
        // searched the first occurrence of every element of test and testing the function accordingly
        assertEquals(0, obj.findFirstOccurrence(test, 1));
        assertEquals(2, obj.findFirstOccurrence(test, 2));
        assertEquals(5, obj.findFirstOccurrence(test, 3));
        assertEquals(9, obj.findFirstOccurrence(test, 4));
        assertEquals(11, obj.findFirstOccurrence(test, 5));
        assertEquals(12, obj.findFirstOccurrence(test, 6));
        assertEquals(14, obj.findFirstOccurrence(test, 7));
        assertEquals(15, obj.findFirstOccurrence(test, 8));
        assertEquals(-1, obj.findFirstOccurrence(test, 9)); // element is not present in the array
    }

    // created a test method to test findLastOccurrence method
    @Test
    void findLastOccurrence() {
        // created an object of FirstAndLastOccurrence class
        FirstAndLastOccurrence obj = new FirstAndLastOccurrence();

        // created sorted test array
        int [] test = {1, 1, 2, 2, 2, 3, 3, 3, 3, 4, 4, 5, 6, 6, 7, 8, 8};
        //             0  1  2  3  4  5  6  7  8  9  10 11 12 13 14 15 16
        // testing the method for multiple testcases
        // searched for the last occurrence of every element of test and testing the function accordingly
        assertEquals(1, obj.findLastOccurrence(test, 1));
        assertEquals(4, obj.findLastOccurrence(test, 2));
        assertEquals(8, obj.findLastOccurrence(test, 3));
        assertEquals(10, obj.findLastOccurrence(test, 4));
        assertEquals(11, obj.findLastOccurrence(test, 5));
        assertEquals(13, obj.findLastOccurrence(test, 6));
        assertEquals(14, obj.findLastOccurrence(test, 7));
        assertEquals(16, obj.findLastOccurrence(test, 8));
        assertEquals(-1, obj.findLastOccurrence(test, 9)); // element is not present in the array
    }


}
