// Name: Jasia Ernest, Abdul Rahman, and Micheal Knowles
// Assignment: Lab 3 - Letter Inventory
// Date: October 15 2024
// Class: CS&145

import java.util.Scanner;

public class LetterInventory {
    // Array to store the count of each letter from 'a' to 'z'
    private int[] letterCounts; 
    
    // Variable to store the total count of all letters in the inventory
    private int size; 
    
    // Constant representing the total number of letters in the English alphabet
    private static final int ALPHABET_SIZE = 26; 

    // Constructor that takes an input string, processes it to initialize the inventory
    public LetterInventory(String data) {
        letterCounts = new int[ALPHABET_SIZE]; // Initialize array to hold counts of letters
        size = 0; // Initialize size to zero
        letterInventory(data); // Fill the letter inventory using the input string
    }

    // Main method for user interaction
    public static void main(String[] args) {
        // Create a Scanner object to read user input
        Scanner scan = new Scanner(System.in);
        System.out.println("Please enter the sentence you want to be put in the letter inventory:");
        String userInput = scan.nextLine();
        
        // Create an instance of LetterInventory using the user's input
        LetterInventory inventory = new LetterInventory(userInput);
        inventory.print(); // Print the letter inventory

        // Menu for user to choose between adding or subtracting from the inventory
        System.out.println("Do you want to add or subtract from the letter inventory?");
        System.out.println("1. Add");
        System.out.println("2. Subtract");
        System.out.println("3. No");
        int userChoice = scan.nextInt(); // Read the user's choice
        scan.nextLine(); // Consume the newline character
        
        // Handle the user's choice
        switch (userChoice) {
            case 1:
                // Handle addition to the inventory
                System.out.println("Please enter the sentence you want to add:");
                String addInput = scan.nextLine();
                inventory.add(addInput);
                inventory.print();
                break;
            case 2:
                // Handle subtraction from the inventory
                System.out.println("Please enter the sentence you want to subtract:");
                String subInput = scan.nextLine();
                inventory.subtract(subInput);
                inventory.print();
                break;
            case 3:
                // Exit the program
                System.out.println("Thank you for using our program!");
                break;
            default:
                // Handle invalid input
                System.out.println("Invalid input.");
        }
        scan.close(); // Close the scanner to prevent resource leaks
    }

    // Method to print the inventory of letters with their counts
    public void print() {
        // Iterate through all letters from 'a' to 'z'
        for (char ch = 'a'; ch <= 'z'; ch++) {
            int count = letterCounts[ch - 'a']; // Get the count of each letter
            System.out.println(ch + " : " + count); // Print the letter and its count
        }
    }

    /**
     * Populates the letter inventory by counting each letter in the input string.
     * It ignores non-alphabet characters and treats letters case-insensitively.
     * 
     * @param data the input string to process
     */
    public void letterInventory(String data) {
        data = data.toLowerCase(); // Convert string to lowercase for uniformity
        // Loop through each character in the string
        for (char ch : data.toCharArray()) {
            // If the character is a letter, update its count
            if (ch >= 'a' && ch <= 'z') {
                letterCounts[ch - 'a']++; // Increment the count for that letter
                size++; // Increment the total size of the inventory
            }
        }
    }

    /**
     * Returns the count of a specific letter in the inventory.
     * It is case-insensitive and throws an exception if the input is invalid.
     * 
     * @param letter the letter to get the count of
     * @return the count of the letter in the inventory
     */
    public int get(char letter) {
        letter = Character.toLowerCase(letter); // Convert letter to lowercase
        if (letter < 'a' || letter > 'z') {
            throw new IllegalArgumentException("Character must be a letter."); // Throw error for invalid input
        }
        return letterCounts[letter - 'a']; // Return the count for the letter
    }

    /**
     * Sets the count of a specific letter in the inventory.
     * It is case-insensitive and validates the input.
     * 
     * @param letter the letter to set the count for
     * @param value the count to set for the letter
     */
    public void set(char letter, int value) {
        letter = Character.toLowerCase(letter); // Convert letter to lowercase
        // Validate that the input is a valid letter and the value is non-negative
        if (letter < 'a' || letter > 'z' || value < 0) {
            throw new IllegalArgumentException("Invalid input.");
        }
        size += value - letterCounts[letter - 'a']; // Adjust the total size
        letterCounts[letter - 'a'] = value; // Set the count for the letter
    }

    /**
     * Returns the total number of letters in the inventory.
     * 
     * @return the total size of the inventory
     */
    public int size() {
        return size;
    }

    /**
     * Checks if the inventory is empty, meaning all counts are zero.
     * 
     * @return true if the inventory is empty, false otherwise
     */
    public boolean isEmpty() {
        return size == 0; // Return true if no letters are counted
    }

    /**
     * Returns a string representation of the letter inventory in sorted order.
     * Letters are enclosed in square brackets and appear in lowercase.
     * 
     * @return a string representing the letter inventory
     */
    public String toString() {
        StringBuilder sb = new StringBuilder("["); // Create a string builder for the result
        // Loop through each letter in the alphabet
        for (int i = 0; i < ALPHABET_SIZE; i++) {
            // Append the letter to the string as many times as its count
            for (int j = 0; j < letterCounts[i]; j++) {
                sb.append((char) ('a' + i));
            }
        }
        sb.append("]"); // Close the string with a bracket
        return sb.toString();
    }

    /**
     * Adds the counts of letters from the input string to the current inventory.
     * 
     * @param input the string whose letters to add
     */
    public void add(String input) {
        input = input.toLowerCase(); // Convert input to lowercase
        // Loop through each character and add it to the inventory
        for (char ch : input.toCharArray()) {
            if (ch >= 'a' && ch <= 'z') {
                letterCounts[ch - 'a']++; // Increment the count for the letter
                size++; // Update total size
            }
        }
    }

    /**
     * Subtracts the counts of letters from the input string from the current inventory.
     * 
     * @param input the string whose letters to subtract
     */
    public void subtract(String input) {
        input = input.toLowerCase(); // Convert input to lowercase
        // Loop through each character and subtract it from the inventory
        for (char ch : input.toCharArray()) {
            if (ch >= 'a' && ch <= 'z') {
                letterCounts[ch - 'a']--; // Decrement the count for the letter
                size--; // Update total size
            }
        }
    }
}
