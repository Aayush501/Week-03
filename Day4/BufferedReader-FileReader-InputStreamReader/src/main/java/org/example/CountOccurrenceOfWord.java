package org.example;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class CountOccurrenceOfWord {

    // method to read a file
    public String readAFile(String target) throws IOException {
        String file = "testFile.txt";

        File file1 = new File(file);
        if(!file1.exists()) {
            return "File not found.";
        }

        // creating object of FileReader
        FileReader obj = new FileReader(file);

        // wrapping the FileReader in a BufferedReader
        BufferedReader reader = new BufferedReader(obj);

        String line; // read line will be stored in this string
        int countOfTarget = 0;
        while ((line = reader.readLine()) != null) { // reading the file line by line
            // checking the count of target word in the line
            for (int i = 0; i <= line.length()-target.length(); i++) {
                if (line.startsWith(target, i)){
                    countOfTarget++;
                }
            }
        }

        return "File Reading Completed Successfully.\nCount of " + target + " in the file is: " + countOfTarget;
    }

    // main method
    public static void main(String[] args) throws IOException {
        // calling readAFile method to read a file from the same project directory by creating object of CountOccurrenceOfWord class since the method is not static
        CountOccurrenceOfWord obj = new CountOccurrenceOfWord();
        String fileReadingStatus = obj.readAFile("test");

        // displaying the file reading status
        System.out.println(fileReadingStatus);
    }

}
