package org.algorithmsruntimeanalysis.solutions.test;

import org.algorithmsruntimeanalysis.solutions.LargeFileReading;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LargeFileReadingTest {
    // created a method to test the createLargeFile method of LargeFileReading class
    @Test
    public void createLargeFile() {
        // created object of LargeFileReading class
        LargeFileReading obj = new LargeFileReading();

        // creating files of various sizes and testing the method
        assertEquals("File Writing Successful.", obj.createLargeFile("largeTestFile.txt", 20));
        assertEquals("File Writing Successful.", obj.createLargeFile("largeTestFile.txt", 50));
        assertEquals("File Writing Successful.", obj.createLargeFile("largeTestFile.txt", 100));
    }

    // created a method to test the readFileUsingFileReader method of LargeFileReading class
    @Test
    public void readFileUsingFileReader() {
        // created object of LargeFileReading class
        LargeFileReading obj = new LargeFileReading();

        // performing tests by creating files of various sizes
        obj.createLargeFile("largeTestFile.txt", 1);
        assertEquals("File Reading Successful Using FileReader.", obj.readFileUsingFileReader("largeTestFile.txt"));

        obj.createLargeFile("largeTestFile.txt", 100);
        assertEquals("File Reading Successful Using FileReader.", obj.readFileUsingFileReader("largeTestFile.txt"));

        obj.createLargeFile("largeTestFile.txt", 400);
        assertEquals("File Reading Successful Using FileReader.", obj.readFileUsingFileReader("largeTestFile.txt"));
    }

    // created a method to test the readFileUsingInputStreamReader method of LargeFileReading class
    @Test
    public void readFileUsingInputStreamReader() {
        // created object of LargeFileReading class
        LargeFileReading obj = new LargeFileReading();

        // performing tests by creating files of various sizes
        obj.createLargeFile("largeTestFile.txt", 1);
        assertEquals("File Reading Successful Using InputStreamReader.", obj.readFileUsingInputStreamReader("largeTestFile.txt"));

        obj.createLargeFile("largeTestFile.txt", 100);
        assertEquals("File Reading Successful Using InputStreamReader.", obj.readFileUsingInputStreamReader("largeTestFile.txt"));

        obj.createLargeFile("largeTestFile.txt", 500);
        assertEquals("File Reading Successful Using InputStreamReader.", obj.readFileUsingInputStreamReader("largeTestFile.txt"));
    }
}
