package IceCreamInfo;

//Import the necessary classes
import java.util.Map;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;

//Define the IceCreamInfo class
public class IceCreamInfo {
 // Declare the attribute
 private Map<String, Integer> iceCreamMap;

 // Define the getter and setter for the attribute
 public Map<String, Integer> getIceCreamMap() {
     return iceCreamMap;
 }

 public void setIceCreamMap(Map<String, Integer> iceCreamMap) {
     this.iceCreamMap = iceCreamMap;
 }

 // Define the method to find the ice cream for the given price range
 public List<String> filterIceCreamDetailsForGivenPriceRange(int start, int end) {
     // Create a list to store the ice cream names
     List<String> iceCreamNames = new ArrayList<>();

     // Loop through the ice cream map
     for (Map.Entry<String, Integer> entry : iceCreamMap.entrySet()) {
         // Get the ice cream name and price
         String name = entry.getKey();
         int price = entry.getValue();

         // Check if the price is within the range (exclusive)
         if (price > start && price < end) {
             // Add the name to the list
             iceCreamNames.add(name);
         }
     }

     // Return the list
     return iceCreamNames;
 }

//Define the method to find the cheapest ice cream in the ice cream map
public Map<String, Integer> findTheCheapestIceCream() {
  // Create a map to store the cheapest ice cream
  Map<String, Integer> cheapestIceCream = new HashMap<>();

  // Declare variables to store the minimum price and name
  int minPrice = 0;
  String minName = "";

  // Check if the ice cream map is not empty
  if (!iceCreamMap.isEmpty()) {
      // Get the first entry in the ice cream map
      Map.Entry<String, Integer> firstEntry = iceCreamMap.entrySet().iterator().next();

      // Set the minimum price and name to the first entry
      minPrice = firstEntry.getValue();
      minName = firstEntry.getKey();

      // Loop through the rest of the ice cream map
      for (Map.Entry<String, Integer> entry : iceCreamMap.entrySet()) {
          // Get the ice cream name and price
          String name = entry.getKey();
          int price = entry.getValue();

          // Check if the price is less than the minimum price
          if (price < minPrice) {
              // Update the minimum price and name
              minPrice = price;
              minName = name;
          }
      }

      // Put the minimum name and price to the map
      cheapestIceCream.put(minName, minPrice);
  }

  // Return the map
  return cheapestIceCream;
}

}

