import java.util.*;

public class SlidingWindowMaximum {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Input array size
        System.out.println("Enter number of elements: ");
        int n = sc.nextInt();

        int[] arr = new int[n];

        // Input elements
        System.out.println("Enter numbers:");
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        // Input window size
        System.out.println("Enter size of the window:");
        int k = sc.nextInt();

        // Edge case check
        if (k > n || k <= 0) {
            System.out.println("Invalid window size.");
            return;
        }

        // Deque to store indexes
        Deque<Integer> deque = new LinkedList<>();

        // Iterate through the array
        for (int i = 0; i < n; i++) {
            // Remove elements outside the window
            while (!deque.isEmpty() && deque.peekFirst() < i - k + 1) {
                deque.pollFirst();
            }

            // Remove smaller elements inside the window
            while (!deque.isEmpty() && arr[deque.peekLast()] < arr[i]) {
                deque.pollLast();
            }

            // Add current index
            deque.offerLast(i);

            // Print max of current window
            if (i >= k - 1) {
                System.out.println("Greatest element of window-" + (i - k + 2) + ": " + arr[deque.peekFirst()]);
            }
        }

        sc.close();
    }
}
