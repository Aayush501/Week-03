package org.example;

import java.io.*;

public class ByteStreamToCharacterStream {
    // method to read a file
    public String streamConverter() throws IOException {
        String file = "testFile.txt";

        File file1 = new File(file);
        if(!file1.exists()) {
            return "File not found.";
        }

        // creating object of FileInputStream
        FileInputStream obj = new FileInputStream(file);

        // wrapping the FileInputStream in InputStreamReader
        InputStreamReader reader = new InputStreamReader(obj);

        // wrapping the InputStreamReader in BufferedReader
        BufferedReader reader1 = new BufferedReader(reader);

        int b; // to read the byte stream
        while ((b = reader1.read()) != -1) { // reading the characters
            System.out.print((char) b);
        }

        return "File Reading Completed Successfully.";
    }

    public static void main(String[] args) throws IOException {
        // calling streamConverter method to read a file from the same project directory by creating object of org.example.ByteStreamToCharacterStream class since the method is not static
        ByteStreamToCharacterStream obj = new ByteStreamToCharacterStream();
        String fileReadingStatus = obj.streamConverter();

        // displaying the file reading status
        System.out.println(fileReadingStatus);
    }
}
