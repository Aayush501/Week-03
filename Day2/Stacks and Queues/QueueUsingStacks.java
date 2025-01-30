import java.util.Stack;

class Queue {
    private Stack<Integer> enqueue;
    private Stack<Integer> dequeue;

    Queue() {
        enqueue = new Stack<>();
        dequeue = new Stack<>();
    }

    void enqueue(int number) {
        enqueue.push(number);
        System.out.println(number + " is enqueued.");
    }

    void dequeue() {
        if (enqueue.isEmpty()){
            System.out.println("no element left in the queue!!");
            return;
        }
        while (!enqueue.isEmpty()) {
            dequeue.push(enqueue.pop());
        }
        System.out.println("dequeued element is: " + dequeue.pop());
        while (!dequeue.isEmpty()) {
            enqueue.push(dequeue.pop());
        }
    }
}

public class QueueUsingStacks {

    public static void main(String[] args) {
        QueueUsingStacks queue = new QueueUsingStacks();

        Queue queue1 = new Queue();

        // enqueue operations
        for (int i = 1; i <= 5; i++) {
            queue1.enqueue(i);
        }

        // dequeue operations
        for (int i = 0; i <= 5; i++) {
            queue1.dequeue();
        }
    }
}