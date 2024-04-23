package FoodieZone;

import java.util.*;

public class FoodOrderMain {
    // attribute to store the order records
    private Map<String, Float> orderMap;

    // getter and setter methods for the attribute
    public Map<String, Float> getOrderMap() {
        return orderMap;
    }

    public void setOrderMap(Map<String, Float> orderMap) {
        this.orderMap = orderMap;
    }

    // method to find the rating of a given order id
    public float findRatingOfGivenOrderId(String orderId) {
        // check if the order id is present in the map
        if (orderMap.containsKey(orderId)) {
            // return the rating of the order id
            return orderMap.get(orderId);
        } 
        return -1;
    }

    // method to find the order ids with low rating
    public List<String> findOrderIdsWithLowRating() {
        // create a list to store the order ids with low rating
        List<String> lowRatingOrders = new ArrayList<>();
        // loop through the entries of the map
        for (Map.Entry<String, Float> entry : orderMap.entrySet()) {
            // get the order id and rating from the entry
            String orderId = entry.getKey();
            float rating = entry.getValue();
            // check if the rating is less than or equal to 3
            if (rating <= 3) {
                // add the order id to the list
                lowRatingOrders.add(orderId);
            }
        }
        // return the list of order ids with low rating
        return lowRatingOrders;
    }

    // main method
    public static void main(String[] args) {
        // create an object of FoodOrderMain class
        FoodOrderMain foodOrderMain = new FoodOrderMain();
        // create a scanner object for user input
        Scanner scanner = new Scanner(System.in);
        // prompt the user to enter the number of records to be added
        System.out.println("Enter number of records to be added");
        // read the number of records from the user
        int n = scanner.nextInt();
        scanner.nextLine();
        // create a map to store the order records
        Map<String, Float> orderMap = new HashMap<>();
        // prompt the user to enter the order records
        System.out.println("Enter the order records (Order id : rating)");
        // loop n times to read the order records from the user
        String[] arr=new String[n]; 
        for (int i=0;i<n;i++) {
        	arr[i]=scanner.nextLine();
          String []str=arr[i].split(":");
            
            orderMap.put(str[0], Float.parseFloat(str[1]));
        }
        // set the order map attribute of the foodOrderMain object
        foodOrderMain.setOrderMap(orderMap);
        // prompt the user to enter the order id to be searched
        System.out.println("Enter the order id to be searched");
        // read the order id from the user
        String orderId = scanner.next();
        // call the findRatingOfGivenOrderId method and store the result
        float rating = foodOrderMain.findRatingOfGivenOrderId(orderId);
        // check if the rating is -1
        if (rating != -1) {
        	// print the customer satisfaction rating of the order id
        	System.out.println("Customer satisfaction rating of order id " + orderId + " is " + rating);
            
        } else {
        	// print that the order id is invalid
            
        	System.out.println(orderId + " is an invalid order id");
            
        }
        // call the findOrderIdsWithLowRating method and store the result
        List<String> lowRatingOrders = foodOrderMain.findOrderIdsWithLowRating();
        // check if the list is empty
        if (lowRatingOrders.isEmpty()) {
            // print that no order has a low rating
            System.out.println("No order has a low rating");
        } else {
            // print the order ids of the orders with low rating
            System.out.println("Order ids of the orders with low rating");
            for (String order : lowRatingOrders) {
                System.out.println(order);
            }
        }
        // close the scanner object
        scanner.close();
    }
}
