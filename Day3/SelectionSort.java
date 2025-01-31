import java.util.Arrays;
import java.util.Scanner;

// definition of SelectionSort class
public class SelectionSort {

    // created sort method to implement selection sort algorithm
    static private double[] sort(double [] arr) {
        for (int i = 0; i < arr.length; i++) {
            double smallestElement = arr[i];
            int indexOfSmallest = i;
            for (int j = i+1; j < arr.length; j++) {
                if (arr[j] <= smallestElement) {
                    smallestElement = arr[j];
                    indexOfSmallest = j;
                }
            }
            // selecting the smallest element of the unsorted part of array and swapping it with the first element of unsorted part of array
            double temp = arr[i];
            arr[i] = arr[indexOfSmallest];
            arr[indexOfSmallest] = temp;
        }
        return arr;
    }

    // main method
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // taking input for total number of students and then storing their examScores in a double array
        System.out.println("Enter number of students:");
        int numberOfStudents = sc.nextInt();

        double[] examScores = new double[numberOfStudents];

        System.out.println("Enter examScores of all students:");
        for (int i = 0; i < numberOfStudents; i++) {
            examScores[i] = sc.nextDouble();
        }

        // displaying examScores of students in unsorted order
        System.out.println("examScores of students in unsorted order: " + Arrays.toString(examScores));

        // sorting the examScores array
        sort(examScores);

        // displaying examScores of students in sorted order
        System.out.println("examScores of students in sorted order: " + Arrays.toString(examScores));
    }
}
