import java.util.*;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class User {
    String userName;
    String hashedPassword;  
    List<Ticket> ticketsBooked;
    String userId;
    String email;
    String phoneNumber;
    
    // Constructor for new user registration
    User(String userId, String userName, String email, String phoneNumber, String password) {
        this.userId = userId;
        this.userName = userName;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.hashedPassword = hashPassword(password);
        this.ticketsBooked = new ArrayList<Ticket>();
    }
    
    // Constructor for existing user login
    User(String userId, String userName, String email, String phoneNumber, String hashedPassword, List<Ticket> existingTickets) {
        this.userId = userId;
        this.userName = userName;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.hashedPassword = hashedPassword;
        this.ticketsBooked = (existingTickets != null) ? existingTickets : new ArrayList<Ticket>();
    }
    
    // Method to hash password for security
    private String hashPassword(String password) {
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            byte[] hashedBytes = md.digest(password.getBytes());
            StringBuilder sb = new StringBuilder();
            for (byte b : hashedBytes) {
                sb.append(String.format("%02x", b));
            }
            return sb.toString();
        } catch (NoSuchAlgorithmException e) {
            return password; // Fallback to plain text if hashing fails
        }
    }
    
    // Method to verify password during login
    boolean verifyPassword(String inputPassword) {
        return this.hashedPassword.equals(hashPassword(inputPassword));
    }
    
    // Method to book a ticket
    Ticket bookTicket(String passengerName, String passengerAge, String passengerGender, Train train) {
        if (train == null || !train.hasAvailableSeats()) {
            System.out.println("Sorry, no seats available on this train.");
            return null;
        }
        
        if (train.bookSeat()) {
            String ticketId = "TKT" + System.currentTimeMillis(); // Simple ticket ID generation
            String seatNumber = generateSeatNumber(train);
            double totalFare = train.getFare();
            
            Ticket newTicket = new Ticket(ticketId, passengerName, passengerAge, passengerGender, 
                                        train, seatNumber, totalFare);
            
            ticketsBooked.add(newTicket);
            System.out.println("Ticket booked successfully! Ticket ID: " + ticketId);
            return newTicket;
        } else {
            System.out.println("Failed to book seat. Please try again.");
            return null;
        }
    }
    
    // Helper method to generate seat number
    private String generateSeatNumber(Train train) {
        int seatSequence = train.getTotalSeats() - train.getAvailableSeats();
        int zeroBasedIndex = seatSequence - 1; // Convert to zero-based index
        char seatLetter = (char) ('A' + (zeroBasedIndex % 6)); // A-F for seat letters
        int seatRow = (zeroBasedIndex / 6) + 1;
        return seatLetter + String.valueOf(seatRow);
    }
    
    // Method to cancel a ticket
    boolean cancelTicket(String ticketId) {
        for (Ticket ticket : ticketsBooked) {
            if (ticket.getTicketId().equals(ticketId) && ticket.getBookingStatus().equals("CONFIRMED")) {
                ticket.cancelTicket();
                System.out.println("Ticket " + ticketId + " has been cancelled successfully.");
                return true;
            }
        }
        System.out.println("Ticket not found or already cancelled.");
        return false;
    }
    
    // Method to view all booked tickets
    void viewMyTickets() {
        if (ticketsBooked.isEmpty()) {
            System.out.println("No tickets booked yet.");
            return;
        }
        
        System.out.println("=== YOUR TICKETS ===");
        for (int i = 0; i < ticketsBooked.size(); i++) {
            System.out.println((i + 1) + ". " + ticketsBooked.get(i).getTicketSummary());
        }
    }
    
    // Method to get ticket details by ticket ID
    Ticket getTicketById(String ticketId) {
        for (Ticket ticket : ticketsBooked) {
            if (ticket.getTicketId().equals(ticketId)) {
                return ticket;
            }
        }
        return null;
    }
    
    // Method to download/print ticket
    void downloadTicket(String ticketId) {
        Ticket ticket = getTicketById(ticketId);
        if (ticket != null) {
            System.out.println("\n" + ticket.generateTicketReceipt());
        } else {
            System.out.println("Ticket not found.");
        }
    }
    
    // Method to get user profile information
    String getUserProfile() {
        return "=== USER PROFILE ===\n" +
               "User ID: " + userId + "\n" +
               "Name: " + userName + "\n" +
               "Email: " + email + "\n" +
               "Phone: " + phoneNumber + "\n" +
               "Total Tickets Booked: " + ticketsBooked.size();
    }
    
    // Getters
    String getUserId() { return userId; }
    String getUserName() { return userName; }
    String getEmail() { return email; }
    String getPhoneNumber() { return phoneNumber; }
    List<Ticket> getTicketsBooked() { return ticketsBooked; }
}
