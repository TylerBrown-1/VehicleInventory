package com.pluralsight;
import java.util.Scanner;

public class Main {
    private static Vehicle[] inventory = new Vehicle[20];
    private static int vehicleCount = 6; // Initial count of vehicles
    public static void main(String[] args) {
        // Preload the array with 6 vehicles
        preloadVehicles();

        Scanner scanner = new Scanner(System.in);

        // Main loop for user commands
        while (true) {
            System.out.println("What do you want to do?");
            System.out.println("1 - List all vehicles");
            System.out.println("2 - Search by make/model");
            System.out.println("3 - Search by price range");
            System.out.println("4 - Search by color");
            System.out.println("5 - Add a vehicle");
            System.out.println("6 - Quit");
            System.out.print("Enter your command: ");
            int command = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (command) {
                case 1:
                    listAllVehicles();
                    break;
                case 2:
                    findVehiclesByMakeModel(scanner);
                    break;
                case 3:
                    findVehiclesByPrice(scanner);
                    break;
                case 4:
                    findVehiclesByColor(scanner);
                    break;
                case 5:
                    addAVehicle(scanner);
                    break;
                case 6:
                    System.out.println("Exiting...");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid command. Please try again.");
            }
        }
    }

    // Preloads vehicles into the inventory
    private static void preloadVehicles() {
        inventory[0] = new Vehicle(101121, "Ford Explorer", "Red", 45000, 13500);
        inventory[1] = new Vehicle(101122, "Toyota Camry", "Blue", 60000, 11000);
        inventory[2] = new Vehicle(101123, "Chevrolet Malibu", "Black", 50000, 9700);
        inventory[3] = new Vehicle(101124, "Honda Civic", "White", 70000, 7500);
        inventory[4] = new Vehicle(101125, "Subaru Outback", "Green", 55000, 14500);
        inventory[5] = new Vehicle(101126, "Jeep Wrangler", "Yellow", 30000, 16000);
    }

    // Lists all vehicles in the inventory
    private static void listAllVehicles() {
        if (vehicleCount == 0) {
            System.out.println("No vehicles in inventory.");
            return;
        }
        for (int i = 0; i < vehicleCount; i++) {
            System.out.println(inventory[i]);
        }
    }

    // Searches for vehicles by make/model
    private static void findVehiclesByMakeModel(Scanner scanner) {
        System.out.print("Enter make/model to search: ");
        String searchModel = scanner.nextLine();
        boolean found = false;

        for (int i = 0; i < vehicleCount; i++) {
            if (inventory[i].getMakeModel().equalsIgnoreCase(searchModel)) {
                System.out.println(inventory[i]);
                found = true;
            }
        }
        if (!found) {
            System.out.println("No vehicles found for make/model: " + searchModel);
        }
    }

    // Searches for vehicles by price range
    private static void findVehiclesByPrice(Scanner scanner) {
        System.out.print("Enter minimum price: ");
        float minPrice = scanner.nextFloat();
        System.out.print("Enter maximum price: ");
        float maxPrice = scanner.nextFloat();
        boolean found = false;

        for (int i = 0; i < vehicleCount; i++) {
            if (inventory[i].getPrice() >= minPrice && inventory[i].getPrice() <= maxPrice) {
                System.out.println(inventory[i]);
                found = true;
            }
        }
        if (!found) {
            System.out.println("No vehicles found in the price range $" + minPrice + " - $" + maxPrice);
        }
    }

    // Searches for vehicles by color
    private static void findVehiclesByColor(Scanner scanner) {
        System.out.print("Enter color to search: ");
        String searchColor = scanner.nextLine();
        boolean found = false;

        for (int i = 0; i < vehicleCount; i++) {
            if (inventory[i].getColor().equalsIgnoreCase(searchColor)) {
                System.out.println(inventory[i]);
                found = true;
            }
        }
        if (!found) {
            System.out.println("No vehicles found of color: " + searchColor);
        }
    }

    // Adds a new vehicle to the inventory
    private static void addAVehicle(Scanner scanner) {
        if (vehicleCount >= inventory.length) {
            System.out.println("Inventory is full. Cannot add more vehicles.");
            return;
        }
        System.out.print("Enter vehicle ID: ");
        long vehicleId = scanner.nextLong();
        scanner.nextLine(); // Consume newline
        System.out.print("Enter make/model: ");
        String makeModel = scanner.nextLine();
        System.out.print("Enter color: ");
        String color = scanner.nextLine();
        System.out.print("Enter odometer reading: ");
        int odometerReading = scanner.nextInt();
        System.out.print("Enter price: ");
        float price = scanner.nextFloat();

        inventory[vehicleCount] = new Vehicle(vehicleId, makeModel, color, odometerReading, price);
        vehicleCount++;
        System.out.println("Vehicle added successfully.");
    }
}