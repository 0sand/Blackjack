/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sand.count21.logiikka;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author osand
 */
public class DeckTest {

    public DeckTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    @Test
    public void deckCanNotDealMoreThan52WithoutError() {
        boolean thrown = false;

        try {
            Deck deck = new Deck();
            for (int i = 0; i < 53; i++) {
                deck.dealCard();
            }
        } catch (IllegalStateException e) {
            thrown = true;
        }
        assertTrue(thrown);
    }

    @Test
    public void deckCanDeal52Cards() {
        boolean thrown = true;

        try {
            Deck deck = new Deck();
            for (int i = 0; i < 52; i++) {
                deck.dealCard();
            }
        } catch (IllegalStateException e) {
            thrown = false;
        }
        assertTrue(thrown);
    }

    @Test
    public void allDecksAreCreatedEqual() {
        Deck deck = new Deck();
        Deck deck2 = new Deck();
        assertEquals(deck2, deck);

    }

    @Test
    public void FirstshuffleDeckChangesOrder() {
        Deck deck = new Deck();
        Deck deck2 = new Deck();
        deck.shuffle();
        assertNotEquals(deck2, deck);
    }

    @Test
    public void twoNewDecksShuffledAreNotEqual() {
        Deck deck1 = new Deck();
        Deck deck2 = new Deck();
        deck1.shuffle();
        deck2.shuffle();
        assertNotEquals(deck1, deck2);
    }

    @Test
    public void whenCardIsDealtItIsUsedFromDeck() {
        Deck deck = new Deck();
        Card card = deck.dealCard();
        assertTrue(deck.cardsLeft() == 51);

    }

    @Test
    public void when52CardsIsDealtNoCardIsLeftInDeck() {
        Deck deck = new Deck();
        for (int i = 0; i < 52; i++) {
            deck.dealCard();
        }
        assertTrue(deck.cardsLeft() == 0);
    }

    @Test
    public void possibleToAddAnotherDeckOfCardsToTheDeck() {
        Deck deck = new Deck();
        deck.addAnotherDeck();
        assertTrue(deck.cardsLeft() == 104);
    }
    
    @Test
    public void theTotalValueOfAllCardsInDeckIsCorrectForA52CardDeck() {
        int value = 0;
        int expectedSum = 364;
        Deck deck = new Deck();
        
        
        for (int i = 0; i < 52; i++) {
            value = value + deck.dealCard().getValue();
        }
        assertEquals(expectedSum, value);
        
    }
}
