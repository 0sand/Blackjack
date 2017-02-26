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
        game.dealTo(player1, 20);
        assertTrue(20 == player1.cardsInHand());
    }

    @Test
    public void dealOneCardWorks() {
        Game game = new Game();
        Player player1 = game.getPlayer();
        game.dealOneTo(player1);
        assertTrue(1 == player1.cardsInHand());
    }

    @Test
    public void firstCardsInRoundDeals2DealerAndPlayer() {
        Game game = new Game();
        game.firstCardsInRound();
        Player player = game.getPlayer();
        assertTrue(2 == player.cardsInHand());
        assertTrue(2 == game.getDealer().cardsInHand());
    }

    @Test
    public void gameWillAutomaticlyShuffleWhenNeeded() {
        Game game = new Game();
        Player player1 = game.getPlayer();
        game.dealTo(player1, 200);
        assertTrue(200 == player1.cardsInHand());
    }

    @Test
    public void newGameShufflesTheDeckAutomaticly() {
        Game game1 = new Game();
        Player player1 = new Player();
        Game game2 = new Game();
        Player player2 = new Player();
        game1.dealTo(player1, 1);
        game2.dealTo(player2, 1);

        assertNotEquals(player1.getCards().get(0), player2.getCards().get(0));
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
        Card card2 = new Card(HEARTS, 2);
        Player player1 = game.getPlayer();
        player1.reciveCard(card1);
        player1.reciveCard(card2);
        assertFalse(game.checkForBlackjack(player1));
    }

    @Test
    public void checkIfPlayerGoesBust() {
        Game game = new Game();
        Card card1 = new Card(SPADES, 10);
        Card card2 = new Card(HEARTS, 10);
        Card card3 = new Card(CLUBS, 2);
        Player player1 = game.getPlayer();
        player1.reciveCard(card1);
        player1.reciveCard(card2);
        player1.reciveCard(card3);
        assertTrue(game.checkIfBust(player1));
    }

    @Test
    public void checkIfPlayerGoesBust2() {
        Game game = new Game();
        Card card1 = new Card(SPADES, 10);
        Card card2 = new Card(HEARTS, 10);
        Player player1 = game.getPlayer();
        player1.reciveCard(card1);
        player1.reciveCard(card2);
        assertFalse(game.checkIfBust(player1));
    }

    @Test
    public void checkIfPlayerGoesBust3() {
        Game game = new Game();
        Card card1 = new Card(SPADES, 10);
        Card card2 = new Card(HEARTS, 5);
        Player player1 = game.getPlayer();
        player1.reciveCard(card1);
        player1.reciveCard(card2);
        player1.reciveCard(new Card(HEARTS, 4));
        player1.reciveCard(new Card(HEARTS, 2));
        assertFalse(game.checkIfBust(player1));
    }

    @Test
    public void checkIfPlayerGoesBust4() {
        Game game = new Game();
        Card card1 = new Card(SPADES, 10);
        Card card2 = new Card(HEARTS, 10);
        Card card3 = new Card(HEARTS, 2);
        Player player1 = game.getPlayer();
        player1.reciveCard(card1);
        player1.reciveCard(card2);
        player1.reciveCard(card3);
        assertTrue(game.checkIfBust(player1));
    }

    @Test
    public void checkIfPlayerHas21isTrue() {
        Game game = new Game();
        Card card1 = new Card(SPADES, 1);
        Card card2 = new Card(HEARTS, 7);
        Card card3 = new Card(CLUBS, 10);
        Card card4 = new Card(CLUBS, 3);
        Player player1 = game.getPlayer();
        player1.reciveCard(card1);
        player1.reciveCard(card2);
        player1.reciveCard(card3);
        player1.reciveCard(card4);
        assertTrue(game.checkIfSumIs21(player1));
    }

    @Test
    public void checkIfPlayerHas21isTrue2() {
        Game game = new Game();
        Card card1 = new Card(SPADES, 1);
        Card card2 = new Card(HEARTS, 5);
        Card card3 = new Card(CLUBS, 5);
        Player player1 = game.getPlayer();
        player1.reciveCard(card1);
        player1.reciveCard(card2);
        player1.reciveCard(card3);
        assertTrue(game.checkIfSumIs21(player1));
    }

    @Test
    public void checkIfPlayerHas21isTrue3() {
        Game game = new Game();
        Card card1 = new Card(SPADES, 3);
        Card card2 = new Card(HEARTS, 8);
        Card card3 = new Card(CLUBS, 13);
        Player player1 = game.getPlayer();
        player1.reciveCard(card1);
        player1.reciveCard(card2);
        player1.reciveCard(card3);
        assertTrue(game.checkIfSumIs21(player1));
    }

    @Test
    public void checkIfPlayerHas21isFalse() {
        Game game = new Game();
        Card card1 = new Card(SPADES, 1);
        Card card3 = new Card(CLUBS, 10);
        Card card4 = new Card(CLUBS, 3);
        Player player1 = game.getPlayer();
        player1.reciveCard(card1);
        player1.reciveCard(card3);
        player1.reciveCard(card4);
        assertFalse(game.checkIfSumIs21(player1));
    }

    @Test
    public void checkIfPlayerCanSplitShouldBeTrue() {
        Game game = new Game();
        Card card1 = new Card(SPADES, 10);
        Card card2 = new Card(CLUBS, 10);
        Player player1 = game.getPlayer();
        player1.reciveCard(card1);
        player1.reciveCard(card2);
        assertTrue(game.checkIfPlayerCanSplit(player1));
    }

    @Test
    public void checkIfPlayerCanSplitShouldBeTrue2() {
        Game game = new Game();
        Card card1 = new Card(SPADES, 11);
        Card card2 = new Card(CLUBS, 12);
        Player player1 = game.getPlayer();
        player1.reciveCard(card1);
        player1.reciveCard(card2);
        assertTrue(game.checkIfPlayerCanSplit(player1));
    }

    @Test
    public void checkIfPlayerCanSplitShouldBeFalse() {
        Game game = new Game();
        Card card1 = new Card(SPADES, 5);
        Card card2 = new Card(CLUBS, 10);
        Player player1 = game.getPlayer();
        player1.reciveCard(card1);
        player1.reciveCard(card2);
        assertFalse(game.checkIfPlayerCanSplit(player1));
    }

    @Test
    public void checkIfPlayerCanSplitShouldBeFalse2() {
        Game game = new Game();
        Card card1 = new Card(SPADES, 5);
        Card card2 = new Card(CLUBS, 10);
        Card card3 = new Card(HEARTS, 10);
        Player player1 = game.getPlayer();
        player1.reciveCard(card1);
        player1.reciveCard(card2);
        player1.reciveCard(card3);
        assertFalse(game.checkIfPlayerCanSplit(player1));
    }

    @Test
    public void checkIfComputerShouldHitShouldBeTrue() {
        Game game = new Game();
        Card card1 = new Card(SPADES, 10);
        Card card2 = new Card(CLUBS, 6);

        Player player1 = game.getDealer();
        player1.reciveCard(card1);
        player1.reciveCard(card2);
        assertTrue(game.checkIfDealerMustHit(player1));
    }

    @Test
    public void checkIfComputerShouldHitShouldBeTrue2() {
        Game game = new Game();
        Card card1 = new Card(SPADES, 1);
        Card card2 = new Card(CLUBS, 1);

        Player player1 = game.getDealer();
        player1.reciveCard(card1);
        player1.reciveCard(card2);
        assertTrue(game.checkIfDealerMustHit(player1));
    }

    @Test
    public void checkIfComputerShouldHitShouldBeTrue3() {
        Game game = new Game();
        Card card1 = new Card(SPADES, 1);
        Card card2 = new Card(CLUBS, 6);
        Card card3 = new Card(CLUBS, 9);

        Player player1 = game.getDealer();
        player1.reciveCard(card1);
        player1.reciveCard(card2);
        player1.reciveCard(card3);
        assertTrue(game.checkIfDealerMustHit(player1));
    }

    @Test
    public void checkIfComputerShouldHitShouldBeTrue4() {
        Game game = new Game();

        Player player1 = game.getDealer();
        player1.reciveCard(new Card(SPADES, 1));
        player1.reciveCard(new Card(CLUBS, 1));
        player1.reciveCard(new Card(CLUBS, 2));
        assertTrue(game.checkIfDealerMustHit(player1));
    }

    @Test
    public void checkIfComputerShouldHitShouldBeFalse() {
        Game game = new Game();
        Card card1 = new Card(SPADES, 10);
        Card card2 = new Card(CLUBS, 7);

        Player player1 = game.getDealer();
        player1.reciveCard(card1);
        player1.reciveCard(card2);
        assertFalse(game.checkIfPlayerCanSplit(player1));
    }

    @Test
    public void checkIfComputerShouldHitShouldBeFalse2() {
        Game game = new Game();
        Card card1 = new Card(SPADES, 11);
        Card card2 = new Card(CLUBS, 6);
        Card card3 = new Card(CLUBS, 1);

        Player player1 = game.getDealer();
        player1.reciveCard(card1);
        player1.reciveCard(card2);
        player1.reciveCard(card3);
        assertFalse(game.checkIfDealerMustHit(player1));
    }

    @Test
    public void checkIfComputerShouldHitShouldBeFalse3() {
        Game game = new Game();
        Card card1 = new Card(SPADES, 1);
        Card card2 = new Card(CLUBS, 7);
        Card card3 = new Card(CLUBS, 9);

        Player player1 = game.getDealer();
        player1.reciveCard(card1);
        player1.reciveCard(card2);
        player1.reciveCard(card3);
        assertFalse(game.checkIfDealerMustHit(player1));
    }

    @Test
    public void checkIfComputerShouldHitShouldBeFalse4() {
        Game game = new Game();
        Card card1 = new Card(SPADES, 3);
        Card card2 = new Card(CLUBS, 13);
        Card card3 = new Card(CLUBS, 5);

        Player player1 = game.getDealer();
        player1.reciveCard(card1);
        player1.reciveCard(card2);
        player1.reciveCard(card3);
        assertFalse(game.checkIfDealerMustHit(player1));
    }

    @Test
    public void checkIfComputerShouldHitShouldBeFalse5() {
        Game game = new Game();
        Card card1 = new Card(SPADES, 12);
        Card card2 = new Card(CLUBS, 1);
        Player player1 = game.getDealer();
        player1.reciveCard(card1);
        player1.reciveCard(card2);
        assertFalse(game.checkIfDealerMustHit(player1));
    }

    @Test
    public void checkIfComputerShouldHitShouldBeFalse6() {
        Game game = new Game();
        Card card1 = new Card(SPADES, 3);
        Card card2 = new Card(CLUBS, 9);
        Card card3 = new Card(CLUBS, 1);
        Card card4 = new Card(CLUBS, 6);

        Player player1 = game.getDealer();
        player1.reciveCard(card1);
        player1.reciveCard(card2);
        player1.reciveCard(card3);
        player1.reciveCard(card4);
        assertFalse(game.checkIfDealerMustHit(player1));
    }

    @Test
    public void checkIfComputerShouldHitShouldBeFalse7() {
        Game game = new Game();
        Card card1 = new Card(SPADES, 3);
        Card card2 = new Card(CLUBS, 9);
        Card card3 = new Card(CLUBS, 1);
        Card card4 = new Card(CLUBS, 6);

        Player player1 = game.getDealer();
        player1.reciveCard(card1);
        player1.reciveCard(card2);
        player1.reciveCard(card3);
        player1.reciveCard(card4);
        assertFalse(game.checkIfDealerMustHit(player1));
    }

    @Test
    public void checkIfComputerShouldHitShouldBeFalse8() {
        Game game = new Game();
        Card card1 = new Card(SPADES, 5);
        Card card2 = new Card(CLUBS, 1);
        Card card3 = new Card(HEARTS, 1);
        Card card4 = new Card(CLUBS, 2);
        Card card5 = new Card(CLUBS, 9);

        Player player1 = game.getDealer();
        player1.reciveCard(card1);
        player1.reciveCard(card2);
        player1.reciveCard(card3);
        player1.reciveCard(card4);
        player1.reciveCard(card5);
        assertFalse(game.checkIfDealerMustHit(player1));
    }

    @Test
    public void checkIfComputerShouldHitShouldBeFalse9() {
        Game game = new Game();
        Card card1 = new Card(SPADES, 2);
        Card card2 = new Card(CLUBS, 4);
        Card card3 = new Card(CLUBS, 9);
        Card card4 = new Card(CLUBS, 2);

        Player player1 = game.getDealer();
        player1.reciveCard(card1);
        player1.reciveCard(card2);
        player1.reciveCard(card3);
        player1.reciveCard(card4);
        assertFalse(game.checkIfDealerMustHit(player1));
    }

    @Test
    public void checkIfEveryOneFoldsReallyFolds() {
        Game game = new Game();
        game.firstCardsInRound();
        game.everyOneFolds();
        Player player = game.getPlayer();
        assertEquals(player.cardsInHand(), 0);
        Player dealer = game.getDealer();
        assertEquals(dealer.cardsInHand(), 0);
    }

    @Test
    public void shouldIShuffleDeckMethodTest() {
        Game game = new Game();

        game.dealTo(game.getPlayer(), 52);
        assertTrue(game.shouldIshuffleDeck());
    }

    @Test
    public void shouldIShuffleDeckMethodTest2() {
        Game game = new Game();
        game.dealTo(game.getPlayer(), 53);
        assertFalse(game.shouldIshuffleDeck());
    }

    @Test
    public void didPlayerWinTestShouldBeTrue1() {
        Game game = new Game();
        game.getPlayer().reciveCard(new Card(HEARTS, 10));
        game.getPlayer().reciveCard(new Card(HEARTS, 8));
        game.getDealer().reciveCard(new Card(HEARTS, 1));
        game.getDealer().reciveCard(new Card(HEARTS, 5));
        game.getDealer().reciveCard(new Card(HEARTS, 6));
        assertTrue(game.didPlayerWin());
    }

    @Test
    public void didPlayerWinTestShouldBeTrue2() {
        Game game = new Game();
        game.getPlayer().reciveCard(new Card(HEARTS, 10));
        game.getPlayer().reciveCard(new Card(HEARTS, 8));
        game.getPlayer().reciveCard(new Card(HEARTS, 3));

        game.getDealer().reciveCard(new Card(HEARTS, 1));
        game.getDealer().reciveCard(new Card(HEARTS, 5));
        game.getDealer().reciveCard(new Card(HEARTS, 4));
        assertTrue(game.didPlayerWin());
    }

    @Test
    public void didPlayerWinTestShouldBeTrue3() {
        Game game = new Game();
        game.getPlayer().reciveCard(new Card(HEARTS, 10));
        game.getPlayer().reciveCard(new Card(HEARTS, 8));
        game.getPlayer().reciveCard(new Card(HEARTS, 3));

        game.getDealer().reciveCard(new Card(HEARTS, 9));
        game.getDealer().reciveCard(new Card(HEARTS, 5));
        game.getDealer().reciveCard(new Card(HEARTS, 8));
        assertTrue(game.didPlayerWin());
    }

    @Test
    public void didPlayerWinTestShouldBeTrue4() {
        Game game = new Game();
        game.getPlayer().reciveCard(new Card(HEARTS, 2));
        game.getPlayer().reciveCard(new Card(HEARTS, 2));
        game.getPlayer().reciveCard(new Card(HEARTS, 1));
        game.getPlayer().reciveCard(new Card(HEARTS, 5));
        game.getPlayer().reciveCard(new Card(HEARTS, 1));

        game.getDealer().reciveCard(new Card(HEARTS, 4));
        game.getDealer().reciveCard(new Card(HEARTS, 3));
        game.getDealer().reciveCard(new Card(HEARTS, 2));
        game.getDealer().reciveCard(new Card(HEARTS, 8));
        assertTrue(game.didPlayerWin());
    }

    @Test
    public void didPlayerWinTestShouldBeTrue5() {
        Game game = new Game();
        game.getPlayer().reciveCard(new Card(HEARTS, 9));
        game.getPlayer().reciveCard(new Card(HEARTS, 8));

        game.getDealer().reciveCard(new Card(HEARTS, 1));
        game.getDealer().reciveCard(new Card(HEARTS, 1));
        game.getDealer().reciveCard(new Card(HEARTS, 2));
        assertTrue(game.didPlayerWin());
    }

    @Test
    public void didPlayerWinTestShouldBeTrue6() {
        Game game = new Game();
        game.getPlayer().reciveCard(new Card(HEARTS, 1));
        game.getPlayer().reciveCard(new Card(HEARTS, 10));

        game.getDealer().reciveCard(new Card(HEARTS, 3));
        game.getDealer().reciveCard(new Card(HEARTS, 9));
        game.getDealer().reciveCard(new Card(HEARTS, 9));
        assertTrue(game.didPlayerWin());
    }

    @Test
    public void didPlayerWinTestShouldBeFalse() {
        Game game = new Game();
        game.getPlayer().reciveCard(new Card(HEARTS, 10));
        game.getPlayer().reciveCard(new Card(HEARTS, 10));
        game.getPlayer().reciveCard(new Card(HEARTS, 10));
        game.getPlayer().reciveCard(new Card(HEARTS, 3));
        game.getDealer().reciveCard(new Card(HEARTS, 9));
        game.getDealer().reciveCard(new Card(HEARTS, 5));
        game.getDealer().reciveCard(new Card(HEARTS, 9));
        assertFalse(game.didPlayerWin());
    }

    @Test
    public void didPlayerWinTestShouldBeFalse2() {
        Game game = new Game();
        game.getPlayer().reciveCard(new Card(HEARTS, 11));
        game.getPlayer().reciveCard(new Card(HEARTS, 11));

        game.getDealer().reciveCard(new Card(HEARTS, 10));
        game.getDealer().reciveCard(new Card(HEARTS, 10));
        assertFalse(game.didPlayerWin());
    }

    @Test
    public void didPlayerWinTestShouldBeFalse3() {
        Game game = new Game();
        game.getPlayer().reciveCard(new Card(HEARTS, 11));
        game.getPlayer().reciveCard(new Card(HEARTS, 6));

        game.getDealer().reciveCard(new Card(HEARTS, 2));
        game.getDealer().reciveCard(new Card(HEARTS, 12));
        game.getDealer().reciveCard(new Card(HEARTS, 5));
        assertFalse(game.getBetManager().payBetToPlayer());

    }

    @Test
    public void didPlayerWinTestShouldBeFalse4() {
        Game game = new Game();
        game.getDealer().reciveCard(new Card(CLUBS, 6));
        game.getDealer().reciveCard(new Card(SPADES, 5));
        game.getDealer().reciveCard(new Card(DIAMONDS, 11));

        game.getPlayer().reciveCard(new Card(SPADES, 12));
        game.getPlayer().reciveCard(new Card(CLUBS, 4));

        assertFalse(game.getBetManager().payBetToPlayer());
        assertFalse(game.didPlayerWin());

    }

    @Test
    public void blackjackRoundDoneAddsToPlayerWinCounterWhenThePlayerWon() {
        Game game = new Game();
        game.getPlayer().reciveCard(new Card(HEARTS, 10));
        game.getPlayer().reciveCard(new Card(HEARTS, 8));
        game.getPlayer().reciveCard(new Card(HEARTS, 3));
        game.getDealer().reciveCard(new Card(HEARTS, 1));
        game.getDealer().reciveCard(new Card(HEARTS, 5));
        game.getDealer().reciveCard(new Card(HEARTS, 4));
        game.blackjackRoundDone();
        assertEquals(1, game.getPlayer().getGamesWon());
    }

    @Test
    public void blackjackRoundDoneDoNotAddToPlayerWinCounterWhenThePlayerLost() {
        Game game = new Game();
        game.getPlayer().reciveCard(new Card(HEARTS, 10));
        game.getPlayer().reciveCard(new Card(HEARTS, 8));
        game.getPlayer().reciveCard(new Card(HEARTS, 3));
        game.getDealer().reciveCard(new Card(HEARTS, 1));
        game.getDealer().reciveCard(new Card(HEARTS, 10));
        game.blackjackRoundDone();
        assertEquals(0, game.getPlayer().getGamesWon());
    }

}
