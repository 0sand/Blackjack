/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sand.count21.ui;

import com.sand.count21.logiikka.Game;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author osand
 */
public class BetButtonListener implements ActionListener {
    private Game game;
    private GUI gui;

    public BetButtonListener(Game game, GUI gui) {
        this.game = game;
        this.gui = gui;
    }
    

    @Override
            public void actionPerformed(ActionEvent e) {

            game.getBetManager().increseBet(10);
            gui.getCurrentBetField().setText("Current bet " + (game.getBetManager().getBet()));
            gui.getPlayerMoneyField().setText("Money " + game.getPlayer().getMoney());
            gui.getCurrentBetField().repaint();

        }
    
}
