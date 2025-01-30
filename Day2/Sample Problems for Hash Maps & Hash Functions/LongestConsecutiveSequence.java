import java.util.HashSet;

public class LongestConsecutiveSequence {
    static int findLength(int[]arr){

        // using hashset to count frequency
        HashSet<Integer> set = new HashSet<>();

        // maxlength holds maximum length of consecutive number
        int maxlength = 0;
        // len holds the length of current max
        int len = 1;

        // add all elements in set
        for(int i : arr){
            set.add(i);
        }

        for (int j : set) {
            // check if elements consecutive element exist or not
            if (set.contains(j - 1)) {
                len++;
            }
            set.add(j);
            maxlength = Math.max(len, maxlength);
        }

        return maxlength;
    }
    public static void main(String[] args) {

        int[]arr = {9,6,2,1,4,1,3};

        // print maxLength
        System.out.println(findLength(arr));
    }
}