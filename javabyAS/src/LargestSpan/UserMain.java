package LargestSpan;

import java.util.HashMap;

class UserMainCode {
    // A static method to find the largest span in the array
    public static int getLargestSpan(int[] array) {
        // Create a hashmap object to store the first occurrence of each element
        HashMap<Integer, Integer> map = new HashMap<>();
        // Initialize a variable to store the largest span
        int span = 0;
        // Loop through the array
        for (int i = 0; i < array.length; i++) {
            // Get the current element
            int element = array[i];
            // If the element is already in the hashmap, update the span
            if (map.containsKey(element)) {
                // Get the index of the first occurrence of the element
                int index = map.get(element);
                // Calculate the span between the current and the first occurrence
                int currentSpan = i - index + 1;
                // Update the largest span if needed
                span = Math.max(span, currentSpan);
            } else {
                // If the element is not in the hashmap, put it with the current index
                map.put(element, i);
            }
        }
        // Return the largest span
        return span;
    }
}


