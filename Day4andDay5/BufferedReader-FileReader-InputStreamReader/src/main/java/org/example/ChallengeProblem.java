package org.example;

import java.io.*;

public class ChallengeProblem {
    // methods to read a file and return number of words in that file
    public long readLargeFileUsingBufferedReader() throws IOException {
        String file = "largeTestFile.txt";

        File file1 = new File(file);
        if(!file1.exists()) {
            System.out.println("File not found.");
            return 0;
        }

        // creating object of FileInputStream
        FileReader obj = new FileReader(file);

        // wrapping the InputStreamReader in BufferedReader
        BufferedReader buffer = new BufferedReader(obj);

        String line; // read line will be stored in this string
        long noOfWords = 0;
        while ((line = buffer.readLine()) != null) { // reading the file line by line
            // splitting the line and counting the number of words in that line
            String [] temp = line.split(" ");
            noOfWords += temp.length;
        }

        System.out.println("File Reading Using FileReader Completed Successfully.");
        return noOfWords;
    }

    public long readLargeFileUsingInputStreamReader() throws IOException {
        String file = "largeTestFile.txt";

        File file1 = new File(file);
        if(!file1.exists()) {
            System.out.println("File not found.");
            return 0;
        }

        // creating object of FileInputStream
        FileInputStream obj = new FileInputStream(file);

        // created an inputStreamReader
        InputStreamReader reader = new InputStreamReader(obj);

        // wrapping the InputStreamReader in BufferedReader
        BufferedReader buffer = new BufferedReader(reader);

        String line; // read line will be stored in this string
        long noOfWords = 0;
        while ((line = buffer.readLine()) != null) { // reading the file line by line
             // splitting the line and counting the number of words in that line
            String [] temp = line.split(" ");
            noOfWords += temp.length;
        }

        System.out.println("File Reading Using InputStreamReader Completed Successfully.");
        return noOfWords;
    }

    // method to create a large text file
    public void createLargeFile(String largeString) throws IOException {
        String file = "largeTestFile.txt";

        File file1 = new File(file);
        if(!file1.exists()) {
            return;
        }

        // created an input stream reader
        InputStreamReader reader = new InputStreamReader(System.in);

        // wrapping the InputStreamReader in BufferedReader
        BufferedReader buffer = new BufferedReader(reader);

        // created a FileWriter
        FileWriter writer = new FileWriter(file1);

        // writing the large string into file for 10 times
        for (int i = 0; i < 10; i++) {
            writer.write(largeString + "\n");
        }
        writer.close();

        System.out.println("A File Named largeTestFile now contains large amount of data.");
    }

    // method to compare StringBuilder and StringBuffer
    public String compareStringBuilderAndStringBuffer() {
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

        return builder.toString() + buffer.toString();
    }

    // main method
    public static void main(String[] args) throws IOException {
        // created object of ChallengeProblem class to perform operations since methods are not static
        ChallengeProblem obj = new ChallengeProblem();

        // calling the method to compare the performances of StringBuilder and StringBuffer
        String largeString = obj.compareStringBuilderAndStringBuffer();

        // converting an existing file into a large file
        obj.createLargeFile(largeString);

        // reading a large text file and counting total number of words in the file
        long start1 = System.nanoTime();
        long totalWords = obj.readLargeFileUsingBufferedReader();
        long end1 = System.nanoTime();
        long start2 = System.nanoTime();
        totalWords = obj.readLargeFileUsingInputStreamReader();
        long end2 = System.nanoTime();

        System.out.println("BufferedReader time: " + (end1 - start1));
        System.out.println("FileInputStream time: " + (end2 - start2));
        System.out.println("Total words: " +  totalWords);
    }
}


