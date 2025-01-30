// definition of TextNode class
class TextNode {
    String text;
    TextNode prev;
    TextNode next;

    public TextNode(String text) {
        this.text = text;
        this.prev = null;
        this.next = null;
    }
}

// definition of Text class
class Text {
    private TextNode head;
    private TextNode current;
    private int maxSize = 10; // Limit the history size to 10
    private int size = 0;

    // add a new text state
    public void addState(String newText) {
        TextNode newState = new TextNode(newText);

        if (head == null) {
            head = newState;
            current = head;
        } else {
            // remove all redo states
            current.next = null;

            // Add the new state
            newState.prev = current;
            current.next = newState;
            current = newState;
        }

        size++;
        if (size > maxSize) {
            // remove the oldest state
            head = head.next;
            head.prev = null;
            size--;
        }
    }

    // undo functionality
    public void undo() {
        if (current != null && current.prev != null) {
            current = current.prev;
        } else {
            System.out.println("No more actions to undo.");
        }
    }

    // redo functionality
    public void redo() {
        if (current != null && current.next != null) {
            current = current.next;
        } else {
            System.out.println("No more actions to redo.");
        }
    }

    // display the current state
    public void displayCurrentState() {
        if (current != null) {
            System.out.println("Current State: " + current.text);
        } else {
            System.out.println("No text available.");
        }
    }
}

// definition of UndoRedoFunctionality class
public class UndoRedoFunctionality {
    public static void main(String[] args) {
        Text editor = new Text();

        // Add new states
        editor.addState("Hello");
        editor.addState("Hello World");
        editor.addState("Hello World!");

        // Display the current state
        editor.displayCurrentState(); // Output: Hello World!

        // Perform undo operations
        editor.undo();
        editor.displayCurrentState(); // Output: Hello World

        editor.undo();
        editor.displayCurrentState(); // Output: Hello

        // Perform redo operations
        editor.redo();
        editor.displayCurrentState(); // Output: Hello World

        // Add a new state after undo
        editor.addState("New State Added");
        editor.displayCurrentState(); // Output: New State Added

        // Try to redo after adding a new state (should not work)
        editor.redo(); // Output: No more actions to redo.
    }
}