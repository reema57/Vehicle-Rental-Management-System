
import java.util.ArrayList;

// This class manages all vehicles in the rental system.
public class RentalManagement {

    // ArrayList stores all vehicles.
    private ArrayList<Vehicle> vehicles;

    // Constructor initializes an empty vehicle list.
    public RentalManagement() {
        vehicles = new ArrayList<>();
    }

    // Add 36 sample vehicles from three different brands.
    public void addSampleVehicles() {

        // Toyota vehicles (12 cars)
        vehicles.add(new Vehicle("Camry", "Toyota", 2023, true, 180.0));
        vehicles.add(new Vehicle("Corolla", "Toyota", 2022, true, 130.0));
        vehicles.add(new Vehicle("Yaris", "Toyota", 2024, false, 100.0));
        vehicles.add(new Vehicle("Avalon", "Toyota", 2022, true, 220.0));
        vehicles.add(new Vehicle("Prius", "Toyota", 2023, true, 150.0));
        vehicles.add(new Vehicle("RAV4", "Toyota", 2024, true, 200.0));
        vehicles.add(new Vehicle("Highlander", "Toyota", 2023, false, 280.0));
        vehicles.add(new Vehicle("Land Cruiser", "Toyota", 2024, true, 450.0));
        vehicles.add(new Vehicle("Prado", "Toyota", 2022, true, 300.0));
        vehicles.add(new Vehicle("Fortuner", "Toyota", 2023, false, 250.0));
        vehicles.add(new Vehicle("Hilux", "Toyota", 2024, true, 230.0));
        vehicles.add(new Vehicle("Supra", "Toyota", 2023, true, 400.0));

        // Ford vehicles (12 cars)
        vehicles.add(new Vehicle("Taurus", "Ford", 2022, true, 160.0));
        vehicles.add(new Vehicle("Mustang", "Ford", 2024, true, 350.0));
        vehicles.add(new Vehicle("Explorer", "Ford", 2023, true, 280.0));
        vehicles.add(new Vehicle("Edge", "Ford", 2022, false, 210.0));
        vehicles.add(new Vehicle("Escape", "Ford", 2024, true, 190.0));
        vehicles.add(new Vehicle("Expedition", "Ford", 2023, true, 380.0));
        vehicles.add(new Vehicle("Bronco", "Ford", 2024, false, 320.0));
        vehicles.add(new Vehicle("Ranger", "Ford", 2022, true, 220.0));
        vehicles.add(new Vehicle("F-150", "Ford", 2023, true, 300.0));
        vehicles.add(new Vehicle("Fusion", "Ford", 2021, false, 140.0));
        vehicles.add(new Vehicle("Focus", "Ford", 2022, true, 120.0));
        vehicles.add(new Vehicle("EcoSport", "Ford", 2021, true, 130.0));

        // Honda vehicles (12 cars)
        vehicles.add(new Vehicle("Accord", "Honda", 2024, true, 200.0));
        vehicles.add(new Vehicle("Civic", "Honda", 2023, true, 160.0));
        vehicles.add(new Vehicle("City", "Honda", 2022, false, 120.0));
        vehicles.add(new Vehicle("Jazz", "Honda", 2021, true, 110.0));
        vehicles.add(new Vehicle("CR-V", "Honda", 2024, true, 230.0));
        vehicles.add(new Vehicle("HR-V", "Honda", 2023, true, 180.0));
        vehicles.add(new Vehicle("Pilot", "Honda", 2022, false, 290.0));
        vehicles.add(new Vehicle("Odyssey", "Honda", 2023, true, 270.0));
        vehicles.add(new Vehicle("Passport", "Honda", 2024, true, 260.0));
        vehicles.add(new Vehicle("Ridgeline", "Honda", 2022, false, 250.0));
        vehicles.add(new Vehicle("Insight", "Honda", 2021, true, 150.0));
        vehicles.add(new Vehicle("WR-V", "Honda", 2023, true, 140.0));
    }

    // Add a new vehicle to the system.
    public void addVehicle(Vehicle vehicle) {

        if (vehicle == null) {
            System.out.println("Invalid vehicle information.");
            return;
        }

        vehicles.add(vehicle);
        System.out.println("Vehicle added successfully!");
    }

    // Display all vehicles that are available for rent.
    public void displayAvailableVehicles() {

        boolean found = false;

        System.out.println("\n--- Available Vehicles ---");

        for (Vehicle vehicle : vehicles) {

            if (vehicle.isAvailable()) {
                vehicle.displayInfo();
                found = true;
            }
        }

        if (!found) {
            System.out.println("No available vehicles found.");
        }
    }

    // Search for vehicles by name.
    public void searchByName(String name) {

        boolean found = false;

        for (Vehicle vehicle : vehicles) {

            if (vehicle.getName().equalsIgnoreCase(name)) {

                System.out.println("\nVehicle found:");
                vehicle.displayInfo();
                found = true;
            }
        }

        if (!found) {
            System.out.println("Vehicle not found.");
        }
    }

    // Search for vehicles by brand.
    public void searchByBrand(String brand) {

        boolean found = false;

        for (Vehicle vehicle : vehicles) {

            if (vehicle.getBrand().equalsIgnoreCase(brand)) {

                System.out.println("\nVehicle found:");
                vehicle.displayInfo();
                found = true;
            }
        }

        if (!found) {
            System.out.println("No vehicles found for this brand.");
        }
    }

    // Rent a vehicle using its name.
    public void rentVehicle(String name) {

        for (Vehicle vehicle : vehicles) {

            if (vehicle.getName().equalsIgnoreCase(name)) {

                if (vehicle.isAvailable()) {

                    vehicle.setAvailable(false);

                    System.out.println(
                            "Vehicle rented successfully!");

                } else {

                    System.out.println(
                            "This vehicle is not available.");
                }

                return;
            }
        }

        System.out.println("Vehicle not found.");
    }

    // Return a rented vehicle using its name.
    public void returnVehicle(String name) {

        for (Vehicle vehicle : vehicles) {

            if (vehicle.getName().equalsIgnoreCase(name)) {

                if (!vehicle.isAvailable()) {

                    vehicle.setAvailable(true);

                    System.out.println(
                            "Vehicle returned successfully!");

                } else {

                    System.out.println(
                            "This vehicle is already available.");
                }

                return;
            }
        }

        System.out.println("Vehicle not found.");
    }
}

