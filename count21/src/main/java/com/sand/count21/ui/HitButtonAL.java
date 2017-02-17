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
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

/**
 *
 * @author osand
 */
public class HitButtonAL implements ActionListener {

    private Game game;
    private GUI gui;
    private ImageGetter imageGetter;

    public HitButtonAL(Game game, GUI gui, ImageGetter imageGetter) {
        this.game = game;
        this.gui = gui;
        this.imageGetter = imageGetter;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Player player = game.getPlayer();
        if (!game.checkIfPlayerIsBust(player)) {
            game.dealTo(player, 1);
            Card card = player.getLastCard();
            Image image = imageGetter.getCardImage(card);
            JLabel playerCardHit = new JLabel(new ImageIcon(image));
            gui.getPlayerPanel().add(playerCardHit);
            gui.getPlayerPanel().revalidate();
        }

        if (game.checkIfPlayerIsBust(player)) {

            gui.getHitButton().setEnabled(false);
            for (ActionListener a : gui.getStayButton().getActionListeners()) {
                a.actionPerformed(new ActionEvent(this, ActionEvent.ACTION_PERFORMED, null) {
                    //Nothing need go here, the actionPerformed method (with the
                    //above arguments) will trigger the respective listener
                });
            }
        }

    }

}
