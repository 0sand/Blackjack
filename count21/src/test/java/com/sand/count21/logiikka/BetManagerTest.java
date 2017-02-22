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
    public void betManagerZerosTheBetCorrectly() {
        Game game = new Game();
        BetManager betManager = game.getBetManager();

        int playerMoney = game.getPlayer().getMoney();
        betManager.increseBet();
        betManager.zeroBet();
        assertEquals(betManager.getBet(), 0);

    }

    @Test
    public void betManagerReturnsBetIfBothDealerAndPlayerHasBlackJack() {
        Game game = new Game();
        int money = 10;
        int bet = game.getBetManager().getBet();
        game.getPlayer().setMoney(money);

        game.getPlayer().reciveCard(new Card(HEARTS, 1));
        game.getPlayer().reciveCard(new Card(HEARTS, 10));
        game.getDealer().reciveCard(new Card(HEARTS, 11));
        game.getDealer().reciveCard(new Card(HEARTS, 1));
        game.getBetManager().payBetToPlayer();
        int playerMoneyAfterBetManagerPay = game.getPlayer().getMoney();
        assertEquals(money + bet, playerMoneyAfterBetManagerPay);
    }

    @Test
    public void betManagerPaysCorrectlyToPlayerWhenPlayerHasBlackJack() {
        Game game = new Game();
        int money = 0;
        game.getPlayer().setMoney(0);
        int playerMoneyBeforeBet = game.getPlayer().getMoney();

        game.getPlayer().reciveCard(new Card(HEARTS, 1));
        game.getPlayer().reciveCard(new Card(HEARTS, 10));
        game.getDealer().reciveCard(new Card(HEARTS, 11));
        game.getDealer().reciveCard(new Card(HEARTS, 6));
        game.getBetManager().payBetToPlayer();
        int playerMoneyAfterBetManagerPay = game.getPlayer().getMoney();

        assertEquals(25, playerMoneyAfterBetManagerPay);
    }

    @Test
    public void betManagerPaysCorrectlyWhenTheDealerIsBust() {
        Game game = new Game();
        int money = 0;
        game.getPlayer().setMoney(0);
        int playerMoneyBeforeBet = game.getPlayer().getMoney();

        game.getPlayer().reciveCard(new Card(HEARTS, 5));
        game.getPlayer().reciveCard(new Card(HEARTS, 10));
        game.getDealer().reciveCard(new Card(HEARTS, 10));
        game.getDealer().reciveCard(new Card(HEARTS, 6));
        game.getDealer().reciveCard(new Card(HEARTS, 10));
        game.getBetManager().payBetToPlayer();
        int playerMoneyAfterBetManagerPay = game.getPlayer().getMoney();

        assertEquals(20, playerMoneyAfterBetManagerPay);
    }

    @Test
    public void betManagerPaysCorrectlyWhenTheDealerIsBust2() {
        Game game = new Game();
        int money = 100;
        game.getPlayer().setMoney(100);
        game.getBetManager().setBet(100);
        int playerMoneyBeforeBet = game.getPlayer().getMoney();

        game.getPlayer().reciveCard(new Card(HEARTS, 5));
        game.getPlayer().reciveCard(new Card(HEARTS, 10));
        game.getDealer().reciveCard(new Card(HEARTS, 10));
        game.getDealer().reciveCard(new Card(HEARTS, 6));
        game.getDealer().reciveCard(new Card(HEARTS, 10));
        game.getBetManager().payBetToPlayer();
        int playerMoneyAfterBetManagerPay = game.getPlayer().getMoney();

        assertEquals(300
                , playerMoneyAfterBetManagerPay);
    }

    @Test
    public void betManagerPaysCorrectlyToPlayerWhenPlayerHandIsGreaterThanDealer() {
        Game game = new Game();
        int bet = game.getBetManager().getBet();
        int playerMoneyBeforeBet = game.getPlayer().getMoney();

        game.getPlayer().reciveCard(new Card(HEARTS, 8));
        game.getPlayer().reciveCard(new Card(HEARTS, 10));
        game.getDealer().reciveCard(new Card(HEARTS, 10));
        game.getDealer().reciveCard(new Card(HEARTS, 7));
        game.getBetManager().payBetToPlayer();
        int playerMoneyAfterBetManagerPay = game.getPlayer().getMoney();
        assertEquals(120, playerMoneyAfterBetManagerPay);
    }

    @Test
    public void playerReceivesNothingWhenSumOfHandIsSameAsDealer() {
        Game game = new Game();
        int playerMoneyBefore = game.getPlayer().getMoney();

        game.getPlayer().reciveCard(new Card(HEARTS, 8));
        game.getPlayer().reciveCard(new Card(HEARTS, 10));
        game.getDealer().reciveCard(new Card(HEARTS, 10));
        game.getDealer().reciveCard(new Card(HEARTS, 8));
        game.getBetManager().payBetToPlayer();
        int playerMoneyAfterBetManagerPay = game.getPlayer().getMoney();
        assertEquals(playerMoneyBefore, playerMoneyAfterBetManagerPay);
    }

    @Test
    public void betManagerBetIsSameZeroAfterPayout() {
        Game game = new Game();

        int playerMoneyBeforeBet = game.getPlayer().getMoney();

        game.getPlayer().reciveCard(new Card(HEARTS, 8));
        game.getPlayer().reciveCard(new Card(HEARTS, 10));
        game.getDealer().reciveCard(new Card(HEARTS, 10));
        game.getDealer().reciveCard(new Card(HEARTS, 8));
        game.getBetManager().payBetToPlayer();
        int playerMoneyAfterBetManagerPay = game.getPlayer().getMoney();
        assertEquals(10, game.getBetManager().getBet());
    }

    @Test
    public void betManagerDoesNotTakeToMuchMoneyFromPlayer() {
        Game game = new Game();
        int playerMoney = game.getPlayer().getMoney();
        game.getBetManager().setBet(playerMoney + 1);
        game.getBetManager().deductBetFromPlayer();
        assertEquals(playerMoney, game.getPlayer().getMoney());
    }

    @Test
    public void deductBetFromPlayerTaxesAllMoneyCorrectly() {
        Game game = new Game();
        int playerMoney = game.getPlayer().getMoney();
        game.getBetManager().setBet(playerMoney);
        game.getBetManager().deductBetFromPlayer();
        assertEquals(0, game.getPlayer().getMoney());
    }
    
        @Test
    public void paysCorrectly1() {
        Game game = new Game();
        
        game.getPlayer().setMoney(0);
        game.getBetManager().setBet(100);
        int bet =  game.getBetManager().getBet();

        game.getDealer().reciveCard(new Card(HEARTS, 10));
        game.getDealer().reciveCard(new Card(HEARTS, 5));
        game.getDealer().reciveCard(new Card(HEARTS, 11));
        
        game.getPlayer().reciveCard(new Card(HEARTS, 6));
        game.getPlayer().reciveCard(new Card(HEARTS, 8));
        game.getBetManager().payBetToPlayer();
        int playerMoneyAfterBetManagerPay = game.getPlayer().getMoney();
        assertEquals(200, playerMoneyAfterBetManagerPay);
    }
}
