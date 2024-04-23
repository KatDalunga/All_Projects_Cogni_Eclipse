package ExoticMeseum;

import java.util.*;

public class UserInterface {

    // Method to extract the details of the child and create an object of the Child class
    public static Child extractDetails(String childDetails) {
        // Split the childDetails by colon
        String[] parts = childDetails.split(":");
        // Get the name, gender, age and ticket charge from the parts
        String name = parts[0];
        char gender = parts[1].charAt(0);
        int age = Integer.parseInt(parts[2]);
        double ticketCharge = Double.parseDouble(parts[3]);
        // Create a Child object with the extracted details
        Child child = new Child(name, gender, age, ticketCharge);
        // Return the Child object
        return child;
    }

    // Main method to test the application
    public static void main(String[] args) {
        // Create a scanner object to read input
        Scanner sc = new Scanner(System.in);
        // Read the child details
        System.out.println("Enter the child details");
        String childDetails = sc.nextLine();
        // Extract the details and create a Child object
        Child child = extractDetails(childDetails);
        // Calculate the ticket charge for the child
        double ticketCharge = child.calculateTicketCharge();
        // Print the result
        if (ticketCharge == 0) {
            System.out.println("Invalid child details");
        } else {
            System.out.println("Child Details");
            System.out.println("Name : " + child.getName());
            System.out.println("Gender : " + child.getGender());
            System.out.println("Age : " + child.getAge());
            System.out.println("Ticket Charge : " + ticketCharge);
        }
        // Close the scanner
        sc.close();
    }
}

