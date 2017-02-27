package com.sand.count21.ui;

import com.sand.count21.logiikka.Card;
import com.sand.count21.logiikka.Game;
import com.sand.count21.logiikka.Player;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.Timer;

/**
 *
 * @author osand
 */
public class DealButtonAL implements java.awt.event.ActionListener {
    Timer timer;
    Game game;
    GUI gui;
    ImageGetter imageGetter;

    public DealButtonAL(Game game, GUI gui, ImageGetter imageGetter) {
        this.game = game;
        this.gui = gui;
        this.imageGetter = imageGetter;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        timer = new Timer(100, new AnimatorAL(game, gui));
        game.startNewRound();
        gui.getPlayerMoneyField().setText("Money " + game.getPlayer().getMoney());
        this.clearTheTable();
        this.activateTheCorrectButtons();
        this.updateTheInfoField();

        ArrayList<Card> cards = game.getPlayer().getCards();
        
        ImageIcon icon = imageGetter.getCardIcon(cards.get(0));
        ImageIcon icon2 = imageGetter.getCardIcon(cards.get(1));
        


        JLabel playerCard0 = new JLabel(icon);
        playerCard0.setBounds(15, 15,
                icon.getIconWidth(),
                icon.getIconHeight());
        JLabel playerCard1 = new JLabel(icon2);
        playerCard1.setBounds(130, 15,
                icon.getIconWidth(),
                icon.getIconHeight());
        gui.getPlayerPanel().add(playerCard0, new Integer(0));
        gui.getPlayerPanel().add(playerCard1, new Integer(1));
        

        cards = game.getDealer().getCards();
        icon = imageGetter.getCardIcon(cards.get(0));
        icon2 = imageGetter.getIcon("images/backcard.png");
  

        
        JLabel dealerCard1 = new JLabel(icon);
        dealerCard1.setBounds(15, 15,
                icon.getIconWidth(),
                icon.getIconHeight());

        JLabel dealerCard2 = new JLabel(icon2);

        dealerCard2.setBounds(130, 15,
                icon.getIconWidth(),
                icon.getIconHeight());
        gui.getDealerPanel().add(dealerCard1, new Integer(0));
        gui.getDealerPanel().add(dealerCard2, new Integer(1));

        Player player = game.getPlayer();
        if (game.checkIfSumIs21(player)) {
            gui.getHitButton().setEnabled(false);
        }
        gui.getInfoField().setText("");
    }

    private void updateTheInfoField() {
        gui.getGamesPlayed().setText("Games played " + game.getPlayer().getGamesPlayed());
        gui.getInfoField().repaint();
    }
    
    private void activateTheCorrectButtons() {
        gui.getDecreaseBetButton().setEnabled(false);
        gui.getBetButton().setEnabled(false);
        gui.getAgainButton().setEnabled(false);
        gui.getStayButton().setEnabled(true);
        gui.getHitButton().setEnabled(true);
    }

    private void clearTheTable() {
        gui.getPlayerPanel().removeAll();
        gui.getPlayerPanel().repaint();
        gui.getDealerPanel().removeAll();
        gui.getDealerPanel().repaint();
    }
    
    
    
    
}
