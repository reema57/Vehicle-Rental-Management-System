
// This class represents one vehicle in the rental system.
public class Vehicle {

    // Vehicle attributes.
    private String name;
    private String brand;
    private boolean available;
    private int year;
    private boolean insuranceIncluded;
    private double dailyRate;

    // Constructor initializes vehicle information.
    public Vehicle(String name, String brand, int year,
                   boolean insuranceIncluded, double dailyRate) {

        this.name = name;
        this.brand = brand;
        this.year = year;
        this.insuranceIncluded = insuranceIncluded;
        this.dailyRate = dailyRate;
        this.available = true;
    }

    // Get the vehicle name.
    public String getName() {
        return name;
    }

    // Set the vehicle name.
    public void setName(String name) {
        this.name = name;
    }

    // Get the vehicle brand.
    public String getBrand() {
        return brand;
    }

    // Set the vehicle brand.
    public void setBrand(String brand) {
        this.brand = brand;
    }

    // Check vehicle availability.
    public boolean isAvailable() {
        return available;
    }

    // Update vehicle availability.
    public void setAvailable(boolean available) {
        this.available = available;
    }

    // Get manufacturing year.
    public int getYear() {
        return year;
    }

    // Set manufacturing year.
    public void setYear(int year) {
        this.year = year;
    }

    // Check whether insurance is included.
    public boolean isInsuranceIncluded() {
        return insuranceIncluded;
    }

    // Set insurance information.
    public void setInsuranceIncluded(boolean insuranceIncluded) {
        this.insuranceIncluded = insuranceIncluded;
    }

    // Get daily rental rate.
    public double getDailyRate() {
        return dailyRate;
    }

    // Set daily rental rate.
    public void setDailyRate(double dailyRate) {
        this.dailyRate = dailyRate;
    }

    // Display all vehicle information.
    public void displayInfo() {

        System.out.println("------------------------------------");
        System.out.println("Vehicle Name: " + name);
        System.out.println("Brand: " + brand);
        System.out.println("Manufacturing Year: " + year);
        System.out.println("Insurance Included: "
                + (insuranceIncluded ? "Yes" : "No"));
        System.out.println("Daily Rate: " + dailyRate + " SAR");
        System.out.println("Availability: "
                + (available ? "Available" : "Not Available"));
        System.out.println("------------------------------------");
    }
}


