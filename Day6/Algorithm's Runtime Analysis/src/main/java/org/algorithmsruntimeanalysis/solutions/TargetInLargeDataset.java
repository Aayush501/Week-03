import java.util.ArrayList;

// definition of TargetInLargeDataset class
public class TargetInLargeDataset {
    // definition of linearSearch method to perform linear search algorithm
    public String linearSearch(ArrayList<Integer> arr, int target) { // taking arraylist as parameter for improving efficiency
        int sizeOfList = arr.size();
        boolean check = false; // to check the presence of target in the arrayList

        long start = System.nanoTime(); // for checking the performance of linear search
        int i=0;
        for (; i<sizeOfList; i++) {
            if (arr.get(i) == target) {
                check = true;
                break;
            }
        }
        long end = System.nanoTime(); // for checking the performance of linear search

        System.out.println((check)? target + " is present in the array at index " + i + "." : target + " is not present in the array.");

        return "Linear Search Time: " + (end - start);
    }

    public String binarySearch(ArrayList<Integer> arr, int target) {
        // declaring variables required for binary search
        int left=0, right=arr.size()-1, mid = -1;
        boolean check = false; // to check the presence of target in the arrayList

        long start = System.nanoTime(); // for checking the performance of linear search
        // using while loop to perform binary search in the list
        while (left <= right) {
            // calculating middle index
            mid = (left + right) / 2;

            if (arr.get(mid) == target) {
                check = true;
                break;
            }

            if (arr.get(mid) < target) {
                left = mid+1;
                continue;
            }

            if (arr.get(mid) > target) {
                right = mid-1;
            }
        }
        long end = System.nanoTime(); // for checking the performance of linear search

        System.out.println((check)? target + " is present in the array at index " + mid + "." : target + " is not present in the array.");

        return "Binary Search Time: " + (end - start);
    }

    // main method
    public static void main(String[] args) {
        // creating large datasets to compare the performances of linear search and binary search
        ArrayList<Integer> dataSet1 = new ArrayList<>(); // will contain 1,000 elements
        ArrayList<Integer> dataSet2 = new ArrayList<>(); // will contain 10,000 elements
        ArrayList<Integer> dataSet3 = new ArrayList<>(); // will contain 1,000,000 elements

        // adding elements in datasets
        for (int i = 1; i <= 1000; i++) {
            dataSet1.add(i);
        }

        for (int i = 1; i <= 10000; i++) {
            dataSet2.add(i);
        }

        for (int i = 1; i <= 1000000; i++) {
            dataSet3.add(i);
        }

        // comparing the performances of searching algorithms
        TargetInLargeDataset obj = new TargetInLargeDataset();

        String dataset1LinearSearchPerformance = obj.linearSearch(dataSet1, 1000);
        String dataset1BinarySearchPerformance = obj.binarySearch(dataSet1, 1000);

        String dataset2LinearSearchPerformance = obj.linearSearch(dataSet2, 10000);
        String dataset2BinarySearchPerformance = obj.binarySearch(dataSet2, 10000);

        String dataset3LinearSearchPerformance = obj.linearSearch(dataSet3, 1000000);
        String dataset3BinarySearchPerformance = obj.binarySearch(dataSet3, 1000000);

        // printing the comparison
        System.out.println("Performance comparison for arrayList of 1,000 elements:");
        System.out.println(dataset1LinearSearchPerformance);
        System.out.println(dataset1BinarySearchPerformance);

        System.out.println("Performance comparison for arrayList of 10,000 elements:");
        System.out.println(dataset2LinearSearchPerformance);
        System.out.println(dataset2BinarySearchPerformance);

        System.out.println("Performance comparison for arrayList of 1,000,000 elements:");
        System.out.println(dataset3LinearSearchPerformance);
        System.out.println(dataset3BinarySearchPerformance);
    }
}