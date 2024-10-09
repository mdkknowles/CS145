// Name: Jasia Ernest, Abdul Rahman, and Micheal Knowles
// Assignment: Lab 3 - Letter Inventory
// Date: October 11 2024
// Class: CS&145

public class LetterInventory {
    private int[] inventory = new int[26];
    /* This method constructs an inventory (a count) of the alphabetic letters in the given string, 
    ignoring the case of letters and ignoring any non-alphabetic characters. */
    public LetterInventory(String data) {
        data = data.toUpperCase();
        for ( int i = 0; i < data.length(); i++ ) {
            char ch = data.charAt(i);
            int chInt = ch - 65;
            if ( 0 <= chInt && 25 >= chInt ) {
                this.inventory[chInt]++;
            }
        }
    }

    // This method returns a count of how many of this letter are in the inventory
    public int get(char letter) {

    }

    // This method sets the count for the given letter to the given value.
    public void set(char letter, int value) {

    }

    // This method returns the sum of all of the counts in this inventory
    public int size() {

    }
    
    // This method returns true if this inventory is empty which means that all counts are 0
    public boolean isEmpty() {
        return inventory == null;
    }

    /* This method returns a String representation of the inventory with the letters all in lowercase 
    and in sorted order and surrounded by square brackets */
    public String toString() {

    }

    /* This method is called on a LetterInventory object and adds the input string to the inventory */
    public void add(String input) {
        input = input.toUpperCase();
        for ( int i = 0; i < input.length(); i++ ) {
            char ch = input.charAt(i);
            int chInt = ch - 65;
            if ( 0 <= chInt && 25 >= chInt ) {
                this.inventory[chInt]++;
            }
        }
    }

    /* This method constructs and returns a new LetterInventory object that represents 
    the result of subtracting the other inventory from this inventory 
    (i.e., subtracting the counts in the other inventory from this object’s counts) */
    public void substract(String input) {
        input = input.toUpperCase();
        for ( int i = 0; i < input.length(); i++ ) {
            char ch = input.charAt(i);
            int chInt = ch - 65; // Cast the char as an int and normalize it to be between 0 and 25 inclusive.
            if ( 0 <= chInt && 25 >= chInt ) {
                this.inventory[chInt]--; // Decrement the inventory aryay according to the char int.
            }
        }
    }
}
