public class LeastCommonDenominator {

    // Recursive method to calculate GCD using Euclidean algorithm
    public static int gcd(int a, int b) {
        if (b == 0) {
            return a;
        }
        return gcd(b, a % b);
    }

    // Method to calculate LCM using GCD
    public static int lcm(int a, int b) {
        return (a * b) / gcd(a, b);
    }

    // Method to calculate LCD of two fractions
    public static int calculateLCD(int denom1, int denom2) {
        return lcm(denom1, denom2);
    }

    public static void main(String[] args) {
        int denominator1 = 8; // Denominator of first fraction
        int denominator2 = 12; // Denominator of second fraction

        int lcd = calculateLCD(denominator1, denominator2);
        System.out.println("The Least Common Denominator of " + denominator1 + " and " + denominator2 + " is: " + lcd);
    }
}