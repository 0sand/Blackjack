package com.sand.count21.logiikka;

/**
 * This class takes care of the betting and paying of the bet in the blackjack
 * game.
 *
 * @author osand
 */
public class BetManager {

    private Game game;
    private Player player;
    private int bet;
    private double blackJackPayoutFactor;
    private int normalWinPayoutFactor;
    private int maxBet;

    /**
     * The betManager constructor makes a new betmanager using the provided game
     * and the player of the game.
     *
     * @param game blackjack game that links to the betmanager
     */
    public BetManager(Game game) {
        this.game = game;
        this.player = game.getPlayer();
        this.bet = 10;

        this.blackJackPayoutFactor = 1.5;
        this.normalWinPayoutFactor = 1;
        this.maxBet = 100;

    }

    public double getBlackJackPayoutFactor() {
        return blackJackPayoutFactor;
    }

    public int getNormalWinPayoutFactor() {
        return normalWinPayoutFactor;
    }

    public int getBet() {
        return this.bet;
    }

    public void setBet(int bet) {
        this.bet = bet;
    }
    
    /**
     * This method sets the maxbet possible in the betManager.
     * @param maxbet betManager maxbet
     */
    public void setMaxbet(int maxbet) {
        
    }

    /**
     * This method is used to increase the bet.
     *
     */
    public void increseBet() {
        int increaseBet = 10;
        if ((this.player.getMoney() - (this.bet + increaseBet)) >= 0 && (this.bet + increaseBet <= this.maxBet)) {
            this.bet = this.bet + increaseBet;
        } else if (this.player.getMoney() < this.maxBet) {
            this.bet = this.player.getMoney();
        } else {
            this.bet = this.maxBet;
            
        }
    }

    /**
     * This method is used to decrease the bet.
     */
    public void decreseBet() {
        int decreseBet = 10;
        if ((this.bet - decreseBet) >= 0) {
            this.bet = this.bet - decreseBet;
        }
    }

    /**
     * This method removes the bet from the players money.
     */
    public void deductBetFromPlayer() {
        if (this.player.getMoney() - this.bet >= 0) {
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
    /**
     * This method pays the bet to the player if the player one. The method uses
     * blackJackPayoutFactor and normalWinPayoutFactor to determine the winning
     * amount
     * 
     * @return true if method pays to player
     */
    public boolean payBetToPlayer() {
        int payout = 0;
        if (this.game.checkForBlackjack(this.player) && !this.game.checkForBlackjack(game.getDealer())) {
            payout = (int) Math.round(this.blackJackPayoutFactor * this.bet);
            this.player.reciveMoney(this.bet + payout);
            return true;
        } else if (this.game.checkForBlackjack(this.player) && this.game.checkForBlackjack(game.getDealer())) {
            this.player.reciveMoney(this.bet);
            return true;
        } else if (this.game.didPlayerWin()) {
            payout = this.bet * this.normalWinPayoutFactor;
            this.player.reciveMoney(this.bet + payout);
            return true;
        }
        return false;
    }
}
