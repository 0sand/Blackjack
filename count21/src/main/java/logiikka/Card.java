package logiikka;

public class Card {

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

}

