import java.util.*;

/* Functional Requirements:
    1. User login and signup
    2. Fetch and search trains
    3. Show available seats
    4. Book seats
    5. Ticket download
*/

public class Main {
    private static Scanner scanner = new Scanner(System.in);
    private static List<User> users = new ArrayList<User>();
    private static List<Train> trains = new ArrayList<Train>();
    private static User currentUser = null;
    
    public static void main(String[] args) {
        initializeTrains(); // Add some sample trains
        
        System.out.println("========================================");
        System.out.println("   WELCOME TO TRAIN BOOKING SYSTEM");
        System.out.println("========================================");
        
        while (true) {
            if (currentUser == null) {
                showLoginMenu();
            } else {
                showMainMenu();
            }
        }
    }
    
    // Initialize some sample trains
    private static void initializeTrains() {
        trains.add(new Train("T001", "Express Express", "New York", "Boston", 100, 3, "09:00 AM", "01:00 PM", 75.50));
        trains.add(new Train("T002", "City Connector", "Boston", "Philadelphia", 80, 2, "02:30 PM", "06:15 PM", 65.00));
        trains.add(new Train("T003", "Metro Link", "Philadelphia", "Washington DC", 120, 1, "07:45 AM", "10:30 AM", 55.25));
        trains.add(new Train("T004", "Coastal Runner", "Washington DC", "Miami", 90, 4, "11:00 PM", "08:00 AM", 120.75));
        trains.add(new Train("T005", "Mountain Express", "Chicago", "Denver", 110, 5, "06:00 PM", "02:00 PM", 95.00));
    }
    
    // Show login/signup menu
    private static void showLoginMenu() {
        System.out.println("\n=== LOGIN / SIGNUP ===");
        System.out.println("1. Login");
        System.out.println("2. Signup");
        System.out.println("3. Exit");
        System.out.print("Choose an option: ");
        
        int choice = getIntInput();
        
        switch (choice) {
            case 1:
                login();
                break;
            case 2:
                signup();
                break;
            case 3:
                System.out.println("Thank you for using Train Booking System!");
                System.exit(0);
                break;
            default:
                System.out.println("Invalid option. Please try again.");
        }
    }
    
    // User login
    private static void login() {
        System.out.print("Enter User ID: ");
        String userId = scanner.nextLine();
        System.out.print("Enter Password: ");
        String password = scanner.nextLine();
        
        for (User user : users) {
            if (user.getUserId().equals(userId) && user.verifyPassword(password)) {
                currentUser = user;
                System.out.println("Login successful! Welcome, " + user.getUserName());
                return;
            }
        }
        System.out.println("Invalid credentials. Please try again.");
    }
    
    // User signup
    private static void signup() {
        System.out.print("Enter User ID: ");
        String userId = scanner.nextLine();
        
        // Check if user ID already exists
        for (User user : users) {
            if (user.getUserId().equals(userId)) {
                System.out.println("User ID already exists. Please choose a different one.");
                return;
            }
        }
        
        System.out.print("Enter Full Name: ");
        String name = scanner.nextLine();
        System.out.print("Enter Email: ");
        String email = scanner.nextLine();
        System.out.print("Enter Phone Number: ");
        String phone = scanner.nextLine();
        System.out.print("Enter Password: ");
        String password = scanner.nextLine();
        
        User newUser = new User(userId, name, email, phone, password);
        users.add(newUser);
        System.out.println("Signup successful! You can now login.");
    }
    
    // Show main menu for logged-in users
    private static void showMainMenu() {
        System.out.println("\n=== MAIN MENU ===");
        System.out.println("Hello, " + currentUser.getUserName() + "!");
        System.out.println("1. Search Trains");
        System.out.println("2. Book Ticket");
        System.out.println("3. View My Tickets");
        System.out.println("4. Cancel Ticket");
        System.out.println("5. Download Ticket");
        System.out.println("6. View Profile");
        System.out.println("7. Logout");
        System.out.print("Choose an option: ");
        
        int choice = getIntInput();
        
        switch (choice) {
            case 1:
                searchTrains();
                break;
            case 2:
                bookTicket();
                break;
            case 3:
                currentUser.viewMyTickets();
                break;
            case 4:
                cancelTicket();
                break;
            case 5:
                downloadTicket();
                break;
            case 6:
                System.out.println(currentUser.getUserProfile());
                break;
            case 7:
                currentUser = null;
                System.out.println("Logged out successfully!");
                break;
            default:
                System.out.println("Invalid option. Please try again.");
        }
    }
    
