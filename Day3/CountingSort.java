import java.util.Arrays;
import java.util.Scanner;

// definition of CountingSort class
public class CountingSort {

    // created sort method to implement counting sort algorithm
    static private int[] sort(int [] arr) {
        int[] count = new int[19]; // since maximum age of student can be 18

        for (int i = 0; i < arr.length; i++) {
            count[arr[i]]++;
        }

        int i=0; // iterator for sorted array
        for (int j = 0; j < 19; j++) {
            while (count[j]-- > 0) {
                arr[i] = j;
                i++;
            }
        }

        return arr; // arr is now sorted
    }

    // main method
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // taking input for total number of students and then storing their ages in an integer array
        System.out.println("Enter number of students:");
        int numberOfStudents = sc.nextInt();

        int[] age = new int[numberOfStudents];

        System.out.println("Enter ages of all students:");
        for (int i = 0; i < numberOfStudents; i++) {
            age[i] = sc.nextInt();
        }

        // displaying ages of students in unsorted order
        System.out.println("Ages of students in unsorted order: " + Arrays.toString(age));

        // sorting the ages array
        sort(age);

        // displaying ages of students in sorted order
        System.out.println("Ages of students in sorted order: " + Arrays.toString(age));
    }
}
