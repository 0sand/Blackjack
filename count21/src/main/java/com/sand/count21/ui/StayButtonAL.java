/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sand.count21.ui;

import com.sand.count21.logiikka.Card;
import com.sand.count21.logiikka.Game;
import com.sand.count21.logiikka.ImageGetter;
import com.sand.count21.logiikka.Player;
import java.awt.Color;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author osand
 */
public class StayButtonAL implements java.awt.event.ActionListener {

    private Game game;
    private ImageGetter imageGetter;
    private JPanel dealerPanel;
    private GUI gui;

    public StayButtonAL(Game game, ImageGetter imageGetter, GUI gui) {
        this.gui = gui;
        this.game = game;
        this.imageGetter = imageGetter;
        this.dealerPanel = gui.getDealerPanel();
    }



    @Override
    public void actionPerformed(ActionEvent e) {
        if (game.getBetManager().getBet() > game.getPlayer().getMoney()) {
            game.getBetManager().setBet(game.getPlayer().getMoney());
        }

        dealerPanel.removeAll();
        ArrayList<Card> cards = game.getDealer().getCards();
        Card card1 = cards.get(0);
        Card card2 = cards.get(1);
        Image image1 = imageGetter.getCardImage(card1);
        Image image2 = imageGetter.getCardImage(card2);

        JLabel dealerCard1 = new JLabel(new ImageIcon(image1));
        JLabel dealerCard2 = new JLabel(new ImageIcon(image2));
        dealerPanel.add(dealerCard1);
        dealerPanel.add(dealerCard2);
        dealerPanel.revalidate();
        

        Player dealer = game.getDealer();

        while (game.checkIfDealerMustHit(dealer)) {

            game.dealOneTo(dealer);
            Card card = dealer.getLastCard();
            Image image = imageGetter.getCardImage(card);
            JLabel dealerCardHit = new JLabel(new ImageIcon(image));
            dealerPanel.add(dealerCardHit);

            dealerPanel.repaint();
            dealerPanel.revalidate();

        }

        gui.getAgainButton().setEnabled(true);
        gui.getHitButton().setEnabled(false);
        gui.getStayButton().setEnabled(false);
        gui.getBetButton().setEnabled(true);
        gui.getDecreaseBetButton().setEnabled(true);

        //pays but do not zero bet
        game.blackjackRoundDone();
        if (game.didPlayerWin()) {
            gui.getInfoField().setText("Player won");

        } else {
            gui.getInfoField().setText("Player lost");
        }
        gui.getInfoField().setForeground(Color.red);

        int playerWins = game.getPlayer().getGamesWon();
        gui.getNumberOfWins().setText("Player Wins  " + playerWins);
        gui.getCurrentBetField().setText("bet " + (game.getBetManager().getBet()));
        gui.getPlayerMoneyField().setText("Money " + game.getPlayer().getMoney());
        gui.getCurrentBetField().repaint();
        gui.getPlayerMoneyField().repaint();

    }

}
