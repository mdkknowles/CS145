public class LetterInventory {
    // Array to store counts for each letter of the alphabet (26 letters)
    private int[] letterCounts; 
    
    // Variable to keep track of the total number of letters in the inventory
    private int size; 
    
    // Constant representing the number of letters in the English alphabet
    private static final int ALPHABET_SIZE = 26; 
/**
     * It counts how many times each letter appears in the string.
     * The inventory ignores case and non-alphabetic characters.
     * 
     * @param data The input string to construct the inventory from
     */
    public LetterInventory(String data) {
        // Initialize the array to store letter counts
        letterCounts = new int[ALPHABET_SIZE];
        size = 0; // Start with a size of 0

        // Convert the input string to lowercase for consistency
        data = data.toLowerCase();

        // Loop through each character in the string
        for (char ch : data.toCharArray()) {
            // Check if the character is a letter (between 'a' and 'z')
            if (ch >= 'a' && ch <= 'z') {
                letterCounts[ch - 'a']++; // Increment the count for that letter
                size++; // Increment the total size
            }
        }
    }

    /**
     * Returns the count of a specific letter in the inventory.
     * The method is case-insensitive and validates the input.
     * 
     * @param letter The letter whose count is to be returned
     * @return The count of the specified letter in the inventory
     * @throws IllegalArgumentException if the input is not a valid letter
     */
    public int get(char letter) {
        // Convert the letter to lowercase to ensure case insensitivity
        letter = Character.toLowerCase(letter);
        // Validate that the character is a letter
        if (letter < 'a' || letter > 'z') {
            throw new IllegalArgumentException("Character must be a letter.");
        }
        // Return the count for the letter
        return letterCounts[letter - 'a'];
    }

    /**
     * Sets the count for a specific letter in the inventory.
     * The letter is case-insensitive, and the input is validated.
     * 
     * @param letter The letter whose count is to be set
     * @param value The new count for the specified letter
     * @throws IllegalArgumentException if the letter is not alphabetic or value is negative
     */
    public void set(char letter, int value) {
        // Convert the letter to lowercase for consistency
        letter = Character.toLowerCase(letter);
        // Validate that the input letter is alphabetic and the value is non-negative
        if (letter < 'a' || letter > 'z' || value < 0) {
            throw new IllegalArgumentException("Invalid input.");
        }
        // Update the total size based on the new value
        size += value - letterCounts[letter - 'a'];
        // Set the count for the letter
        letterCounts[letter - 'a'] = value;
    }

    /**
     * Returns the total number of letters in the inventory.
     * 
     * @return The total number of letters
     */
    public int size() {
        return size;
    }

    /**
     * Checks if the inventory is empty, meaning all letter counts are zero.
     * 
     * @return True if the inventory is empty, false otherwise
     */
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * Returns a string representation of the inventory.
     * The string contains all letters in lowercase, in sorted order, and enclosed in square brackets.
     * The number of occurrences of each letter matches its count in the inventory.
     * 
     * @return The string representation of the inventory
     */
    public String toString() {
        // StringBuilder to construct the result
        StringBuilder sb = new StringBuilder();
        sb.append("["); // Start with an opening bracket
        // Loop through each letter in the alphabet
        for (int i = 0; i < ALPHABET_SIZE; i++) {
            // Append the letter as many times as its count
            for (int j = 0; j < letterCounts[i]; j++) {
                sb.append((char) ('a' + i));
            }
        }
        sb.append("]"); // End with a closing bracket
        return sb.toString();
    }
   }
