package com.sand.count21.ui;

import com.sand.count21.logiikka.Card;
import com.sand.count21.logiikka.Game;
import java.awt.Color;
import java.awt.Image;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JOptionPane;

/**
 *
 * @author osand
 */
public class StayButtonAL implements java.awt.event.ActionListener {

    private final Game game;
    private final ImageGetter imageGetter;
    private final JComponent dealerPanel;
    private final GUI gui;
    private final JFrame frame;

    public StayButtonAL(Game game, ImageGetter imageGetter, GUI gui, JFrame frame) {
        this.gui = gui;
        this.game = game;
        this.imageGetter = imageGetter;
        this.dealerPanel = gui.getDealerPanel();
        this.frame = frame;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        this.gui.getCounter().zeroCounter();
        this.showDealersHiddenCard();

        this.showDealerHitCard();
        game.blackjackRoundDone();

        this.activateTheCorrectButtons();
        this.updateTheInfoField();

        if (this.game.getPlayer().getMoney() == 0) {
            this.gameOverWindow();
        }
        

    }

    private void showDealersHiddenCard() {
        dealerPanel.remove(0);
        
        Card card1 = game.getDealer().getCards().get(1);
        Image image1 = imageGetter.getCardImage(card1);
        ImageIcon icon = new ImageIcon(image1);
        JLabel dealerCard1 = new JLabel(icon);
        dealerCard1.setBounds(130, 15,
                icon.getIconWidth(),
                icon.getIconHeight());

        dealerPanel.add(dealerCard1, new Integer(2));
        dealerPanel.repaint();
    }

    private void showDealerHitCard() {
        int i = 2;
        int moveCard = 120;
        while (game.checkIfDealerMustHit(game.getDealer())) {
            
            i++;
            game.dealOneTo(game.getDealer());
            Card card = game.getDealer().getLastCard();
            ImageIcon icon = imageGetter.getCardIcon(card);
            JLabel dealerCardHit = new JLabel(icon);
            dealerCardHit.setBounds(130 + (moveCard * (i -2)), 15,
                    icon.getIconWidth(),
                    icon.getIconHeight());
            dealerPanel.add(dealerCardHit, new Integer(i));
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
        gui.getNumberOfWins().setText("Total Wins  " + playerWins);
        gui.getCurrentBetField().setText("bet " + (game.getBetManager().getBet()));
        gui.getPlayerMoneyField().setText("Money " + game.getPlayer().getMoney());
        gui.getGamesPlayed().setText("Games played " + game.getPlayer().getGamesPlayed());
        gui.getInfoField().repaint();
    }

    private void gameOverWindow() {
        JOptionPane pane = new JOptionPane();
        pane.setBounds(300, 100, 500, 500);

        pane.setLocation(500, 500);
        pane.setVisible(true);

        String[] options = {"Yes", "No"};

        int x = JOptionPane.showOptionDialog(frame, "You lost all your money. Do you wan´t to play again?",
                "Game Over",
                JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, options, options[0]);
        if (x == 0) {
            this.game.startNewGame();
            this.updateTheInfoField();
            gui.getInfoField().setText(" ");
            gui.getPlayerPanel().removeAll();
            gui.getPlayerPanel().repaint();

            gui.getDealerPanel().removeAll();
            gui.getDealerPanel().repaint();

        } else {
            System.exit(0);
        }
    }

}
