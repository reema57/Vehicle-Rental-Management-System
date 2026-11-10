
import java.util.Scanner;

// This is the main class of the Vehicle Rental System.
public class Main {

    // Scanner reads user input.
    private static Scanner input = new Scanner(System.in);

    // Main method starts the program.
    public static void main(String[] args) {

        // Create the rental management object.
        RentalManagement management = new RentalManagement();

        // Add sample vehicles to the system.
        management.addSampleVehicles();

        // Display welcome message once.
        System.out.println("========================================");
        System.out.println("     Welcome to Vehicle Rental System");
        System.out.println("          Your Journey Starts Here!");
        System.out.println("========================================");
        System.out.println("We are happy to serve you.");

        boolean running = true;

        // Main menu loop.
        while (running) {

            System.out.println("\n========== MAIN MENU ==========");
            System.out.println("1. Agent");
            System.out.println("2. Client");
            System.out.println("3. Exit");
            System.out.println("===============================");

            int choice = readInt("Enter your choice: ");

            switch (choice) {

                case 1:
                    agentMenu(management);
                    break;

                case 2:
                    clientMenu(management);
                    break;

                case 3:
                    System.out.println("\nThank you for choosing our service!");
                    System.out.println("We hope to see you again.");
                    System.out.println("Have a wonderful day!");
                    System.out.println("Goodbye!");

                    running = false;
                    break;

                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }

        // Close Scanner after exiting the program.
        input.close();
    }

    // Display the agent menu.
    public static void agentMenu(RentalManagement management) {

        boolean agentRunning = true;

        while (agentRunning) {

            System.out.println("\n========== AGENT MENU ==========");
            System.out.println("1. Add New Vehicle");
            System.out.println("2. Display Available Vehicles");
            System.out.println("3. Search for a Vehicle");
            System.out.println("4. Rent a Vehicle");
            System.out.println("5. Return a Vehicle");
            System.out.println("6. Back to Main Menu");
            System.out.println("================================");

            int choice = readInt("Enter your choice: ");

            switch (choice) {

                case 1:
                    addNewVehicle(management);
                    showThankYouMessage();
                    break;

                case 2:
                    management.displayAvailableVehicles();
                    showThankYouMessage();
                    break;

                case 3:
                    searchMenu(management);
                    showThankYouMessage();
                    break;

                case 4:
                    String rentName = readText(
                            "Enter the vehicle name to rent: ");

                    management.rentVehicle(rentName);
                    showThankYouMessage();
                    break;

                case 5:
                    String returnName = readText(
                            "Enter the vehicle name to return: ");

                    management.returnVehicle(returnName);
                    showThankYouMessage();
                    break;

                case 6:
                    agentRunning = false;
                    break;

                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    // Display the client menu.
    public static void clientMenu(RentalManagement management) {

        boolean clientRunning = true;

        while (clientRunning) {

            System.out.println("\n========== CLIENT MENU ==========");
            System.out.println("1. Search by Vehicle Name");
            System.out.println("2. Search by Brand");
            System.out.println("3. Back to Main Menu");
            System.out.println("=================================");

            int choice = readInt("Enter your choice: ");

            switch (choice) {

                case 1:
                    String name = readText(
                            "Enter vehicle name: ");

                    management.searchByName(name);
                    showThankYouMessage();
                    break;

                case 2:
                    String brand = readText(
                            "Enter brand name: ");

                    management.searchByBrand(brand);
                    showThankYouMessage();
                    break;

                case 3:
                    clientRunning = false;
                    break;

                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    // Display the search options for the agent.
    public static void searchMenu(RentalManagement management) {

        boolean searching = true;

        while (searching) {

            System.out.println("\n========== SEARCH MENU ==========");
            System.out.println("1. Search by Vehicle Name");
            System.out.println("2. Search by Brand");
            System.out.println("3. Back");
            System.out.println("=================================");

            int choice = readInt("Enter your choice: ");

            switch (choice) {

                case 1:
                    String name = readText(
                            "Enter vehicle name: ");

                    management.searchByName(name);
                    searching = false;
                    break;

                case 2:
                    String brand = readText(
                            "Enter brand name: ");

                    management.searchByBrand(brand);
                    searching = false;
                    break;

                case 3:
                    searching = false;
                    break;

                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    // Add a new vehicle using information entered by the agent.
    public static void addNewVehicle(RentalManagement management) {

        System.out.println("\n--- Add New Vehicle ---");

        String name = readText("Enter vehicle name: ");
        String brand = readText("Enter vehicle brand: ");

        int year;

        do {
            year = readInt("Enter manufacturing year: ");

            if (year <= 0) {
                System.out.println("Please enter a valid year.");
            }

        } while (year <= 0);

        double dailyRate;

        do {
            dailyRate = readDouble("Enter daily rental rate: ");

            if (dailyRate <= 0) {
                System.out.println("Please enter a rate greater than zero.");
            }

        } while (dailyRate <= 0);

        boolean insurance = readBoolean(
                "Is insurance included? (yes/no): ");

        // Create a new vehicle object.
        Vehicle vehicle = new Vehicle(
                name, brand, year, insurance, dailyRate);

        // Add the new vehicle to the system.
        management.addVehicle(vehicle);
    }

    // Display a thank-you message after completing an operation.
    public static void showThankYouMessage() {

        System.out.println("\nThank you for using our service!");
        System.out.println("Is there anything else we can help you with?");
    }

    // Read an integer and handle invalid input.
    public static int readInt(String message) {

        while (true) {

            System.out.print(message);

            try {
                return Integer.parseInt(input.nextLine());

            } catch (NumberFormatException e) {

                System.out.println("Invalid input. Please enter a number.");
            }
        }
    }

    // Read a decimal number and handle invalid input.
    public static double readDouble(String message) {

        while (true) {

            System.out.print(message);

            try {
                return Double.parseDouble(input.nextLine());

            } catch (NumberFormatException e) {

                System.out.println("Invalid input. Please enter a valid number.");
            }
        }
    }

    // Read text and prevent empty input.
    public static String readText(String message) {

        while (true) {

            System.out.print(message);

            String value = input.nextLine().trim();

            if (!value.isEmpty()) {
                return value;
            }

            System.out.println("Input cannot be empty. Please try again.");
        }
    }

    // Read yes or no input.
    public static boolean readBoolean(String message) {

        while (true) {

            System.out.print(message);

            String value = input.nextLine().trim();

            if (value.equalsIgnoreCase("yes")
                    || value.equalsIgnoreCase("y")) {
                return true;
            }

            if (value.equalsIgnoreCase("no")
                    || value.equalsIgnoreCase("n")) {
                return false;
            }

            System.out.println("Please enter yes or no.");
        }
    }
}
