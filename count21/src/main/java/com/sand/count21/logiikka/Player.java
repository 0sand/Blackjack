/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sand.count21.logiikka;

import java.util.ArrayList;
import java.util.Collections;

/**
 *
 * @author osand
 */
public class Player {

    private int gamesPlayed = 0;
    private int gamesLost = 0;
    private int gamesWon = 0;
    private int money;
    private ArrayList<Card> playerHand = new ArrayList();

    public Player() {
        this.money = 100;
    }

    public Player(int money) {
        this.money = money;
    }

    public void playerWon() {
        this.gamesWon++;
        this.gamesPlayed++;
    }

    public void playerLost() {
        this.gamesLost++;
        this.gamesPlayed++;
    }

    public void deductMoney(int money) {
        if (this.money - money >= 0) {
            this.money -= money;
        }
    }

    public void reciveMoney(int money) {
        this.money += money;
    }

    public int getMoney() {
        return this.money;
    }

    public void reciveCard(Card card) {
        this.playerHand.add(card);
    }

    public int cardInHand() {
        return playerHand.size();
    }

    public int totalValueOfCardsAceLow() {
        int sum = 0;
        for (Card card : playerHand) {
            sum += card.getValue();
        }
        return sum;
    }

    public int totalValueOfCardsAceHigh() {
        int sum = 0;
        for (Card card : playerHand) {
            if (card.getValue() == 1) {
                sum += 11;
            } else {
                sum += card.getValue();
            }
        }
        return sum;
    }

    public ArrayList<Card> getCards() {
        return this.playerHand;
    }

    public Card getLastCard() {
        if (playerHand != null && !playerHand.isEmpty()) {
            Card card = playerHand.get(playerHand.size() - 1);
            return card;
        }
        return null;
    }

    public void sortPlayerCardsSmallToLarge() {
        Collections.sort(this.playerHand);
    }

    public void foldHand() {
        this.playerHand.clear();
    }

}
