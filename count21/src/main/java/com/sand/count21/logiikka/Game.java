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
    private Player player2 = new Player();

    public Game() {
        deck.shuffle();
    }

    public void start() {

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

    public Player getPlayer(int n) {
        if (n == 1) {
            return this.player1;
        }
        if (n == 2) {
            return this.player2;
        } else {
            return null;
        }
    }

}
