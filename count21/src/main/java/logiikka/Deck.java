package logiikka;

import java.util.Arrays;

public class Deck {

    private Card[] deckArray;
    private int cardsUsed;

    public Deck() {

        deckArray = new Card[52];
        int cardCt = 0;
        for (Suits suit : Suits.values()) {
            for (int value = 1; value <= 13; value++) {
                deckArray[cardCt] = new Card(suit, value);
                cardCt++;
            }
        }

        cardsUsed = 0;
    }

    public void shuffle() {
        for (int i = deckArray.length - 1; i > 0; i--) {
            int rand = (int) (Math.random() * (i + 1));
            Card temp = deckArray[i];
            deckArray[i] = deckArray[rand];
            deckArray[rand] = temp;
        }
        cardsUsed = 0;
    }

    public int cardsLeft() {
        return deckArray.length - cardsUsed;
    }

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
        return(Arrays.equals(deck.deckArray,this.deckArray));
    }

}
