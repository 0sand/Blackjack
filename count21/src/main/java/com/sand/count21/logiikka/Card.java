package com.sand.count21.logiikka;
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
     * @param value The value of the card 1 <= value <= 13 
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

    /**
     * If two cards has the same suit and value they are considered to
     * be the same card.
     * @param other
     * @return 
     */
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

    /**
     * The cards are sorted only according to their value.
     * @param card
     * @return 
     */
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
