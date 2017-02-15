/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sand.count21.logiikka;

import static com.sand.count21.logiikka.Suits.HEARTS;
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
public class BetManagerTest {

    public BetManagerTest() {
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
    public void betManagerTakesMoneyFromPlayerWhenTheBetIsIncreased() {
        Game game = new Game();
        BetManager betManager = game.getBetManager();
        int bet = 10;
        int playerMoney = game.getPlayer().getMoney();
        betManager.increseBet(bet);
        assertEquals(game.getPlayer().getMoney(), playerMoney - bet);

    }

    @Test
    public void playerCanNotBetMoreMoneyThanHeHas() {
        Game game = new Game();
        BetManager betManager = game.getBetManager();

        int playerMoney = game.getPlayer().getMoney();
        int bet = playerMoney + 1;
        betManager.increseBet(bet);
        assertEquals(betManager.getBet(), 0);

    }

    @Test
    public void betManagerSetsTheBetWhenItsDeductedfromThePlayer() {
        Game game = new Game();
        BetManager betManager = game.getBetManager();
        int bet = 100;
        int playerMoney = game.getPlayer().getMoney();
        betManager.increseBet(bet);
        assertEquals(betManager.getBet(), bet);

    }

    @Test
    public void betManagerZerosTheBetCorrectly() {
        Game game = new Game();
        BetManager betManager = game.getBetManager();
        int bet = 10;
        int playerMoney = game.getPlayer().getMoney();
        betManager.increseBet(bet);
        betManager.zeroBet();
        assertEquals(betManager.getBet(), 0);

    }

    @Test
    public void betManagerReturnsBetIfBothDealerAndPlayerHasBlackJack() {
        Game game = new Game();
        int bet = 10;
        int playerMoneyBeforeBet = game.getPlayer().getMoney();
        game.getBetManager().increseBet(bet);
        game.getPlayer().reciveCard(new Card(HEARTS, 1));
        game.getPlayer().reciveCard(new Card(HEARTS, 10));
        game.getDealer().reciveCard(new Card(HEARTS, 11));
        game.getDealer().reciveCard(new Card(HEARTS, 1));
        game.getBetManager().payBetToPlayer();
        int playerMoneyAfterBetManagerPay = game.getPlayer().getMoney();
        assertEquals(playerMoneyBeforeBet, playerMoneyAfterBetManagerPay);
    }

    @Test
    public void betManagerPaysCorrectlyToPlayerWhenPlayerHasBlackJack() {
        Game game = new Game();
        int bet = 100;
        int playerMoneyBeforeBet = game.getPlayer().getMoney();
        game.getBetManager().increseBet(bet);
        game.getPlayer().reciveCard(new Card(HEARTS, 1));
        game.getPlayer().reciveCard(new Card(HEARTS, 10));
        game.getDealer().reciveCard(new Card(HEARTS, 11));
        game.getDealer().reciveCard(new Card(HEARTS, 6));
        game.getBetManager().payBetToPlayer();
        int playerMoneyAfterBetManagerPay = game.getPlayer().getMoney();

        assertEquals(250, playerMoneyAfterBetManagerPay);
    }

    @Test
    public void betManagerPaysCorrectlyToPlayerWhenPlayerHandIsGreaterThanDealer() {
        Game game = new Game();
        int bet = 100;
        int playerMoneyBeforeBet = game.getPlayer().getMoney();
        game.getBetManager().increseBet(bet);
        game.getPlayer().reciveCard(new Card(HEARTS, 8));
        game.getPlayer().reciveCard(new Card(HEARTS, 10));
        game.getDealer().reciveCard(new Card(HEARTS, 10));
        game.getDealer().reciveCard(new Card(HEARTS, 7));
        game.getBetManager().payBetToPlayer();
        int playerMoneyAfterBetManagerPay = game.getPlayer().getMoney();
        assertEquals(200, playerMoneyAfterBetManagerPay);
    }

    @Test
    public void playerReceivesNothingWhenSumOfHandIsSameAsDealer() {
        Game game = new Game();
        int bet = 100;
        int playerMoneyBeforeBet = game.getPlayer().getMoney();
        game.getBetManager().increseBet(bet);
        game.getPlayer().reciveCard(new Card(HEARTS, 8));
        game.getPlayer().reciveCard(new Card(HEARTS, 10));
        game.getDealer().reciveCard(new Card(HEARTS, 10));
        game.getDealer().reciveCard(new Card(HEARTS, 8));
        game.getBetManager().payBetToPlayer();
        int playerMoneyAfterBetManagerPay = game.getPlayer().getMoney();
        assertEquals(0, playerMoneyAfterBetManagerPay);
    }

    @Test
    public void betManagerBetIsZeroAfterPayout() {
        Game game = new Game();
        int bet = 100;
        int playerMoneyBeforeBet = game.getPlayer().getMoney();
        game.getBetManager().increseBet(bet);
        game.getPlayer().reciveCard(new Card(HEARTS, 8));
        game.getPlayer().reciveCard(new Card(HEARTS, 10));
        game.getDealer().reciveCard(new Card(HEARTS, 10));
        game.getDealer().reciveCard(new Card(HEARTS, 8));
        game.getBetManager().payBetToPlayer();
        int playerMoneyAfterBetManagerPay = game.getPlayer().getMoney();
        assertEquals(0, game.getBetManager().getBet());
    }
}
