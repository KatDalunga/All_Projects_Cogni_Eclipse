package BagParadise;


import java.util.*;

public class UserInterface {

    // Method to extract the details of the bag and create an object of BagInfo class
    public static BagInfo extractDetails(String bagDetails) {
        // Split the bagDetails by colon
        String[] parts = bagDetails.split(":");
        // Get the customer name, bag id, bag brand, bag type and bag price from the parts
        String customerName = parts[0];
        int bagId = Integer.parseInt(parts[1]);
        String bagBrand = parts[2];
        String bagType = parts[3];
        double bagPrice = Double.parseDouble(parts[4]);
        // Create a BagInfo object with the extracted details
        BagInfo bag = new BagInfo(customerName, bagId, bagBrand, bagType, bagPrice);
        // Return the BagInfo object
        return bag;
    }

    // Main method to test the application
    public static void main(String[] args) {
        // Create a scanner object to read input
        Scanner sc = new Scanner(System.in);
        // Read the bag details
        System.out.println("Enter the Bag details");
        String bagDetails = sc.nextLine();
        // Extract the details and create a BagInfo object
        BagInfo bag = extractDetails(bagDetails);
        // Calculate the total price to be paid by the customer
        double totalPrice = bag.calculateTotalPrice();
        // Print the result
        if (totalPrice == -1) {
            System.out.println("Invalid Bag details");
        } else {
            System.out.println("Bag Details");
            System.out.println("Customer Name: " + bag.getCustomerName());
            System.out.println("Bag ID: " + bag.getBagId());
            System.out.println("Bag Brand: " + bag.getBagBrand());
            System.out.println("Bag Type: " + bag.getBagType());
            System.out.println("Bag Price: " + bag.getBagPrice());
            System.out.println("Total Amount to be paid: " + totalPrice);
        }
        // Close the scanner
        sc.close();
    }
}
