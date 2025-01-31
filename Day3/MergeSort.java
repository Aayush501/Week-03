import java.util.Arrays;
import java.util.Scanner;

// definition of MergeSort class
public class MergeSort {

    // created sort method to implement merge sort algorithm
    static private void sort(double [] price, int left, int right) {
        if (left < right) {
            int mid = left + (right - left) / 2;

            sort(price, left, mid);
            sort(price, mid + 1, right);
            merge(price, left, mid, right);
        }
    }

    // created method to merge
    private static void merge(double[] price, int left, int mid, int right) {
        int n1 = mid - left + 1;
        int n2 = right - mid;

        double[] leftArr = new double[n1];
        double[] rightArr = new double[n2];

        System.arraycopy(price, left, leftArr, 0, n1);
        System.arraycopy(price, mid + 1, rightArr, 0, n2);

        int i = 0, j = 0, k = left;
        while (i < n1 && j < n2) {
            if (leftArr[i] <= rightArr[j]) {
                price[k++] = leftArr[i++];
            } else {
                price[k++] = rightArr[j++];
            }
        }
        while (i < n1) price[k++] = leftArr[i++];
        while (j < n2) price[k++] = rightArr[j++];
    }

    // main method
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // taking input for total number of books and then storing their prices in a double array
        System.out.println("Enter number of books:");
        int numberOfBooks = sc.nextInt();

        double[] price = new double[numberOfBooks];

        System.out.println("Enter prices of all books:");
        for (int i = 0; i < numberOfBooks; i++) {
            price[i] = sc.nextDouble();
        }

        // displaying prices of books in unsorted order
        System.out.println("prices of books in unsorted order: " + Arrays.toString(price));

        // sorting the prices array
        sort(price, 0, numberOfBooks-1);

        // displaying prices of books in sorted order
        System.out.println("prices of books in sorted order: " + Arrays.toString(price));
    }
}
