/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sand.count21.logiikka;

import static com.sand.count21.logiikka.Suits.*;
import java.util.ArrayList;
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
        assertTrue(player.totalValueOfCardsAceLow() == 11);
    }

    @Test
    public void playerKnowsSumOfCardsCorrectly2() {
        Player player = new Player();
        Card card1 = new Card(SPADES, 1);
        Card card2 = new Card(SPADES, 13);
        player.reciveCard(card2);
        player.reciveCard(card1);
        assertTrue(player.totalValueOfCardsAceHigh() == 21);
    }

    @Test
    public void playerKnowsSumOfCardsCorrectly3() {
        Game game = new Game();
        Card card1 = new Card(SPADES, 10);
        Card card2 = new Card(CLUBS, 5);
        Card card3 = new Card(CLUBS, 1);

        Player player1 = game.getDealer();
        player1.reciveCard(card1);
        player1.reciveCard(card2);
        player1.reciveCard(card3);
        assertEquals(16, player1.totalValueOfCardsAceLow());

    }

    @Test
    public void playerKnowsHowManyCardsInHand() {
        Player player = new Player();
        Card card1 = new Card(SPADES, 1);
        Card card2 = new Card(SPADES, 13);
        player.reciveCard(card2);
        player.reciveCard(card1);
        assertTrue(player.cardInHand() == 2);
    }

    @Test
    public void playerCanShowCards() {
        Player player = new Player();
        Card card1 = new Card(SPADES, 1);
        Card card2 = new Card(SPADES, 13);
        player.reciveCard(card2);
        player.reciveCard(card1);
        ArrayList<Card> kortit = player.getCards();
        Assert.assertNotNull(kortit);

    }

    @Test
    public void playerCanFoldHandCorrectly() {
        Player player = new Player();
        Card card1 = new Card(SPADES, 1);
        Card card2 = new Card(SPADES, 13);
        player.reciveCard(card2);
        player.reciveCard(card1);
        player.foldHand();
        assertTrue(player.cardInHand() == 0);
    }

    @Test
    public void playerCanSortCardsFromSmallValueToLarge() {
        Player player = new Player();
        player.reciveCard(new Card(HEARTS, 13));
        player.reciveCard(new Card(SPADES, 10));
        player.reciveCard(new Card(CLUBS, 7));
        player.reciveCard(new Card(HEARTS, 1));
        player.sortPlayerCardsSmallToLarge();
        ArrayList<Card> cards = player.getCards();
        assertEquals(cards.get(0).getValue(), 1);
        assertEquals(cards.get(1).getValue(), 7);
        assertEquals(cards.get(2).getValue(), 10);
        assertEquals(cards.get(3).getValue(), 13);

    }

    @Test
    public void playerGivesLastCardCorrectly() {
        Player player = new Player();
        player.reciveCard(new Card(HEARTS, 13));
        player.reciveCard(new Card(SPADES, 10));
        player.reciveCard(new Card(CLUBS, 7));
        player.reciveCard(new Card(HEARTS, 1));
        assertEquals(player.getLastCard(), (new Card(HEARTS, 1)));
    }

    @Test
    public void lastCardInHandReturnNullWhenHandIsEmpty() {
        Player player = new Player();
        assertEquals(player.getLastCard(), null);
    }

    @Test
    public void canConstructPlayerWithMoreMoney() {
        Player player = new Player(1000);
        int money = player.getMoney();
        assertEquals(money, 1000);
    }

    @Test
    public void playerKnowsCorrectlyHowManyGamesPlayed() {
        Player player = new Player();
        player.addToPlayerGamesPlayed();
        int n = player.getGamesPlayed();
        assertEquals(n, 1);
    }

    @Test
    public void playerKnowsCorrectlyHowManyGamesWon() {
        Player player = new Player();
        player.addToPlayerWon();
        int n = player.getGamesWon();
        assertEquals(n, 1);
    }

    @Test
    public void playerCanDeductMoneyCorrectly() {
        Player player = new Player(1000);
        player.deductMoney(1000);
        assertEquals(player.getMoney(), 0);
    }

    @Test
    public void playerCanReciveMoneyCorrectly() {
        Player player = new Player(1000);
        player.reciveMoney(1000);
        assertEquals(player.getMoney(), 2000);
    }

}
