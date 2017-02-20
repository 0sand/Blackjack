package com.sand.count21.ui;

import com.sand.count21.logiikka.Card;
import com.sand.count21.logiikka.Game;
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
        game.blackjackRoundDone();
        this.showDealersHiddenCard();
        this.showDealerHitCard();
        this.activateTheCorrectButtons();
        this.updateTheInfoField();
    }

    private void showDealersHiddenCard() {
        dealerPanel.remove(0);
        Card card1 = game.getDealer().getCards().get(0);
        Image image1 = imageGetter.getCardImage(card1);
        JLabel dealerCard1 = new JLabel(new ImageIcon(image1));
        dealerPanel.add(dealerCard1, 0);
        dealerPanel.repaint();
    }

    private void showDealerHitCard() {
        while (game.checkIfDealerMustHit(game.getDealer())) {
            game.dealOneTo(game.getDealer());
            Card card = game.getDealer().getLastCard();
            Image image = imageGetter.getCardImage(card);
            JLabel dealerCardHit = new JLabel(new ImageIcon(image));
            dealerPanel.add(dealerCardHit);
            dealerPanel.repaint();
        }
    }

    private void activateTheCorrectButtons() {
        gui.getAgainButton().setEnabled(true);
        gui.getHitButton().setEnabled(false);
        gui.getStayButton().setEnabled(false);
        gui.getBetButton().setEnabled(true);
        gui.getDecreaseBetButton().setEnabled(true);
    }

    private void updateTheInfoField() {
        if (game.getBetManager().getBet() > game.getPlayer().getMoney()) {
            game.getBetManager().setBet(game.getPlayer().getMoney());
        }
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
        gui.getInfoField().repaint();
    }

}
