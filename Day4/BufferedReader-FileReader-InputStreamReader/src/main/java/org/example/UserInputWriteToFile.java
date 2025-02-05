package org.example;

import java.io.*;

public class UserInputWriteToFile {

    // method to write to a file with user input
    public String writeToFile() throws IOException {
        String file = "testFile.txt";

        File file1 = new File(file);
        if(!file1.exists()) {
            return "File not found.";
        }

        // created an input stream reader
        InputStreamReader reader = new InputStreamReader(System.in);

        // wrapping the InputStreamReader in BufferedReader
        BufferedReader buffer = new BufferedReader(reader);

        // created a FileWriter
        FileWriter writer = new FileWriter(file1);

        String line; // read line will be stored in this string
        System.out.println("Enter Strings To Write In The File:");

        while ((line = buffer.readLine()) != null) {
            if(line.equals("exit")){
                writer.close();
                break;
            }
            writer.write(line + "\n");
        }

        // creating object of ReadAFile class to read the contents of the file
        ReadAFile obj = new ReadAFile();
        String fileReading = obj.readAFile();

        System.out.println(fileReading);

        return "Writing Inputs To File, Completed Successfully.";
    }

    public static void main(String[] args) throws IOException {
        // calling writeToFile method to read a file from the same project directory by creating object of UserInputWriteToFile class since the method is not static
        UserInputWriteToFile obj = new UserInputWriteToFile();
        String fileReadingStatus = obj.writeToFile();

        // displaying the file reading status
        System.out.println(fileReadingStatus);
    }
}
