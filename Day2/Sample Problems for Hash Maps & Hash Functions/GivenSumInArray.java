import java.util.HashMap;

public class GivenSumInArray {
    static boolean check(int[]arr, int target){

        // using hashmap to store elements of array with index
        HashMap<Integer, Integer> map = new HashMap<>();

        // iterating all elements of an array to find elements with target sum
        for(int i=0; i<arr.length; i++){
            if(map.containsKey(target - arr[i])){
                return true;
            }
            map.put(arr[i], i);
        }

        return false;
    }
    public static void main(String[] args) {
        int[]arr = {1,2,3,4,5};
        int target = 4;
        System.out.println("Do we have a pair gives the target sum : " + check(arr, target));
    }
}
