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
public class StayButtonListener implements java.awt.event.ActionListener {

    private Game game;
    private ImageGetter imageGetter;
    private JPanel dealerPanel;
    private GUI gui;

    public StayButtonListener(Game game, ImageGetter imageGetter, GUI gui) {
        this.gui = gui;
        this.game = game;
        this.imageGetter = imageGetter;
        this.dealerPanel = gui.getDealerPanel();
    }

    @Override
    public void actionPerformed(ActionEvent e) {

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
            dealerPanel.revalidate();

        }

        gui.getAgainButton().setEnabled(true);
        gui.getHitButton().setEnabled(false);
        gui.getStayButton().setEnabled(false);
        gui.getBetButton().setEnabled(true);
        game.blackjackRoundDone();

        int playerWins = game.getPlayer().getGamesWon();
        gui.getNumberOfWins().setText("Player Wins  " + playerWins);
        gui.getCurrentBetField().setText("Current bet " + (game.getBetManager().getBet()));
        gui.getPlayerMoneyField().setText("Money " + game.getPlayer().getMoney());
        gui.getCurrentBetField().repaint();
        gui.getPlayerMoneyField().repaint();

    }

}
