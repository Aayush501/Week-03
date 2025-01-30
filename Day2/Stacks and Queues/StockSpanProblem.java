import java.util.Scanner;
import java.util.Stack;

public class StockSpanProblem {
    public static void main(String[] args) {
        double[] stockPrice;

        Scanner sc = new Scanner(System.in);
        System.out.println("enter number of days: ");
        int numberOfDays = sc.nextInt();

        stockPrice = new double[numberOfDays];

        System.out.println("Enter price of each day");
        for (int i=0; i<numberOfDays; i++) {
            stockPrice[i] = sc.nextDouble();
        }

        /*
            calculating the span (number of consecutive days) the price was less than or equal to the current day's price
            current price is the price at the last element of the stockPrice array
        */
        Stack<Double> maxSpan = new Stack<>();
        int answer = 0;
        for (int i = 0; i < numberOfDays; i++) {
            if (maxSpan.isEmpty() && stockPrice[numberOfDays-1] >= stockPrice[i]) {
                maxSpan.push(stockPrice[i]);
            } else if (stockPrice[numberOfDays-1] >= stockPrice[i]) {
                maxSpan.push(stockPrice[i]);
            } else {
                answer = Math.max(answer, maxSpan.size());
                maxSpan = new Stack<>();
            }
        }

        System.out.println("Max span when the price was less than current price is: " + answer);
    }
}
