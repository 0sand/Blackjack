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




public class BetManager {
private Game game;
private Player player;
private int bet;

    public BetManager(Game game) {
        this.game = game;
        this.player = game.getPlayer();
        this.bet = 0;
    }


    /**
     * This method is used to set the current bet.
     *
     * @param bet increase the current bet
     */
    public void increseBet(int bet) {
        if (this.player.getMoney() - bet >= 0) {
            this.bet = this.bet + bet;
            this.player.deductMoney(bet);

        }

    }

    /**
     * This method zeros the current bet.
     */
    public void zeroBet() {
        this.bet = 0;
    }

    /**
     * This method gets the current bet;
     *
     * @return the current bet.
     */
    public int getBet() {
        return this.bet;
    }

    /**
     * This method pays the bet to the player if he won and zeros the current
     * bet.
     */
    public void payBetToPlayer() {
        if (this.game.checkForBlackjack(player) && !this.game.checkForBlackjack(game.getDealer())) {
            player.reciveMoney(bet);
        }
        if (this.game.checkForBlackjack(player)) {
            this.player.reciveMoney(bet * 3);
        } else if (this.game.didPlayerWin()) {
            this.player.reciveMoney(bet * 2);
        }

    }
}
