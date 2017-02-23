package com.sand.count21.logiikka;

import java.util.Objects;

/**
 * This class contains normal playing cards for a deck. The cards has a suit
 * and value.
 * @author osand
 */
public class Card implements Comparable<Card> {

    private Suits suit;
    private int value;

    /**
     * Construct the card. A card has suit and value.
     * @param suit The suit of the card. HEARTS, CLUBS, DIAMONDS, SPADES
     * @param value The value of the card 1-13 
     */
    public Card(Suits suit, int value) {
        this.suit = suit;
        this.value = value;
    }

    public Suits getSuit() {
        return this.suit;
    }

    public int getValue() {
        return this.value;
    }
    
    /**
     * This method gets the filename for the card. 
     * @return "images/" + value + suitFirstLetter + ".png"
     */
    public String getFileName() {
        String cardValue = Integer.toString(this.value);
        String suitFirstLetter = this.suit.toString();
        return "images/" + cardValue + suitFirstLetter + ".png";
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
        Card card = (Card) other;
        return (this.suit == card.getSuit() && this.value == card.getValue());
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 89 * hash + Objects.hashCode(this.suit);
        hash = 89 * hash + this.value;
        return hash;
    }

    @Override
    public int compareTo(Card card) {
        if (this.value == card.getValue()) {
            return 0;
        } else if (this.value > card.getValue()) {
            return 1;
        } else {
            return -1;
        }
    }
}
