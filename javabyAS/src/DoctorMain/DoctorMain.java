package DoctorMain;

import java.util.*;

public class DoctorMain {

    // Attribute to store the doctor details as a map
    private Map<String, String> doctorDetailsMap;

    // Getter and setter methods for the attribute
    public Map<String, String> getDoctorDetailsMap() {
        return doctorDetailsMap;
    }

    public void setDoctorDetailsMap(Map<String, String> doctorDetailsMap) {
        this.doctorDetailsMap = doctorDetailsMap;
    }

    // Constructor to initialize the attribute with an empty map
    public DoctorMain() {
        this.doctorDetailsMap = new HashMap<>();
    }

    // Method to find the specialization based on the given doctorId
    public String findSpecialization(String doctorId) {
        // Check if the map contains the given doctorId as a key
        if (doctorDetailsMap.containsKey(doctorId)) {
            // Return the value associated with the key
            return doctorDetailsMap.get(doctorId);
        } else {
            // Return a string indicating invalid doctor id
            return "Invalid doctor id";
        }
    }

    // Method to filter the doctors based on the given specialization
    public List<String> findDoctorsBasedOnTheGivenSpecialization(String specialization) {
        // Create an empty list to store the filtered doctor ids
        List<String> filteredDoctors = new ArrayList<>();
        // Loop through the entries of the map
        for (Map.Entry<String, String> entry : doctorDetailsMap.entrySet()) {
            // Get the key and value of the entry
            String doctorId = entry.getKey();
            String doctorSpecialization = entry.getValue();
            // Compare the value with the given specialization, ignoring case
            if (doctorSpecialization.equalsIgnoreCase(specialization)) {
                // Add the key to the list
                filteredDoctors.add(doctorId);
            }
        }
        // Return the list
        return filteredDoctors;
    }

    // Main method to test the class
    public static void main(String[] args) {
        // Create an object of the class
        DoctorMain dm = new DoctorMain();
        // Create a scanner object to read input
        Scanner sc = new Scanner(System.in);
        // Read the number of records to be added
        System.out.println("Enter number of records to be added: ");
        int n = sc.nextInt();
        // Consume the newline
        sc.nextLine();
        // Read the details of the doctors and add them to the map
        System.out.println("Enter the details (doctorId : specialization): ");
        for (int i = 0; i < n; i++) {
            // Read a line of input
            String line = sc.nextLine();
            // Split the line by colon
            String[] parts = line.split(":");
            // Get the doctor id and specialization from the parts
            String doctorId = parts[0];
            String specialization = parts[1];
            // Add the doctor id and specialization to the map
            dm.getDoctorDetailsMap().put(doctorId, specialization);
        }
        // Read the doctor id to be searched
        System.out.println("Enter the doctor id to be searched ");
        String doctorId = sc.nextLine();
        // Find the specialization based on the doctor id
        String specialization = dm.findSpecialization(doctorId);
        // Print the result
        if (specialization.equals("Invalid doctor id")) {
            System.out.println(specialization);
        } else {
            System.out.println("The given doctor " + doctorId + " is specialized in " + specialization);
        }
        // Read the specialization to be searched
        System.out.println("Enter the specialization to be searched ");
        specialization = sc.nextLine();
        // Find the doctors based on the specialization
        List<String> doctors = dm.findDoctorsBasedOnTheGivenSpecialization(specialization);
        // Print the result
        if (doctors.isEmpty()) {
            System.out.println("No doctors were found for the given specialization");
        } else {
            System.out.println("Doctors specialized in " + specialization + " are ");
            for (String doc : doctors) {
                System.out.println(doc);
            }
        }
        // Close the scanner
        sc.close();
    }
}
