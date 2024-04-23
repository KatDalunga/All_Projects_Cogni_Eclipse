package LargestSpan;

import java.util.HashMap;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        // Create a scanner object to read the input
        Scanner sc = new Scanner(System.in);
        // Read the number of elements in the array
        int n = sc.nextInt();
        // Create an array object
        int[] array = new int[n];
        // Loop through the array and read the elements
        for (int i = 0; i < n; i++) {
            array[i] = sc.nextInt();
        }
        // Call the getLargestSpan method from UserMainCode class
        int span = UserMainCode.getLargestSpan(array);
        // Print the output
        System.out.println(span);
        // Close the scanner
        sc.close();
    }
}

