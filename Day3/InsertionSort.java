import java.util.Arrays;
import java.util.Scanner;

// definition of InsertionSort class
public class InsertionSort {
    // created sort method to implement insertion sort algorithm
    public static String[] sort(String [] arr) {
        int n = arr.length;
        for (int i = 1; i < n; i++) {
            String key = arr[i];
            int j = i - 1;
            // iteration to sort the array gradually
            while (j >= 0 && arr[j].compareTo(key) > 0) {
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j + 1] = key;
        }
        return arr;
    }

    // main method
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // taking input for total number of employees and then storing their employeeIDs in a String array
        System.out.println("Enter number of employees:");
        int numberOfEmployees = sc.nextInt();

        String [] employeeIDs = new String[numberOfEmployees];

        System.out.println("Enter employee IDs of all employees:");
        for (int i = 0; i < numberOfEmployees; i++) {
            employeeIDs[i] = sc.next();
        }

        // displaying IDs of employees in unsorted order
        System.out.println("employeeIDs of employees in unsorted order: " + Arrays.toString(employeeIDs));

        // sorting the employeeIDs array
        sort(employeeIDs);

        // displaying employeeIDs of employees in sorted order
        System.out.println("employeeIDs of employees in sorted order: " + Arrays.toString(employeeIDs));
    }
}
