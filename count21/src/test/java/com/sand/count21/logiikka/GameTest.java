/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sand.count21.logiikka;

import static com.sand.count21.logiikka.Suits.*;
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
public class GameTest {

    public GameTest() {
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
    public void canDealCards() {
        Game game = new Game();
        Player player1 = game.getPlayer();
        game.dealToPlayer(player1, 20);
        assertTrue(20 == player1.cardInHand());
    }

    @Test
    public void gameWillAutomaticlyShuffleWhenNeeded() {
        Game game = new Game();
        Player player1 = game.getPlayer();
        game.dealToPlayer(player1, 200);
        assertTrue(200 == player1.cardInHand());
    }

    @Test
    public void testCheckForBlackjack1() {
        Game game = new Game();
        Card card1 = new Card(SPADES, 1);
        Card card2 = new Card(HEARTS, 10);
        Player player1 = game.getPlayer();
        player1.reciveCard(card1);
        player1.reciveCard(card2);
        assertTrue(game.checkForBlackjack(player1));

    }

    @Test
    public void testCheckForBlackjack2() {
        Game game = new Game();
        Card card1 = new Card(SPADES, 1);
        Card card2 = new Card(HEARTS, 10);
        Card card3 = new Card(HEARTS, 13);
        Player player1 = game.getPlayer();
        player1.reciveCard(card1);
        player1.reciveCard(card2);
        player1.reciveCard(card3);
        assertFalse(game.checkForBlackjack(player1));

    }

    @Test
    public void testCheckForBlackjack3() {
        Game game = new Game();
        Card card1 = new Card(SPADES, 13);
        Card card2 = new Card(HEARTS, 1);
        Player player1 = game.getPlayer();
        player1.reciveCard(card1);
        player1.reciveCard(card2);
        assertTrue(game.checkForBlackjack(player1));
    }

    @Test
    public void testCheckForBlackjack4() {
        Game game = new Game();
        Card card1 = new Card(SPADES, 9);
        Card card2 = new Card(HEARTS, 1);
        Player player1 = game.getPlayer();
        player1.reciveCard(card1);
        player1.reciveCard(card2);
        assertFalse(game.checkForBlackjack(player1));
    }
}
