import org.example.FirstNegativeNumber;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;

// created class JunitTesting to test the code
public class JunitTesting {

    // created a test method which is going to be tested
    @Test
    public void firstNegativeElement() {
        /*
         this method will be testing the method for finding the index of first negative element of the array
         the method will be tested with multiple test cases to ensure its accuracy
        */

        // creating object of FirstNegativeNumber class
        FirstNegativeNumber obj = new FirstNegativeNumber();

        // creating an integer array without any negative element
        int[] arr = {10, 12, 14, 1, 5, 7, 13};
        // testing the method
        assertEquals(-1, obj.linearSearch(arr)); // the method should return -1

        // adding a negative element into arr
        arr[3] = -2;
        // testing the method
        assertEquals(3, obj.linearSearch(arr)); // the method should return 3

        // adding multiple negative elements into arr
        arr[2] = -4; arr[4] = -3; arr[6] = -5;
        // testing the method
        assertEquals(2, obj.linearSearch(arr)); // the method should return 2
    }
}