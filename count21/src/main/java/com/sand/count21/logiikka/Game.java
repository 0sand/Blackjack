package com.sand.count21.logiikka;

import java.util.ArrayList;

/**
 * This class provides the main logic to the blackjack game. The class owns a
 * player, dealer and a deck.
 *
 */
public class Game {

    private Deck deck;
    private Player player = new Player();
    private Player dealer = new Player();

    /**
     * Constructor for the game. It initializes a deck and shuffles it.
     */
    public Game() {
        deck = new Deck();
        deck.shuffle();
    }

    /**
     * This method is used in the beginning of every blackjack round. It deals
     * two cards to player and dealer.
     */
    public void firstCardsInRound() {
        dealTo(player, 2);
        dealTo(dealer, 2);
    }

    /**
     * The method checks that there is still cards in the deck.
     *
     * @return true if there is no card left in deck, otherwise false
     */
    public boolean shouldIshuffleDeck() {
        if (deck.cardsLeft() == 0) {
            return true;
        }
        return false;
    }

    /**
     * The method shuffles the deck in the game.
     */
    public void shuffleDeck() {
        deck.shuffle();
    }

    /**
     * The method deals cards to the player provided to the method.
     *
     * @param player The player that will recive cards from deck
     * @param n how many cards will the player recive
     */
    public void dealTo(Player player, int n) {

        for (int i = 0; i < n; i++) {
            if (shouldIshuffleDeck()) {
                shuffleDeck();
            }
            Card card = deck.dealCard();
            player.reciveCard(card);
        }

    }

    /**
     * Getter for the player playing the game.
     * 
     * @return The player in the game
     */
    public Player getPlayer() {
        return this.player;
    }

    /**
     * This method is gets the dealer for the game.
     * 
     * @return The dealer
     */
    public Player getDealer() {
        return this.dealer;
    }

    /**
     * The dealer will need to hit if the sum of the cards are less than 17 (Ace
     * value = 1). To avoid potential problems the code also checks if the
     * player is not bust
     * @param dealer The dealer checked
     * @return True if dealer must hit
     */
    public boolean checkIfDealerMustHit(Player dealer) {
        if (this.checkForBlackjack(dealer)) {
            return false;
        } else if (this.checkIfPlayerHas21(dealer)) {
            return false;
        } else if (dealer.totalValueOfCardsAceLow() < 17 && dealer.totalValueOfCardsAceHigh() > 21) {
            return true;
        } else if (dealer.totalValueOfCardsAceHigh() >= 17 && dealer.totalValueOfCardsAceLow() != 2) {
            return false;
        } else if (this.checkIfPlayerIsBust(dealer)) {
            return false;
        }

        return true;
    }

    /**
     * This method checks if the player has blackjack.
     *
     * @param player the player the method checks
     * @return true if the player has blackjack
     */
    public boolean checkForBlackjack(Player player) {
        if (player.cardInHand() > 2) {
            return false;
        }
        player.sortPlayerCardsSmallToLarge();
        Card card1 = player.getCards().get(0);
        Card card2 = player.getCards().get(1);
        if (card1.getValue() != 1) {
            return false;
        }
        if (card2.getValue() >= 10) {
            return true;
        }
        return false;
    }

    /**
     * This method checks if the value of the hand of the player is more than
     * 21.
     *
     * @param player the player that is checked
     * @return true if the value is over 21
     */
    public boolean checkIfPlayerIsBust(Player player) {
        if (player.totalValueOfCardsAceLow() > 21) {
            return true;
        }
        return false;
    }

    /**
     * This method checks if the value of the hand the player got is exactly 21.
     *
     * @param player the player that is checked
     * @return true if the value is 21
     */
    public boolean checkIfPlayerHas21(Player player) {
        if (player.totalValueOfCardsAceLow() == 21 || player.totalValueOfCardsAceHigh() == 21) {
            return true;
        }
        return false;
    }

    /**
     * This method checks if the player can split. If the player has two cards
     * that has equal value then the player can split. Face cards are all valued
     * as 10.
     *
     * @param player The player that is checked
     * @return returns true if the player can split
     */
    public boolean checkIfPlayerCanSplit(Player player) {
        ArrayList<Card> cards = player.getCards();
        if (player.cardInHand() == 2) {

            if (cards.get(0).getValue() == cards.get(1).getValue()) {
                return true;
            } else if (cards.get(0).getValue() > 10 && cards.get(1).getValue() > 10) {
                return true;
            }
        }
        return false;
    }

   /**
    * This method folds the cards of the player and dealer so they
    * are ready for the next round.
    */

    public void everyOneFolds() {
        dealer.foldHand();
        player.foldHand();
    }

}
