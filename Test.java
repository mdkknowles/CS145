package blackjack;

import java.util.Scanner;

// The Test class contains the main method and handles the game logic
public class Test {
    
    public static void main(String[] args) {
        // Create a DeckManager object to manage the deck
        DeckManager deckManager = new DeckManager();
        
        // Scanner to handle user input
        Scanner scanner = new Scanner(System.in);
        
        // Player's total score
        int playerScore = 0;

        intro();

        // Flag to keep track of whether the player wants to keep playing
        boolean keepPlaying = true;

        // Game loop: Keep playing until the player busts, wins, or quits
        while (keepPlaying) {
            try {
                // Deal a card from the deck
                Card card = deckManager.dealCard();
                
                // Display the card that the player drew
                System.out.println("You drew: " + card);

                // Add the value of the card to the player's score
                playerScore += card.getRank().getValue();
                
                // Show the player's current score
                System.out.println("Your current score: " + playerScore);

                // Check if the player went over 21 (bust)
                if (playerScore > 21) {
                    System.out.println("Bust! You went over 21. Game over.");
                    break; // End the game if the player busts
                }

                // Check if the player hit exactly 21 (win)
                if (playerScore == 21) {
                    System.out.println("Congratulations! You hit 21!");
                    break; // End the game if the player wins
                }

                // Ask the player if they want to draw another card
                System.out.print("Do you want to draw another card? (1: Yes, 2: No): ");
                int choice = scanner.nextInt();

                // Switch statement to handle the player's choice
                switch (choice) {
                    case 1:
                        // Keep playing (draw another card)
                        break;
                    case 2:
                        // Player chooses to stop (end the game)
                        keepPlaying = false;
                        break;
                    default:
                        // Invalid input, end the game
                        System.out.println("Invalid input, exiting.");
                        keepPlaying = false;
                        break;
                }
            } catch (Exception e) {
                // Catch the exception if no cards are left in the deck
                System.out.println(e.getMessage());
                keepPlaying = false; // End the game
            }
        }

        // Display the player's final score after the game ends
        System.out.println("Your final score: " + playerScore);
        scanner.close(); // Close the scanner
    }

    public static void intro() {
        // Welcome message
        System.out.println("Welcome to blackjack! The goal is to reach 21 without going over.");
        System.out.println("If a player's hand goes over 21, it's called a 'bust' and they lose the round. ");
        System.out.println("If a player's hand is closer to 21 than the dealer's, they win. "); 
        System.out.println("If the dealer busts, all remaining players win.");
        System.out.println("If neither player nor dealer busts, the player with the highest hand wins. ");
    }
}