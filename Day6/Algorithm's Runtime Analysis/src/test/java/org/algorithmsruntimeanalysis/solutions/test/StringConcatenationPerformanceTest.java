package org.algorithmsruntimeanalysis.solutions.test;

import org.algorithmsruntimeanalysis.solutions.StringConcatenationPerformance;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

// definition of StringConcatenationPerformanceTest class
public class StringConcatenationPerformanceTest {
    // created a method to test the stringPerformance method of StringConcatenationPerformance class
    @Test
    public void stringPerformance() {
        // creating object of StringConcatenationPerformance class
        StringConcatenationPerformance obj = new StringConcatenationPerformance();

        // defining test strings
        String test1 = "Hello ";
        String test2 = "Hello ";
        String test3 = "Hello ";

        // performing tests
        assertEquals("String concatenated " + 1000 + " times.", obj.stringPerformance(test1, 1000));
        assertEquals("String concatenated " + 10000 + " times.", obj.stringPerformance(test2, 10000));
        /*
            assertEquals("String concatenated " + 1000000 + " times.", obj.stringPerformance(test3, 1000000));
            performing this not a good option,
            because time complexity of concatenating String is O(n^2)
        */
    }

    // created a method to test the stringBuilderPerformance method of StringConcatenationPerformance class
    @Test
    public void stringBuilderPerformance() {
        // creating object of StringConcatenationPerformance class
        StringConcatenationPerformance obj = new StringConcatenationPerformance();

        // defining test strings
        StringBuilder test1 = new StringBuilder("Hello ");
        StringBuilder test2 = new StringBuilder("Hello ");
        StringBuilder test3 = new StringBuilder("Hello ");

        // performing tests
        assertEquals("StringBuilder concatenated " + 1000 + " times.", obj.stringBuilderPerformance(test1, 1000));
        assertEquals("StringBuilder concatenated " + 10000 + " times.", obj.stringBuilderPerformance(test2, 10000));
        assertEquals("StringBuilder concatenated " + 1000000 + " times.", obj.stringBuilderPerformance(test3, 1000000));
    }

    // created a method to test the stringBufferPerformance method of StringConcatenationPerformance class
    @Test
    public void stringBufferPerformance() {
        // creating object of StringConcatenationPerformance class
        StringConcatenationPerformance obj = new StringConcatenationPerformance();

        // defining test strings
        StringBuffer test1 = new StringBuffer("Hello ");
        StringBuffer test2 = new StringBuffer("Hello ");
        StringBuffer test3 = new StringBuffer("Hello ");

        // performing tests
        assertEquals("StringBuffer concatenated " + 1000 + " times.", obj.stringBufferPerformance(test1, 1000));
        assertEquals("StringBuffer concatenated " + 10000 + " times.", obj.stringBufferPerformance(test2, 10000));
        assertEquals("StringBuffer concatenated " + 1000000 + " times.", obj.stringBufferPerformance(test3, 1000000));
    }
}
