package org.algorithmsruntimeanalysis.solutions;

import java.util.Scanner;

// definition of FibonacciComputation class
public class FibonacciComputation {
    // created a method to find the recursive solution of fibonacci series
    public int fibonacciRecursive(int n) {
        if (n <= 1) return n; // returning 0 or 1
        return fibonacciRecursive(n - 1) + fibonacciRecursive(n - 2); // recursive calls
    }

    // created a method to check the performance of fibonacciRecursive method
    public String fibonacciRecursivePerformance(int n) {
        long start = System.nanoTime();
        System.out.println("For n = " + n +", Solution from Recursive code: " + fibonacciRecursive(n)); // calling fibonacciRecursive method
        long end = System.nanoTime(); // start and end variables are used to measure the performance of recursive solution

        // displaying the performance
        System.out.println("Recursive Solution Time: " + (end - start));
        return "Recursive Fibonacci Computation Completed.";
    }

    // created a method to find the iterative solution of fibonacci series
    public int fibonacciIterative(int n) {
        int first = 0, second = 1, sum; // created variables to be used in the solution
        for (int i = 2; i <= n; i++) { // iterations
            sum = first + second;
            first = second;
            second = sum;
        }
        // returning the result
        return second;
    }

    // created a method to check the performance of fibonacciIterative method
    public String fibonacciIterativePerformance(int n) {
        long start = System.nanoTime();
        System.out.println("For n = " + n +", Solution from Iterative code: " + fibonacciIterative(n)); // calling fibonacciRecursive method
        long end = System.nanoTime(); // start and end variables are used to measure the performance of iterative solution

        // displaying the performance
        System.out.println("Iterative Solution Time: " + (end - start));
        return "Iterative Fibonacci Computation Completed.";
    }

    // main method
    public static void main(String[] args) {
        // creating object of  this class to call the methods
        FibonacciComputation obj = new FibonacciComputation();

        // taking user input for number
        Scanner sc = new Scanner(System.in); // object of scanner class
        System.out.println("Enter Number:");
        int number = sc.nextInt();

        // comparing the performances
        System.out.println("Iterative Fibonacci Computation Performance: ");
        System.out.println(obj.fibonacciIterativePerformance(number) + "\n");

        System.out.println("Recursive Fibonacci Computation Performance: ");
        System.out.println(obj.fibonacciRecursivePerformance(number) + "\n");
    }

}
