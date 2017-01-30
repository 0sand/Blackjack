/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sand.count21.logiikka;

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
        Player player1 = game.getPlayer(1);
        game.dealToPlayer(player1, 20);
        assertTrue(20 == player1.cardInHand());
    }

    @Test
    public void gameWillAutomaticlyShuffleWhenNeeded() {
        Game game = new Game();
        Player player1 = game.getPlayer(1);
        game.dealToPlayer(player1, 200);
        assertTrue(200 == player1.cardInHand());
    }

    /*
    @Test
    public void gameShufflesDeckWhenNeeded() {
    
    }
     */
}
