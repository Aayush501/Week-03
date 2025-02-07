package org.linearandbinarysearch.testdata;

import org.junit.jupiter.api.Test;
import org.linearandbinarysearch.solutions.RotationPoint;
import static org.junit.jupiter.api.Assertions.assertEquals;

// created class RotationPointTest to test the code of RotationPoint class
public class RotationPointTest {
    // created a method to test the search method of RotationPoint class
    @Test
    void search(){
        // created the object of RotationPoint class
        RotationPoint obj = new RotationPoint();

        // created multiple testcases
        int [] case1 = {1, 2, 3, 4, 5}; // fully sorted array
        int [] case2 = {5, 1, 2, 3, 4}; // rotated sorted array
        int [] case3 = {4, 5, 1, 2, 3};
        int [] case4 = {3, 4, 5, 1, 2};
        int [] case5 = {2, 3, 4, 5, 1};

        // testing the method for all above testcases
        assertEquals(1, obj.search(case1, 0, 4));
        assertEquals(1, obj.search(case2, 0, 4));
        assertEquals(1, obj.search(case3, 0, 4));
        assertEquals(1, obj.search(case4, 0, 4));
        assertEquals(1, obj.search(case5, 0, 4));
    }
}
