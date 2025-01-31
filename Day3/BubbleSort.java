import java.util.Scanner;

// definition of BubbleSort class
public class BubbleSort {

    // created sort method to implement bubble sort algorithm
    static private double[] sort(double [] arr) {
        for (int j = 0; j < arr.length; j++) {
            for (int i = 0; i < arr.length-1-j; i++) {
                if(arr[i] > arr[i+1]) {
                    // swapping the elements by using addition and subtraction operator
                    arr[i] = arr[i] + arr[i+1];
                    arr[i+1] = arr[i] - arr[i+1];
                    arr[i] = arr[i] - arr[i+1];
                }
            }
        }
        return arr;
    }

    // main method
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // taking input for total number of students and then storing their marks in a double array
        System.out.println("Enter number of students:");
        int numberOfStudents = sc.nextInt();

        double[] marks = new double[numberOfStudents];

        System.out.println("Enter marks of all students:");
        for (int i = 0; i < numberOfStudents; i++) {
            marks[i] = sc.nextDouble();
        }

        // displaying marks of students in unsorted order
        System.out.print("Marks of students in unsorted order: [ ");
        for (double i : marks) {
            System.out.print(i + ", ");
        }
        System.out.println("]");

        // sorting the marks array
        sort(marks);

        // displaying marks of students in sorted order
        System.out.print("Marks of students in sorted order: [ ");
        for (double i : marks) {
            System.out.print(i + ", ");
        }
        System.out.println("]");
    }
}
