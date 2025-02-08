package org.algorithmsruntimeanalysis.solutions;

import java.io.*;

public class LargeFileReading {
    // created a method to create a large text file
    public String createLargeFile(String file, int targetSize) {

        File file1 = new File(file); // object of File class with specified file path

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(file1))){
            // try with resources in order to avoid exceptions

            String toBeAdded = "Large File Content  "; // string to be added in the file
            int iterations = targetSize * 50000; // no of times the string will be added
            for (int i = 0; i < iterations; i++) {
                writer.write(toBeAdded); // writing to the file
            }
        } catch (IOException e) {
            System.out.println("Exception Occurred.");
            throw new RuntimeException(e);
        }

        return "File Writing Successful.";
    }

    // created a method to read file using FileReader
    public String readFileUsingFileReader(String file) {

        File file1 = new File(file); // object of File class with specified file path

        long start = System.nanoTime();
        try (BufferedReader obj = new BufferedReader(new FileReader(file1))){
            String lineUp, lineDown;
            while (((lineUp = obj.readLine()) != null) && ((lineDown = obj.readLine()) != null)) {
                // the condition is kept to reduce some time while reading the file
            }
        } catch (IOException e) {
            System.out.println("Exception Occurred.");
            throw new RuntimeException(e);
        }
        long end = System.nanoTime(); // created start and end variables to measure the performance of FileReader

        System.out.println("FileReader Time: " + (end - start));
        return "File Reading Successful Using FileReader.";
    }

    // created a method to read file using FileReader
    public String readFileUsingInputStreamReader(String file) {

        File file1 = new File(file); // object of File class with specified file path

        long start = System.nanoTime();
        try (BufferedReader obj = new BufferedReader(new InputStreamReader(new FileInputStream(file)))){
            int letter;
            while ((letter = obj.read()) != -1) {} // reading the file
        } catch (IOException e) {
            System.out.println("Exception Occurred.");
            throw new RuntimeException(e);
        }
        long end = System.nanoTime(); // created start and end variables to measure the performance of InputStreamReader

        System.out.println("InputStreamReader Time: " + (end - start));
        return "File Reading Successful Using InputStreamReader.";
    }

    // main method
    public static void main(String[] args) {
        // creating a file of 10 Mb
        LargeFileReading obj = new LargeFileReading();
        System.out.println(obj.createLargeFile("largeFile.txt",10));

        // reading the file using FileReader and InputStreamReader
        System.out.println("File Reader Performance: \n" + obj.readFileUsingFileReader("largeFile.txt"));
        System.out.println("File Reader Performance: \n" + obj.readFileUsingInputStreamReader("largeFile.txt"));
    }
}
