/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sand.count21.logiikka;

import logiikka.*;
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
public class PlayerTest {

    public PlayerTest() {
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
    public void playerKnowsSumOfCardsCorrectly() {
        Player player = new Player();
        Card card1 = new Card(SPADES, 1);
        Card card2 = new Card(SPADES, 13);
        player.reciveCard(card2);
        player.reciveCard(card1);
        assertTrue(player.TotalValueOfCards() == 14);
    }

    @Test
    public void PlayerKnowsHowManyCardsInHand() {
        Player player = new Player();
        Card card1 = new Card(SPADES, 1);
        Card card2 = new Card(SPADES, 13);
        player.reciveCard(card2);
        player.reciveCard(card1);
        assertTrue(player.cardInHand() == 2);
    }

}
