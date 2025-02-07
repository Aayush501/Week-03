package org.linearandbinarysearch.testdata;

import org.junit.jupiter.api.Test;
import org.linearandbinarysearch.solutions.ChallengeProblem;
import static org.junit.jupiter.api.Assertions.assertEquals;

// created class ChallengeProblemTest to test the code of challengeProblem class
class ChallengeProblemTest {
    // method to test findMissing method
    @Test
    void findMissing() {
        // creating object of ChallengeProblem class
        ChallengeProblem obj = new ChallengeProblem();

        // creating multiple testcases
        int [] case1 = {2, 3, 4, 5, 6, 7, 8}; // first missing element is 1
        int [] case2 = {1, 2, 3, 5, 7, 8, 9}; // first missing element is 4 which is neither 1st nor last element
        int [] case3 = {1, 2, 3, 4, 5, 6, 7}; // no element is missing and first missing element is 8
        int [] case4 = {2, 2, 3, 3, 3, 4, 4}; // array contains multiple elements and 1 is first missing element
        int [] case5 = {1, 1, 1, 3, 3, 3, 4}; // array contains multiple elements and 2 is first missing element
        int [] case6 = {1, 1, 2, 2, 3, 3, 4}; // array contains multiple elements and no element is missing

        // testing the method for all testcases
        assertEquals(1, obj.findMissing(case1));
        assertEquals(4, obj.findMissing(case2));
        assertEquals(8, obj.findMissing(case3));
        assertEquals(1, obj.findMissing(case4));
        assertEquals(2, obj.findMissing(case5));
        assertEquals(5, obj.findMissing(case6));
    }

    // method to test searchElement method
    @Test
    void searchElement() {
        // creating object of ChallengeProblem class
        ChallengeProblem obj = new ChallengeProblem();

        // created sorted test array
        int [] test = {1, 2, 3, 4, 5, 6, 7, 8};

        // testing the method for all testcases
        assertEquals(0, obj.searchElement(test, 1));
        assertEquals(1, obj.searchElement(test, 2));
        assertEquals(2, obj.searchElement(test, 3));
        assertEquals(3, obj.searchElement(test, 4));
        assertEquals(4, obj.searchElement(test, 5));
        assertEquals(5, obj.searchElement(test, 6));
        assertEquals(6, obj.searchElement(test, 7));
        assertEquals(7, obj.searchElement(test, 8));
        assertEquals(-1, obj.searchElement(test, 9)); // element is not present in the array
    }
}
