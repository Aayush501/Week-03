package org.stringbuilderandstringbuffer.solutions;

public class ChallengeProblem {
    // method to compare StringBuilder and StringBuffer
    public void compareStringBuilderAndStringBuffer() {
        // created two long variables to store the start-time and end-time of execution of operations
        long startTime, endTime;

        // testing StringBuilder Performance by concatenating a string 1 million times using for loop
        startTime = System.nanoTime();
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < 1000000; i++) {
            builder.append("Hello "); // appending the strings
        }
        endTime = System.nanoTime(); // recording the time when operation execution completed
        // displaying the output
        System.out.println("StringBuilder Time: " + (endTime - startTime) + " ns");

        // testing StringBuffer Performance using same operation we performed on StringBuilder
        startTime = System.nanoTime(); // recording start time
        StringBuffer buffer = new StringBuffer();
        for (int i = 0; i < 1000000; i++) {
            buffer.append("Hello "); // appending the strings
        }
        endTime = System.nanoTime(); // recording the time when operation execution completed
        // displaying the output
        System.out.println("StringBuffer Time: " + (endTime - startTime) + " ns");


    }

    // main method
    public static void main(String[] args) {
        // created object of ChallengeProblem class to perform operations since methods are not static
        ChallengeProblem obj = new ChallengeProblem();

        // calling the method to compare the performances of StringBuilder and StringBuffer
        obj.compareStringBuilderAndStringBuffer();
    }
}


