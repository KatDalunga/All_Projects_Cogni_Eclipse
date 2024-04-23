package StatueInfo;

import java.util.Scanner;


//Define the method to extract the details of the Statue from a string

//Define the UserInterface class
public class UserInterface {

public static StatueInfo extractDetails(String statueDetails) {
		  // Split the statueDetails by colon
		  String[] details = statueDetails.split(":");

		  // Parse the statueName, origin, carvingType, and price from the details
		  String statueName =details[0];
		  
		  String origin = details[1];
		  String carvingType = details[2];
		  
		  double price = Double.parseDouble(details[3]);

		  // Create and return a new StatueInfo object with the parsed details
		  return new StatueInfo(statueName, origin, carvingType, price);
		}
	
	
	
// Define the main method
public static void main(String[] args) {
   // Create a scanner object to read the user input
   Scanner scanner = new Scanner(System.in);

   // Prompt the user to enter the statue details
   System.out.println("Enter the Statue details");
   String statueDetails = scanner.nextLine();

   // Extract the statue object from the statue details
   StatueInfo statue = extractDetails(statueDetails);

   // Print the statue details
   System.out.println("Statue Details");
   System.out.println("Statue Name: " + statue.getStatueName());
   System.out.println("Statue Origin: " + statue.getOrigin());
   System.out.println("Statue carving type: " + statue.getCarvingType());
   System.out.println("Statue Price: $" + statue.getPrice());

   // Prompt the user to enter the quantity
   
   System.out.println("Enter the Quantity");
   int quantity = scanner.nextInt();
   // Calculate the total statue price to be paid and print the result
   double totalStatuePrice = statue.calculateTotalStatuePrice(quantity);
   if (totalStatuePrice == -1) {
       System.out.println("Invalid Statue details");
   } else {
       System.out.println("Total Statue Price to be paid: $" + totalStatuePrice);
   }

   // Close the scanner object
   scanner.close();
}
}