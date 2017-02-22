package com.sand.count21.logiikka;
import java.util.ArrayList;
import java.util.Collections;

/**
 * This class is the player in the game. The player knows his own cards and can
 * count the values of the cards using Blackjack rules.
 */
public class Player {
    private int gamesPlayed = 0;
    private int gamesWon = 0;
    private int money;
    private ArrayList<Card> playerHand = new ArrayList();
    private Card lastCardRecived = null;

    /**
     * Default constructor for the player. The player has 100 set in money.
     */
    public Player() {
        this.money = 100;
    }
    

    /**
     * This constructor makes it possible to construct a player with more money
     * than the default value 100.
     *
     * @param money money the player has in the beginning
     */
    public Player(int money) {
        this.money = money;
    }
    
    /**
     * Setter for the amount of money the player has. Makes is possible to cheat in the
     * game. That means the player can get more money without creating a new player. Actually used for
     * testing only.
     * @param money new value for player money
     */
    public void setMoney(int money) {
        this.money = money;
    }
    
    /**
     * This method zeros the game played and game wins counter.
     */
    
    public void zeroGameCounters() {
        this.gamesPlayed = 0;
        this.gamesWon = 0;
    }

    /**
     * Add one to the counter that keeps track how many games the player played.
     */
    public void addToPlayerGamesPlayed() {
        this.gamesPlayed++;
    }

    /**
     * This method adds one to the counter that tracks how many games the player
     * won.
     */
    public void addToPlayerWon() {
        this.gamesWon++;
    }

    /**
     * This method deducts money from the player.
     *
     * @param money the money deducted from the player
     */
    public void deductMoney(int money) {
        if (this.money - money >= 0) {
            this.money -= money;
        }
    }

    /**
     * This method gives money to the player.
     *
     * @param money how much money the player gets.
     */
    public void reciveMoney(int money) {
        this.money += money;
    }

    /**
     * Gets the amount money the player has.
     *
     * @return how much money the player has
     */
    public int getMoney() {
        return this.money;
    }

    /**
     * This method adds a card to the players hand.
     *
     * @param card card the player recives.
     */
    public void reciveCard(Card card) {
        this.playerHand.add(card);
        this.lastCardRecived = card;
    }

    /**
     * Gives how many cards the player has in his hand.
     *
     * @return the amount of cards in the players hand
     */
    public int cardsInHand() {
        return playerHand.size();
    }

    /**
     * This method calculates the total value of cards in the players hand. The
     * ace has the value 1 and every face card has the value 10.
     *
     * @return the total value of the cards
     */
    public int totalValueOfCardsAceLow() {
        int sum = 0;
        for (Card card : playerHand) {
            if (card.getValue() > 10) {
                sum += 10;
            } else {
                sum += card.getValue();
            }
        }
        return sum;
    }

    /**
     * This method calculates the total value of the cards in the players hand.
     * The ace has the value 11 and every face card has the value 10. If there
     * is more aces than one in the hand then only one ace is counted as 11, the other
     * aces are counted as one.
     *
     * @return The total value of the cards in hand. Ace is 11 and Facecard 10
     */
    public int totalValueOfCardsAceHigh() {
        int sum = 0;
        for (Card card : playerHand) {
            if (card.getValue() > 10) {
                sum += 10;
            } else {
                sum += card.getValue();
            }
        }
        
        this.sortPlayerCardsSmallToLarge();
        if (this.playerHand.get(0).getValue() == 1) {
            sum += 10;
        }
        
        
        return sum;
    }
    /**
     * This method gets the cards in the players hand.
     *
     * @return The players cards
     */
    public ArrayList<Card> getCards() {
        return this.playerHand;
    }

    /**
     * This method gets the last card added to the players hand.
     *
     * @return the last card added to the players hand.
     */
    public Card getLastCard() {
        return this.lastCardRecived;
    }
    
    public int getGamesPlayed() {
        return this.gamesPlayed;
    }
    
    public int getGamesWon() {
        return this.gamesWon;
    }
    /**
     * This method sorts the players hand from small to large. Not used in
     * Blackjack but can be handy in other games.
     */
    public void sortPlayerCardsSmallToLarge() {
        Collections.sort(this.playerHand);
    }
    /**
     * This method clears the cards in the players hand.
     */
    public void foldHand() {
        this.playerHand.clear();
    }
}