    // Search trains functionality
    private static void searchTrains() {
        System.out.println("\n=== TRAIN SEARCH ===");
        System.out.print("Enter source station: ");
        String source = scanner.nextLine();
        System.out.print("Enter destination station: ");
        String destination = scanner.nextLine();
        
        List<Train> availableTrains = new ArrayList<Train>();
        
        for (Train train : trains) {
            if (train.getSourceStation().equalsIgnoreCase(source) && 
                train.getDestinationStation().equalsIgnoreCase(destination)) {
                availableTrains.add(train);
            }
        }
        
        if (availableTrains.isEmpty()) {
            System.out.println("No trains found for the given route.");
            return;
        }
        
        System.out.println("\n=== AVAILABLE TRAINS ===");
        for (int i = 0; i < availableTrains.size(); i++) {
            System.out.println("\n" + (i + 1) + ". " + availableTrains.get(i).getTrainDetails());
            System.out.println("-------------------------------------------");
        }
    }
    
    // Book ticket functionality  
    private static void bookTicket() {
        System.out.println("\n=== BOOK TICKET ===");
        
        // Build list of available trains
        List<Train> availableTrains = new ArrayList<Train>();
        for (Train train : trains) {
            if (train.hasAvailableSeats()) {
                availableTrains.add(train);
            }
        }
        
        if (availableTrains.isEmpty()) {
            System.out.println("No trains have available seats at the moment.");
            return;
        }
        
        // Show available trains with contiguous numbering
        System.out.println("Available Trains:");
        for (int i = 0; i < availableTrains.size(); i++) {
            Train train = availableTrains.get(i);
            System.out.println((i + 1) + ". " + train.getTrainName() + 
                             " (" + train.getSourceStation() + " to " + train.getDestinationStation() + 
                             ") - Available: " + train.getAvailableSeats() + " seats");
        }
        
        System.out.print("Select train number: ");
        int trainChoice = getIntInput() - 1;
        
        if (trainChoice < 0 || trainChoice >= availableTrains.size()) {
            System.out.println("Invalid train selection.");
            return;
        }
        
        Train selectedTrain = availableTrains.get(trainChoice);
        if (!selectedTrain.hasAvailableSeats()) {
            System.out.println("No seats available on this train.");
            return;
        }
        
        System.out.print("Enter passenger name: ");
        String passengerName = scanner.nextLine();
        System.out.print("Enter passenger age: ");
        String passengerAge = scanner.nextLine();
        System.out.print("Enter passenger gender (Male/Female/Other): ");
        String passengerGender = scanner.nextLine();
        
        Ticket bookedTicket = currentUser.bookTicket(passengerName, passengerAge, passengerGender, selectedTrain);
        
        if (bookedTicket != null) {
            System.out.println("\nBooking Confirmation:");
            System.out.println(bookedTicket.getTicketSummary());
        }
    }
    
    // Cancel ticket functionality
    private static void cancelTicket() {
        System.out.println("\n=== CANCEL TICKET ===");
        currentUser.viewMyTickets();
        
        if (currentUser.getTicketsBooked().isEmpty()) {
            return;
        }
        
        System.out.print("Enter ticket ID to cancel: ");
        String ticketId = scanner.nextLine();
        currentUser.cancelTicket(ticketId);
    }
    
    // Download ticket functionality
    private static void downloadTicket() {
        System.out.println("\n=== DOWNLOAD TICKET ===");
        currentUser.viewMyTickets();
        
        if (currentUser.getTicketsBooked().isEmpty()) {
            return;
        }
        
        System.out.print("Enter ticket ID to download: ");
        String ticketId = scanner.nextLine();
        currentUser.downloadTicket(ticketId);
    }
    
    // Helper method to get integer input safely
    private static int getIntInput() {
        try {
            return Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            return -1; // Return invalid option if input is not a number
        }
    }
}
