package FirstMajesticSilver;

import java.util.*;

public class SilverMain {

    // Attribute to store the silver map
    private Map<String, String> silverMap;

    // Getter and setter methods for the attribute
    public Map<String, String> getSilverMap() {
        return silverMap;
    }

    public void setSilverMap(Map<String, String> silverMap) {
        this.silverMap = silverMap;
    }

    // Constructor to initialize the attribute with an empty map
    public SilverMain() {
        this.silverMap = new HashMap<>();
    }

    // Method to find the count of orderIds based on the given silverType
    public int findCountOfOrderIdsBasedOnTheSilverType(String silverType) {
    	int count = 0;
    for(Map.Entry<String, String> m:silverMap.entrySet()) {
    	 if(m.equals(silverType)) {
      	     count++;
         }
    	 else {
    		 return -1;
    	 }
    }
    return count;
      
    }

    // Method to filter the orderIds based on the silverType and return the list of orderIds
    public List<String> findOrderIdsBasedOnTheSilverType(String silverType) {
        // Check if the silverType is null or empty
        if (silverType == null || silverType.isEmpty()) {
            // Return an empty list
            return Collections.emptyList();
        }
        // Create an empty list to store the filtered orderIds
        List<String> filteredOrderIds = new ArrayList<>();
        // Loop through the entries of the map
        for (Map.Entry<String, String> entry : silverMap.entrySet()) {
            // Get the key and value of the entry
            String orderId = entry.getKey();
            String value = entry.getValue();
            // Compare the value with the silverType, ignoring case
            if (value.equalsIgnoreCase(silverType)) {
                // Add the key to the list
                filteredOrderIds.add(orderId);
            }
        }
        // Return the list
        return filteredOrderIds;
    }

    // Main method to test the class
    public static void main(String[] args) {
        // Create an object of the class
        SilverMain sm = new SilverMain();
        // Create a scanner object to read input
        Scanner sc = new Scanner(System.in);
        // Read the number of records to be added
        System.out.println("Enter number of records to be added");
        int n = sc.nextInt();
        // Consume the newline
        sc.nextLine();
        // Read the records and add them to the map
        System.out.println("Enter the records (Order Id: Silver Type)");
        String[] arr=new String[n]; 
        for (int i=0;i<n;i++) {
        	arr[i]=sc.nextLine();
          String []str=arr[i].split(":");
        
        
        /*for (int i = 0; i < n; i++) {
        	
            // Read a line of input
            String line = sc.nextLine();
            // Split the line by colon
            String[] parts = line.split(":");
            // Get the order id and silver type from the parts
            String orderId = parts[0];
            String silverType = parts[1];
            // Add the order id and silver type to the map*/
            sm.getSilverMap().put(str[0], str[1]);
        }
        // Read the silver type to be searched
        System.out.println("Enter the Silver type to be searched");
        String silverType = sc.nextLine();
        // Find the count of orderIds based on the silver type
        int count = sm.findCountOfOrderIdsBasedOnTheSilverType(silverType);
        // Print the result
        if (count == -1) {
            System.out.println("No Orders were found for the silverType " + silverType);
        } else {
            System.out.println("The count of orders based on " + silverType + " are " + count);
        }
        // Read the silver type to identify the orderIds
        System.out.println("Enter the Silver type to identify the Order Ids");
        silverType = sc.nextLine();
        // Find the orderIds based on the silver type
        List<String> orderIds = sm.findOrderIdsBasedOnTheSilverType(silverType);
        // Print the result
        if (orderIds.isEmpty()) {
            System.out.println("No Orders were found for the silverType " + silverType);
        } else {
            System.out.println("Order Ids based on the " + silverType + " are ");
            for (String orderId : orderIds) {
                System.out.println(orderId);
            }
        }
        // Close the scanner
        sc.close();
    }
}
