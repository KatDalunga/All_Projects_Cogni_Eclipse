package ResultantHashMap;

import java.util.HashMap;
import java.util.Scanner;

public class ResultantHashMap {

    public static void main(String[] args) {
        // Create a scanner object to read the input
        Scanner sc = new Scanner(System.in);
        // Read the size of the hashmap
        int size = sc.nextInt();
        // Create a hashmap object
        HashMap<Integer, String> map = new HashMap<>();
        // Loop through the size and read the key-value pairs
        for (int i = 0; i < size; i++) {
            int key = sc.nextInt();
            String value = sc.next();
            // Put the key-value pair in the hashmap
            map.put(key, value);
        }
        // Call the sizeOfResultandHashMap method from UserMainCode class
        int result = UserMainCode.sizeOfResultandHashMap(map);
        // Print the output
        System.out.println(result);
        // Close the scanner
        sc.close();
    }
}

