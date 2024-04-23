package DepositorInfo;

import java.util.Scanner;

public class UserInterface {
	 // A method to extract the details of the depositor info from a string
	 public static DepositorInfo extractDetails(String depositorDetails) {
	     // Split the string by colon
	     String[] details = depositorDetails.split(":");

	     // Check if the string has four parts
	     if (details.length == 4) {
	         // Parse the account number, deposit type, no of years, and deposit amount
	         String accountNumber = details[0];
	         String depositType = details[1];
	         int noOfYears = Integer.parseInt(details[2]);
	         double depositAmount = Double.parseDouble(details[3]);

	         // Create a depositor info object with the parsed values
	         DepositorInfo depositorInfo = new DepositorInfo(accountNumber, depositType, noOfYears, depositAmount);

	         // Return the depositor info object
	         return depositorInfo;
	     } else {
	         // Return null if the string is invalid
	         return null;
	     }
	 }
	 
	 public static void displayDetails(DepositorInfo depositorInfo) {
	     // Check if the depositor info object is not null
	     if (depositorInfo != null) {
	         // Get the account number, deposit type, no of years, and deposit amount from the depositor info object
	         String accountNumber = depositorInfo.getAccountNumber();
	         String depositType = depositorInfo.getDepositType();
	         int noOfYears = depositorInfo.getNoOfYears();
	         double depositAmount = depositorInfo.getDepositAmount();

	         // Print the depositor details
	         System.out.println("Depositor Details");
	         System.out.println("Account Number: " + accountNumber);
	         System.out.println("Deposit Type: " + depositType);
	         System.out.println("Number of Years: " + noOfYears);
	         System.out.println("Deposit Amount: " + depositAmount);

	         // Calculate the total amount of returns using the depositor info object
	         double totalAmountOfReturns = depositorInfo.calculateTotalAmountOfReturns();

	         // Check if the total amount of returns is valid
	         if (totalAmountOfReturns != -1) {
	             // Print the total amount of returns
	             System.out.println("Total Amount of Returns: " + totalAmountOfReturns);
	         } else {
	             // Print an error message if the total amount of returns is invalid
	             System.out.println("Invalid Depositor Details");
	         }
	     } else {
	         // Print an error message if the depositor info object is null
	         System.out.println("Invalid Depositor Details");
	     }
	 }

	 // A main method to test the program
	 public static void main(String[] args) {
	     // Create a scanner object to read user input
	     Scanner scanner = new Scanner(System.in);

	     // Prompt the user to enter the depositor details
	     System.out.println("Enter the Depositor Details");
	     String depositorDetails = scanner.nextLine();

	     // Extract the depositor info object from the user input
	     DepositorInfo depositorInfo = extractDetails(depositorDetails);

	     // Display the depositor details and the total amount of returns
	     displayDetails(depositorInfo);

	     // Close the scanner object
	     scanner.close();
	 }
}
