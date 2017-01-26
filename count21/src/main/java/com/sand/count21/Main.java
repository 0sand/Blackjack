package com.sand.count21;

import logiikka.Card;
import logiikka.Deck;

public class Main {


    public static void main(String[] args) {
        Deck deck = new Deck();
        Card kortti = deck.dealCard();
        System.out.println(kortti.getSuit());
        System.out.println(kortti.getValue());
        System.out.println("112");
    }
    
}
