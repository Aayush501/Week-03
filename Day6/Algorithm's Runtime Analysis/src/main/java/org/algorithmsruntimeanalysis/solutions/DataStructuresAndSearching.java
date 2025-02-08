package org.algorithmsruntimeanalysis.solutions;

import java.util.HashSet;
import java.util.Scanner;
import java.util.TreeSet;

// definition of DataStructuresAndSearching class
public class DataStructuresAndSearching {

    // created a method to search an element in the array
    public boolean searchInArray (int [] arr, int target) {
        for (int i : arr) { // iterating through arr, performing linear search
            if (i == target) return true; // if target is found
        }
        return false; // if target is not present in the array
    }

    // created a method to measure the performance of searching in an array
    public String arrayPerformance(int [] arr, int target) {
        long start = System.nanoTime();

        // checking the performance
        System.out.println(target + " is " + ((searchInArray(arr, target))? "present " : "not present ") + "in the array.");

        long end = System.nanoTime(); // start and end variables for checking performance of array on searching

        // displaying the performance
        System.out.println("Time to search " + target + " in the array: " + (end - start));
        return "Search in array is completed.";
    }

    // created a method to search an element in the hash set
    public boolean searchInHashSet (HashSet <Integer> hashSet, int target) {
        return hashSet.contains(target); // inbuilt method in hashset
    }

    // created a method to measure the performance of searching in a hash set
    public String hashSetPerformance(HashSet <Integer> hashSet, int target) {
        long start = System.nanoTime();

        // checking the performance
        System.out.println(target + " is " + ((searchInHashSet(hashSet, target))? "present " : "not present ") + "in the Hash Set.");

        long end = System.nanoTime(); // start and end variables for checking performance of array on searching

        // displaying the performance
        System.out.println("Time to search " + target + " in the hash set: " + (end - start));
        return "Search in Hash Set is completed.";
    }

    // created a method to search an element in the tree set
    public boolean searchInTreeSet (TreeSet <Integer> treeSet, int target) {
        return treeSet.contains(target); // inbuilt method in tree set
    }

    // created a method to measure the performance of searching in a tree set
    public String treeSetPerformance(TreeSet <Integer> treeSet, int target) {
        long start = System.nanoTime();

        // checking the performance
        System.out.println(target + " is " + ((searchInTreeSet(treeSet, target))? "present " : "not present ") + "in the Tree Set.");

        long end = System.nanoTime(); // start and end variables for checking performance of array on searching

        // displaying the performance
        System.out.println("Time to search " + target + " in the tree set: " + (end - start));
        return "Search in Tree Set is completed.";
    }

    // created method to compare the performances of data structures
    public String comparePerformances(int [] arr, HashSet<Integer> hashSet, TreeSet<Integer> treeSet, int target){
        // checking performances of data structures
        DataStructuresAndSearching obj = new DataStructuresAndSearching();

        System.out.println("Performance of array:");
        System.out.println(obj.arrayPerformance(arr, target) + "\n");

        System.out.println("Performance of Hash Set:");
        System.out.println(obj.hashSetPerformance(hashSet, target) + "\n");

        System.out.println("Performance of Tree Set:");
        System.out.println(obj.treeSetPerformance(treeSet, target) + "\n");

        return "Completed the comparison of performances of various data structures on searching.";
    }

    // main method
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in); // object of scanner class

        // taking inputs for number of elements in the data structures
        System.out.println("Enter the number of elements for each data structure:");
        int dataStructureSize = sc.nextInt();

        // creating various data structures
        int [] arr = new int[dataStructureSize];
        HashSet <Integer> hashSet = new HashSet<>();
        TreeSet <Integer> treeSet = new TreeSet<>();

        // adding data to the data structures
        for (int i = 0; i < dataStructureSize; i++) {
            int data = (i%2 == 0)? i+15 : 1+10;
            arr[i] = data;
            hashSet.add(data);
            treeSet.add(data);
        }

        // taking input for target elements
        System.out.println("Enter Target Element:");
        int target = sc.nextInt();

        // comparing the performances of data structures
        DataStructuresAndSearching obj = new DataStructuresAndSearching();

        System.out.println(obj.comparePerformances(arr, hashSet, treeSet, target));
    }
}
