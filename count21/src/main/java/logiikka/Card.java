package logiikka;

public class Card {
    
    private Suits suit;
    private int value;
    
    public Card(Suits suit, int rank) {
        this.suit = suit;
        this.value = value;
    }

    public Suits getSuit() {
        return this.suit;
    }
    
    public int getValue() {
        return this.value;
    }
}

