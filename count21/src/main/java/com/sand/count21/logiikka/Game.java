/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sand.count21.logiikka;

/**
 *
 * @author osand
 */
public class Game {

    private Deck deck = new Deck();
    private Player player1 = new Player();
    private Player computer = new Player();

    public Game() {
        deck.shuffle();
    }

    public void start() {
        dealToPlayer(player1, 2);
        dealToPlayer(computer, 2);
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

    public void dealToPlayer(Player player, int n) {
        
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
        return this.computer;
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
}
