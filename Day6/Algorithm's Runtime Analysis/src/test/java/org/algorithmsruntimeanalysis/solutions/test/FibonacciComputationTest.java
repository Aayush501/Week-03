package org.algorithmsruntimeanalysis.solutions.test;

import org.algorithmsruntimeanalysis.solutions.FibonacciComputation;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FibonacciComputationTest {
    // created a method to test the fibonacciRecursive method
    @Test
    public void fibonacciRecursive() {
        FibonacciComputation obj = new FibonacciComputation();

        // testing the method for multiple testcases
        assertEquals(5, obj.fibonacciRecursive(5));
        assertEquals(55, obj.fibonacciRecursive(10));
        assertEquals(610, obj.fibonacciRecursive(15));
        assertEquals(6765, obj.fibonacciRecursive(20));
        assertEquals(75025, obj.fibonacciRecursive(25));
        assertEquals(832040, obj.fibonacciRecursive(30));
        assertEquals(9227465, obj.fibonacciRecursive(35));
        assertEquals(102334155, obj.fibonacciRecursive(40));
        assertEquals(1134903170, obj.fibonacciRecursive(45));
    }

    // created a method to test the fibonacciIterative method
    @Test
    public void fibonacciIterative() {
        FibonacciComputation obj = new FibonacciComputation();

        // testing the method for multiple testcases
        assertEquals(5, obj.fibonacciIterative(5));
        assertEquals(55, obj.fibonacciIterative(10));
        assertEquals(610, obj.fibonacciIterative(15));
        assertEquals(6765, obj.fibonacciIterative(20));
        assertEquals(75025, obj.fibonacciIterative(25));
        assertEquals(832040, obj.fibonacciIterative(30));
        assertEquals(9227465, obj.fibonacciIterative(35));
        assertEquals(102334155, obj.fibonacciIterative(40));
        assertEquals(1134903170, obj.fibonacciIterative(45));

    }
}
