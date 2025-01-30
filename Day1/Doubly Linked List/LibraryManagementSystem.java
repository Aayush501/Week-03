// definition of BookNode class
class BookNode {
    // declaring the attributes of this class
    String title;
    String author;
    String genre;
    int bookID;
    boolean isAvailable;
    BookNode next;
    BookNode prev;

    // created a parameterized constructor to initialize the object
    public BookNode(String title, String author, String genre, int bookID, boolean isAvailable) {
        this.title = title;
        this.author = author;
        this.genre = genre;
        this.bookID = bookID;
        this.isAvailable = isAvailable;
        this.next = null;
        this.prev = null;
    }
}

// definition of Book class
class Book {
    // declaring the attributes of this class
    private BookNode head;
    private BookNode tail;
    private int count;

    // created a non-parameterized constructor
    public Book() {
        this.head = null;
        this.tail = null;
        this.count = 0;
    }

    // add a new book
    public void addBook(String title, String author, String genre, int bookID, boolean isAvailable, int position) {
        BookNode newBook = new BookNode(title, author, genre, bookID, isAvailable);
        if (position <= 0 || head == null) { // Add at the beginning
            newBook.next = head;
            if (head != null) {
                head.prev = newBook;
            }
            head = newBook;
            if (tail == null) {
                tail = newBook;
            }
        } else if (position >= count) { // Add at the end
            newBook.prev = tail;
            if (tail != null) {
                tail.next = newBook;
            }
            tail = newBook;
            if (head == null) {
                head = newBook;
            }
        } else { // Add at specific position
            BookNode current = head;
            for (int i = 0; i < position - 1; i++) {
                current = current.next;
            }
            newBook.next = current.next;
            newBook.prev = current;
            if (current.next != null) {
                current.next.prev = newBook;
            }
            current.next = newBook;
        }
        count++;
    }

    // remove a book by Book ID
    public void removeBook(int bookID) {
        BookNode current = head;
        while (current != null && current.bookID != bookID) {
            current = current.next;
        }
        if (current == null) {
            System.out.println("Book not found.");
            return;
        }
        if (current.prev != null) {
            current.prev.next = current.next;
        } else {
            head = current.next;
        }
        if (current.next != null) {
            current.next.prev = current.prev;
        } else {
            tail = current.prev;
        }
        count--;
        System.out.println("Book removed successfully.");
    }

    // search for a book by Title or Author
    public void searchBook(String keyword) {
        BookNode current = head;
        boolean found = false;
        while (current != null) {
            if (current.title.equalsIgnoreCase(keyword) || current.author.equalsIgnoreCase(keyword)) {
                System.out.println("Book Found: [Title: " + current.title + ", Author: " + current.author + ", Genre: " + current.genre + ", ID: " + current.bookID + ", Available: " + current.isAvailable + "]");
                found = true;
            }
            current = current.next;
        }
        if (!found) {
            System.out.println("No book found with the given keyword.");
        }
    }

    // update Availability Status
    public void updateAvailability(int bookID, boolean isAvailable) {
        BookNode current = head;
        while (current != null) {
            if (current.bookID == bookID) {
                current.isAvailable = isAvailable;
                System.out.println("Availability status updated.");
                return;
            }
            current = current.next;
        }
        System.out.println("Book not found.");
    }

    // display all books in forward order
    public void displayBooksForward() {
        BookNode current = head;
        while (current != null) {
            System.out.println("[Title: " + current.title + ", Author: " + current.author + ", Genre: " + current.genre + ", ID: " + current.bookID + ", Available: " + current.isAvailable + "]");
            current = current.next;
        }
    }

    // display all books in reverse order
    public void displayBooksReverse() {
        BookNode current = tail;
        while (current != null) {
            System.out.println("[Title: " + current.title + ", Author: " + current.author + ", Genre: " + current.genre + ", ID: " + current.bookID + ", Available: " + current.isAvailable + "]");
            current = current.prev;
        }
    }

    // count the total number of books
    public int getTotalBooks() {
        return count;
    }
}

// definition of LibraryManagementSystem class
public class LibraryManagementSystem {
    public static void main(String[] args) {
        Book library = new Book();

        library.addBook("Book1", "Author1", "Fiction", 101, true, 0);
        library.addBook("Book2", "Author2", "Mystery", 102, true, 1);
        library.addBook("Book3", "Author3", "Horror", 103, true, 1);

        System.out.println("All books in forward order:");
        library.displayBooksForward();

        System.out.println("\nAll books in reverse order:");
        library.displayBooksReverse();

        System.out.println("\nSearching for 'Author2':");
        library.searchBook("Author2");

        System.out.println("\nUpdating availability of Book ID 102:");
        library.updateAvailability(102, false);
        library.displayBooksForward();

        System.out.println("\nRemoving Book ID 103:");
        library.removeBook(103);
        library.displayBooksForward();

        System.out.println("\nTotal number of books: " + library.getTotalBooks());
    }
}