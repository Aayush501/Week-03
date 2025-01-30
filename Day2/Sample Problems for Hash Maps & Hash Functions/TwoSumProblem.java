import java.util.HashMap;
import java.util.Scanner;

public class TwoSumProblem {

    static int[] findIndex(int[] arr, int targetSum){

        // hashmap to store the array elements with index
        HashMap<Integer, Integer> map = new HashMap<>();

        for(int i=0; i<arr.length; i++){
            if(map.containsKey(targetSum - arr[i])){
                return new int[]{map.get(targetSum - arr[i]), i};
            }
            map.put(arr[i], i);
        }

        // condition when elements not found
        return new int[]{-1,-1};
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // number of elements in array
        int n = sc.nextInt();
        int targetSum = sc.nextInt();
        int[]arr = new int[n];

        // taking input for array
        for(int i=0; i<n; i++){
            arr[i] = sc.nextInt();
        }

        // ans array has index
        int[]ans = findIndex(arr,targetSum);

        // print index
        System.out.println("Index are : " + ans[0] + " " + ans[1]);
    }
}
