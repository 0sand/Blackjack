/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sand.count21.logiikka;

import java.util.ArrayList;

/**
 *
 * @author osand
 */
public class Game {

    private Deck deck = new Deck();
    private Player player = new Player();
    private Player dealer = new Player();

    public Game() {
        deck.shuffle();
    }

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

    public Player getPlayer() {
        return this.player;
    }

    public Player getComputer() {
        return this.dealer;
    }

    /**
     * The dealer will need to hit if the sum of the cards are less than 17 (Ace value = 1). 
     * To avoid potential problems the code also checks if the player is not bust
     * @param computer 
     * @return 
     */
    public boolean checkIfDealerMustHit(Player computer) {
        if (this.checkIfPlayerIsBust(computer)) {
            return false;
        }
        if (this.checkIfPlayerHas21(computer)) {
            return false;
        }
        if (computer.totalValueOfCardsAceHigh() >= 17) {
            return false;
        }
        return true;
    }

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

    public boolean checkIfPlayerIsBust(Player player) {
        if (player.totalValueOfCardsAceLow() > 21) {
            return true;
        }
        return false;
    }

    public boolean checkIfPlayerHas21(Player player) {
        if (player.totalValueOfCardsAceLow() == 21 || player.totalValueOfCardsAceHigh() == 21) {
            return true;
        }
        return false;
    }

    public boolean checkIfPlayerCanSplit(Player player) {
        
        if (player.cardInHand() == 2) {
            ArrayList<Card> cards = player.getCards();
            if (cards.get(0).getValue() == cards.get(1).getValue()) {
                return true;
            }
        }
        return false;
    }

    public void dealerPlays(Player dealer) {
        while (this.checkIfDealerMustHit(dealer)) {
            this.dealTo(dealer, 1);
        }
    }
    

    
   public void everyOneFolds() {
       dealer.foldHand();
       player.foldHand();
   }
    


}
