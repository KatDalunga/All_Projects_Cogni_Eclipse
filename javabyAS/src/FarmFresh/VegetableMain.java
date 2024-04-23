package FarmFresh;

import java.util.*;

public class VegetableMain {

    // Attribute to store the vegetable map
    private Map<String, String> vegetableMap;

    // Getter and setter methods for the attribute
    public Map<String, String> getVegetableMap() {
        return vegetableMap;
    }

    public void setVegetableMap(Map<String, String> vegetableMap) {
        this.vegetableMap = vegetableMap;
    }

    // Constructor to initialize the vegetable map
    public VegetableMain() {
        vegetableMap = new HashMap<>();
    }

    // Method to find the count of vegetables based on the given vegetable type
    public int findTheCountOfVegetablesBasedOnTheVegetableType(String vegetableType) {
    	int count =0;

    			for(String type:vegetableMap.values()) {

    				if(type.equalsIgnoreCase(vegetableType)) {

    					count++;

    				}

    			}
    			if(count==0) {
    				return -1;
    			}

    			return count;
    }

    // Method to find the list of vegetables based on the given vegetable type
    public List<String> findVegetablesBasedOnTheVegetableType(String vegetableType) {
//    	[11:37 AM] Mangaraj, Manamohan (Contractor)
    	List<String> list = new ArrayList<>();

    			for(Map.Entry<String,String> m:vegetableMap.entrySet()) {

    				if(m.getValue().equalsIgnoreCase(vegetableType)) {

    					list.add(m.getKey());

    				}

    			}

    			return list;
    }

    // Main method to test the program
    public static void main(String[] args) {
        // Create an object of VegetableMain class
        VegetableMain vm = new VegetableMain();
        // Create a scanner object to read the user input
        Scanner sc = new Scanner(System.in);
        // Prompt the user to enter the number of records to be added
        System.out.println("Enter number of records to be added");
        // Read the number of records
        int n = sc.nextInt();
        // Consume the newline
        sc.nextLine();
        // Prompt the user to enter the records in the format of vegetable name: vegetable type
        System.out.println("Enter the records (Vegetable Name: Vegetable Type)");
        // Loop for n times
        for (int i = 0; i < n; i++) {
            // Read the record
            String record = sc.nextLine();
            // Split the record by colon
            String[] parts = record.split(":");
            // Trim the leading and trailing spaces
            String name = parts[0].trim();
            String type = parts[1].trim();
            // Put the name and type in the vegetable map
            vm.getVegetableMap().put(name, type);
        }
        // Prompt the user to enter the vegetable type to be searched
        System.out.println("Enter the Vegetable type to be searched");
        // Read the vegetable type
        String type = sc.nextLine();
        // Call the method to find the count of vegetables based on the type
        int count = vm.findTheCountOfVegetablesBasedOnTheVegetableType(type);
        // If the count is -1, print no vegetables were found
        if (count == -1) {
            System.out.println("No Vegetables were found for " + type);
        }
        // Otherwise, print the count
        else {
            System.out.println("The count of vegetables based on the type " + type + " are " + count);
        }
        // Prompt the user to enter the vegetable type to get the list of vegetables
        System.out.println("Enter the vegetable type to get the list of vegetables");
        // Read the vegetable type
        type = sc.nextLine();
        // Call the method to find the list of vegetables based on the type
        List<String> vegetables = vm.findVegetablesBasedOnTheVegetableType(type);
        // If the list is empty, print no vegetables were found
        if (vegetables.isEmpty()) {
            System.out.println("No vegetables were found for the " + type);
        }
        // Otherwise, print the list
        else {
            System.out.println("Vegetables based on the " + type + " are");
            for (String vegetable : vegetables) {
                System.out.println(vegetable);
            }
        }
        // Close the scanner
        sc.close();
    }
}

