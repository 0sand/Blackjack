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

    private int money;
    private ArrayList<Card> playerHand = new ArrayList();

    public Player() {
        this.money = 100;
    }

    public Player(int money) {
        this.money = money;
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

    public int totalValueOfCards() {
        int sum = 0;
        for (Card card : playerHand) {
            sum += card.getValue();
        }
        return sum;
    }

    public ArrayList<Card> getCards() {
        return this.playerHand;
    }

    public void sortPlayerCardsSmallToLarge() {
        Collections.sort(this.playerHand);
    }

}
