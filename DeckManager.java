package blackjack;

import java.util.Random;

// The DeckManager class handles the deck (shuffling, dealing)
public class DeckManager {
    
    // Array to hold the deck of 52 cards
    private final Card[] deck;
    
    // Keeps track of the current card being dealt
    private int currentCard;
    
    // Constant for the total number of cards in a standard deck
    private static final int NUMBER_OF_CARDS = 52;
    
    // Random number generator used for shuffling
    private final Random randomNumbers;

    // Constructor initializes the deck with all 52 cards and shuffles them
    public DeckManager() {
        deck = new Card[NUMBER_OF_CARDS];
        currentCard = 0; // Reset current card pointer
        randomNumbers = new Random();

        // Fill the deck with cards (all suits and ranks)
        int i = 0;
        for (Card.Suit suit : Card.Suit.values()) {
            for (Card.Rank rank : Card.Rank.values()) {
                deck[i++] = new Card(suit, rank);
            }
        }
        shuffle(); // Shuffle the deck after it's created
    }

    // Shuffle the deck using a one-pass algorithm
    public void shuffle() {
        currentCard = 0; // Reset to the first card after shuffling

        // Shuffle the deck by swapping each card with a randomly selected card
        for (int first = 0; first < deck.length; first++) {
            int second = randomNumbers.nextInt(NUMBER_OF_CARDS); // Random card index
            Card temp = deck[first]; // Temporary variable to hold the card
            deck[first] = deck[second]; // Swap the first card with a random card
            deck[second] = temp; // Complete the swap
        }
    }

    // Method to deal one card from the deck
    public Card dealCard() throws Exception {
        // If there are still cards left, return the next card
        if (currentCard < deck.length) {
            return deck[currentCard++]; // Return current card and increment the pointer
        } else {
            // If all cards have been dealt, throw an exception
            throw new Exception("All cards have been dealt.");
        }
    }
}