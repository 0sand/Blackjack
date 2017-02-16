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

/**
 *
 * @author osand
 */
public class DealButtonListener implements java.awt.event.ActionListener {

    Game game;
    GUI gui;
    ImageGetter imageGetter;

    public DealButtonListener(Game game, GUI gui, ImageGetter imageGetter) {
        this.game = game;
        this.gui = gui;
        this.imageGetter = imageGetter;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        game.getBetManager().deductBetFromPlayer();
        gui.getPlayerMoneyField().setText("Money " + game.getPlayer().getMoney());

        gui.getDecreaseBetButton().setEnabled(false);
        gui.getBetButton().setEnabled(false);
        gui.getAgainButton().setEnabled(false);
        gui.getStayButton().setEnabled(true);
        gui.getHitButton().setEnabled(true);
        game.everyOneFolds();

        gui.getPlayerPanel().removeAll();
        gui.getPlayerPanel().repaint();

        gui.getDealerPanel().removeAll();
        gui.getDealerPanel().repaint();

        game.firstCardsInRound();
        ArrayList<Card> cards = game.getPlayer().getCards();
        Card card1 = cards.get(0);
        Image image1 = imageGetter.getCardImage(card1);
        Card card2 = cards.get(1);
        Image image2 = imageGetter.getCardImage(card2);

        JLabel playerCard0 = new JLabel(new ImageIcon(image1));
        JLabel playerCard1 = new JLabel(new ImageIcon(image2));
        gui.getPlayerPanel().add(playerCard0);
        gui.getPlayerPanel().add(playerCard1);

        cards = game.getDealer().getCards();

        image1 = imageGetter.getImageFromString("images/backcard.png");
        card2 = cards.get(1);
        image2 = imageGetter.getCardImage(card2);

        JLabel dealerCard1 = new JLabel(new ImageIcon(image1));
        JLabel dealerCard2 = new JLabel(new ImageIcon(image2));
        gui.getDealerPanel().add(dealerCard1);
        gui.getDealerPanel().add(dealerCard2);

        gui.getPlayerPanel().revalidate();
        gui.getDealerPanel().revalidate();
        gui.getBottomPanel().revalidate();

        Player player = game.getPlayer();
        if (game.checkIfPlayerHas21(player)) {
            gui.getHitButton().setEnabled(false);
        }
        gui.getInfoField().setText("");
       
    }
}
