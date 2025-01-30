import java.util.Scanner;
import java.util.Stack;

public class SortAStack {
    static private Stack<Integer> sort (Stack<Integer> problem, Stack<Integer> solution) {
        if (problem.isEmpty()) {
            return solution;
        }

        int greatest = Integer.MIN_VALUE;
        Stack<Integer> popper = new Stack<>();

        while (!problem.isEmpty()) {
            greatest = Math.max(problem.peek(), greatest);
            popper.push(problem.pop());
        }
        boolean done=true;
        while (!popper.isEmpty()) {
            if (done && popper.peek() == greatest){
                done = false;
                popper.pop();
            }
            if (!popper.isEmpty()) {
                problem.push(popper.pop());
            }
        }
        solution.push(greatest);
        return sort(problem, solution); // using recursion to sort
    }

    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        Scanner sc = new Scanner(System.in);

        // taking input for stack elements
        System.out.println("Enter number of elements:");
        int numberOfElements = sc.nextInt();

        System.out.println("Enter elements:");
        for (int i=0; i<numberOfElements; i++) {
            int element = sc.nextInt();
            stack.push(element);
        }

        // printing initial stack
        Stack<Integer> temp = new Stack<>();
        System.out.println("Initial stack:");
        while (!stack.isEmpty()) {
            System.out.println(stack.peek());
            temp.push(stack.pop());
        }
        while (!temp.isEmpty()) {
            stack.push(temp.pop());
        }

        // sorting the elements of stack
        System.out.println("Sorting elements of stack.");
        stack = sort(stack, new Stack<>());
        temp = new Stack<>();

        // printing sorted stack
        System.out.println("Sorted stack:");
        while (!stack.isEmpty()) {
            System.out.println(stack.peek());
            temp.push(stack.pop());
        }
        stack = temp;
        temp = null;
    }
}