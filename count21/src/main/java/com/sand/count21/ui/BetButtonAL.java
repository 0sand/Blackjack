package com.sand.count21.ui;

import com.sand.count21.logiikka.Game;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author osand
 */
public class BetButtonAL implements ActionListener {

    private Game game;
    private GUI gui;

    public BetButtonAL(Game game, GUI gui) {
        this.game = game;
        this.gui = gui;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == gui.getDecreaseBetButton()) {
            game.getBetManager().decreseBet();
        } else {
            game.getBetManager().increseBet();
        } 
        gui.getCurrentBetField().setText("bet " + (game.getBetManager().getBet()));
        gui.getPlayerMoneyField().setText("Money " + game.getPlayer().getMoney());
        gui.getCurrentBetField().repaint();
    }
}
