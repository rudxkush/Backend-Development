import java.util.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Ticket {
    String ticketId;
    String passengerName;
    String passengerAge;
    String passengerGender;
    Train bookedTrain;
    String seatNumber;
    LocalDateTime bookingDate;
    double totalFare;
    String bookingStatus; // "CONFIRMED", "CANCELLED", "WAITLISTED"
    
    // Constructor
    Ticket(String ticketId, String passengerName, String passengerAge, String passengerGender,
           Train train, String seatNumber, double totalFare) {
        this.ticketId = ticketId;
        this.passengerName = passengerName;
        this.passengerAge = passengerAge;
        this.passengerGender = passengerGender;
        this.bookedTrain = train;
        this.seatNumber = seatNumber;
        this.totalFare = totalFare;
        this.bookingDate = LocalDateTime.now();
        this.bookingStatus = "CONFIRMED";
    }
    
    // Method to cancel ticket
    void cancelTicket() {
        this.bookingStatus = "CANCELLED";
        // Return the seat to train
        if (bookedTrain != null) {
            bookedTrain.cancelSeat();
        }
    }
    
    // Method to generate ticket details for printing/downloading
    String generateTicketReceipt() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
        
        return "=== TRAIN TICKET ===\n" +
               "Ticket ID: " + ticketId + "\n" +
               "Booking Date: " + bookingDate.format(formatter) + "\n" +
               "Status: " + bookingStatus + "\n\n" +
               "=== PASSENGER DETAILS ===\n" +
               "Name: " + passengerName + "\n" +
               "Age: " + passengerAge + "\n" +
               "Gender: " + passengerGender + "\n" +
               "Seat Number: " + seatNumber + "\n\n" +
               "=== TRAIN DETAILS ===\n" +
               (bookedTrain != null ? bookedTrain.getTrainDetails() : "Train details not available") + "\n\n" +
               "=== PAYMENT DETAILS ===\n" +
               "Total Fare: $" + totalFare + "\n" +
               "==========================================\n" +
               "Please reach the platform 30 minutes before departure.\n" +
               "Have a safe journey!";
    }
    
    // Method to get short ticket summary
    String getTicketSummary() {
        return "Ticket " + ticketId + " | " + passengerName + " | " +
               (bookedTrain != null ? bookedTrain.getTrainName() + " (" + 
               bookedTrain.getSourceStation() + " to " + bookedTrain.getDestinationStation() + ")" : "N/A") +
               " | Seat: " + seatNumber + " | Status: " + bookingStatus;
    }
    
    // Getters
    String getTicketId() { return ticketId; }
    String getPassengerName() { return passengerName; }
    String getPassengerAge() { return passengerAge; }
    String getPassengerGender() { return passengerGender; }
    Train getBookedTrain() { return bookedTrain; }
    String getSeatNumber() { return seatNumber; }
    LocalDateTime getBookingDate() { return bookingDate; }
    double getTotalFare() { return totalFare; }
    String getBookingStatus() { return bookingStatus; }
    
    public static void main(String[] args) {
        // Demo usage
        Train train = new Train("T001", "Express Express", "New York", "Boston", 
                               100, 3, "09:00 AM", "01:00 PM", 75.50);
        Ticket ticket = new Ticket("TKT001", "John Doe", "30", "Male", 
                                 train, "A15", 75.50);
        System.out.println(ticket.generateTicketReceipt());
    }
}
