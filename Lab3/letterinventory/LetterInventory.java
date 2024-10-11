// Name: Jasia Ernest, Abdul Rahman, and Micheal Knowles
// Assignment: Lab 3 - Letter Inventory
// Date: October 11 2024
// Class: CS&145

import java.util.Arrays;
import java.util.Scanner;

public class LetterInventory {
    // Array to store counts for each letter of the alphabet (26 letters)
    private static int[] letterCounts; 
    
    // Variable to keep track of the total number of letters in the inventory
    private static int size; 
    
    // Constant representing the number of letters in the English alphabet
    private static final int ALPHABET_SIZE = 26; 

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Please enter the sentence you want to be put in the letter inventory");
        String userInput = scan.nextLine();
        letterInventory(userInput);
        print();
        System.out.println("Do you want to add or substract the letter inventory?");
        System.out.println("1. add");
        System.out.println("2. substract");
        System.out.println("3. no");
        int userChoice = scan.nextInt();
        scan.nextLine();
        switch (userChoice) {
            case 1:
                System.out.println("Please enter the sentence you want to be added with the previous the letter inventory");
                String addInput = scan.nextLine();
                letterInventory(addInput);
                add(addInput);
                print();
                break;
            case 2:
                System.out.println("Please enter the sentence you want to be substracted with the previous letter inventory");
                String subInput = scan.nextLine();
                letterInventory(subInput);
                subtract(subInput);
                print();
                break;
            case 3:
                System.out.println("Thank you for using our program!");
                break;
            default:
                System.out.println("Invalid input.");
                System.out.println();
        }
    }

    public static void intro() {
        System.out.println("This program will keep track of an inventory of letters of the alphabet");
    }

    public static void print() {
        int i = 0;
        for (int j = 65; j <= 90; j++) {
            int count = letterCounts[i];
            String forPrint = new Character((char) j).toString();
            System.out.println(forPrint + " : " + Integer.toString(count));
            i++;
        }
    }

/**
     * It counts how many times each letter appears in the string.
     * The inventory ignores case and non-alphabetic characters.
     * 
     * @param data The input string to construct the inventory from
     */
    public static void letterInventory(String data) {
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
        // Convert the letter to uppercase to ensure case insensitivity
        letter = Character.toUpperCase(letter);
        // Validate that the character is a letter
        if (letter < 'A' || letter > 'Z') {
            throw new IllegalArgumentException("Character must be a letter.");
        }
        // Return the count for the letter
        return letterCounts[letter - 'A'];
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
        // Convert the letter to uppercase for consistency
        letter = Character.toUpperCase(letter);
        // Validate that the input letter is alphabetic and the value is non-negative
        if (letter < 'A' || letter > 'Z' || value < 0) {
            throw new IllegalArgumentException("Invalid input.");
        }
        // Update the total size based on the new value
        size += value - letterCounts[letter - 'A'];
        // Set the count for the letter
        letterCounts[letter - 'A'] = value;
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

    /* This method is called on a LetterInventory object and adds the input string to the inventory.
     * It iterates over the string, which has been cast to upper case, using a for loop and extracts
     * the char with charAt(i) where i is the index. The char is subtracted by an offset of 65 to bring
     * the A-Z integer representation within the size of the array.  It is then saved to the array if within
     * the bounds of 0 and 25 inclusive.
    */
    public static void add(String input) {
        input = input.toUpperCase();
        for ( int i = 0; i < input.length(); i++ ) {
            char ch = input.charAt(i);
            int chInt = ch - 65;
            if ( 0 <= chInt && 25 >= chInt ) {
                letterCounts[chInt]++;
            }
        }
    }

    /* This method operates in the same way as the add() method.
     * It instead decrements the array element using --.
     */
    public static void subtract(String input) {
        input = input.toUpperCase();
        for ( int i = 0; i < input.length(); i++ ) {
            char ch = input.charAt(i);
            int chInt = ch - 65; // Cast the char as an int and normalize it to be between 0 and 25 inclusive.
            if ( 0 <= chInt && 25 >= chInt ) {
                letterCounts[chInt]--; // Decrement the inventory array according to the char int.
            }
        }
    }
   }