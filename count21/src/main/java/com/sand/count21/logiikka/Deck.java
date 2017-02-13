package com.sand.count21.logiikka;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

/**
 * This class is a Deck mainly used for the Blackjack game. It contains a deck
 * with cards and methods to manipulate the deck.
 *
 * @author osand
 */
public class Deck {

    private Card[] deckArray;
    private int cardsUsed;
    
 

    /**
     * Constructor for the deck. Constructs a new deck with 52 cards and for
     * different suits. The cards are not shuffled.
     */
    public Deck() {
        
        deckArray = createDeck();
        cardsUsed = 0;
    }

    /**
     * This method creates a new deck with 52 cards and returns it.
     * @return deck created
     */
    
    public Card[] createDeck() {
        Card[] newDeck = new Card[52];
        int cardCt = 0;
        for (Suits suit : Suits.values()) {
            for (int value = 1; value <= 13; value++) {
                newDeck[cardCt] = new Card(suit, value);
                cardCt++;
            }
        }

        cardsUsed = 0;
        return newDeck;
    }
    

    /**
     * This method adds another deck with 52 cards to the deck
     */
    public void addAnotherDeck() {
        Card[] newDeck = this.createDeck();
        ArrayList<Card> comboDeck = new ArrayList<Card>(newDeck.length + this.deckArray.length);
        Collections.addAll(comboDeck , deckArray);
        Collections.addAll(comboDeck, newDeck);
        deckArray = comboDeck.toArray(new Card[comboDeck.size()]);
        this.shuffle();
    }

    /**
     * This method shuffles the deck and sets cardUsed to zero.
     */
    public void shuffle() {
        for (int i = deckArray.length - 1; i > 0; i--) {
            int rand = (int) (Math.random() * (i + 1));
            Card temp = deckArray[i];
            deckArray[i] = deckArray[rand];
            deckArray[rand] = temp;
        }
        cardsUsed = 0;
    }

    /**
     * Getter for how many cards can still be used.
     *
     * @return amount of cards that can be dealt
     */
    public int cardsLeft() {
        return deckArray.length - cardsUsed;
    }

    /**
     * Deals a card from the deck. The first card is from the beginning of the
     * array. No card is ever removed from the deck. The cardUsed variable is
     * just growing.
     *
     * @return Next card in deck
     */
    public Card dealCard() {
        if (cardsUsed == deckArray.length) {
            throw new IllegalStateException("No cards are left in the deck.");
        }
        cardsUsed++;
        return deckArray[cardsUsed - 1];

    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if (other == null) {
            return false;
        }
        if (getClass() != other.getClass()) {
            return false;
        }
        Deck deck = (Deck) other;
        return (Arrays.equals(deck.deckArray, this.deckArray));
    }

}
