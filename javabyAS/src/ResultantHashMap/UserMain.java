package ResultantHashMap;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

class UserMainCode {
    // A static method to remove the entries having keys multiple of 4 and return the size of the final hashmap
    public static int sizeOfResultandHashMap(HashMap<Integer, String> map) {
        // Create an iterator object to traverse the hashmap
        Iterator<Map.Entry<Integer, String>> it = map.entrySet().iterator();
        // Loop through the iterator
        while (it.hasNext()) {
            // Get the current entry
            Map.Entry<Integer, String> entry = it.next();
            // Get the key of the entry
            int key = entry.getKey();
            // If the key is divisible by 4, remove the entry
            if (key % 4 == 0) {
                it.remove();
            }
        }
        // Return the size of the final hashmap
        return map.size();
    }
}

