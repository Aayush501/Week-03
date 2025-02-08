package org.algorithmsruntimeanalysis.solutions;

// definition of StringConcatenationPerformance class
public class StringConcatenationPerformance {
    // created a method to test the performance of String on concatenation
    public String stringPerformance(String initial, int noOfConcatenations) {
        long start = System.nanoTime();
        String addition = initial; // string to be added in each iteration

        for (int i=1; i<=noOfConcatenations; i++) {
            initial = initial.concat(addition); // concatenating the string noOfConcatenation times
        }
        long end = System.nanoTime(); // taking start and end to check the performance of string

        // displaying the performance of String
        System.out.println("String Time: " + (end - start));
        return "String concatenated " + noOfConcatenations + " times.";
    }

    // created a method to test the performance of StringBuilder on concatenation
    public String stringBuilderPerformance(StringBuilder initial, int noOfConcatenations) {
        long start = System.nanoTime();
        StringBuilder addition = new StringBuilder(initial); // stringBuilder to be added in each iteration

        for (int i=1; i<=noOfConcatenations; i++) {
            initial.append(addition); // concatenating the stringBuilder noOfConcatenation times
        }
        long end = System.nanoTime(); // taking start and end to check the performance of stringBuilder

        // displaying the performance of StringBuilder
        System.out.println("StringBuilder Time: " + (end - start));
        return "StringBuilder concatenated " + noOfConcatenations + " times.";
    }

    // created a method to test the performance of StringBuffer on concatenation
    public String stringBufferPerformance(StringBuffer initial, int noOfConcatenations) {
        long start = System.nanoTime();
        StringBuffer addition = new StringBuffer(initial); // stringBuffer to be added in each iteration

        for (int i=1; i<=noOfConcatenations; i++) {
            initial.append(addition); // concatenating the stringBuffer noOfConcatenation times
        }
        long end = System.nanoTime(); // taking start and end to check the performance of stringBuffer

        // displaying the performance of StringBuffer
        System.out.println("StringBuffer Time: " + (end - start));
        return "StringBuffer concatenated " + noOfConcatenations + " times.";
    }

    // main method
    public static void main(String[] args) {
        // creating the String, StringBuilder, and StringBuffer to concatenate
        String string = "Hello ";
        StringBuilder stringBuilder = new StringBuilder("Hello ");
        StringBuffer stringBuffer = new StringBuffer("Hello ");

        // creating the object of StringConcatenationPerformance class to call the methods
        StringConcatenationPerformance obj = new StringConcatenationPerformance();

        // calling the methods to review the performances of String, StringBuilder, and StringBuffer
        System.out.println("String Performance On Concatenation:");
        System.out.println(obj.stringPerformance(string, 100) + "\n");
        System.out.println("StringBuilder Performance On Concatenation:");
        System.out.println(obj.stringBuilderPerformance(stringBuilder, 100) + "\n");
        System.out.println("StringBuffer Performance On Concatenation:");
        System.out.println(obj.stringBufferPerformance(stringBuffer, 100) + "\n");
    }

}
