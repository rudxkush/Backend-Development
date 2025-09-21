import java.util.*;

public class Train {
    String trainId;
    String trainName;
    String sourceStation;
    String destinationStation;
    int totalSeats;
    int availableSeats;
    int platformNumber;
    String departureTime;
    String arrivalTime;
    double fare;
    
    // Constructor
    Train(String trainId, String trainName, String source, String destination, 
          int totalSeats, int platform, String departureTime, String arrivalTime, double fare) {
        this.trainId = trainId;
        this.trainName = trainName;
        this.sourceStation = source;
        this.destinationStation = destination;
        this.totalSeats = totalSeats;
        this.availableSeats = totalSeats; // Initially all seats available
        this.platformNumber = platform;
        this.departureTime = departureTime;
        this.arrivalTime = arrivalTime;
        this.fare = fare;
    }
    
    // Method to book a seat
    boolean bookSeat() {
        if (availableSeats > 0) {
            availableSeats--;
            return true;
        }
        return false;
    }
    
    // Method to cancel a seat booking
    void cancelSeat() {
        if (availableSeats < totalSeats) {
            availableSeats++;
        }
    }
    
    // Method to check if seats are available
    boolean hasAvailableSeats() {
        return availableSeats > 0;
    }
    
    // Method to get train details
    String getTrainDetails() {
        return "Train ID: " + trainId + 
               "\nTrain Name: " + trainName +
               "\nRoute: " + sourceStation + " to " + destinationStation +
               "\nDeparture: " + departureTime + " | Arrival: " + arrivalTime +
               "\nPlatform: " + platformNumber +
               "\nAvailable Seats: " + availableSeats + "/" + totalSeats +
               "\nFare: $" + fare;
    }
    
    // Getters
    String getTrainId() { return trainId; }
    String getTrainName() { return trainName; }
    String getSourceStation() { return sourceStation; }
    String getDestinationStation() { return destinationStation; }
    int getTotalSeats() { return totalSeats; }
    int getAvailableSeats() { return availableSeats; }
    int getPlatformNumber() { return platformNumber; }
    String getDepartureTime() { return departureTime; }
    String getArrivalTime() { return arrivalTime; }
    double getFare() { return fare; }
    
    public static void main(String[] args) {
        // Demo usage
        Train train = new Train("T001", "Express Express", "New York", "Boston", 
                               100, 3, "09:00 AM", "01:00 PM", 75.50);
        System.out.println(train.getTrainDetails());
    }
}
