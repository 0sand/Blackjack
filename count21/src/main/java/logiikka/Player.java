/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logiikka;
import java.util.ArrayList;

/**
 *
 * @author osand
 */
public class Player {
    private ArrayList<Card> playerHand;
    
    public Player() {
        
    }
    public void reciveCard(Card card) {
        this.playerHand.add(card);
    }
    
    
    public int cardInHand() {
        return playerHand.size();
    }
    public int TotalValueOfCards() {
        int sum = 0;
        for(Card card:playerHand) {
            sum +=card.getValue();
        }
        return sum;
    }
    
    
}
