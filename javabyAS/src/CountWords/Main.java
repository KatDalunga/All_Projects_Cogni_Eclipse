package CountWords;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        // Create a scanner object to read the input
        Scanner sc = new Scanner(System.in);
        // Read the sentence and the word
        String sentence = sc.nextLine();
        String word = sc.nextLine();
        // Call the countWords method from UserMainCode class
        int count = UserMainCode.countWords(sentence, word);
        // Print the output
        System.out.println(count);
        // Close the scanner
        sc.close();
    }
}


