package ToyOrder;

import java.util.*;

public class ToyOrderMain {

    // attribute to store the toy name and quantity as key-value pairs
    private Map<String, Integer> toyMap;

    // constructor to initialize the toyMap attribute
    public ToyOrderMain() {
        toyMap = new HashMap<>();
    }

    // getter method for the toyMap attribute
    public Map<String, Integer> getToyMap() {
        return toyMap;
    }

    // setter method for the toyMap attribute
    public void setToyMap(Map<String, Integer> toyMap) {
        this.toyMap = toyMap;
    }

    // method to find the quantity of the given toy name
    public int findQuantity(String toyName) {
        // convert the toy name to lower case for case insensitive comparison
        toyName = toyName.toLowerCase();
        // check if the toy name is present in the toyMap
        if (toyMap.containsKey(toyName)) {
            // return the quantity of the toy
            return toyMap.get(toyName);
        } else {
            // return -1 to indicate that the toy name is invalid
            return -1;
        }
    }

    // method to filter the toys with quantity less than or equal to the given quantity
    public List<String> findToysBasedOnTheGivenQuantity(int quantity) {
        // create a list to store the toy names that match the criteria
        List<String> toyList = new ArrayList<>();
        // iterate over the toyMap entries
        for (Map.Entry<String, Integer> entry : toyMap.entrySet()) {
            // get the toy name and quantity from the entry
            String toyName = entry.getKey();
            int toyQuantity = entry.getValue();
            // check if the toy quantity is less than or equal to the given quantity
            if (toyQuantity <= quantity) {
                // add the toy name to the list
                toyList.add(toyName);
            }
        }
        // return the list of toy names
        return toyList;
    }

    // main method to test the program
    public static void main(String[] args) {
        // create a scanner object to read the user input
        Scanner sc = new Scanner(System.in);
        // create an object of ToyOrderMain class
        ToyOrderMain tom = new ToyOrderMain();
        // get the number of records to be added
        System.out.println("Enter number of records to be added");
        int n = sc.nextInt();
        // consume the newline
        sc.nextLine();
        // get the toy details from the user and store them in the toyMap
        System.out.println("Enter the toy details(toyName: quantity)");
        for (int i = 0; i < n; i++) {
        	
            // get the input as a string
            String input = sc.nextLine();
            // split the input by colon to get the toy name and quantity
            String[] parts = input.split(":");
            // trim any leading or trailing spaces from the toy name
            String toyName = parts[0].trim();
            // convert the toy name to lower case for case insensitive comparison
            //toyName = toyName.toLowerCase();
            // parse the quantity as an integer
            int quantity = Integer.parseInt(parts[1]);
            // put the toy name and quantity in the toyMap
            tom.getToyMap().put(toyName, quantity);
        }
        // get the toy name to be searched
        System.out.println("Enter the toy name to be searched");
        String toyName = sc.nextLine();
        // find the quantity of the toy name
        int quantity = tom.findQuantity(toyName);
        // check if the quantity is valid
        if (quantity != -1) {
            // print the order details
            System.out.println("Order placed for " + quantity + " " + toyName);
        } else {
            // print the error message
            System.out.println(toyName + " is an invalid toy name");
        }
        // get the quantity to filter the toys
        System.out.println("Enter the quantity to filter the toys");
        int filterQuantity = sc.nextInt();
        // find the toys based on the given quantity
        List<String> toyList = tom.findToysBasedOnTheGivenQuantity(filterQuantity);
        // check if the list is empty
        if (toyList.isEmpty()) {
            // print the message that no toys were found
            System.out.println("No toys were found for the given quantity");
        } else {
            // print the message that the toys will be delivered on the same day
            System.out.println("Toys that will be delivered on the same day are");
            // iterate over the list and print the toy names
            for (String toy : toyList) {
                System.out.println(toy);
            }
        }
        // close the scanner object
        sc.close();
    }
}
