package CountWords;


class UserMainCode {
    // A static method to count the number of occurrences of a word in a sentence
    public static int countWords(String sentence, String word) {
        // Split the sentence by spaces
        String[] words = sentence.split(" ");
        // Initialize a variable to store the count
        int count = 0;
        // Loop through the words array
        for (String w : words) {
            // If the word matches the given word, increment the count
            if (w.equals(word)) {
                count++;
            }
        }
        // Return the count
        return count;
    }
}


