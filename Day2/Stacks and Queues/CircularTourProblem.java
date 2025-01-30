import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class PetrolPump {
    // attributes of this node
    int petrol;  // amount of petrol available at the pump
    int distance; // distance to the next petrol pump

    // constructor for initializing petrol and distance
    public PetrolPump(int petrol, int distance) {
        this.petrol = petrol;
        this.distance = distance;
    }
}

public class CircularTourProblem {
    // method for finding the starting petrol pump using a queue
    static private int findStartingPoint(PetrolPump[] pumps, int n) {
        Queue<Integer> queue = new LinkedList<>(); // queue to maintain the circular tour
        int start = 0;
        int surplus = 0;
        int deficit = 0;

        // iterating through all petrol pumps to check feasibility
        for (int i = 0; i < n; i++) {
            queue.add(i);
            surplus += pumps[i].petrol - pumps[i].distance;

            // if surplus becomes negative, reset the start position
            if (surplus < 0) {
                start = i + 1;
                deficit += surplus;
                surplus = 0;
                queue.clear();
            }
        }

        return (surplus + deficit >= 0) ? start : -1;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // taking input for the number of petrol pumps
        System.out.println("Enter the number of petrol pumps:");
        int n = sc.nextInt();
        PetrolPump[] pumps = new PetrolPump[n];

        // taking input for petrol and distance for each petrol pump
        System.out.println("Enter petrol and distance for each pump:");
        for (int i = 0; i < n; i++) {
            int petrol = sc.nextInt();
            int distance = sc.nextInt();
            pumps[i] = new PetrolPump(petrol, distance); // Creating PetrolPump objects
        }

        // finding the starting petrol pump
        int startPoint = findStartingPoint(pumps, n);

        // printing the result
        if (startPoint == -1) {
            System.out.println("No valid starting point found.");
        } else {
            System.out.println("Start at petrol pump index: " + (startPoint+1));
        }
    }
}
