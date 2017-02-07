package com.sand.count21.logiikka;

public class Card implements Comparable<Card> {

    private Suits suit;
    private int value;

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
    
    public String getFileName() {
        String number = Integer.toString(this.value);
        String name = this.suit.toString();
        
        return "images/" + number + name + ".png";
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
