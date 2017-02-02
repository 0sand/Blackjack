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
    private Player player1 = new Player();
    private Player dealer = new Player();

    public Game() {
        deck.shuffle();
    }

    public void firstCardsInRound() {
        dealTo(player1, 2);
        dealTo(dealer, 2);
    }

    public boolean shouldIshuffleDeck() {
        if (deck.cardsLeft() == 0) {
            return true;
        }
        return false;
    }

    public void shuffleDeck() {
        deck.shuffle();
    }

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
        return this.player1;
    }

    public Player getComputer() {
        return this.dealer;
    }

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
    
   
    


}
