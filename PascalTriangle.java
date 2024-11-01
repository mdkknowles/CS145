public class PascalTriangle {

    // Recursive method to calculate binomial coefficient
    public static int binomialCoefficient(int n, int k) {
        // Base cases
        if (k == 0 || k == n) {
            return 1;
        }
        // Recursive call
        return binomialCoefficient(n - 1, k - 1) + binomialCoefficient(n - 1, k);
    }

    // Method to print Pascal's Triangle
    public static void printPascalTriangle(int rows) {
        for (int n = 0; n < rows; n++) {
            // Print leading spaces for formatting
            for (int spaces = 0; spaces < rows - n; spaces++) {
                System.out.print(" ");
            }
            // Print binomial coefficients
            for (int k = 0; k <= n; k++) {
                System.out.print(binomialCoefficient(n, k) + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        int numberOfRows = 5; // Change this value for more rows
        printPascalTriangle(numberOfRows);
    }
}