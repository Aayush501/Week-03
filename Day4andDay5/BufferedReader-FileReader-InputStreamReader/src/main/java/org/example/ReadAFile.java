package org.example;

import java.io.*;

// definition of ReadAFile class
public class ReadAFile {

    // method to read a file
    public String readAFile() throws IOException {
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
        while ((line = reader.readLine()) != null) { // reading the file line by line
            // displaying the line
            System.out.println(line);
        }

//        try (BufferedReader br = new BufferedReader(new FileReader(file))) { // try-with-resources statement
//            String line; // read line will be stored in this string
//            while ((line = br.readLine()) != null) { // reading the file line by line
//                // displaying the line
//                System.out.println(line);
//            }
//        } catch (IOException e) {
//            return "IOException Occurred While Reading The File.";
//        }
        return "File Reading Completed Successfully.";
    }

    // main method
    public static void main(String[] args) throws IOException {
        // calling readAFile method to read a file from the same project directory by creating object of ReadAFile class since the method is not static
        ReadAFile obj = new ReadAFile();
        String fileReadingStatus = obj.readAFile();

        // displaying the file reading status
        System.out.println(fileReadingStatus);
    }

}