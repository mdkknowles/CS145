// Contributors:    Abdul Rahman Said and Michael Knowles
// Assignment:      Lab 5 - PascalTriangle
// Date:            11/5/2024
// Class:           CS&145

import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class PascalTriangle {

    // Method to calculate the factorial of a number
    public int fact(int num) {
        int fact = 1; // Initialize factorial as 1
        for (int i = 1; i <= num; i++) { // Loop from 1 to num
            fact *= i; // Multiply fact by i in each iteration to get factorial
        }
        return fact; // Return the factorial of num
    }
    
    // Method to calculate the binomial coefficient (n choose k), nCk
    public int nck(int n, int k) {
        // Use factorial formula for binomial coefficient: n! / (k! * (n - k)!)
        return fact(n) / (fact(k) * fact((n - k)));
    }

    // Method to generate Pascal's Triangle as a LinkedList of LinkedLists
    public List<List<Integer>> generatePascalTriangle(int rows) {
        if (rows <= 0) {
            return null; // Return null for invalid row count
        }

        List<List<Integer>> triangle = new LinkedList<>(); // Initialize LinkedList of LinkedLists
        for (int n = 0; n < rows; n++) {
            List<Integer> row = new LinkedList<>(); // Initialize a new row
            for (int k = 0; k <= n; k++) {
                row.add(nck(n, k)); // Calculate binomial coefficient for each position and add to row
            }
            triangle.add(row); // Add the row to the triangle
        }
        return triangle;
    }
    // Method to display Pascal's Triangle with improved alignment and null handling
    public void displayPascalTriangle(int rows) {
        List<List<Integer>> triangle = generatePascalTriangle(rows); // Generate triangle as a list of lists

        if (triangle == null) {
            System.out.println("Invalid number of rows. Please enter a positive integer.");
            return; // Exit the method if the triangle is null
        }

        System.out.println("Pascal Triangle:");
        for (int n = 0; n < rows; n++) {
            System.out.print(" ".repeat((rows - n) * 2)); // Print spaces for alignment
            for (int value : triangle.get(n)) {
                System.out.printf("%4d", value); // Print each element with a width of 4 for alignment
            }
            System.out.println(); // Move to next line after each row
        }
    }
        public static void main(String args[]) {
        PascalTriangle pascalTriangle = new PascalTriangle(); // Create an instance of PascalTriangle
        Scanner scanner = new Scanner(System.in); // Initialize scanner for user input
         
        while (true) {
            System.out.println("\nChoose an option:");
            System.out.println("1. Display Pascal's Triangle");
            System.out.println("2. Exit");
            System.out.print("Enter choice: ");
            int choice;
            
            try {
                choice = scanner.nextInt(); // Read user choice
                if (choice == 2) {
                    System.out.println("Exiting program. Goodbye!");
                    break; // Exit program
                } else if (choice == 1) {
                    System.out.print("Enter number of rows (positive integer): ");
                    int rows = scanner.nextInt(); // Read number of rows
                    if (rows <= 0) {
                        System.out.println("Number of rows must be a positive integer.");
                        continue; // Prompt user again if input is invalid
                    }
                    pascalTriangle.displayPascalTriangle(rows); // Display Pascal's Triangle
                } else {
                    System.out.println("Invalid choice. Please enter 1 or 2.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter an integer.");
                scanner.nextLine(); // Clear the invalid input
            }
        }
        scanner.close(); // Close scanner to avoid resource leak
    }
}
