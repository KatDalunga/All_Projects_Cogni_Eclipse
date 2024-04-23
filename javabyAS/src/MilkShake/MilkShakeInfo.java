package MilkShake;

import java.util.*;

public class MilkShakeInfo {

    // attribute to store the milkshake name and price as key-value pairs
    private Map<String, Double> shakeOrderMap;

    // constructor to initialize the shakeOrderMap attribute
    public MilkShakeInfo() {
        shakeOrderMap = new HashMap<>();
    }

    // getter method for the shakeOrderMap attribute
    public Map<String, Double> getShakeOrderMap() {
        return shakeOrderMap;
    }

    // setter method for the shakeOrderMap attribute
    public void setShakeOrderMap(Map<String, Double> shakeOrderMap) {
        this.shakeOrderMap = shakeOrderMap;
    }

    // method to find the total cost of the milkshake order
    public double findTotalCostOfMilkShakeOrder() {
        // initialize the total cost to zero
        double totalCost = 0;
        // iterate over the shakeOrderMap values
        for (double price : shakeOrderMap.values()) {
            // add the price to the total cost
            totalCost += price;
        }
        // return the total cost
        return totalCost;
    }

    // method to filter the milkshake names from the shakeOrderMap for the given price range
    public List<String> filterMilkShakeOrderForGivenPriceRange(double start, double end) {
        // create a list to store the milkshake names that match the criteria
        List<String> shakeList = new ArrayList<>();
        // iterate over the shakeOrderMap entries
        for (Map.Entry<String, Double> entry : shakeOrderMap.entrySet()) {
            // get the milkshake name and price from the entry
            String shakeName = entry.getKey();
            double price = entry.getValue();
            // check if the price is within the start and end range (inclusive)
            if (price >= start && price <= end) {
                // add the milkshake name to the list
                shakeList.add(shakeName);
            }
        }
        // return the list of milkshake names
        return shakeList;
    }

    // main method to test the program
    public static void main(String[] args) {
        // create a scanner object to read the user input
        Scanner sc = new Scanner(System.in);
        // create an object of MilkShakeInfo class
        MilkShakeInfo msi = new MilkShakeInfo();
        // get the number of milkshake orders to be added
        System.out.println("Enter the number of milkshake order to be added");
        int n = sc.nextInt();
        // consume the newline
        sc.nextLine();
        // get the milkshake details from the user and store them in the shakeOrderMap
        System.out.println("Enter the milkshake details (milkshake:price)");
        for (int i = 0; i < n; i++) {
            // get the input as a string
            String input = sc.nextLine();
            // split the input by colon to get the milkshake name and price
            String[] parts = input.split(":");
            // trim any leading or trailing spaces from the milkshake name
            String shakeName = parts[0].trim();
            // convert the milkshake name to lower case for case insensitive comparison
            shakeName = shakeName.toLowerCase();
            // parse the price as a double
            double price = Double.parseDouble(parts[1]);
            // put the milkshake name and price in the shakeOrderMap
            msi.getShakeOrderMap().put(shakeName, price);
        }
        // find the total cost of the milkshake order
        double totalCost = msi.findTotalCostOfMilkShakeOrder();
        // print the total cost
        System.out.println("The total cost of the milkshake purchase is $" + totalCost);
        // get the range to filter the milkshake order details
        System.out.println("Enter the range to filter the milkshake order details");
        double start = sc.nextDouble();
        double end = sc.nextDouble();
        // find the milkshake names that match the price range
        List<String> shakeList = msi.filterMilkShakeOrderForGivenPriceRange(start, end);
        // check if the list is empty
        if (shakeList.isEmpty()) {
            // print the message that there are no milkshakes in the price range
            System.out.println("There are no milkshakes in the price range of $" + start + " and $" + end);
        } else {
            // print the message that the milkshakes in the price range are
            System.out.println("Milkshakes in the price range of $" + start + " and $" + end + " are");
            // iterate over the list and print the milkshake names
            for (String shake : shakeList) {
                System.out.println(shake);
            }
        }
        // close the scanner object
        sc.close();
    }
}

