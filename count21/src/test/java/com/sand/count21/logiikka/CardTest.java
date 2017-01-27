/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sand.count21.logiikka;

import logiikka.Card;

import static logiikka.Suits.*;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author osand
 */
public class CardTest {

    public CardTest() {
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

    @Test
    public void twoIdenticalCardsAreEqual() {
        Card card1 = new Card(HEARTS, 1);
        Card card2 = new Card(HEARTS, 1);
        assertEquals(card1, card2);

    }

    @Test
    public void twoCardsWithSameValueButDiffrentSuitNotEqual() {
        Card card1 = new Card(SPADES, 1);
        Card card2 = new Card(HEARTS, 1);
        assertNotEquals(card1, card2);
        
    }
}
