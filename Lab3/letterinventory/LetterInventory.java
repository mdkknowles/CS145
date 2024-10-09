package letterinventory;

public class LetterInventory {
    // The LetterInventory class has one single dimensional array as a field.
    private int[] inventory;
    /* The following constructor method LetterInventory() initializes the inventory
       field with a 26 element empty integer array. */
    public LetterInventory() {
        this.inventory = new int[26];
    }

    public int[] getArray() {
        return this.inventory;
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

    /* This method is called on a LetterInventory object and adds the input string to the inventory.
     * It iterates over the string, which has been cast to upper case, using a for loop and extracts
     * the char with charAt(i) where i is the index. The char is subtracted by an offset of 65 to bring
     * the A-Z integer representation within the size of the array.  It is then saved to the array if within
     * the bounds of 0 and 25 inclusive.
    */
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

    /* This method operates in the same way as the add() method.
     * It instead decrements the array element using --.
     */
    public void subtract(String input) {
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
