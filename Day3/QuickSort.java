import java.util.Arrays;
import java.util.Scanner;

public class QuickSort {
    // created sort method to implement quick sort algorithm
    public static void sort(double [] arr, int low, int high) {
        if(low>=high)return; // break the recursion if low>=high

        int left = low, right = high;
        int mid = left + (right-left)/2;
        double pivot = arr[mid]; // pivot element is taken middle element to avoid worst case

        while (left<=right) {
            // finding element on left side that is greater than pivot
            while (arr[left] < pivot) {
                left++;
            }

            // finding element on right side that is smaller than pivot
            while (arr[right] > pivot) {
                right--;
            }

            // swap both the numbers
            if (left <= right){
                double t=arr[right];
                arr[right]=arr[left];
                arr[left]=t;
                right--;
                left++;
            }
        }

        // recursively calling the sort function
        sort(arr, low, right);
        sort(arr, left, high);
    }

    // main method
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // taking input for total number of products and then storing their prices in a double array
        System.out.println("Enter number of products:");
        int numberOfProducts = sc.nextInt();

        double[] price = new double[numberOfProducts];

        System.out.println("Enter prices of all products:");
        for (int i = 0; i < numberOfProducts; i++) {
            price[i] = sc.nextDouble();
        }

        // displaying prices of products in unsorted order
        System.out.println("prices of products in unsorted order: " + Arrays.toString(price));

        // sorting the prices array
        sort(price, 0, numberOfProducts-1);

        // displaying prices of products in sorted order
        System.out.println("prices of products in sorted order: " + Arrays.toString(price));
    }
}