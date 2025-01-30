import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

// definiition of ZeroSumSubarrays class
class ZeroSumSubarrays {
    public static List<int[]> findZeroSumSubarrays(int[] arr) {
        List<int[]> result = new ArrayList<>();
        HashMap<Integer, List<Integer>> sumMap = new HashMap<>();
        int sum = 0;

        // Initialize the map with sum 0 at index -1
        sumMap.put(0, new ArrayList<>());
        sumMap.get(0).add(-1);

        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];

            if (sumMap.containsKey(sum)) {
                List<Integer> indices = sumMap.get(sum);
                for (int start : indices) {
                    result.add(new int[]{start + 1, i});
                }
            }

            if (!sumMap.containsKey(sum)) {
                sumMap.put(sum, new ArrayList<>());
            }
            sumMap.get(sum).add(i);
        }

        return result;
    }
}

// definition of SubarraysWithZeroSum class
public class SubarraysWithZeroSum {
    public static void main(String[] args) {
        int[] arr = {1, 2, -3, 4, -2, 2, -4, 2, 2};
        List<int[]> zeroSumSubarrays = ZeroSumSubarrays.findZeroSumSubarrays(arr);

        for (int[] subarray : zeroSumSubarrays) {
            System.out.println("Subarray found from index " + subarray[0] + " to " + subarray[1]);
        }
    }
}