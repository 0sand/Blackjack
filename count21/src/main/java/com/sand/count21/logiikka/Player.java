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
public class Player {
    private ArrayList<Card> playerHand = new ArrayList();
    
    public Player() {
        
    }
    public void reciveCard(Card card) {
        this.playerHand.add(card);
    }
    
    
    public int cardInHand() {
        return playerHand.size();
    }
    public int totalValueOfCards() {
        int sum = 0;
        for (Card card:playerHand) {
            sum += card.getValue();
        }
        return sum;
    }
    public ArrayList<Card> getCards() {
        return this.playerHand;
    }
    
    
}
