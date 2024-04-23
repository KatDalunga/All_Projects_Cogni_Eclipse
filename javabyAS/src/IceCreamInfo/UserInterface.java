package IceCreamInfo;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

//Define the UserInterface class
public class UserInterface {
// Define the main method
public static void main(String[] args) {
   // Create a scanner object to read the user input
   Scanner scanner = new Scanner(System.in);

   // Prompt the user to enter the number of ice cream details to be added
   System.out.println("Enter the number of IceCream details to be added");
   int n = scanner.nextInt();

   // Create a map to store the ice cream details
   Map<String, Integer> iceCreamMap = new HashMap<>();

   // Loop n times
   System.out.println("Enter the IceCream details(IceCreamName:Price)");
   for (int i = 0; i < n; i++) {
       // Prompt the user to enter the ice cream details
       
       String iceCreamDetails = scanner.next();

       // Split the ice cream details by colon
       String[] details = iceCreamDetails.split(":");

       // Parse the ice cream name and price
       String name = details[0];
       int price = Integer.parseInt(details[1]);

       // Put the name and price to the map
       iceCreamMap.put(name, price);
   }

   // Create an IceCreamInfo object and set the ice cream map
   IceCreamInfo iceCreamInfo = new IceCreamInfo();
   iceCreamInfo.setIceCreamMap(iceCreamMap);

   // Prompt the user to enter a range to filter the ice cream details
   System.out.println("Enter a range to filter the IceCream details.");
   int start = scanner.nextInt();
   int end = scanner.nextInt();

   // Call the method to filter the ice cream details for the given price range
   List<String> iceCreamNames = iceCreamInfo.filterIceCreamDetailsForGivenPriceRange(start, end);

   // Check if the list is empty
   if (iceCreamNames.isEmpty()) {
       // Print a message
       System.out.println("No IceCream available within the price range $." + start + " and $." + end);
   } else {
       // Print the ice cream names
       System.out.println("IceCream available within the price range $." + start + " and $." + end + " are");
       for (String name : iceCreamNames) {
           System.out.println(name);
       }
   }

   // Call the method to find the cheapest ice cream
   Map<String, Integer> cheapestIceCream = iceCreamInfo.findTheCheapestIceCream();

   // Print the cheapest ice cream
   System.out.println("The IceCream with the lowest price is");
   for (Map.Entry<String, Integer> entry : cheapestIceCream.entrySet()) {
       System.out.println(entry.getKey() + " - $." + entry.getValue());
   }

   // Close the scanner object
   scanner.close();
}
}

