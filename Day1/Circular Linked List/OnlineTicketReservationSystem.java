import java.time.LocalDateTime;
import java.util.*;

class TicketNode {
    int ticketID;
    String customerName;
    String movieName;
    String seatNumber;
    LocalDateTime bookingTime;
    TicketNode next;

    public TicketNode(int ticketID, String customerName, String movieName, String seatNumber, LocalDateTime bookingTime) {
        this.ticketID = ticketID;
        this.customerName = customerName;
        this.movieName = movieName;
        this.seatNumber = seatNumber;
        this.bookingTime = bookingTime;
        this.next = null;
    }
}

class Ticket {
    private TicketNode head;
    private TicketNode tail;
    private int totalTickets;

    public Ticket() {
        this.head = null;
        this.tail = null;
        this.totalTickets = 0;
    }

    // Add a new ticket reservation at the end
    public void addTicket(int ticketID, String customerName, String movieName, String seatNumber) {
        TicketNode newTicket = new TicketNode(ticketID, customerName, movieName, seatNumber, LocalDateTime.now());
        if (head == null) {
            head = newTicket;
            tail = newTicket;
            tail.next = head;
        } else {
            tail.next = newTicket;
            tail = newTicket;
            tail.next = head;
        }
        totalTickets++;
        System.out.println("Ticket booked successfully for " + customerName + "!");
    }

    // Remove a ticket by Ticket ID
    public void removeTicket(int ticketID) {
        if (head == null) {
            System.out.println("No tickets to remove.");
            return;
        }

        TicketNode current = head;
        TicketNode previous = tail;
        do {
            if (current.ticketID == ticketID) {
                if (current == head) {
                    head = head.next;
                    tail.next = head;
                } else if (current == tail) {
                    tail = previous;
                    tail.next = head;
                } else {
                    previous.next = current.next;
                }
                totalTickets--;
                System.out.println("Ticket with ID " + ticketID + " removed successfully.");
                return;
            }
            previous = current;
            current = current.next;
        } while (current != head);

        System.out.println("Ticket with ID " + ticketID + " not found.");
    }

    // Display the current tickets in the list
    public void displayTickets() {
        if (head == null) {
            System.out.println("No tickets booked yet.");
            return;
        }

        TicketNode current = head;
        System.out.println("Current Tickets:");
        do {
            System.out.println("[Ticket ID: " + current.ticketID + ", Customer Name: " + current.customerName + ", Movie Name: " + current.movieName + ", Seat: " + current.seatNumber + ", Booking Time: " + current.bookingTime + "]");
            current = current.next;
        } while (current != head);
    }

    // Search for a ticket by Customer Name or Movie Name
    public void searchTicket(String keyword) {
        if (head == null) {
            System.out.println("No tickets booked yet.");
            return;
        }

        TicketNode current = head;
        boolean found = false;
        do {
            if (current.customerName.equalsIgnoreCase(keyword) || current.movieName.equalsIgnoreCase(keyword)) {
                System.out.println("[Ticket ID: " + current.ticketID + ", Customer Name: " + current.customerName + ", Movie Name: " + current.movieName + ", Seat: " + current.seatNumber + ", Booking Time: " + current.bookingTime + "]");
                found = true;
            }
            current = current.next;
        } while (current != head);

        if (!found) {
            System.out.println("No tickets found for the given keyword.");
        }
    }

    // Calculate the total number of booked tickets
    public int getTotalTickets() {
        return totalTickets;
    }
}

public class OnlineTicketReservationSystem {
    public static void main(String[] args) {
        Ticket tickets = new Ticket();

        // Adding tickets
        tickets.addTicket(1, "Customer1", "Movie1", "A1");
        tickets.addTicket(2, "Customer2", "Movie1", "A2");
        tickets.addTicket(3, "Customer3", "Movie2", "B5");

        // Displaying tickets
        tickets.displayTickets();

        // Searching for a ticket
        System.out.println("\nSearching for tickets for 'Movie1':");
        tickets.searchTicket("Movie1");

        // Removing a ticket
        System.out.println("\nRemoving ticket with ID 2:");
        tickets.removeTicket(2);

        // Displaying tickets after removal
        tickets.displayTickets();

        // Total tickets count
        System.out.println("\nTotal number of tickets: " + tickets.getTotalTickets());
    }
}